package ru.coins;

/**
 * Created by nik on 4/2/2017.
 */
public class Coin {
    /**
     * Array of coins.
     */
    private int[] coins;
    /**
     * Array count of coins.
     */
    private int[] res;
    /**
     * Counter of coins.
     */
    private int count;

    /**
     * Constructor.
     * @param coins - array of coins.
     */
    public Coin(int[] coins) {
        this.coins = coins;
        res = new int[coins.length];
        this.count = 0;
        this.sort();
    }

    /**
     * Sort array.
     */
    private void sort() {
        int tmp;
        for (int  i = 0; i < coins.length; i++) {
            for (int j = i + 1; j < coins.length; j++) {
                if (coins[j] < coins[i]) {
                    tmp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = tmp;
                }
            }
        }
    }

    /**
     * Change coin method.
     * @param maxCoin - index of max coin to change.
     * @param s - coin for change.
     */
    public void recurs(int maxCoin, int s) {
        int i;
        if (s == 0) {
            for (i = res.length - 1; i >= 0; i--) {
                if (res[i] != 0) {
                    for (int j = 0; j < res[i]; j++) {
                        System.out.print(coins[i]);
                    }
                }
            }
            System.out.print("\n");
            count++;
            return;
        }
        if (s >= coins[maxCoin]) {

            res[maxCoin]++;
            recurs(maxCoin, s - coins[maxCoin]);
            res[maxCoin]--;
        }
        if (maxCoin != 0) {
            recurs(maxCoin - 1, s);
        }
    }
//    public static void main(String[] args) {
//        int[] arr = new int[] {1, 5, 2};
//        Coin coin = new Coin(arr);
//        int k = 2;
//        int s = 12;
//        coin.recurs(k, s);
//    }
}
