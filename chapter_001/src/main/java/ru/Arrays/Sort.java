package ru.arrays;

/**
* Sort array.
* @author nik1202
* @since 02.03.2017
* @version 0.1
*/

public class Sort {

	/**
	* Sort array.
	* @param mas array for sort.
	*/
	void bubbleSort(int[] mas) {
		int tmp;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
            }
        }
	}
}