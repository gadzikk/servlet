package db;

import model.Account;

import java.sql.*;
import java.util.List;

public class AccountDaoImp implements AccountDao {

    private AccountRepository accountRepository = new AccountJDBC();
    private static Connection conn;

    public Account getById(Long id) throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM  ACCOUNT where id = ?");
        return accountRepository.getById(stmt, id);
    }

    public List<Account> getAll() throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM  ACCOUNT");
        return accountRepository.getAll(stmt);
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
