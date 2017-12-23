package db;

import model.Account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gadzik on 16.12.17.
 */
public interface AccountRepository {
    Account getById(PreparedStatement stmt, Parameters params) throws SQLException;
    List<Account> getAll(PreparedStatement stmt) throws SQLException;
}
