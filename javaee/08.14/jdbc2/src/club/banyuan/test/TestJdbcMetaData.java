package club.banyuan.test;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.Product;
import club.banyuan.pojo.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbcMetaData {
    @Test
    public void testMetaData() throws SQLException {
        Connection conn = DataSourceUtil.openConnection();
        //获取数据库的元数据
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables(conn.getCatalog(),null,null,null);
        while(rs.next()){
            System.out.println(rs.getString("TABLE_NAME"));
        }
        ResultSet rs2 = metaData.getColumns(conn.getCatalog(),metaData.getUserName(),"user",null);
        while (rs2.next()){
            System.out.print(rs2.getString("column_name"));
            System.out.print("\t"+rs2.getString("TYPE_NAME"));
            System.out.println("\t"+rs2.getString("ORDINAL_POSITION"));
        }
    }

    @Test
    public void testTableToClass() throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        ProductDao productDao = new ProductDaoImpl(conn);
        ResultSet rs = productDao.executeQuery("select * from product where name like '%华为%'",null);
        rs.next();
        Product product = (Product)tableToClass(conn ,"product", Product.class,rs);
        System.out.println(product);
        conn.close();
    }

    public Object tableToClass(Connection conn ,String tableName,Class clazz,ResultSet rs) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj = clazz.newInstance();
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs2 = metaData.getColumns(conn.getCatalog(),metaData.getUserName(),tableName,null);
        while(rs2.next()) {
            String colName = rs2.getString("column_name");
            int index = Integer.parseInt(rs2.getString("ORDINAL_POSITION"));

            Method[] methods = clazz.getMethods();
            for(Method method : methods){
                if(method.getName().equalsIgnoreCase("set"+colName)){
                    method.invoke(obj,rs.getObject(index));
                }
            }
        }
        return obj;
    }
}
