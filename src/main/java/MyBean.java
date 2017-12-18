import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyBean {


    public boolean getTrue() {
        return true;
    }

    public FrontData connectionWithDB(String method, Parameters params) {
        AccountRepository accountRepository = new AccountFacade();
        FrontData accountData = new FrontData();
//        List<String> list = new ArrayList<String>();
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "postgres";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            if ("getall".equals(method)) {
                stmt = conn.prepareStatement("SELECT email FROM  ACCOUNT");
                accountData.accounts = accountRepository.getAll(stmt);

            } else if ("getbyid".equals(method)) {
                stmt = conn.prepareStatement("SELECT email FROM  ACCOUNT where id = ?");
                accountData.account = accountRepository.getById(stmt, params);
            }


//            String sql = "SELECT email FROM  ACCOUNT ";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String email = rs.getString("email");
//                list.add(email);
//
//                System.out.println(email);
//            }
//            rs.close();

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

            return accountData;
        }
    }
}