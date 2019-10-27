package db;


import model.Transfer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 07.01.18.
 */
public interface TransferDao {
    void outgoingTransfer(Parameters params) throws SQLException;
    void incomingTransfer(Parameters params) throws SQLException;
    void saveTransfer(Parameters params) throws SQLException;
    List<Transfer> getByAccountWithPagination(Parameters params) throws SQLException;
    Integer countByAccount(Parameters params) throws SQLException;
}
