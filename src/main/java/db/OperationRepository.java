package db;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 08.01.18.
 */
public interface OperationRepository {
    void executeSaveOperation(PreparedStatement stmt, Long accountId, String type, BigDecimal money) throws SQLException;
}
