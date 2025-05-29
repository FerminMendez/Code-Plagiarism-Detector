
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOSE
 */
public class DancingWithTheGooglers {

    public void process() {
        ArrayList<String> inputList = readFile("B-small-attempt0.in");
        String output = "";
        int testCase = 0;
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            if (i == 0) {
                testCase = Integer.parseInt(input);
            } else {
                int result = eachTestcaseProcess(input);
                output = output + "Case #" + i + ": " + result;
                if (i != (inputList.size() - 1)) {
                    output = output + '\n';
                }
            }
        }
        writeFile(output);
    }

    public int eachTestcaseProcess(String input) {
        // String test = "3 1 5 15 13 11";
        String spliInputt[] = input.split("\\s");
        int googler = 0;
        int serprise = 0;
        int p = 0;
        double[] totalpoint = null;
        int resultCount = 0;

        for (int i = 0; i < spliInputt.length; i++) {
            if (i == 0) {
                googler = Integer.parseInt(spliInputt[i]);
                totalpoint = new double[googler];
            } else if (i == 1) {
                serprise = Integer.parseInt(spliInputt[i]);
            } else if (i == 2) {
                p = Integer.parseInt(spliInputt[i]);
            } else {
                totalpoint[i - 3] = Double.parseDouble(spliInputt[i]);
            }
        }

        int[][] triplet = new int[googler][3];

        for (int i = 0; i < totalpoint.length; i++) {
            double divide = totalpoint[i] / 3;
            double mod = totalpoint[i] % 3;

            triplet[i][0] = (int) divide;
            triplet[i][1] = (int) divide;
            triplet[i][2] = (int) divide;
            for (int j = 0; j < mod; j++) {
                triplet[i][j]++;
            }
        }

        for (int i = 0; i < triplet.length; i++) {
            boolean flag = false;
            int checkSurprising = 0;
            while (checkSurprising != -1) {
                checkSurprising = findSurprising(triplet, i);
                if (checkSurprising != -1) {

                    flag = isEquealOrGreaterThanP(triplet, p, i);
                    if (flag && (checkSurprising != 1 || serprise > 0)) {
                        if (checkSurprising == 1) {
                            serprise--;
                        }
                        resultCount++;
                        checkSurprising = -1;
                    } else {
                        if (triplet[i][1] > 0) {
                            triplet[i][0]++;
                            triplet[i][1]--;
                        } else {
                            checkSurprising = -1;
                        }
                    }
                }
            }
        }

        return resultCount;
    }

    private int findSurprising(int[][] triplet, int i) {
        int a = (triplet[i][0] - triplet[i][1]);
        int b = (triplet[i][0] - triplet[i][2]);
        int c = (triplet[i][1] - triplet[i][2]);
        int result = -1;
        if (a < 2 && b < 2 && c < 2) {
            result = 0;
        } else if ((a <= 2 && b <= 2 && c <= 2)) {
            result = 1;
        }
        return result;
    }

    private boolean isEquealOrGreaterThanP(int[][] triplet, int p, int i) {
        boolean result = false;
        for (int j = 0; j < 3; j++) {
            if (triplet[i][j] >= p) {
                result = true;
            }
        }
        return result;
    }

    private ArrayList<String> readFile(String fileName) {

        BufferedReader br = null;
        ArrayList<String> inputList = null;
        try {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
            String message = null;
            inputList = new ArrayList<String>();
            while ((message = br.readLine()) != null) {
                inputList.add(message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return inputList;
        }
    }

    private void writeFile(String message) {
        BufferedWriter bw = null;
        try {
            File file = new File("Output.txt");
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DancingWithTheGooglers dwtg = new DancingWithTheGooglers();
        dwtg.process();
    }
}
