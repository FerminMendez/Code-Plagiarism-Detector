/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author tal
 */
public class Second {

    public static final int MAX_NUMBER = 11;
    public static Map<Integer, Map<Collection<Integer>, Boolean>> fullLearnedMap;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        fullLearnedMap = learn();
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);

        String readLine = in.readLine();
        int n = Integer.parseInt(readLine);
        for (int i = 0; n > 0; i++) {
            String caseText = in.readLine();
            if (caseText == null || caseText.isEmpty()) {
                break;
            }
            System.out.println("Case #" + (i + 1) + ": " + maxPoints(caseText));
            n--;
        }
        in.close();
    }

    public static Map<Integer, Map<Collection<Integer>, Boolean>> learn() {
        Map<Integer, Map<Collection<Integer>, Boolean>> map = new TreeMap<Integer, Map<Collection<Integer>, Boolean>>();
        int N = 0;
        for (int i = 0; i < MAX_NUMBER; i++) {
            for (int j = i; j < MAX_NUMBER; j++) {
                for (int k = j; k < MAX_NUMBER; k++) {
                    if (Math.abs(i - j) > 2 || Math.abs(i - k) > 2 || Math.abs(j - k) > 2) {
                        continue;
                    }
                    int sum = i + j + k;
                    Map<Collection<Integer>, Boolean> triples = map.get(sum);
                    Boolean surprise = false;
                    if (Math.abs(i - j) > 1 || Math.abs(i - k) > 1 || Math.abs(j - k) > 1) {
                        surprise = true;
                    }
                    Integer[] triple = {i, j, k};
                    if (triples == null) {
                        triples = new HashMap<Collection<Integer>, Boolean>();
                        map.put(sum, triples);
                    }
                    triples.put(Arrays.asList(triple), surprise);
                    N++;
                }
            }
        }
        //System.out.println("Total: " + N);
        return map;
    }

    public static Integer maxPoints(String input) {
        String[] split = input.split(" ");
        int N = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int p = Integer.parseInt(split[2]);
        int[] dancersScores = new int[N];
        for (int i = 3; i < 3 + N; i++) {
            dancersScores[i - 3] = Integer.parseInt(split[i]);
        }
        return findMaxRec(dancersScores, p, S);
    }

    public static Integer findMaxRec(int[] reducedDancersScores, Integer p, Integer S) {
        if (reducedDancersScores == null || reducedDancersScores.length == 0 || S < 0) {
            return 0;
        }
        int localMax = 0;
        int[] copyOfRange;
        if (reducedDancersScores.length == 1) {
            copyOfRange = null;
        } else {
            copyOfRange = Arrays.copyOfRange(reducedDancersScores, 1, reducedDancersScores.length);
        }
        Map<Collection<Integer>, Boolean> triples = fullLearnedMap.get(reducedDancersScores[0]);
        for (Map.Entry<Collection<Integer>, Boolean> triple : triples.entrySet()) {
            if (relevantTriple(triple.getKey(), p)) {
                if (triple.getValue()) {
                    if (S > 0) {
                        Integer foundMaxOnSubset = findMaxRec(copyOfRange, p, S - 1); // recursive call
                        if (localMax < 1 + foundMaxOnSubset) {
                            localMax = 1 + foundMaxOnSubset;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Integer foundMaxOnSubset = findMaxRec(copyOfRange, p, S); // recursive call
                    if (localMax < 1 + foundMaxOnSubset) {
                        localMax = 1 + foundMaxOnSubset;
                    }

                }
            }
        }
        Integer foundMaxRec = findMaxRec(copyOfRange, p, S);
        if (localMax < foundMaxRec) {
            localMax = foundMaxRec;
        }

        return localMax;
    }

    public static boolean relevantTriple(Collection<Integer> triple, int min) {
        for (Integer judgeScore : triple) {
            if (judgeScore >= min) {
                return true;
            }
        }
        return false;
    }
}
