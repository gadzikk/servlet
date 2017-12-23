package service;

import db.Parameters;
import model.Account;
import java.util.List;

/**
 * Created by gadzik on 23.12.17.
 */
public interface AccountService {
    Account getById(Parameters params);
    List<Account> getAll();
}
