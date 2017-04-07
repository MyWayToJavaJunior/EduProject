package ru.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/7/2017.
 */
public class BankTest {
    /**
     * Test transfet money is ok.
     */
    @Test
    public void whenTransferMoneyIsOkThenTrue() {
        Bank bank = new Bank();
        boolean testData = true;
        User first = new User("first name", "first passport");
        User second = new User("second name", "second passport");

        bank.addUser(first);
        bank.addUser(second);

        Account firstAc1 =  new Account(100, 111);
        Account firstAc2 =  new Account(110, 112);
        Account secondAc1 =  new Account(150, 211);

        bank.addAccountToUser(first, firstAc1);
        bank.addAccountToUser(first, firstAc2);

        bank.addAccountToUser(second, secondAc1);

        boolean result = bank.transferMoney(first, firstAc1, second, secondAc1, 50);
        assertThat(testData, is(result));
    }

    /**
     * Test transfet money is not ok.
     */
    @Test
    public void whenTransferMoneyIsNotOfThenFalse() {
        Bank bank = new Bank();
        boolean testData = false;
        User first = new User("first name", "first passport");
        User second = new User("second name", "second passport");

        bank.addUser(first);
        bank.addUser(second);

        Account firstAc1 =  new Account(100, 111);
        Account firstAc2 =  new Account(110, 112);
        Account secondAc1 =  new Account(150, 211);

        bank.addAccountToUser(first, firstAc1);
        bank.addAccountToUser(first, firstAc2);

        bank.addAccountToUser(second, secondAc1);

        boolean result = bank.transferMoney(first, firstAc1, second, secondAc1, 250);
        assertThat(testData, is(result));
    }
}
