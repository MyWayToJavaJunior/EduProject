package ru.arrays;

/**
* Rotate array.
* @author nik1202
* @since 03.03.2017
* @version 0.1
*/

public class Rotate {

	/**
	* Rotate array.
	* @param mas array for rotate.
	*/
	void rotate(int[][] mas) {
		int len = mas.length;
        int tmp;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                tmp = mas[i][j];
                mas[i][j] = mas[len - j - 1][i];
                mas[len - j - 1][i] = mas[len - i - 1][len - j - 1];
                mas[len - i - 1][len - j - 1] = mas[j][len - i - 1];
                mas[j][len - i - 1] = tmp;
            }
        }
	}
}