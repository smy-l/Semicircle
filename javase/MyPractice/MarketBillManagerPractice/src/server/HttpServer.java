package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      Socket clientSocket = serverSocket.accept();
      SocketHandler socketHandler = new SocketHandler(clientSocket);
      socketHandler.start();
    }

  }

}
