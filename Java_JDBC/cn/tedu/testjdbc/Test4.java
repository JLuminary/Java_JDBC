package cn.tedu.testjdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;
/*本类用于SQL攻击解决方案*/
public class Test4 {
    //    @Test
//    public void get() throws Exception {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.get();
//        Statement st = conn.createStatement();
        System.out.println("请您输入用户名:");
        String user = new Scanner(System.in).nextLine();
        System.out.println("请您输入密码:");
        String pwd = new Scanner(System.in).nextLine();
        String sql = "select * from user where name=? and password=?";
        PreparedStatement pr = conn.prepareStatement(sql);
        pr.setObject(1, user);
        pr.setObject(2, pwd);
        ResultSet re = pr.executeQuery();
        if (re.next()) {
            System.out.println("恭喜你，登陆成功");
        } else {
            System.out.println("登陆失败");
        }
        re.close();
        pr.close();
        conn.close();
    }
}
