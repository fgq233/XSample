import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConn {

    private Connection conn;
    private PreparedStatement pre;
    private ResultSet resultSet;

    @Test
    public void testConn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("-----开始尝试连接数据库！-----");
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，1521是oracle默认端口，orcl是数据库SID
            String user = "scott";
            String password = "qwer1234";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("-----连接成功！-----");
            String sql = "select * from gtx where price=?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, 666);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                System.out.println("name:" + resultSet.getString("name") + "--price:" + resultSet.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if (pre != null){
                    pre.close();
                }
                if (conn != null){
                    conn.close();
                }
                System.out.println("-----数据库连接已关闭！-----");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
