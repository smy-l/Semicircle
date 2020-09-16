package club.banyuan.admin.service.impl;

import club.banyuan.admin.entity.Admin;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

//url=jdbc:mysql://localhost:3306/hrms?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT
//        driver=com.mysql.cj.jdbc.Driver
//        username=root
//        password=12345678
public class Main {
  public static void main(String[] args)throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setUser("root");
    dataSource.setPassword("12345678");
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hrms?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT");
    dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");

    QueryRunner qr = new QueryRunner(dataSource);

    List<Admin> query = qr.query("select * from t_admin", new BeanListHandler<Admin>(Admin.class));
    System.out.println(query);
  }
}
