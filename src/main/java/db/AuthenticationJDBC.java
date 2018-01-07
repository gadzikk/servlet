package db;

import model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gadzik on 04.01.18.
 */
public class AuthenticationJDBC implements AuthenticationRepository {

    public Account executeLogin(PreparedStatement stmt, Parameters params) throws SQLException {
        stmt.setString(1,params.getEmail());
        stmt.setString(2,params.getPassword());
        ResultSet rs = stmt.executeQuery();
        if(!rs.isBeforeFirst()){
            return null;
        }
        Account account = new Account();
        while (rs.next()){
            account.setId(rs.getLong("id"));
            account.setEmail(rs.getString("email"));
            account.setMoney(rs.getBigDecimal("money"));
            account.setCreationDate(rs.getDate("creation_date"));
        }
        return account;
    }
}
