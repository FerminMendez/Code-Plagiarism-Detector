/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.recycled.numbers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lucas
 */
public class RecycledNumbers {

    public ArrayList<Integer> findRecycledNumbers(ArrayList<Integer[]> list) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Integer[] current;
        int x;
        int y;
        int total;
        int temp;
        String str;

        for (int n = 0; n < list.size(); n++) {

            current = list.get(n);
            total = 0;

            x = current[0];
            y = current[1];

            for (int m = x; m <= y; m++) {

                str = String.valueOf(m);

                for (int j = 0; j < str.length() - 1; j++) {

                    str = str.substring(1) + str.charAt(0);
                    temp = Integer.parseInt(str);

                    if ((temp <= y) && (temp > m) && (temp >= x)) { 
                        total++;
                    }
                }
            }
            result.add(total);
        }
        return result;
    }
}
