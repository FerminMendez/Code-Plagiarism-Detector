/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jam2012;
import jam.util.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sam
 */
public class DancingGooglers {

    private int T;//number of testcases
    private int N;//number of googlers
    private int S;//number of surprising triplets of scores
    private int p;//best result for each case
    private int[] scores;
    private int ti;//score for each googler
    private Scanner input;
    private static Utilities utility=new Utilities();
    //method to calculate maximum number of googlers

    public void openFile() {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter File Path containing test data: ");
        String filePath = cin.nextLine();
        try {
            input = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening file!");
            System.exit(1);
            Logger.getLogger(DancingGooglers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//small input

    public void readFile() throws Exception {

        if (input.hasNext()) {
            //read number of test cases
            T = input.nextInt();
            //enforce T limit

            //move to first case
            int test_count = 0;
            input.nextLine();
            //for each test case read N, S, p, and N values to array ti and call output method
            while (input.hasNext() && (test_count <= T)) {
                test_count++;
                N = input.nextInt();
                //proceed for this input
                S = input.nextInt();
                p = input.nextInt();
                scores = new int[N];
                //populate scores
                for (int i = 0; i < N; i++) {
                    scores[i] = input.nextInt();
                }
                Arrays.sort(scores);
                //call output method
                output(test_count, S, p, scores);
            }

        }
    }

    public void closeFile() {
        input.close();
    }

    public void output(int test_case, int surprises, int best_result, int[] scores) throws Exception {
        String output="";
        if (p > 1) {
            int q = p * 3 - 2;
            int s = p * 3 - 4;
            int count = 0;
            int pt = N - 1;

            for (int i = N - 1; i >= 0; i--) {
                if (scores[i] >= q) {
                    count++;
                    pt--;
                }
            }
            while (pt >= 0 && scores[pt] >= s && S > 0) {
                count++;
                pt--;
                S--;
            }
            output="Case #" + test_case + ": " + count;
            System.out.println("Case #" + test_case + ": " + count);
           // Utilities.writeToFile("googld.in","Case #" + test_case + ": " + count);
        } else if (p == 1) {
            int j = 0;
            for (j = 0; j < N; j++) {
                if (scores[j] > 0) {
                    break;
                }

            }
            output="Case #" + test_case + ": " + (N - j);
            System.out.println("Case #" + test_case + ": " + (N - j));
            //Utilities.writeToFile("googled.in","Case #" + test_case + ": " + (N - j));
        } else if (p == 0) {
            output="Case #" + test_case + ": " + N;
            System.out.println("Case #" + test_case + ": " + N);

        }
        Utilities.writeToFile("googld.in",output);
    }

    public static void main(String[] str) throws Exception {
        DancingGooglers dG = new DancingGooglers();
        dG.openFile();
        dG.readFile();
        dG.closeFile();
    }
}
