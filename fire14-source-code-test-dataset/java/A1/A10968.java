package contests.GoogleCodejam.GCJ2012.qualification;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: addepar
 * Date: 4/14/12
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProblemB {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(ProblemB.class.getResourceAsStream("b_small.in"));

        int tests = scanner.nextInt();


        for (int test = 1; test <= tests; test++) {
            int result = 0;

            int numGooglers = scanner.nextInt();
            int surprises = scanner.nextInt();
            int minscore = scanner.nextInt();

            int potential = 0;
            for(int i = 0; i < numGooglers; i++){
                //555  645
                //566  557
                //556  466

                int score = scanner.nextInt();
                int maxscore = score/3;

                if(score %3 >0){
                    maxscore++;
                }

                if(maxscore >= minscore){
                    result++;
                } else if((maxscore +1) == minscore){
                    if(score > 0 && (score %3 == 0 || score%3 == 2)){
                        potential++;
                    }
                }
            }


            result += Math.min(potential,surprises);


            System.out.println("Case #" + test + ": " + result);
        }

    }
}


