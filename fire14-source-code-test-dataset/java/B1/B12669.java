/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package year_2012.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author paul
 * @date 14 Apr 2012
 */
public class QuestionC {

    private static Set<Integer> getCycle(int x) {

        String s = Integer.toString(x);
        Set<Integer> set = new HashSet<Integer>();
        set.add(x);
        for (int c = 1; c < s.length(); c++) {
            String t = s.substring(c).concat(s.substring(0, c));
            set.add(Integer.parseInt(t));
        }
        return set;
        
    }

    private static Set<Integer> mask(Set<Integer> set, int a, int b) {
        Set<Integer> result = new HashSet<Integer>();

        for (int x : set) {
            if (x >= a && x <= b) {
                result.add(x);
            }
        }
        
        return result;

    }


    public static void main(String[] args) throws FileNotFoundException, IOException {

        String question = "C";

//        String name = "large";
        String name = "small-attempt0";
//        String name = "test";

        String filename = String.format("%s-%s", question, name);

        BufferedReader input = new BufferedReader(
                new FileReader(String.format("/home/paul/Documents/code-jam/2012/qualification/%s.in",
                filename)));

        String firstLine = input.readLine();

        PrintWriter pw = new PrintWriter(new File(
                String.format("/home/paul/Documents/code-jam/2012/qualification/%s.out", filename)));


        int T = Integer.parseInt(firstLine);

        // Loop through test cases.
        for (int i = 0; i < T; i++) {

//             Read data.
            String[] tokens = input.readLine().split(" ");

//            int N = Integer.parseInt(input.readLine());

            int A = Integer.parseInt(tokens[0]);
            int B = Integer.parseInt(tokens[1]);

//            System.out.format("%d, %d\n", A, B);

            boolean[] used = new boolean[B+1];
            int total = 0;
            for (int n = A; n <= B; n++) {
                if (!used[n]) {
                    Set<Integer> set = mask(getCycle(n), A, B);
                    int k = set.size();
                    total += (k * (k-1))/2;
                    for (int m : set) {
                        used[m] = true;
                    }
                }
            }

            pw.format("Case #%d: %d\n", i + 1, total);
        }

        pw.close();

    }

}
