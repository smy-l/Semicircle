import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

  private static Properties properties = new Properties();

  static {
    InputStream resourceAsStream = PropUtil.class.getClassLoader()
            .getResourceAsStream("user.properties");

    try {
      properties.load(resourceAsStream);
    } catch (IOException e) {
      System.err.println("加载配置文件失败");
      System.exit(0);
    }
  }

  public static String getProp(String key){
    return properties.getProperty(key);
  }
}
