package ru.arrays;

/**
* Turn array.
* @author nik1202
* @since 02.03.2017
* @version 0.1
*/

public class Turn {

	/**
	* Turn array.
	* @param mas array for turn.
	*/
	void back(int[] mas) {
		int centr = mas.length / 2;
        int tmp;
        int end = mas.length - 1;
        for (int i = 0; centr > i; i++) {
            tmp = mas[i];
            mas[i] = mas[end];
            mas[end] = tmp;
            end--;
        }
	}
}