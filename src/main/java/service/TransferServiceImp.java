package service;

import db.Parameters;
import db.TransferDao;
import db.TransferDaoImp;
import model.Transfer;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by gadzik on 07.01.18.
 */
public class TransferServiceImp implements TransferService {
    private TransferDao transferDao = new TransferDaoImp();

    public void outgoingTransfer(Parameters params) {
        try {
            transferDao.outgoingTransfer(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void incomingTransfer(Parameters params) {
        try {
            transferDao.incomingTransfer(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveTransfer(Parameters params) {
        try {
            transferDao.saveTransfer(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transfer> getByAccountWithPagination(Parameters params) {
        try {
            return transferDao.getByAccountWithPagination(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int countByAccount(Parameters params) {
        try {
            return transferDao.countByAccount(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
