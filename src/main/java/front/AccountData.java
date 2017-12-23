package front;

import model.Account;

import java.util.List;

/**
 * Created by gadzik on 18.12.17.
 */
public class AccountData {

    private Account account;
    private List<Account> accounts;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
