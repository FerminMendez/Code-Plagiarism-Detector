package ex2;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Jean-Nicolas
 */
public class Ex2 {

    private static ArrayList<ArrayList<Integer>> getCombinaisons(int p, int n) {
        return getCombinaisons(p, n, new ArrayList<Integer>());
    }

    private static ArrayList<ArrayList<Integer>> getCombinaisons(int p, int n, ArrayList<Integer> currentCombinaison) {

        if (p == 0) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            result.add(currentCombinaison);
            return result;
        } else {

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            // on trouve le max actuel de la liste
            int currentMax;

            if (currentCombinaison.isEmpty()) {
                currentMax = -1;
            } else {
                currentMax = currentCombinaison.get(currentCombinaison.size() - 1);
            }

            for (int i = currentMax + 1; i < n; i++) {
                ArrayList<Integer> newCurrentCombinaison = (ArrayList<Integer>) currentCombinaison.clone();
                newCurrentCombinaison.add(i);
                result.addAll(getCombinaisons(p - 1, n, newCurrentCombinaison));
            }

            return result;
        }
    }

    private static int getMaxScoreFromPoints(int totalPoints, boolean surprising) {
        if (surprising) {

            if (totalPoints < 2) {
                return 0;
            } else {
                int totalPointsTmp;

                if (totalPoints % 3 == 2) {
                    totalPointsTmp = totalPoints + 1;
                } else if (totalPoints % 3 == 1) {
                    totalPointsTmp = totalPoints - 1;
                } else {
                    totalPointsTmp = totalPoints;
                }

                int avg = totalPointsTmp / 3;

                int maxScore = avg + 1;

                return maxScore;
            }
        } else {
            if (totalPoints < 1) {
                return 0;
            } else {

                int totalPointsTmp;

                if (totalPoints % 3 == 1) {
                    totalPointsTmp = totalPoints + 2;
                } else if (totalPoints % 3 == 2) {
                    totalPointsTmp = totalPoints + 1;
                } else {
                    totalPointsTmp = totalPoints;
                }

                int maxScore = totalPointsTmp / 3;

                return maxScore;
            }
        }
    }

    public static int resultCount(int[] totalPoints, int nbSurprising, int bestResultMin) {
        ArrayList<ArrayList<Integer>> combinaisons = getCombinaisons(nbSurprising, totalPoints.length);

        int maxCount = 0;
        for (int i = 0; i < combinaisons.size(); i++) {

            int countThisCombinaison = 0;
            for (int j = 0; j < totalPoints.length; j++) {
                int maxScore = getMaxScoreFromPoints(totalPoints[j], combinaisons.get(i).contains(j));

                if (maxScore >= bestResultMin) {
                    countThisCombinaison++;
                }
            }

            maxCount = Math.max(maxCount, countThisCombinaison);
        }

        return maxCount;
    }

    public static String readFile(File file) {

        String result = "";
        try {
            InputStream ips = new FileInputStream(file);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;
            while ((line = br.readLine()) != null) {
                result += line + "\n";
            }
            br.close();
            result.substring(0, Math.max(0, result.length() - 1)); // Deletion of the last \n
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    public static void writeFile(File file, String data) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(data);
            out.close();
        } catch (IOException ex) {
            System.out.println("Exception ");
        }
    }

    public static void main(String[] args) {

        String resultStr = "";

        String data = readFile(new File("data.txt"));
        String[] lines = data.split("\n");

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(" ");
            int nbSurprising = Integer.parseInt(values[1]);
            int bestResultMin = Integer.parseInt(values[2]);
            int[] totalPoints = new int[values.length - 3];

            for (int j = 0; j < totalPoints.length; j++) {
                totalPoints[j] = Integer.parseInt(values[j + 3]);
            }

            int result = resultCount(totalPoints, nbSurprising, bestResultMin);

            resultStr += "Case #" + i + ": " + result + "\n";
        }
        resultStr = resultStr.substring(0, resultStr.length() - 1);
        System.out.println(resultStr);
        writeFile(new File("result.txt"), resultStr);
    }
}
