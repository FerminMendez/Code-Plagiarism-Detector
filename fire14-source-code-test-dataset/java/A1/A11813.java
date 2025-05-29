package codejam.codejam_2012;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: csrazvan
 * Date: 14.04.2012
 * Time: 02:43
 * To change this template use File | Settings | File Templates.
 */
public class DancingWithGooglers {
    static private boolean DEBUG = false;

    public void solve() throws Exception {
        Scanner scanner = new Scanner(new File("dancing.in"));
        int t = scanner.nextInt();
        scanner.nextLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("dancing.out")));
        for (int i = 1; i <= t; i++) {
            String split[] = scanner.nextLine().split(" ");
            System.out.println("Solving " + i);
            solveCase(split, i, bw);
        }
        bw.close();

    }

    public void solveCase(String[] split, int caseNr, BufferedWriter bw) throws FileNotFoundException, IOException {
        int n = Integer.parseInt(split[0]);
        int surprisingCount = Integer.parseInt(split[1]);
        int p = Integer.parseInt(split[2]);
        Case[][] matrix = new Case[n][7];
        int size[] = new int[n];

        for (int i = 0; i < n; i++) {
            int j = 0;
            int number = Integer.parseInt(split[3 + i]);

            // 1:a a a
            if (number % 3 == 0) {
                int a = number / 3;
                boolean ge = false;
                if (a >= p) {
                    ge = true;
                }
                matrix[i][j++] = new Case(false, ge, 1);
                size[i]++;
            }
            // 2:a a a+1
            if ((number - 1 >= 0) & ((number - 1) % 3 == 0)) {
                int a = (number - 1) / 3;
                boolean ge = false;
                if ((a + 1) >= p) {
                    ge = true;
                }
                matrix[i][j++] = new Case(false, ge, 2);
                size[i]++;
            }

            // 3:a a+1 a+1
            if ((number - 2 >= 0) & ((number - 2) % 3 == 0)) {
                int a = (number - 2) / 3;
                boolean ge = false;
                if ((a + 1) >= p) {
                    ge = true;
                }
                matrix[i][j++] = new Case(false, ge, 3);
                size[i]++;
            }

            // 4:a a a+2
            if ((number - 2 >= 0) & ((number - 2) % 3 == 0)) {
                int a = (number - 2) / 3;
                boolean ge = false;
                if ((a + 2) >= p) {
                    ge = true;
                }
                matrix[i][j++] = new Case(true, ge, 4);
                size[i]++;
            }
            // 5:a a a+2
            if ((number - 4 >= 0) & ((number - 4) % 3 == 0)) {
                int a = (number - 4) / 3;
                boolean ge = false;
                if ((a + 2) >= p) {
                    ge = true;
                }
                matrix[i][j++] = new Case(true, ge, 5);
                size[i]++;
            }

            // 6:a a+1 a+2
            if ((number - 3 >= 0) & ((number - 3) % 3 == 0)) {
                int a = (number - 3) / 3;
                boolean ge = false;
                if ((a + 2) >= p || (a + 1) >= p) {
                    ge = true;
                }
                matrix[i][j++] = new Case(true, ge, 6);
                size[i]++;
            }
        }

        if (DEBUG) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < size[i]; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // a little backtracking .....:(
        int combinations[] = new int[n];
        Arrays.fill(combinations, 0);
        int bestScore = 0;
        int k = n - 1;
        while (combinations[0] < size[0] && k >= 0) {
            // do some logic 
            int nrStrange = 0;
            int bestLocal = 0;

            for (int i = 0; i < n; i++) {
                if (matrix[i][combinations[i]].hasGE) {
                    bestLocal++;
                }
                if (matrix[i][combinations[i]].isSurprising()) {
                    nrStrange++;
                }
                if (nrStrange > surprisingCount) {
                    break;
                }
            }
            if (nrStrange == surprisingCount && bestLocal > bestScore) {
                bestScore = bestLocal;
                if (DEBUG) {
                    System.out.println(Arrays.toString(combinations) + " - " + bestLocal);
                }
            }
            // next combi
            if (combinations[k] < size[k] - 1) {
                combinations[k]++;
            } else {
                combinations[k] = 0;
                if (k - 1 >= 0) {
                    combinations[--k]++;
                }else {break;}
                while (k >= 1 && combinations[k] >= size[k]) {
                    combinations[k] = 0;
                    combinations[--k]++;
                }
                k = n - 1;
            }


        }
        if (bw != null) {
            bw.write(String.format("Case #%s: %s\n", caseNr, bestScore));
        }      else {
            System.out.println(String.format("Case #%s: %s\n", caseNr, bestScore));
        }

    }

    public static void main(String[] args) {
        try {
            new DancingWithGooglers().solve();
//            new DancingWithGooglers().solveCase("1 0 7 16".split(" "), 1, null);
//            new DancingWithGooglers().solveCase("3 1 5 15 13 11".split(" "),1,null);
//            new DancingWithGooglers().solveCase("3 0 8 23 22 21".split(" "),1,null);
//            new DancingWithGooglers().solveCase("2 1 1 8 0".split(" "),1,null);
//            new DancingWithGooglers().solveCase("6 2 8 29 20 8 18 18 21".split(" "), 1,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class Case {
    boolean surprising = false;
    boolean hasGE = false;
    int caz = 0;

    public int getCaz() {
        return caz;
    }

    public void setCaz(int caz) {
        this.caz = caz;
    }

    public boolean isSurprising() {
        return surprising;
    }

    public void setSurprising(boolean surprising) {
        this.surprising = surprising;
    }

    public boolean isHasGE() {
        return hasGE;
    }

    public void setHasGE(boolean hasGE) {
        this.hasGE = hasGE;
    }

    Case(boolean surprising, boolean hasGE, int caz) {
        this.surprising = surprising;
        this.hasGE = hasGE;
        this.caz = caz;

    }

    @Override
    public String toString() {
        return "Case{" +
                "surprising=" + surprising +
                ", hasGE=" + hasGE +
                ", caz=" + caz +
                '}';
    }
}