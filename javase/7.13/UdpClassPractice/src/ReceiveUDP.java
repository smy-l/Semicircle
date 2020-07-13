import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveUDP {
  public static void main(String[] args) {
    try {
      DatagramSocket socket = new DatagramSocket(5000);
      byte[] buf = new byte[1024];
      DatagramPacket packet = new DatagramPacket(buf, buf.length);
      socket.receive(packet);
      System.out.println(new String(packet.getData(), 0, packet.getLength()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
