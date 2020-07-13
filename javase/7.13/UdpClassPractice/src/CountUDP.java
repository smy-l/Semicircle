import java.io.IOException;
import java.net.*;
import java.util.*;

public class CountUDP {
  public static void main(String[] args) {

    List<Integer> UDPList = new ArrayList<>();
    for (int i = 0; i < 65536; i++) {
      try {
        DatagramSocket socket = new DatagramSocket(i);
        socket.close();
      } catch (SocketException e) {
        UDPList.add(i);
      }
    }
    System.out.println(UDPList);
  }
}
