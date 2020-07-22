package server;

import exception.FromPostException;
import service.UserService;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Map;
import java.util.StringTokenizer;

public class SocketHandler extends Thread {

  private Socket clientSocket = new Socket();
  private UserService userService = new UserService();

  public SocketHandler(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    //创建接收信息的类
    MbmRequest mbmRequest = new MbmRequest();

    try {
      //获取浏览器发送的信息
      InputStream inputStream = clientSocket.getInputStream();

      //将字节流转换为字符流
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      //开始读取
      String line = bufferedReader.readLine();
      if (line == null) {
        System.err.println("解析失败");
        return;
      }

      //GET / HTTP1.1 (第一行)
      StringTokenizer stringTokenizer = new StringTokenizer(line);
      mbmRequest.setMethod(stringTokenizer.nextToken());
      mbmRequest.setPath(URLDecoder.decode(stringTokenizer.nextToken(), "utf-8"));

      //继续读取数据
      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          String replace = line.replace("Host: ", "");
          mbmRequest.setHost(replace);
        }

        if (line.startsWith("Content-Length:")) {
          String replace = line.replace("Content-Length: ", "");
          mbmRequest.setContentLength(Integer.parseInt(replace));
        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }

      if (mbmRequest.getContentLength() > 0) {
        char[] chars = new char[mbmRequest.getContentLength()];
        bufferedReader.read(chars);
        mbmRequest.setPayload(URLDecoder.decode(new String(chars), "utf-8"));
      }

      String resourcePath = mbmRequest.getPath();

      if (resourcePath.startsWith("/server")) {
        process(mbmRequest);
      } else {
        responseResource(mbmRequest);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (FromPostException e) {
      try {
        responseRedirect(mbmRequest,"/pages/404.html");
      } catch (IOException ioException) {
        ioException.printStackTrace();
      }
    }

  }

  private void responseResource(MbmRequest mbmRequest) throws IOException {
    String resourcePath = mbmRequest.getPath();
    if (resourcePath.startsWith("/")) {
      resourcePath = resourcePath.substring(1);
    }

    if (resourcePath.length() == 0) {
      resourcePath = "pages/login.html";
    } else if (resourcePath.startsWith("css") ||
            resourcePath.startsWith("images") ||
            resourcePath.startsWith("js") ||
            resourcePath.contains(".html")) {
      resourcePath = "pages/" + resourcePath;
    }

    InputStream resourceAsStream = HttpServer.class.getClassLoader().
            getResourceAsStream(resourcePath);

    if (resourceAsStream == null) {
      resourceAsStream = HttpServer.class.getClassLoader().
              getResourceAsStream("404.html");
    }

    //第一行： HTTP/1.1 200 OK\r\n
    //如果包含".html"
    //第二行：Content-Type: text/html; charset=utf-8\r\n
    //将长度换为资源文件长度，使用available获取资源文件长度
    //第三行：Content-Length: 长度\r\n
    //第四行：\r\n
    //读到空行后，开始读取资源文件数据

    OutputStream outputStream = clientSocket.getOutputStream();
    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
    if (resourcePath.contains(".html")) {
      outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
    }
    String contentLength = "Content-Length: " + resourceAsStream.available() + "\r\n";
    outputStream.write(contentLength.getBytes());
    outputStream.write("\r\n".getBytes());
    outputStream.write(resourceAsStream.readAllBytes());
    outputStream.close();
  }

  private void process(MbmRequest mbmRequest) throws IOException, FromPostException {
    switch (mbmRequest.getPath()) {
      case "server/user/login": {
        Map<String, String> formdata = mbmRequest.getFormData();
        if (userService.login(formdata.get("name"), formdata.get("pwd"))) {
          responseRedirect(mbmRequest, "/bill_list.html");
        } else {
          throw new FromPostException("用户名或者密码错误");
        }
      }
      break;
    }
  }

  //重定向
  //"HTTP/1.1 302 Found\r\n"
  //"Location: http://" + request.getHost() + path + \r\n
  private void responseRedirect(MbmRequest mbmRequest, String path) throws IOException {
    OutputStream outputStream = clientSocket.getOutputStream();
    outputStream.write("HTTP/1.1 302 Found\r\n".getBytes());
    String information = "Location: http://" + mbmRequest.getHost() + path + "\r\n";
    outputStream.write(information.getBytes());
  }
}
