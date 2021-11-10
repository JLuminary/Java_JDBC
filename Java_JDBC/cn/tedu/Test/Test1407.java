package cn.tedu.Test;

import javafx.scene.control.SplitPane;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1407 {
    @Test
    public void get() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/cgb2109?characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from courses");
        while (re.next()) {
            for (int i = 1; i < 4; i++) {
                System.out.print(re.getString(i) + "   \t");
            }
            System.out.println();
        }
        re.close();
        st.close();
        conn.close();
    }
}