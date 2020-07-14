package club.banyuan.mbm.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpServer {

  public static void main(String[] args) throws IOException {
    InputStream resourceAsStream = HttpServer.class.getClassLoader().
            getResourceAsStream("pages/login.html");
//    System.out.println(resourceAsStream);

//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
//
//    String line = bufferedReader.readLine();
//    while (line != null){
//      System.out.println(line);
//      line = bufferedReader.readLine();
//    }

    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {
      Socket accept = serverSocket.accept();
      InputStream inputStream = accept.getInputStream();
      System.out.println(accept.getInetAddress().getHostAddress());


      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line = bufferedReader.readLine();
      if (line == null) {
        throw new RuntimeException("解析失败");
      }

      StringTokenizer tokenizer = new StringTokenizer(line);
      MbmRequest mbmRequest = new MbmRequest();
      mbmRequest.setMethod(tokenizer.nextToken());
      mbmRequest.setPath(tokenizer.nextToken());

      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          mbmRequest.setHost(line.replace("Host: ", ""));
        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }

      System.out.println(mbmRequest);

      String contentLength = "Content-Length: " + resourceAsStream.available();

      OutputStream outputStream = accept.getOutputStream();
      outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
      outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
      outputStream.write(contentLength.getBytes());
      outputStream.write("\r\n".getBytes());
      outputStream.write("\r\n".getBytes());
      outputStream.write(resourceAsStream.readAllBytes());
    }

  }
}