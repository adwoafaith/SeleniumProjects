

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTesting {


    public class DatabaseUtil {
        private static final String DB_URL = "jdbc:postgresql://localhost:5432/library_management_system";
        private static final String USER = "postgres";
        private static final String PASS = "Mypostgres055!";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        }

        public static ResultSet executeQuery(String query) throws SQLException {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        }

        public static void closeConnection(Connection conn) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}


