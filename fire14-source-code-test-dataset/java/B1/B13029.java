package qualification.q3;

import qualification.common.InputReader;
import qualification.common.OutputWriter;
import qualification.q1.Q1Solver;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public class Q3Sim {

    public static void main(String[] args){
        String inputFile = "input.txt";
        String outPutFile = "output.txt";
        String[] lines = InputReader.getInputLines(inputFile);
        Q3Solver solver = new Q3Solver();
        int numOfTests = Integer.parseInt(lines[0]);
        String[] output = new String[numOfTests];
        for (int i = 0 ; i < numOfTests ; i++){
            String[] nums = lines[i+1].split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int res = solver.solve(a,b);
            output[i] = "Case #" + (i+1) + ": " + res;
        }
        OutputWriter.writeOutput(outPutFile, output);
    }
}
