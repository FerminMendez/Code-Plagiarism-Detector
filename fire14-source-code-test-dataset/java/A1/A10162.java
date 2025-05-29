import java.util.*;
import java.io.*;

public class CodeJam {
    public static void main(String[] args) {
        try {
            //recycleLarge(1000000, 2000000);
            // read
            FileInputStream instream = new FileInputStream("A-small.in");
            DataInputStream in = new DataInputStream(instream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // write
            FileOutputStream outstream = new FileOutputStream("A-small.out");
            DataOutputStream out = new DataOutputStream(outstream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            // reading file information
            int testcases = Integer.parseInt(br.readLine());
            for (int i = 0; i < testcases; i++) {
                // -------------------------------------------------------------------------------------------------------------
                String line = br.readLine();
                String[] items = line.split(" ");
                int N = Integer.parseInt(items[0]);
                int S = Integer.parseInt(items[1]);
                int p = Integer.parseInt(items[2]);
                long howManyP = 0;
                if (p == 0) {
                    howManyP = N;
                } else {
                    for(int j=3; j<items.length; j++){
                        int score = Integer.parseInt(items[j]);
                        if (p == 1){
                            if (score > 0) {
                                howManyP++;
                            }
                        } else {
                            int relaxedScore = (3 * p) - 2;
                            int minimumScore = (3 * p) - 4;
                            if (score >= relaxedScore) howManyP++;
                            else if (score >= minimumScore && S > 0) {
                                howManyP++; S--;
                            }
                        }
                    }
                }


                // -------------------------------------------------------------------------------------------------------------
                bw.write("Case #" + (i + 1) + ": " + howManyP + "\r\n");
            }

            // close input file
            in.close();
            // close output file
            bw.flush();
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    private static void printArray(Object[] array) {
        for (Object ch : array)
            System.out.print(ch);
    }


}

