/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 3/3/12
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */

import SRMLib.MathLibrary;
import SRMLib.TestSRMLib;
import com.sun.org.apache.bcel.internal.generic.F2D;

import java.io.*;
import java.util.*;
import java.util.logging.Handler;
import java.util.zip.Inflater;

public class SRM {
    public static void main(String[] args) throws IOException {
        //TestSRMLib.run();
        codeJam.main();

        return;
    }
}

class codeJam {
    public static void main() throws IOException {
        String inputPath = "E:\\input.txt";
        String outputPath = "E:\\output.txt";
        BufferedReader input = new BufferedReader(new FileReader(inputPath));
        BufferedWriter output = new BufferedWriter(new FileWriter(outputPath));

        String line;
        line = input.readLine();
        int T = Integer.parseInt(line);
        for (int i = 1; i <= T; ++i) {
            line = input.readLine();
            String[] words = line.split(" ");
            Integer A = Integer.parseInt(words[0]);
            Integer B = Integer.parseInt(words[1]);

            int res = 0;
            int l = A.toString().length();
            int multiplier = 1;
            for (int k = 1; k < l; ++k)
                multiplier *= 10;

            for (int n = A; n < B; ++n) {
                int m = n;
                Set<Integer> set = new HashSet<Integer>();
                for (int j = 1; j < l; ++j) {
                    m = (m % multiplier) * 10 + m / multiplier;
                    if ((n < m) && (m <= B)) {
                        if (!set.contains(m)) {
                            res++;
                            set.add(m);
                        }
                    }
                }
            }

            output.write("Case #" + i + ": " + res);
            output.newLine();
        }

        input.close();
        output.close();
    }
}