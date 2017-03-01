package ru.bespalov;

/**
* Sum of range.
* @author nik1202
* @since 01.03.2017
* @version 0.1
*/

public class Counter {

	/**
	* Sum of range.
	* @param start - begin of range.
	* @param finish - end of range.
	* @return result sum of range.
	*/
	int add(int start, int finish) {
		int result = 0;
		for (; start <= finish; start++) {
			if (start % 2 == 0) {
				result += start;
			}
		}
		return result;
	}
}