package DbConn;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;

public class DbConn {

    public static Connection dbconn() {

        Connection conn;

        try {

            MysqlDataSource mds = new MysqlDataSource();
            mds.setServerName("localhost");
            mds.setPortNumber(3306);
            mds.setDatabaseName("kra_bms");
            mds.setUser("root");
            mds.setPassword("");

            conn = mds.getConnection();

            return conn;

        } catch (SQLException e) {

        }
        return null;

    }

    public static void DbClose(Connection conn, PreparedStatement psmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }
        if (psmt != null) {
            try {
                psmt.close();
            } catch (SQLException ex) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }

    }
}
