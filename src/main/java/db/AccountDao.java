package db;

import front.AccountData;
import model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 23.12.17.
 */
public interface AccountDao {

    Account getById(Long id) throws SQLException;
    List<Account> getAll() throws SQLException;
}
