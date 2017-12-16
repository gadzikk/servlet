import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyBean {
    public boolean getTrue() {
        return true;
    }

    public List<String> connectionWithDB() {
        List<String> list = new ArrayList<String>();
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "postgres";

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT email FROM  ACCOUNT ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String email = rs.getString("email");
                list.add(email);

                System.out.println(email);
            }
            rs.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
            }

            return list;
        }
    }
}