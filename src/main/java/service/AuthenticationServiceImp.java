package service;

import db.AuthenticationDao;
import db.AuthenticationDaoImp;
import db.Parameters;
import model.Account;

import java.sql.SQLException;

/**
 * Created by gadzik on 04.01.18.
 */
public class AuthenticationServiceImp implements AuthenticationService {
    private AuthenticationDao authenticationDao = new AuthenticationDaoImp();

    public Account login(Parameters params) {
        try {
            return authenticationDao.login(params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
