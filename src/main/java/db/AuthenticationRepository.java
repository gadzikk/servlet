package db;

import model.Account;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gadzik on 04.01.18.
 */
public interface AuthenticationRepository {
    Account executeLogin(PreparedStatement stmt, Parameters params) throws SQLException;
}
