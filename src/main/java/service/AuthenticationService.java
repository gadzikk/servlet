package service;

import db.Parameters;
import model.Account;

/**
 * Created by gadzik on 04.01.18.
 */
public interface AuthenticationService {
    Account login(Parameters params);
}
