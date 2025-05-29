import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * Author: Andriy Gusyev
 * Date: 14.04.12
 */
public class Task3 {

    private static class Case {

        private int googlers;

        private int surprising;

        private int minScore;

        private int[] totalScores;

        @Override
        public String toString() {
            return "Case{" +
                    "googlers=" + googlers +
                    ", surprising=" + surprising +
                    ", minScore=" + minScore +
                    ", totalScores=" + Arrays.toString(totalScores) +
                    "}\n";
        }
    }

    private static class Dancer {

        private Integer bestSurprisedScore;

        private Integer bestNonSuprisedScore;

        public Dancer(int totalScore) {
            if (totalScore == 0) {
                bestNonSuprisedScore = 0;
                bestSurprisedScore = 0;
                return;
            }
            switch (totalScore % 3) {
                case 0:
                    bestNonSuprisedScore = totalScore / 3;
                    bestSurprisedScore = totalScore / 3 + 1;
                    if (bestSurprisedScore > 10) {
                        bestSurprisedScore = 10;
                    }
                    break;
                case 1:
                    bestNonSuprisedScore = totalScore / 3 + 1;
                    bestSurprisedScore = totalScore / 3 + 1;
                    if (bestSurprisedScore > 10) {
                        bestSurprisedScore = 10;
                    }
                    break;
                case 2:
                    bestNonSuprisedScore = totalScore / 3 + 1;
                    bestSurprisedScore = totalScore / 3 + 2;
                    if (bestSurprisedScore > 10) {
                        bestSurprisedScore = 10;
                    }
            }
        }

        @Override
        public String toString() {
            return "Dancer{" +
                    "bestNonSuprisedScore=" + bestNonSuprisedScore +
                    ", bestSurprisedScore=" + bestSurprisedScore +
                    "}\n";
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }

    static private int cases;

    static private Case[] objs;

    static private int[] results;

    private static void readInput(String s, int index) {
        s = s.trim();
        String[] arr = s.split(" ");
        Case cas = new Case();
        cas.googlers = Integer.parseInt(arr[0]);
        cas.surprising = Integer.parseInt(arr[1]);
        cas.minScore = Integer.parseInt(arr[2]);
        cas.totalScores = new int[cas.googlers];
        for (int i = 0; i < cas.googlers; i++) {
            cas.totalScores[i] = Integer.parseInt(arr[3 + i]);
        }
        objs[index] = cas;
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(new File("d:/codejam/3/small"), "UTF-8");
        cases = Integer.parseInt(sc.nextLine());
        objs = new Case[cases];
        results = new int[cases];
        for (int i = 0; i < cases; i++) {
            readInput(sc.nextLine(), i);
        }

        for (int i = 0; i < cases; i++) {
            results[i] = proceedCase(objs[i]);
        }
        System.out.println(Arrays.toString(results));
        FileWriter fw = new FileWriter(new File("d:/codejam/3/small_out"));
        int k = 0;
        for (int i : results) {
            k++;
            fw.write(String.format("Case #%s: %s\n", String.valueOf(k), String.valueOf(i)));
        }
        fw.close();
    }

    private static int proceedCase(Case cas) {
        int result = 0;
        List<Dancer> dancers = new ArrayList<Dancer>();
        for (int i = 0; i < cas.googlers; i++) {
            dancers.add(new Dancer(cas.totalScores[i]));
        }
        Collections.sort(dancers, new Comparator<Dancer>() {
            public int compare(Dancer o1, Dancer o2) {
                if (o1.bestNonSuprisedScore == o2.bestNonSuprisedScore) {
                    return -o1.bestSurprisedScore.compareTo(o2.bestSurprisedScore);
                }
                return -o1.bestNonSuprisedScore.compareTo(o2.bestNonSuprisedScore);
            }
        });
        System.out.println(dancers);
        int surprisedUsed = 0;
        for (Dancer dancer : dancers) {
            if (dancer.bestNonSuprisedScore >= cas.minScore) {
                result++;
                continue;
            } else if (dancer.bestSurprisedScore >= cas.minScore && cas.surprising > surprisedUsed) {
                result++;
                surprisedUsed++;
                continue;
            }
        }
        return result;
    }
}
