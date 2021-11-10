package cn.tedu.Test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
    @Test
    public void add() throws Exception {
        Connection conn = JDBCUtils.get();
        Statement st = conn.createStatement();
        int rows = st.executeUpdate("insert into dept values(null,'java开发','七区')");

        st.close();
        conn.close();

    }
    @Test
    public void get() throws Exception {
        //获取字节码对象
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/cgb2109?characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement st = conn.createStatement();//传输器
        ResultSet rs = st.executeQuery("select * from courses");//执行语句
        while (rs.next()) {
            for (int i = 1; i < 4; i++) {
                System.out.print(rs.getObject(i)+"        \t");
            }
            System.out.println();
        }
        rs.close();
        st.close();
        conn.close();
    }
}
