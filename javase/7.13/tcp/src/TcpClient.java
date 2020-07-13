import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

public class TcpClient {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Properties properties = new Properties();
    final String path = properties.getProperty("path");
    try {
      Socket socket = new Socket("127.0.0.1", 5000);
      System.out.println("建立连接");

      String code = secretOrNot(scanner);
      OutputStream isSecret = socket.getOutputStream();
      isSecret.write(code.getBytes());

      File file = new File(path);
      int length = (int) file.length();
      OutputStream fileNum = socket.getOutputStream();
      fileNum.write(parse(length));


      BufferedReader reader = new BufferedReader(new FileReader(file));
      StringBuilder builder = new StringBuilder();

      int count = 0;
      String line = reader.readLine();
      while (line != null) {
        count++;
        System.out.println("写入：" + line);
        builder.append(line);
        builder.append(System.lineSeparator());
        line = reader.readLine();
      }



    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String secretOrNot(Scanner scanner) {
    System.out.println("请输入加密还是解密");
    String code = scanner.nextLine();
    if(!code.equals("加密") && !code.equals("解密")){
      System.out.println("输入不合法!");
      code = secretOrNot(scanner);
    }
    return code;
  }

  public static byte[] parse(int target) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) (target >> 8 * (3 - i));
    }
    return bytes;
  }
}
