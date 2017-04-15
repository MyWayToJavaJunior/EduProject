package ru.unimas;

/**
* Union 2 arrays.
* @author nik1202
* @since 07.03.2017
* @version 0.1
*/

public class Unimas {

	/**
	* Detect subtring in string.
	* @param mas1 first array.
	* @param mas2 second array.
	* @return union array.
	*/
	int[] union(int[] mas1, int[] mas2) {
        int[] result = new int[mas1.length + mas2.length];
        int j = 0, k = 0;
        for (int i = 0; i < result.length; i++) {
            if (j < mas1.length && k < mas2.length && (mas1[j] < mas2[k])) {
                result[i] = mas1[j];
                j++;
            } else if (j < mas1.length && k < mas2.length && (mas1[j] >= mas2[k])) {
                result[i] = mas2[k];
                k++;
            } else if (j == mas1.length) {
                result[i] = mas2[k];
                k++;
            } else if (k == mas2.length) {
                result[i] = mas1[j];
                j++;
            }
        }
        return result;
    }
}