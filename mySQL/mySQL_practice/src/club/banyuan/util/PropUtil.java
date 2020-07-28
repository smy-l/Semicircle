package club.banyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

  public static Properties properties = new Properties();

  static {
    InputStream resourceAsStream = PropUtil.class.getClassLoader().
            getResourceAsStream("app.properties");

    try {
      properties.load(resourceAsStream);
    } catch (IOException e) {
      System.err.println("加载配置文件实失败");
      System.exit(0);
    }

  }

  public static String getProp(String key) {
    return properties.getProperty(key);
  }

}
