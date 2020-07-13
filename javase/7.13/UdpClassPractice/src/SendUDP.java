import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendUDP {
  public static void main(String[] args) {
    String str = "孙明羽";
    byte[] bytes = str.getBytes();
    try {
      DatagramSocket socket = new DatagramSocket();
      DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.9.27"), 5000);
      socket.send(packet);
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
