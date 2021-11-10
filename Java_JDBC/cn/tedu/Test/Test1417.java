package cn.tedu.Test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1417 {

    @Test
    public void get() throws Exception {
        //注册驱动--Driver
        //获取字节码对象
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库 端口 库名 用户名 密码
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgb2109?characterEncoding=utf8", "root", "root");
        //获取传输器
        Statement st = conn.createStatement();
        //执行SQL语句
        ResultSet rs = st.executeQuery("select * from dept");
        //处理结果
        while (rs.next()) {
//            rs.getInt(1);
//            System.out.println(rs.getInt("deptno"));
//            System.out.println(rs.getString("loc"));
            for (int i = 1; i < 4.; i++) {
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        //释放资源
        rs.close();
        st.close();
        conn.close();
    }
}
