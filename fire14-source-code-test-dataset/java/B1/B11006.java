package contests.GoogleCodejam.GCJ2012.qualification;


import contests.GoogleCodeJam.practice.GCJ2010.qualification.ProblemA;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: vassili
 * Date: 4/14/12
 * Time: 1:12 PM
 *
 */
public class ProblemC {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(ProblemC.class.getResourceAsStream("c_small.in"));

        int tests = scanner.nextInt();

        for (int test = 1; test <= tests; test++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int result = 0;

            for(int i = A; i <= B; i++){
                String num1 = ""+i;
                int len1 = num1.length();

                for(int j = i + 1; j<=B; j++){
                    String num2 = "" + j;
                    if(len1 != num2.length()){
                        break;
                    }

                    for(int k = 0; k < num2.length(); k++){
                        num2 = num2.charAt(len1-1) + num2.substring(0, len1-1);
                        if(num2.equals(num1)){
                            result+=1;
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + test + ": " + result);
        }

    }
}

