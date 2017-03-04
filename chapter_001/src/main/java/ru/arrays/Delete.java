package ru.arrays;
import java.util.Arrays;
/**
* Delete duplicates array.
* @author nik1202
* @since 03.03.2017
* @version 0.1
*/

public class Delete {

	/**
	* Delete buplicates array.
	* @param mas array for delete.
	* @return array without duplicates.
	*/
	String[] del(String[] mas) {
		int len = mas.length;
        int end = len - 1;
        int count = 0;
        String tmp;
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j <= end; j++) {
                if (mas[i].equals(mas[j]) && i != j) {
                    tmp = mas[j];
                    for(int t = j; t < end; t++) {
                        mas[t] = mas[t + 1];
                    }
                    mas[end] = tmp;
                   // tmp = mas[end];
                   // tmp1 = mas[end - 1];
                   // mas[end]=mas[j];
                   //  mas[j]=tmp;
                    end--;
                    count++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(mas, len - count);
	}
}