import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpServer {

  static User user;

//      // TODO 读文件
//      String line = bufferedReader.readLine();
//      if (line.contains("${name}")) {
//        line.replace("${name}", user.getName());
//      }
//
//      if (line.contains("${pwd}")) {
//        line.replace("${pwd}", user.getPwd());
//      }

      // 写返回值

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(5000);

    while(true){
      Socket clientSocket = serverSocket.accept();

      SocketHandler socketHandler = new SocketHandler(clientSocket);
      socketHandler.start();
    }


    // response header
    // HTTP/1.1 200 OK
    // Content-Type: text/html; charset=utf-8
    // Content-Length: 1234
    //
    // bytes

    // "HTTP/1.1 200 OK\r\n"
    // "Content-Type: text/html; charset=utf-8\r\n"
    // "Content-Length: 1234\r\n"
    // "\r\n"
    // data

    // out.writeBytes("HTTP/1.1 200 OK");
    // out.writeBytes("\r\n");
    // out.writeBytes("Content-Type: text/html; charset=utf-8");
    // out.writeBytes("\r\n");
    // out.writeBytes(("Content-Length: " + resourceAsStream.available()));
    // out.writeBytes("\r\n");
    // out.writeBytes("\r\n");
  }
}
