package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 07.01.18.
 */
public class TransferJDBC implements TransferRepository {
    public void executeOutgoingTransfer(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setBigDecimal(1, params.getMoney());
        stmt.setLong(2, params.getSenderId());
        stmt.executeUpdate();

    }

    public void executeIncomingTransfer(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setBigDecimal(1, params.getMoney());
        stmt.setLong(2, params.getReceiverId());
        stmt.executeUpdate();
    }
}
