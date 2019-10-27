package db;

import model.Transfer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 07.01.18.
 */
public interface TransferRepository {
    void executeOutgoingTransfer(PreparedStatement stmt, Parameters params) throws SQLException;
    void executeIncomingTransfer(PreparedStatement stmt, Parameters params) throws SQLException;
    void executeSaveTransfer(PreparedStatement stmt,Parameters params) throws SQLException;
    List<Transfer> executeGetByAccountWithPagination(PreparedStatement stmt, Parameters params) throws SQLException;
    Integer executeCountByAccount(PreparedStatement stmt,Parameters params) throws SQLException;
}
