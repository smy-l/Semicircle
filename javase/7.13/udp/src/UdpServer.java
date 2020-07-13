import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

public class UdpServer {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("开始接收");
      try {
        DatagramSocket socketReceive = new DatagramSocket(5000);
        byte[] bytes = new byte[0x10000];
        DatagramPacket packetReceive = new DatagramPacket(bytes, bytes.length);
        socketReceive.receive(packetReceive);
        System.out.println(new String(packetReceive.getData(), 0, packetReceive.getLength()));
        socketReceive.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }


      try {
        System.out.println("开始输入");
        DatagramSocket socket = new DatagramSocket();
        String input = scanner.nextLine();

        if(input.equals("quit")){
          return;
        }
        String[] inputStr = input.split(" ");
        if (inputStr.length == 3) {
          if (ipIsCurrent(inputStr[0]) && connectorIsCurrent(inputStr[2])) {
            byte[] bytes = input.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(inputStr[0]), Integer.parseInt(inputStr[2]));
            socket.send(packet);
            socket.close();
          }
        } else {
          System.out.println("输入不合法!");
        }
      } catch (IOException | IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

  }


  private static boolean connectorIsCurrent(String s) {
    int connector = Integer.parseInt(s);
    if (connector < 0 || connector > 65535) {
      throw new IllegalArgumentException("接口错误");
    }
    return true;
  }

  private static boolean ipIsCurrent(String s) {
    String[] ipAddress = s.split("\\.");
    if (ipAddress.length != 4) {
      System.out.println("IP地址错误");
      throw new IllegalArgumentException("IP地址错误");
    }

    for (String address : ipAddress) {
      int addressNum = Integer.parseInt(address);
      if (addressNum > 255 || addressNum < 0) {
        throw new IllegalArgumentException("IP地址错误");
      }
    }
    return true;
  }
}
