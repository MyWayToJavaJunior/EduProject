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
        for (int i = 0; i < or.length; i++) {
            if (or[i] == sb[0]) {
                for (int j = 1; j < sb.length; j++) {
                    if (or[++i] != sb[j]) {
                        result = false;
						count = 0;
                        break;
                    }
                    result = true;
					count++;
                }
				if (count == sb.length - 1) {
					break;
				}
            }
        }
        return result;
    }
}