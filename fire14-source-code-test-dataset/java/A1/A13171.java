/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

/**
 *
 * @author Abdelrahman
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaseB {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f1 = new File("E:\\new c++\\Google\\codejame 2011\\2012\\inputCodejame.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f1));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] line = reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int s = Integer.parseInt(line[1]);
            int p = Integer.parseInt(line[2]);
            int[] scores = new int[line.length - 3];
            int k = 0;
            for (int j = 3; j < line.length; j++) {
                scores[k++] = Integer.parseInt(line[j]);
            }
            int counter = 0;
            for (int j = 0; j < n; j++) {
                int score = scores[j];
                if (score == 0 || score == 30) {
                    if (score / 3 >= p) {
                        counter++;
                    }
                } else if (score % 3 == 0) {
                    if (score / 3 >= p) {
                        counter++;
                    } else if ((score / 3) + 1 >= p) {
                        if (s > 0) {
                            s--;
                            counter++;
                        }
                    }
                } else if (score % 3 == 1) {
                    if ((score / 3) + 1 >= p) {
                        counter++;
                    }
                }
                else if (score % 3 == 2) {
                    if ((score / 3)+1 >= p) {
                        counter++;
                    } else if ((score / 3) + 2 >= p) {
                        if (s > 0) {
                            s--;
                            counter++;
                        }
                    }
                }               
            }
            System.out.println("Case #" + (i + 1) + ": " + counter);
        }
    }
}