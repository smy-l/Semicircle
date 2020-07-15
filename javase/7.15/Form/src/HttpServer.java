import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.SocketHandler;

public class HttpServer {

  static User user;


  public static void main(String[] args) throws IOException {

    //创建服务端的接口
    ServerSocket serverSocket = new ServerSocket(5000);

    while (true) {

      // 阻塞，浏览器发送请求后继续执行
      Socket clientSocket = serverSocket.accept();

      // 开启字节流，获取浏览器发送数据
      InputStream inputStream = clientSocket.getInputStream();

      // 将字节流转换为字符流
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      //读取数据
      String line = bufferedReader.readLine();
      if (line == null) { // 等于null说明出错
        System.err.println("解析失败");
        continue;
      }

      //从读取的数据中获取 GET / HTTP1.1 等信息
      // GET / HTTP/1.1
      // GET 为浏览器向服务器请求数据 POST为浏览器向服务端发送数据
      //Host: 127.0.0.1:5000
      // 浏览器使用IP地址和端口号
      StringTokenizer stringTokenizer = new StringTokenizer(line);
      MbmRequest mbmRequest = new MbmRequest();
      mbmRequest.setMethod(stringTokenizer.nextToken());
      mbmRequest.setPath(stringTokenizer.nextToken());

      while (line != null && line.length() != 0) {
        if (line.startsWith("Host:")) {
          mbmRequest.setHost(line.replace("Host: ", ""));
        }
        if (line.startsWith("Content-Length:")) {
          mbmRequest.setContentLength(Integer.parseInt(line.replace("Content-Length: ", "")));
        }
        System.out.println(line);
        line = bufferedReader.readLine();
      }

      if (mbmRequest.getContentLength() > 0) {
        char[] chars = new char[mbmRequest.getContentLength()];
        bufferedReader.read(chars, 0, chars.length);
        mbmRequest.setPayload(URLDecoder.decode(new String(chars), "utf-8"));
      }

      //判断请求的数据是什么
      String resourcePath = mbmRequest.getPath();
      if (resourcePath.startsWith("/")) {
        resourcePath = resourcePath.substring(1);
      }

      //判断请求的界面以及设置返回的界面路径
      if (resourcePath.length() == 0 || resourcePath.equals("welcome.html")) {
        resourcePath = "login.html";
      }

      OutputStream outputStream = clientSocket.getOutputStream();
      outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
      if (resourcePath.contains(".html")) {
        outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
      }

      UserService userService = new UserService();
      Map<String, String> rlt = new HashMap<>();
      StringTokenizer tokenizer = new StringTokenizer(mbmRequest.getPayload(), "&|=");
      while (tokenizer.hasMoreTokens()) {
        rlt.put(tokenizer.nextToken(), tokenizer.nextToken());
      }

//      if (userService.login(rlt.get("name"), rlt.get("pwd")) == null) {
//        //登录失败
//        OutputStream outputStream2 = clientSocket.getOutputStream();
//        outputStream2.write("HTTP/1.1 302 Found".getBytes());
//        outputStream2.write("\r\n".getBytes());
//        // 告知浏览器请求结束，需要再次向请求给定的路径发起请求
//        outputStream2.write(("Location: " + "http://" + mbmRequest.getHost() + "login.html").getBytes());
//        outputStream2.write("\r\n".getBytes());
//      } else {
//        //登录成功
//        OutputStream outputStream1 = clientSocket.getOutputStream();
//        outputStream1.write("HTTP/1.1 302 Found".getBytes());
//        outputStream1.write("\r\n".getBytes());
//        // 告知浏览器请求结束，需要再次向请求给定的路径发起请求
//        outputStream1.write(("Location: " + "http://" + mbmRequest.getHost() + "welcome.html").getBytes());
//        outputStream1.write("\r\n".getBytes());
//      }
//      break;
    }
  }
}
