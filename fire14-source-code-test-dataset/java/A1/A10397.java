

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ProbB {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("B-small-attempt0.in");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("outB.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String a = br.readLine();
        int cases = Integer.parseInt(a);
        
        int n=0, s=0, p=0, num=0;
        
        for (int i = 1; i < cases+1; i++) {
            String testCase = br.readLine();
            String tokens[] = testCase.split(" ");
            n= Integer.parseInt(tokens[0]);
            s = Integer.parseInt(tokens[1]);
            p = Integer.parseInt(tokens[2]);
            
            int count = 0;
            for (int j = 3; j < n + 3; j++) {
                num = Integer.parseInt(tokens[j]);
                if ((num - p) >= 2 * (p - 1) && (num - p) >= 0) {
                    count++;
                } else if ((num - p) < 2 * (p - 1) && (num - p) >= 0) {
                    if (s != 0 && (num - p) >= 2 * (p - 2)) {
                        count++;
                        s--;
                    }
                }
            }
            String result = "Case #" + (i) + ": " + count;
            bw.write(result);
            bw.newLine();

        }

        bw.close();
        fw.close();

        br.close();
        fr.close();
    }
}
