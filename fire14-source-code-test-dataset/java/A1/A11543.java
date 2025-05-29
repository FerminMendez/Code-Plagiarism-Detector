import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class QualificationB {

    public static void main(String[] args) {
        try {
            FileReader input = new FileReader(args[0]);
            BufferedReader in = new BufferedReader(input);
            FileWriter output = new FileWriter("QualificationB.out");
            BufferedWriter out = new BufferedWriter(output);
            
            String line;
            int count = 1;
            
            line = in.readLine();
            int cases = Integer.parseInt(line);
            line = in.readLine();
            
            while (line != null && count <= cases) {
                if (count != 1) {
                    out.write("\n");
                }
                
                String outStr = "Case #" + count + ": " + getMaxGooglers(line);
                System.out.println(outStr);
                out.write(outStr);
                
                line = in.readLine();
                count++;
            }
            
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMaxGooglers(String line) {
        String[] lineArr = line.split(" ");
        final int N = Integer.parseInt(lineArr[0]);   // Number of Googlers
        final int S = Integer.parseInt(lineArr[1]);   // Number of surprising triplets of scores
        final int p = Integer.parseInt(lineArr[2]);   // Minimum total score
        
        int googlerCount = 0;
        int sCount = 0;
        
        for (int i = 3; i < lineArr.length && i <= N + 3; i++) {
            int score = Integer.parseInt(lineArr[i]);
            
            if (((score + 2) / 3) >= p) {
                googlerCount++;
            } else if (((score + 4) / 3) >= p && sCount < S && p > 1) {
                googlerCount++;
                sCount++;
            }
        }
        
        return googlerCount;
    }

}
