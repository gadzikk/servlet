package db;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by gadzik on 08.01.18.
 */
public interface OperationDao {
    void saveOperation(Long accountId, String type, BigDecimal money) throws SQLException;
}
