package db;

import front.FrontData;
import model.Account;

import java.sql.*;
import java.util.List;

public class AccountDB {

    public FrontData getConnection(String method, Parameters params) {
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "postgres";

        AccountRepository accountRepository = new AccountFacade();
        FrontData accountData = new FrontData();

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
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return accountData;
        }
    }
}