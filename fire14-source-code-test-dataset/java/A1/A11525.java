package codejam.dancing;

import codejam.is.TestAbstract;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: ofer
 * Date: 4/14/12
 * Time: 4:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class DancingTest extends TestAbstract {


    @Override
    public void run(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        int numOfGooglers = Integer.parseInt(tokenizer.nextToken());
        int numOfSurprises = Integer.parseInt(tokenizer.nextToken());
        int bestResult = Integer.parseInt(tokenizer.nextToken());

        int result = 0;
        for (int i = 0; i < numOfGooglers; i++) {
            int score = Integer.parseInt(tokenizer.nextToken());
            if (score >= bestResult + 2*Math.max(bestResult-1, 0)) {
                result++;
            } else if (score >= (bestResult + 2*Math.max(bestResult-2, 0)) && numOfSurprises > 0) {
                result++;
                numOfSurprises--;
            }
        }

        output.append(result);
    }
}
