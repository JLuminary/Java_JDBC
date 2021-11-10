package cn.tedu.testjdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/*练习新的传输器*/
public class Test5 {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.get();
        String user = new Scanner(System.in).nextLine();
        String pwd = new Scanner(System.in).nextLine();
//        String sql="insert into dept values(null,'洛阳','龙门')";
        String sql1 = "insert into dept values(null,?,?)";
//        String sql1 = "delete from dept where deptno=12";
//        PreparedStatement pr = conn.prepareStatement(sql);
        PreparedStatement pr = conn.prepareStatement(sql1);
        pr.setObject(1, user);
        pr.setObject(2, pwd);
        int row = pr.executeUpdate();
        pr.close();
        conn.close();
    }
}
