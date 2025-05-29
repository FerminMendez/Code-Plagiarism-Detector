package qualification.q1;

import com.sun.deploy.net.proxy.StaticProxyManager;
import qualification.common.InputReader;
import qualification.common.OutputWriter;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
public class Q1Sim {
    
    public static void main(String[] args){
        String inputFile = "input.txt";
        String outPutFile = "output.txt";
        String[] lines = InputReader.getInputLines(inputFile);
        Q1Solver solver = new Q1Solver();
        int numOfTests = Integer.parseInt(lines[0]);
        String[] output = new String[numOfTests];
        for (int i = 0 ; i < numOfTests ; i++){
            String decrypted = solver.convertString(lines[i+1]);
            output[i] = "Case #" + (i+1) + ": " + decrypted;
        }
        OutputWriter.writeOutput(outPutFile,output);
    }
}
