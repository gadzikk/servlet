package service;

import db.Parameters;
import db.TransferDao;
import db.TransferDaoImp;

import java.sql.SQLException;


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
}
