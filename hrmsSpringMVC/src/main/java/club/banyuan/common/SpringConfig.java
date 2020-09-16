package club.banyuan.common;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

// @Configuration 用来定义配置类，可以替换.xml文件
@Configuration
// @PropertySources 用来加载指定的配置文件
@PropertySources({
        @PropertySource("classpath:hrms.properties")
})
public class SpringConfig {

  // 加载 @PropertySources 中加载的配置文件中的属性值
  @Value("${driver}")
  private String driver;

  @Value("${url}")
  private String url;

  @Value("${name}")
  private String username;

  @Value("${password}")
  private String password;

  // 相当于xml文件中的<Bean>标签
  @Bean
  // QueryRunner 帮助更好的使用sql语句
  public QueryRunner getQueryRunner() throws PropertyVetoException {
    return new QueryRunner(getDataSource());
  }

  @Bean
  // DataSource 数据源 获取数据源才能和数据库交互
  public DataSource getDataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(driver);
    dataSource.setJdbcUrl(url);
    dataSource.setUser(username);
    dataSource.setPassword(password);
    return dataSource;
  }



}
