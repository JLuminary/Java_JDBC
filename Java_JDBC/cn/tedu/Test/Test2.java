package cn.tedu.Test;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws Exception {

            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.连接数据库
            Connection conn = DriverManager.getConnection("jdbc:mysql:///cgb2109?characterEncoding=utf8", "root", "root");
            //3.获取传输器
//            Statement st = conn.createStatement();

        System.out.println("请您输入用户名：");
            String user = new Scanner(System.in).nextLine();
            System.out.println("请您输入用户密码：");
            String pwd = new Scanner(System.in).nextLine();
        //4.执行sql语句
        String sql="select * from user where name='" + user + "'and password='" + pwd + "'";
        PreparedStatement pr = conn.prepareStatement(sql);
        ResultSet re = pr.executeQuery(sql);
            if (re.next()) {
                System.out.println("恭喜您，登陆成功");
            } else {
                System.err.println("很抱歉，请重新输入");
            }
            re.close();
            pr.close();
            conn.close();
        }
    }
