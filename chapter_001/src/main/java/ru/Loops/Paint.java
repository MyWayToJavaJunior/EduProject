package ru.loops;

/**
* Paint triangle.
* @author nik1202
* @since 02.03.2017
* @version 0.1
*/

public class Paint {

	/**
	* Paint.
	* @param h - height of pyramid.
	* @return result pyramid.
	*/
String piramid(int h) {
StringBuilder result = new StringBuilder();
        int strLen = h * 2 - 1;
        int rSin = h - 1;
        int lSin = h - 1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < strLen; j++) {
                if (lSin == j && rSin == j) {
                    result.append('^');
                    lSin--;
                    rSin++;
                    break;
                }
                if (j == lSin) {
                    result.append('^');
                    lSin--;
				} else if (j == rSin) {
                    result.append('^');
                    rSin++;
                    break;
				} else if (j != lSin && j != rSin) {
                    result.append(' ');
                }
            }
            result.append('\n');
        }
        return result.toString();
	}
}