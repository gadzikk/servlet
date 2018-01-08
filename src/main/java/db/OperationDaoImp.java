package db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 08.01.18.
 */
public class OperationDaoImp implements OperationDao {
    private static Connection conn;
    private OperationRepository repository = new OperationJDBC();

    public void saveOperation(Long accountId, String type, BigDecimal money) throws SQLException {
        conn = getConn();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO OPERATION (ID,ACCOUNT_ID,TYPE,AMOUNT,CREATION_DATE) " +
                "VALUES (nextval('operation_id_seq'),?,?,?,CURRENT_TIMESTAMP )");
        repository.executeSaveOperation(stmt, accountId, type, money);
        close(stmt);

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
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    }

    private void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
        conn.close();
        conn = null;
    }
}
