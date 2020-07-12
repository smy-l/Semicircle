import java.io.IOException;
import java.util.Properties;

public class PropUtil {

  private static final Properties properties = new Properties();

  static {
    try {
      properties.load(PropUtil.class.getClassLoader().getResourceAsStream("car.properties"));
    } catch (IOException e) {
      throw new RuntimeException("加载配置文件失败");
    }
  }

  public String getProp(String key) {
    return properties.getProperty(key);
  }

  public static String getPath() {
    return properties.getProperty("path");
  }

}
