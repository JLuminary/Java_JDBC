package cn.tedu.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
/*本类用于解决程序的冗余/高内聚*/
public class JDBCUtils {
     public static Connection get() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        String url = "jdbc:mysql:///cgb2109?characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        return conn;
    }
}
