package db;

import model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 04.01.18.
 */
public class AuthenticationDaoImp implements AuthenticationDao {
    private static Connection conn;
    private AuthenticationRepository repository = new AuthenticationJDBC();

    public Account login(Parameters params) throws SQLException {
        PreparedStatement stmt = getConn().prepareStatement("SELECT * FROM ACCOUNT WHERE EMAIL = ? AND PASSWORD = ?");
        return repository.executeLogin(stmt, params);
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
