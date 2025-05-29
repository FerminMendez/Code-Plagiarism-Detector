/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qualification.Dancing;

import java.util.*;

/**
 *
 * @author farshid
 */
public class Dancing {

    public Dancing() {
    }

    public int solve(String problem) {
        String[] arr = problem.split(" ");

        int n = Integer.parseInt(arr[0]);
        int s = Integer.parseInt(arr[1]);
        int p = Integer.parseInt(arr[2]);
        int[] scores = new int[arr.length - 3];

        for (int i = 3; i < arr.length; i++) {
            scores[i - 3] = Integer.parseInt(arr[i]);
        }

        LinkedList<LinkedList<Combination>> combs =
                new LinkedList<LinkedList<Combination>>();

        for (int i = 0; i < scores.length; i++) {
            LinkedList<Combination> l = this.dancerPossibleCombs(scores[i], p);
            combs.add(l);
        }

        int max = this.processCombination(combs, s);

        return max;
    }

    public void test() {
    
    }

    private int processCombination(LinkedList<LinkedList<Combination>> combs, int maxSur) {

        int max = 0;
        int currentSur = 0;

        for (int i = 0; i < combs.size(); i++) {
            LinkedList<Combination> current = combs.get(i);
            boolean increased = false;
            
            for (int j = 0; j < current.size(); j++) {
                if (!current.get(j).isSurprising()){
                    max++;
                    increased = true;
                    break;
                }
            }
            
            if (!increased && !current.isEmpty() && currentSur < maxSur){
                max++;
                currentSur++;
            }
        }

        return max;
    }

    private LinkedList<Combination> dancerPossibleCombs(int total, int p) {

        LinkedList<Combination> list = new LinkedList<Combination>();

        // Get all possible combs
        for (int i = 0; i <= 10; i++) {

            if ((i + 2) >= p && (3 * i) + 4 >= total) { // otherwise no possible/useful combination

                // 8 possible combs
                if (3 * i == total && i >= p) {
                    Combination c = new Combination(
                            new int[]{i, i, i}, false);
                    list.add(c);
                    continue;
                }
                if ((3 * i + 1) == total && (i + 1) >= p) {
                    Combination c = new Combination(
                            new int[]{i, i, i + 1}, false);
                    list.add(c);
                    continue;
                }

                if ((3 * i + 2) == total) {
                    if (i + 2 >= p) {
                        Combination c1 = new Combination(
                                new int[]{i, i, i + 2}, true);
                        list.add(c1);
                    }
                    if (i + 1 >= p) {
                        Combination c2 = new Combination(
                                new int[]{i, i + 1, i + 1}, false);

                        list.add(c2);
                    }

                    continue;
                }

                if (3 * i + 3 == total && (i + 2) >= p) {
                    Combination c = new Combination(
                            new int[]{i, i + 1, i + 2}, true);
                    list.add(c);
                    continue;
                }

                if (3 * i + 4 == total && (i + 2) >= p) {
                    Combination c1 = new Combination(
                            new int[]{i, i + 2, i + 2}, true);
                    list.add(c1);
                }
            }
        }

        return list;

    }
}
