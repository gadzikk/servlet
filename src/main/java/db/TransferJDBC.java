package db;

import model.Transfer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 07.01.18.
 */
public class TransferJDBC implements TransferRepository {
    public void executeOutgoingTransfer(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setBigDecimal(1, params.getMoney());
        stmt.setLong(2, params.getId());
        stmt.executeUpdate();
    }

    public void executeIncomingTransfer(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setBigDecimal(1, params.getMoney());
        stmt.setLong(2, params.getReceiverId());
        stmt.executeUpdate();
    }

    public void executeSaveTransfer(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setLong(1, params.getId());
        stmt.setLong(2, params.getReceiverId());
        stmt.setBigDecimal(3, params.getMoney());
        stmt.executeUpdate();
    }

    public List<Transfer> executeGetByAccountWithPagination(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setLong(1, params.getId());
        stmt.setInt(2, 10);
        stmt.setInt(3, (params.getPage() - 1) * 10);
        ResultSet rs = stmt.executeQuery();
        List<Transfer> transfers = new ArrayList<Transfer>();
        while (rs.next()) {
            Transfer transfer = new Transfer();
            transfer.setId(rs.getLong("id"));
            transfer.setSenderId(rs.getLong("sender_id"));
            transfer.setReceiverId(rs.getLong("receiver_id"));
            transfer.setTransferedMoney(rs.getBigDecimal("transfered_money"));
            transfer.setCreationDate(rs.getDate("creation_date"));
            transfers.add(transfer);
        }
        return transfers;
    }

    public Integer executeCountByAccount(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setLong(1, params.getId());
        ResultSet rs = stmt.executeQuery();
        int total = 0;
        while (rs.next()){
            total = rs.getInt(1);
        }
        return total;
    }
}
