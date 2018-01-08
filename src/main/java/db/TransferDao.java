package db;


import java.sql.SQLException;

/**
 * Created by gadzik on 07.01.18.
 */
public interface TransferDao {
    void outgoingTransfer(Parameters params) throws SQLException;
    void incomingTransfer(Parameters params) throws SQLException;

}
