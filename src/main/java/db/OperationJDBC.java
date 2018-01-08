package db;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 08.01.18.
 */
public class OperationJDBC implements OperationRepository {

    public void executeSaveOperation(PreparedStatement stmt, Long accountId, String type, BigDecimal money) throws SQLException {
        stmt.setLong(1, accountId);
        stmt.setString(2, type);
        stmt.setBigDecimal(3, money);
        stmt.executeUpdate();
    }
}
