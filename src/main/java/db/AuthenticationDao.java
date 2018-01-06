package db;

import model.Account;

import java.sql.SQLException;

/**
 * Created by gadzik on 04.01.18.
 */
public interface AuthenticationDao {
    Account login(Parameters params) throws SQLException;
}
