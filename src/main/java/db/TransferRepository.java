package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 07.01.18.
 */
public interface TransferRepository {
    void executeOutgoingTransfer(PreparedStatement stmt, Parameters params) throws SQLException;
    void executeIncomingTransfer(PreparedStatement stmt, Parameters params) throws SQLException;
    void executeSaveTransfer(PreparedStatement stmt,Parameters params) throws SQLException;
}
