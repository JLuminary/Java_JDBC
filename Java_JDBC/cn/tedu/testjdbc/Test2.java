package cn.tedu.testjdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

/*本类用于测试输入用户名和密码*/
public class Test2 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql:///cgb2109?characterEncoding=utf8";
        //连接数据库
        Connection conn = DriverManager.getConnection(url, "root", "root");
        //获取传输器
//            Statement st = conn.createStatement();
        System.out.println("请您输入用户名:");
        String user = new Scanner(System.in).nextLine();
        System.out.println("请您输入密码：");
        String pwd = new Scanner(System.in).nextLine();
//            String url1="select * from user where name='" + user + "' and password='" + pwd + "'";
        String url1 = "select * from user where name=? and password=?";
        PreparedStatement ps = conn.prepareStatement(url1);
        ps.setString(1, user);
        ps.setString(2, pwd);
        ResultSet re = ps.executeQuery();
        if (re.next()) {
            System.out.println("恭喜您，登陆成功");
        } else {
            System.out.println("很抱歉，登陆失败");
        }
        re.close();
        ps.close();
        conn.close();
    }
}

