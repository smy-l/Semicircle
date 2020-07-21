package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketHandler extends Thread{

  Socket clientSocket = new Socket();

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
      if(line == null){
        System.err.println("解析失败");
        return;
      }

      //

    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
