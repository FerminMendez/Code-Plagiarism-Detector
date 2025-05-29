package codejam.world2012.qualification.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class C {
    
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/codejam/world2012/qualification/c/small.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("src/codejam/world2012/qualification/c/small.out"));

        int T = 0;
        T = Integer.parseInt(in.readLine());
        
        for (int t = 0; t < T; t++) {
            String[] line = in.readLine().split(" ");
            
            Long answer = 0L;
            
            Long A = Long.parseLong(line[0]);
            Long B = Long.parseLong(line[1]);
            
            Set<String> history = new HashSet<String>();
            
            for (Long n = A; n < B; n++) {
                
                String current = n.toString();
                
                for (int i = current.length() -1; i> 0; i--) {
                    StringBuilder recycled = new StringBuilder();  
                    recycled.append(current.substring(i));
                    recycled.append(current.substring(0, i));
                    Long m = Long.parseLong(recycled.toString());
                    
                    if ((m > n) && (B>= m)) {
                        if (!history.contains(current +":" + recycled) && !history.contains(recycled +":" + current)) {
                            answer++;
                            history.add(current +":" + recycled);
                        }
                    }
                }
            }
            
            out.write("Case #"+String.valueOf(t+1) +": "+answer.toString());
            if (t < T-1) out.write(System.getProperty("line.separator"));
            
        }
        out.close();
    }
    
}
