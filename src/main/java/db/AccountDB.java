package db;

import front.AccountData;
import model.Account;

import java.sql.*;
import java.util.List;

public class AccountDB {
    private static Connection conn;
    private AccountRepository accountRepository = new AccountFacade();

    public AccountData getAll() throws SQLException {
        AccountData accountData = new AccountData();
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM  ACCOUNT");
        List<Account> accounts = accountRepository.getAll(stmt);
        accountData.setAccounts(accounts);
        return accountData;
    }

    public AccountData getById(Parameters params) throws SQLException {
        AccountData accountData = new AccountData();
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM  ACCOUNT where id = ?");
        Account account = accountRepository.getById(stmt, params);
        accountData.setAccount(account);
        return accountData;
    }

    private Connection getConn() {
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASS = "postgres";

        if (conn != null) {
            return conn;
        } else {
            Connection conn = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
}
