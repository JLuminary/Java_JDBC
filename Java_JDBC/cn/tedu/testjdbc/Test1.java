package cn.tedu.testjdbc;
/*本类用于测试JDBC查询语句*/
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
    @Test
    public void get1() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接
        Connection conn = DriverManager.getConnection("jdbc:mysql:///cgb2109?characterEncoding=utf8","root","root");
        //获取传输器
        Statement st = conn.createStatement();
        int i = st.executeUpdate("insert into dept values(null,'xiaoming','红旗区')");
        st.close();
        conn.close();
    }

    @Test
    public void get() throws Exception {
        //注册驱动
        //创建字节码对象
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接
        Connection conn = DriverManager.getConnection("jdbc:mysql:///cgb2109?characterEncoding=utf8", "root", "root");
        //获取传输器
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from emp");
        //处理结果
        while(re.next()){
            for (int i = 1; i < 6; i++) {
                System.out.print(re.getObject(i)+" \t");
            }
            System.out.println();
        }
        re.close();
        st.close();
        conn.close();
    }
}
