import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.sql.*;

public class TestConn {


    private String dirver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";   // 127.0.0.1是本机地址，1521是oracle默认端口，orcl是数据库SID
    private String username = "scott";
    private String password = "tiger";

    private Connection conn;
    private PreparedStatement pre;
    private CallableStatement call;
    private ResultSet resultSet;

    @Test
    public void testConn() {
        try {
            Class.forName(dirver);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from product where pid=?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, "1");
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                System.out.println("name:" + resultSet.getString("name") +
                        "--price:" + resultSet.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试存储过程
     * {call <procedure-name>[(<arg1>,<arg2>, ...)]}
     */
    @Test
    public void testProcedure() {
        try {
            Class.forName(dirver);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "{call my_pro3(?,?)}";
            call = conn.prepareCall(sql);
            //  对于 in 参数：赋值
            call.setString(1, "1");
            //  对于 out 参数：声明
            call.registerOutParameter(2, OracleTypes.VARCHAR);
            //  执行
            call.executeQuery();
            //  获取输出参数
            System.out.println(call.getString(2));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (call != null) {
                    call.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 测试函数
     * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
     */
    @Test
    public void testFunction() {
        try {
            Class.forName(dirver);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "{?=call my_fun3(?,?,?)}";
            call = conn.prepareCall(sql);

            //  对于 in 参数：赋值
            call.setInt(2, 555);
            call.setInt(3, 222);
            //  对于 out 参数：声明
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.registerOutParameter(4, OracleTypes.VARCHAR);
            //  执行
            call.executeQuery();

            //  获取返回值、输出参数
            System.out.println(call.getString(1));
            System.out.println(call.getString(4));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (call != null) {
                    call.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
