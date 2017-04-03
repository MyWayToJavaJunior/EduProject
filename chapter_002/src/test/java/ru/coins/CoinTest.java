package ru.coins;

import org.junit.Test;

/**
 * Created by nik on 4/2/2017.
 */
public class CoinTest {
    /**
     * Test changing coins.
     */
    @Test
    public void whenCoinChangeThenOK() {
        int[] coins = new  int[]{1, 2, 5};
        Coin coin = new Coin(coins);
        coin.recurs(coins.length - 1, 12);
    }
}
