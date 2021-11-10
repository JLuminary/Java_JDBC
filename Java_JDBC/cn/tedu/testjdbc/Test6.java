package cn.tedu.testjdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author xiaoming
 * @version 1.0
 * @date 2021/11/8 20:24
 */
public class Test6 {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.get();
        System.out.println("请您输入用户名：");
        String user=new Scanner(System.in).nextLine();
        System.out.println("请您输入密码：");
        String pwd=new Scanner(System.in).nextLine();
        String sql = "select * from user where name=? and password=?";
        PreparedStatement pr = conn.prepareStatement(sql);
        pr.setObject(1, user);
        pr.setString(2, pwd);
        ResultSet re = pr.executeQuery();
        if (re.next()) {
            System.out.println("恭喜您，登陆成功");
        }else{
            System.out.println("很抱歉，登陆失败");
        }
        re.close();
        pr.close();
        conn.close();
    }
@Test
public void Update() throws Exception{
    Connection conn = JDBCUtils.get();
    String sql="update dept set loc='老洛阳' where deptno=9";
    PreparedStatement pr = conn.prepareStatement(sql);
    int i = pr.executeUpdate();
    pr.close();
    conn.close();

}
    @Test
    public void get() throws Exception {
        Connection conn = JDBCUtils.get();
        String sql = "select * from dept";
        PreparedStatement pr = conn.prepareStatement(sql);
        ResultSet re = pr.executeQuery();
        while (re.next()) {
            for (int i = 1; i < 4; i++) {
                System.out.print(re.getObject(i) + "  \t");
            }
            System.out.println();
        }
        re.close();
        pr.close();
        conn.close();
    }
}