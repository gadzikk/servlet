package db;

import model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 16.12.17.
 */
public class AccountJDBC implements AccountRepository {

    public Account getById(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
        Account account = new Account();
        ResultSet rs = stmt.executeQuery();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            account.setId(rs.getLong("id"));
            account.setEmail(rs.getString("email"));
            account.setMoney(rs.getBigDecimal("money"));
            account.setCreationDate(rs.getDate("creation_date"));
        }
        rs.close();
        return account;
    }

    public List<Account> getAll(PreparedStatement stmt) throws SQLException {
        List<Account> result = new ArrayList<Account>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Account account = new Account();
            account.setId(rs.getLong("id"));
            account.setEmail(rs.getString("email"));
            account.setMoney(rs.getBigDecimal("money"));
            account.setCreationDate(rs.getDate("creation_date"));
            result.add(account);
        }
        rs.close();
        return result;
    }
}
