import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QualificationC {
    public static void main(String[] args) {
        try {
            FileReader input = new FileReader(args[0]);
            BufferedReader in = new BufferedReader(input);
            FileWriter output = new FileWriter("QualificationC.out");
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
                
                String outStr = "Case #" + count + ": " + getMaxRecycledPairs(line);
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

    private static int getMaxRecycledPairs(String line) {
        String[] lineArr = line.split(" ");
        int A = Integer.parseInt(lineArr[0]);
        int B = Integer.parseInt(lineArr[1]);
        
        int count = 0;
        
        for (int n = A; n < B; n++) {
            String nStr = String.valueOf(n);
            
            List<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < nStr.length(); i++) {
                String mStr = nStr.substring(i) + nStr.substring(0, i);
                
                if (mStr.charAt(0) != '0') {
                    int m = Integer.parseInt(mStr);
                    
                    if (m <= B && n < m && !tempList.contains(m)) {
                        tempList.add(m);
                        count++;
                    }
                }                
            }
        }
        
        return count;
    }

}
