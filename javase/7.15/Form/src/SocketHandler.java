import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.sql.ClientInfoStatus;
import java.util.Map;
import java.util.StringTokenizer;

public class SocketHandler extends Thread {

  private Socket clientSocket;

  public SocketHandler(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {

    try {
      InputStream inputStream = clientSocket.getInputStream();

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      String line = bufferedReader.readLine();
      StringTokenizer tokenizer = new StringTokenizer(line);
      MbmRequest mbmRequest = new MbmRequest();
      mbmRequest.setMethod(tokenizer.nextToken());
      mbmRequest.setPath(tokenizer.nextToken());

      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          mbmRequest.setHost(line.replace("Host: ", ""));
        }
        if (line.startsWith("Content-Length:")) {
          mbmRequest.setContentLength(Integer.parseInt(line.replace("Content-Length: ", "")));
        }
//        System.out.println(line);
        line = bufferedReader.readLine();
      }

      if (mbmRequest.getContentLength() > 0) {
        char[] chars = new char[mbmRequest.getContentLength()];
        bufferedReader.read(chars);

        mbmRequest.setPayload(URLDecoder.decode(new String(chars), "utf-8"));
      }

      String resourcePath = mbmRequest.getPath();
      System.out.println(resourcePath);

      if (resourcePath.startsWith("/")) {
        resourcePath = resourcePath.substring(1);
      }

      if (resourcePath.length() == 0) {
        resourcePath = "login.html";
        InputStream resourceAsStream =  HttpServer.class.getClassLoader()
                .getResourceAsStream(resourcePath);

        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        if (resourcePath.contains(".html")) {
          outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
        }

        String contentLength = "Content-Length: " + resourceAsStream.available();
        outputStream.write(contentLength.getBytes());

        outputStream.write("\r\n".getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.write(resourceAsStream.readAllBytes());
        clientSocket.close();
      }



      if (resourcePath.equals("welcome.html")) {
        InputStream resourceAsStream;
        resourceAsStream = HttpServer.class.getClassLoader()
                .getResourceAsStream(resourcePath);
        System.out.println(resourcePath + " 222");

        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        if (resourcePath.contains(".html")) {
          outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
        }

        String contentLength = "Content-Length: " + resourceAsStream.available();
        outputStream.write(contentLength.getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.write("\r\n".getBytes());

        String line1 = reader.readLine();
        while (line1 != null) {
          if (line1.contains("$")) {
            //replace并不会改变原来的字符串而是传给一个新的字符串
            line1 = line1.replace("${name}", "u1");
            line1 = line1.replace("${pwd}", "123");
            System.out.println(line1);
          }
          outputStream.write(line.getBytes());
          line = bufferedReader.readLine();
        }
        outputStream.write(resourceAsStream.readAllBytes());
        clientSocket.close();
      }

      if (resourcePath.equals("server/login")) {
        resourcePath = "welcome.html";
        InputStream resourceAsStream =  HttpServer.class.getClassLoader()
                .getResourceAsStream(resourcePath);
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write("HTTP/1.1 302 Found".getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.write(("Location: " + "http://" + mbmRequest.getHost() + resourcePath).getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.write(resourceAsStream.readAllBytes());
        clientSocket.close();
      }


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//  private void responseRedirect(MbmRequest request, String path)
//          throws IOException {
//    OutputStream outputStream = clientSocket.getOutputStream();
//    outputStream.write("HTTP/1.1 302 Found".getBytes());
//    outputStream.write("\r\n".getBytes());
//    // 告知浏览器请求结束，需要再次向请求给定的路径发起请求
//    outputStream.write(("Location: " + "http://" + request.getHost() + path).getBytes());
//    outputStream.write("\r\n".getBytes());
//
//    // out.writeBytes("HTTP/1.1 302 Found");
//    // out.writeBytes("\r\n");
//    // out.writeBytes("Location: " + "http://" + request.getHost() + path);
//    // out.writeBytes("\r\n");
//  }
//
//  private void responseResource(MbmRequest mbmRequest) throws IOException {
//    String resourcePath = mbmRequest.getPath();
//    System.out.println(resourcePath);
//    if (resourcePath.startsWith("/")) {
//      resourcePath = resourcePath.substring(1);
//    }
//
//    if (resourcePath.length() == 0) {
//      resourcePath = "login.html";
//    }
//
//
//    if (resourcePath.equals("welcome.html")) {
//      InputStream resourceAsStream;
//      resourceAsStream = HttpServer.class.getClassLoader()
//              .getResourceAsStream(resourcePath);
//      System.out.println(resourcePath + " 222");
//
//
//      OutputStream outputStream = clientSocket.getOutputStream();
//      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
//      outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
//      if (resourcePath.contains(".html")) {
//        outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
//      }
//
//      String contentLength = "Content-Length: " + resourceAsStream.available();
//      outputStream.write(contentLength.getBytes());
//
//      outputStream.write("\r\n".getBytes());
//      outputStream.write("\r\n".getBytes());
//
//      String line = bufferedReader.readLine();
//      while (line != null) {
//        if (line.contains("$")) {
//          //replace并不会改变原来的字符串而是传给一个新的字符串
//          line = line.replace("${name}", "u1");
//          line = line.replace("${pwd}", "123");
//          System.out.println(line);
//        }
//        outputStream.write(line.getBytes());
//        line = bufferedReader.readLine();
//      }
//      outputStream.write(resourceAsStream.readAllBytes());
//      return;
//    }
//
//    if ("sever/login".equals(resourcePath)) {
//      responseRedirect(mbmRequest, "welcome.html");
//    }
//
//
//    InputStream resourceAsStream = HttpServer.class.getClassLoader()
//            .getResourceAsStream(resourcePath);
//
//    if (resourceAsStream == null) {
//      resourceAsStream = HttpServer.class.getClassLoader()
//              .getResourceAsStream("404.html");
//    }
//
//    OutputStream outputStream = clientSocket.getOutputStream();
//    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
//    if (resourcePath.contains(".html")) {
//      outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
//    }
//
//    String contentLength = "Content-Length: " + resourceAsStream.available();
//    outputStream.write(contentLength.getBytes());
//
//    outputStream.write("\r\n".getBytes());
//    outputStream.write("\r\n".getBytes());
//    outputStream.write(resourceAsStream.readAllBytes());
//  }


}
