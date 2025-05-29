/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.dancing.with.the.googlers;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class BestResultFinder {

    public ArrayList<Integer> findBestResult(ArrayList<ArrayList> list) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> current;
        int total;
        int surprising;
        int min;
        int value;

        for (int n = 0; n < list.size(); n++) {

            current = list.get(n);
            total = 0;
            surprising = current.get(1);
            min = current.get(2);

            for (int m = 0; m < current.get(0); m++) {

                value = current.get(3 + m) / 3;

                switch (current.get(3 + m) % 3) {

                    // (n, n, n) -> Regular
                    // (n - 1, n , n + 1) -> Surprising

                    case 0: {

                        if (value >= min) {
                            total++;
                        } else if ((surprising > 0) && (value > 0) && (value + 1 >= min)) {
                            total++;
                            surprising--;
                        }
                        break;
                    }
                        
                    // (n, n, n + 1) -> Regular
                    // (n - 1, n + 1, n + 1) -> Surprising
                            
                    case 1: {
                        if ((value >= min) || (value + 1 >= min)) {
                            total++;
                        } else if ((surprising > 0) && (value + 1 >= min)) {
                            total++;
                            surprising--;
                        }
                        break;
                    }
                        
                    // (n, n + 1, n + 1) -> Regular
                    // (n, n, n + 2) -> Surprising
                        
                    case 2: {
                        if ((value >= min) || (value + 1 >= min)) {
                            total++;
                        } else if ((surprising > 0) && (value + 2 >= min)) {
                            total++;
                            surprising--;
                        }
                        break;
                    }
                }
            }
            result.add(total);
        }
        return result;
    }
}
