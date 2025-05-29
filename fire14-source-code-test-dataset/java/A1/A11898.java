import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari
 */
public class ProblemB {
    static String in = "src/b.in";
    static String out = "src/b.out";
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new File(in));
        BufferedWriter write = new BufferedWriter(new FileWriter(out));
        int numlines = scan.nextInt();
        int peeps;
        int surprises;
        int minScore;
        int minTotal;
        int minSurpriseTotal;
        int answer;
        int totalScore;
        for(int x = 0; x < numlines; x++) {
             write.write("Case #" + (x+1) + ": ");
             answer = 0;
             peeps = scan.nextInt();
             surprises = scan.nextInt();
             minScore = scan.nextInt();
             minTotal = minScore*3 - 2;
             minSurpriseTotal = minTotal - 2;
             
             if(minTotal < 0) {
                 minTotal = 0;
                 //minSurpriseTotal = 0;
             }
             else if(minSurpriseTotal < 0) {
                 minSurpriseTotal = 1;
             }
             
             for(int y = 0; y < peeps; y++) {
                 totalScore = scan.nextInt();
                 if(totalScore >= minTotal) {
                     answer++;
                 }
                 else if(totalScore >= minSurpriseTotal && surprises > 0) {
                     surprises--;
                     answer++;
                 }
             }
             
             write.write("" + answer);
             write.write('\n');
        }
        scan.close();
        write.close();
    }
}
