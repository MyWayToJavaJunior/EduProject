package ru.substr;

/**
* Detect subtring in string.
* @author nik1202
* @since 05.03.2017
* @version 0.1
*/

public class DetectSubStr {

	/**
	* Detect subtring in string.
	* @param origin string.
	* @param sub substring.
	* @return is substring contains in string.
	*/
	boolean contains(String origin, String sub) {
        boolean result = false;
        char[] or = origin.toCharArray();
        char[] sb = sub.toCharArray();
		int count = 0;
        for (int i = 0; i < or.length - sb.length; i++) {
            if (or[i] == sb[0]) {
                for (int j = 0; j < sb.length; j++) {
                    if (or[i + j] == sb[j]) {
                        count++;
                    } else {
                        count = 0;
                        break;
                    }
                }
				if (count == sb.length) {
					result = true;
					break;
				}
            }
        }
        return result;
    }
}