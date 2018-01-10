package service;

import db.AccountDao;
import db.AccountDaoImp;
import db.Parameters;
import model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 23.12.17.
 */
public class AccountServiceImp implements AccountService {
    private AccountDao accountDao = new AccountDaoImp();

    public Account getById(Long id) {
        try {
            return accountDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAll() {
        try {
            return accountDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
