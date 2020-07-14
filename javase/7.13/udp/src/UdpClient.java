import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true)
      try {
        DatagramSocket socket = new DatagramSocket();
        String input = scanner.nextLine();

        if (input.equals("quit")) {
          return;
        }

        String[] inputStr = input.split(" ");
        if (inputStr.length == 3) {
          if (ipIsCurrent(inputStr[0]) && connectorIsCurrent(inputStr[1])) {
            byte[] bytes = input.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(inputStr[0]), Integer.parseInt(inputStr[1]));
            socket.send(packet);
            socket.close();
          }
        } else {
          System.out.println("输入不合法！");
        }
      } catch (IOException | IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }

  }

  private static boolean connectorIsCurrent(String s) {
    try {
      int connector = Integer.parseInt(s);
      if (connector < 0 || connector > 65535) {
        throw new IllegalArgumentException("接口错误");
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return true;
  }

  private static boolean ipIsCurrent(String s) throws IllegalArgumentException {
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
