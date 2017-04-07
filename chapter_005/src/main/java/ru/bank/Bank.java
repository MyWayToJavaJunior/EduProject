package ru.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by nik on 4/7/2017.
 */
public class Bank {
    /**
     * Map of clients.
     */
    private Map<User, List<Account>> bank = new HashMap<User, List<Account>>();

    /**
     * Add user.
     * @param user - user to add.
     */
    public void addUser(User user) {
        bank.put(user, new ArrayList<Account>());
    }

    /**
     * Delete user.
     * @param user - user to delete.
     */
    public void deleteUser(User user) {
        bank.remove(user);
    }

    /**
     * Add account user.
     * @param user - user to add.
     * @param account - account to add.
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> tmp = bank.get(user);
        tmp.add(account);
        bank.put(user, tmp);
    }

    /**
     * Delete account user.
     * @param user - user to delete.
     * @param account - account to delete.
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> tmp = bank.get(user);
        for (Account a : tmp) {
            if (a.getRequisites() == account.getRequisites()) {
                tmp.remove(account);
            }
        }
    }

    /**
     * Get all accounts of user.
     * @param user - user.
     * @return - list of accounts
     */
    public List<Account> getUserAccounts(User user) {
        return bank.get(user);
    }


    /**
     * Get all accounts of user.
     * @param srcUser - source user.
     * @param srcAccount - source account.
     * @param dstUser - destination user.
     * @param dstAccount - destination account.
     * @param amount - ammout.
     * @return - result.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;

        List<Account> srcAccs = bank.get(srcUser);
        List<Account> dstAccs = bank.get(dstUser);

        Account srcAcc = null;
        for (Account a : srcAccs) {
            if (a == srcAccount) {
                srcAcc = a;
            }
        }

        Account dstAcc = null;
        for (Account a : dstAccs) {
            if (a == dstAccount) {
                dstAcc = a;
            }
        }

        if (srcAcc != null && dstAcc != null) {
            if (srcAcc.getValue() - amount > 0) {
                srcAcc.setValue(srcAcc.getValue() - amount);
                dstAcc.setValue(dstAcc.getValue() + amount);
                result = true;
            }
        }
        return result;
    }
}
