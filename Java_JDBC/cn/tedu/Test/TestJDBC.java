package cn.tedu.Test;

import org.junit.Test;

import java.sql.*;

/*本类用于测试JDBC*/
public class TestJDBC {
    //利用单元测试：@Test public  void 没有参数
    //需求：利用java查询数据库 表的所有数据
    @Test
    public void get() throws Exception {
        //1.注册驱动 -- 利用反射获取Driver
        //获取字节码对象
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.数据库的连接 端口号 数据库名 用户名 密码
        String url = "jdbc:mysql://localhost:3306/cgb2109?characterEncoding=utf8";
        String user = "root";
        String pwd = "root";
        Connection conn = DriverManager.getConnection(url, user, pwd);
        //3.获取传输器
        Statement st = conn.createStatement();
        //4.执行SQL语句
        ResultSet rs = st.executeQuery("select * from courses");
        //5.处理结果
        while (rs.next()) {
            for (int i = 1; i < 4; i++) {
                System.out.print(rs.getString(i)+"   \t");
            }
            System.out.println();
        }
        //6.释放系统资源
        rs.close();
        st.close();
        conn.close();
    }
}
