package jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class Jam2 {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("C:/jam/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/jam/output.txt"));
        int nr = new Integer(reader.readLine());
        int[] normal = new int[11];
        int[] sup = new int[11];
        for (int i = 0; i < 11; i++) {
            normal[i] = 3 * i - 2;
            sup[i] = 3 * i - 4;
        }
        normal[0] = 0;
        sup[0] = 0;
        sup[1] = 1;

        for (int i = 0; i < nr; i++) {
            String in = reader.readLine();
            String data1[] = in.split(" ");
            Integer data2[] = new Integer[data1.length];
            for (int t = 0; t < data1.length; t++) {
                data2[t] = Integer.parseInt(data1[t]);
            }
            int N = data2[0];
            int S = data2[1];
            int p = data2[2];
            
            int mayNormal = 0;
            int maySup = 0;
          //  System.out.println("normal[p] = " + normal[p]);
          //  System.out.println("sup[p] = " + sup[p]);
            for (int j = 0; j < N; j++) {
                int test = data2[3+j];
             //  System.out.println("test = " + test);
                
                if(test >= normal[p]){
                    mayNormal++;
                }else if (test >= sup[p]){
                    maySup++;
                }
            }
         //   System.out.println("mayNormal = " + mayNormal);
         //   System.out.println("maySup = " + maySup);
            
            int out = mayNormal + Math.min(maySup, S);
            System.out.println("out = " + out);
            writer.write("Case #"+(i+1)+": "+out);
                writer.newLine();
                    
        }
        writer.close();
    }
}
