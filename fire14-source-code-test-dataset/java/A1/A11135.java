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
import java.util.zip.Inflater;

public class SRM {
    public static void main(String[] args) throws IOException {
        //TestSRMLib.run();
        codeJam1.main();

        return;
    }
}
class codeJam1 {
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
            int N = Integer.parseInt(words[0]);
            int S = Integer.parseInt(words[1]);
            int p = Integer.parseInt(words[2]);
            int n = 0;
            int res = 0;

            for (int j = 3; j < words.length; ++j) {
                if (p == 0) {
                    res++;
                    continue;
                }

                int t = Integer.parseInt(words[j]);
                if (p == 1) {
                    if (t > 0)
                        res++;
                    continue;
                }
                if (t >= 3 * p - 2)
                    res++;
                else if (t >= 3 * p - 4)
                    n++;
            }

            res += Math.min(n, S);
            output.write("Case #" + i + ": " + res);
            output.newLine();
        }

        input.close();
        output.close();
    }
}
