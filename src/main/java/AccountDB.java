import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDB {


    public boolean getTrue() {
        return true;
    }

    public FrontData getConnection(String method, Parameters params) {
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
                stmt = conn.prepareStatement("SELECT * FROM  ACCOUNT");
                List<Account> accounts = accountRepository.getAll(stmt);
                accountData.setAccounts(accounts);

            } else if ("getbyid".equals(method)) {
                stmt = conn.prepareStatement("SELECT * FROM  ACCOUNT where id = ?");
                Account account = accountRepository.getById(stmt, params);
                accountData.setAccount(account);
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