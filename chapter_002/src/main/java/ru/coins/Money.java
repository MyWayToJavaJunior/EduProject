package ru.coins;

/**
 * Created by nik on 4/3/2017.
 */
public class Money {
    /**
     * Array of coins.
     */
    private int[] coinsNom;

    /**
     * Constructor.
     * @param coinsNom - array of coins.
     */
    public Money(int[] coinsNom) {
        this.coinsNom = coinsNom;
    }

    /**
     * Method.
     * @param money - money.
     */
    public void getCountOfWay(int money) {
        getCountOfWay(money, 0, "");
    }

    /**
     * Methhod.
     * @param money - money.
     * @param indexOfCoin - index of coin.
     * @param str - string.
     */
    private void getCountOfWay(int money, int indexOfCoin, String str) {
        if (money < 0) {
            return;
        }
        if (money == 0) {
            System.out.println(str);
            return;
        }
        for (int i = indexOfCoin; i < this.coinsNom.length; i++) {
            StringBuilder sb = new StringBuilder(str);
            getCountOfWay(money - this.coinsNom[i], i, sb.append(this.coinsNom[i]).toString());
        }
    }
//    public static void main(String[] args) {
//        Money coins = new Money(new int[] {1, 2, 5});
//        coins.getCountOfWay(10);
//    }

}
