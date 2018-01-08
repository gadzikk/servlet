package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 07.01.18.
 */
public class TransferDaoImp implements TransferDao {
    private static Connection conn;
    private TransferRepository repository = new TransferJDBC();

    public void outgoingTransfer(Parameters params) throws SQLException {
        conn = getConn();
        PreparedStatement stmt = conn.prepareStatement("UPDATE ACCOUNT SET MONEY = MONEY - ? WHERE ID = ?");
        repository.executeOutgoingTransfer(stmt, params);
        commitClose(stmt);
    }

    public void incomingTransfer(Parameters params) throws SQLException {
        conn = getConn();
        PreparedStatement stmt = conn.prepareStatement("UPDATE ACCOUNT SET MONEY = MONEY + ? WHERE ID = ?");
        repository.executeIncomingTransfer(stmt, params);
        commitClose(stmt);
    }

    private static Connection getConn() {
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
                conn.setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    }

    private void commitClose(PreparedStatement stmt) throws SQLException {
        conn.commit();
        stmt.close();
        conn.close();
        conn = null;
    }
}
