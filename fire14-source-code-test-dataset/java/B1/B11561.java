package codejam.recycled;

import codejam.is.TestAbstract;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ofer
 * Date: 4/14/12
 * Time: 2:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecycledTest extends TestAbstract {
    @Override
    public void run(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        int min = Integer.parseInt(tokenizer.nextToken());
        int max = Integer.parseInt(tokenizer.nextToken());

        int tmp = max;
        int length = 0;
        while (tmp != 0) {
            tmp = tmp / 10;
            length++;
        }

        int resultCounter = 0;
        for (int i = min; i < max; i++) {
            int rotatedNum = i;
            Set<Integer> foundSet = new HashSet<Integer>();
            for (int j = 0; j < length-1; j++) {

                int end = rotatedNum / 10;
                int beginning = (int)Math.pow(10,length-1) * (rotatedNum%10);

                rotatedNum = beginning + end;
                if (rotatedNum > i && rotatedNum <= max && !foundSet.contains(rotatedNum)) {
                    foundSet.add(rotatedNum);
//                    output.append("\n");
//                    output.append(i);
//                    output.append("->");
//                    output.append(rotatedNum);
                    resultCounter++;
                }
            }
        }
        output.append(resultCounter);
    }
}
