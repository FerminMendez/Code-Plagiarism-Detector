package qualification.q2;

import qualification.common.InputReader;
import qualification.common.OutputWriter;
import qualification.q1.Q1Solver;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class Q2Sim {

    public static void main(String[] args){
        String inputFile = "input.txt";
        String outPutFile = "output.txt";
        String[] lines = InputReader.getInputLines(inputFile);
        Q2Solver solver = new Q2Solver();
        int numOfTests = Integer.parseInt(lines[0]);
        String[] output = new String[numOfTests];
        for (int i = 0 ; i < numOfTests ; i++){
            String[] splited = lines[i+1].split(" ");
            int n = Integer.parseInt(splited[0]);
            int s =  Integer.parseInt(splited[1]);
            int p = Integer.parseInt(splited[2]);
            int[] sums = new int[n];
            for (int j = 0 ; j < n ; j++){
                int sum = Integer.parseInt(splited[j+3]);
                sums[j] = sum;
            }
            int res = solver.solve(n,s,p,sums);
            output[i] = "Case #" + (i+1) + ": " + res;
        }
        OutputWriter.writeOutput(outPutFile, output);
    }
}
