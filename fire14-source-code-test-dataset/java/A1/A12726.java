package qualification;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
    static int numberOfSurprises;
    static int atLeastP;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("B-small-attempt2.in"));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numberOfGooglers = scanner.nextInt();
            numberOfSurprises = scanner.nextInt();
            atLeastP = scanner.nextInt();

            int total = 0;
            for (int j = 0; j < numberOfGooglers; j++) {
                int score = scanner.nextInt();
                HashSet<List<Integer>> combinations = computeCombinationsForThisScore(score);
                // printCombinations(combinations);
                total += solve(score, combinations);
            }
            System.out.format("Case #%d: %d\n", (i + 1), total);
        }
    }

    private static int solve(int score, HashSet<List<Integer>> combinationsForThisScore) {
        List<List<Integer>> listaSemChance = new ArrayList<List<Integer>>();
        for (List<Integer> list : combinationsForThisScore) {
            Integer a = list.get(0);
            Integer b = list.get(1);
            Integer c = list.get(2);
            if (Math.abs(a - b) < 2 && Math.abs(a - c) < 2 && Math.abs(b - c) < 2) {
                listaSemChance.add(list);
            }
        }

        for (List<Integer> list : listaSemChance) {
            for (Integer integer : list) {
                if (integer >= atLeastP) {
                    return 1;
                }
            }
        }

        List<List<Integer>> listaComChance = new ArrayList<List<Integer>>();
        for (List<Integer> list : combinationsForThisScore) {
            Integer a = list.get(0);
            Integer b = list.get(1);
            Integer c = list.get(2);
            if (Math.abs(a - b) == 2 || Math.abs(a - c) == 2 || Math.abs(b - c) == 2) {
                listaComChance.add(list);
            }
        }

        for (List<Integer> list : listaComChance) {
            for (Integer integer : list) {
                if (integer >= atLeastP && numberOfSurprises > 0) {
                    numberOfSurprises--;
                    return 1;
                }
            }
        }

        return 0;
    }

    private static void printCombinations(HashSet<List<Integer>> combinations) {
        for (List<Integer> list : combinations) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static HashSet<List<Integer>> computeCombinationsForThisScore(int score) {
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
        for (int a = 10; a >= 0; a--) {
            for (int b = 10; b >= 0; b--) {
                for (int c = 10; c >= 0; c--) {
                    if (a + b + c != score) {
                        continue;
                    }

                    if (Math.abs(a - b) > 2 || Math.abs(a - c) > 2 || Math.abs(b - c) > 2) {
                        continue;
                    }

                    // System.out.format("Score: %d -> %d %d %d\n", score, a, b,
                    // c);
                    List<Integer> list = giveThemOrderedInAList(a, b, c);
                    hashSet.add(list);
                }
            }
        }
        return hashSet;
    }

    private static List<Integer> giveThemOrderedInAList(int a, int b, int c) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list);
        return list;
    }
}
