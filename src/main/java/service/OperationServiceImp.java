package service;

import db.OperationDao;
import db.OperationDaoImp;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by gadzik on 08.01.18.
 */
public class OperationServiceImp implements OperationService {
    OperationDao operationDao = new OperationDaoImp();

    public void saveOperation(Long accountId, String type, BigDecimal money) {
        try {
            operationDao.saveOperation(accountId, type, money);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
