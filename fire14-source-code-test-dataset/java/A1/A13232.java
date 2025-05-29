package codejam2012.qr.dancing;

import codejam2012.qr.googlerese.Translator;
import codejam2012.util.ReadWriteUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedez
 */
public class Main
{
    /**
     * Args0 in file
     * Args1 out file
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        List<String> in;
        List<String> out;
        String[] lineArray;        
        
        int caseNumber = 1;
        int scores[];
        int result, googlers, surprises, scoreTopass;
        int i;

        in = ReadWriteUtil.readFile(args[0]);
        if (in.size() < 2 || Integer.parseInt(in.get(0)) != in.size() - 1)
        {
            throw new Exception("Input error");
        }
        in.remove(0);

        out = new ArrayList<String>(in.size());
        for (String line : in)
        {
            lineArray = line.split("\\s");
            googlers = Integer.parseInt(lineArray[0]);
            surprises = Integer.parseInt(lineArray[1]);
            scoreTopass = Integer.parseInt(lineArray[2]);
            scores = new int[lineArray.length-3];
            for ( i = 3; i < lineArray.length; i++ )
            {
                scores[i-3] = Integer.parseInt(lineArray[i]);
            }

            result = DancerSolver.solve(googlers, scores, surprises, scoreTopass);
            out.add("Case #" + caseNumber + ": " + result);
            caseNumber ++;
        }
        ReadWriteUtil.writeFile(args[1], out);
    }
}
