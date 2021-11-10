package cn.tedu.testjdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;
/*注册用户练习*/

public class Test3 {

    //    @Test
//    public void get() throws Exception {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.get();
        String user = new Scanner(System.in).nextLine();
        String pwd = new Scanner(System.in).nextLine();
        String url1 = "select * from user where name='" + user + "' and password='" + pwd + "'";
        PreparedStatement pr = conn.prepareStatement(url1);
        ResultSet re = pr.executeQuery(url1);
        if (re.next()) {
            System.out.println("恭喜你，登陆成功");
        } else {
            System.out.println("很抱歉，登录失败");
        }
        re.close();
        pr.close();
        conn.close();
    }
}
