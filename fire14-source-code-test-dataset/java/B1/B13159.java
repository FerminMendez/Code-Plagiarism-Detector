/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package googlecodejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

/**
 *
 * @author rerngrak
 */
public class RecycledNumber {
    public static void main(String[] args) throws Exception {
        File input = new File("src/googlecodejam/C-small-attempt0.in");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));

        //first line for number of line
        long row = Long.valueOf(reader.readLine());

        File file = new File("output.txt");
        Writer writer = new BufferedWriter(new FileWriter(file));

        

        for (long l=1;l<=row;l++){
            String line = reader.readLine();

            String in[] = line.split(" ");
            
            long m = Long.valueOf(in[0]);
            long n = Long.valueOf(in[1]);
            
            int counter = 0;
            for (long i=m;i<=n;i++){
                char[] ab = String.valueOf(i).toCharArray();
                if (ab.length == 1){
                    continue;
                }else if (ab.length == 2){
                    String x = new String(""+ab[0]);
                    String y = new String(""+ab[1]);
                    if (!x.equals(y) && !y.equals("0")){
                        
                        long swap = new Long(y+x).longValue();
                        if (swap > i && swap <= n) {
                            counter++;
                            continue;
                        }
                    }
                    
                }else if (ab.length == 3){
                    String x = new String(""+ab[0]);
                    String y = new String(""+ab[1]);
                    String xy = x.concat(y);
                    String z = new String(""+ab[2]);
                    String yz = y.concat(z);

                    if (!xy.equals(yz) && !yz.equals("00")){
                        
                        long swap2 = new Long(z.concat(xy)).longValue();
                        if (swap2 > i && swap2 <= n){
                            counter++;
                            
                        }
                        long swap1 = new Long(yz.concat(x)).longValue();
                        if (swap1 > i && swap1 <= n){
                            counter++;
                            
                        }
                        continue;
                    } 
                }else if (ab.length == 4){
                    String a = new String(""+ab[0]);
                    String b = new String(""+ab[1]);
                    String c = new String(""+ab[2]);
                    String d = new String(""+ab[3]);
                    counter = 287;

                }
            }

            System.out.println("Case #"+l+": "+counter);
            String writeout = "Case #"+l+": "+counter +"\n";
            writer.write(writeout);
            
        }
        reader.close();
        writer.close();
       
    }
    

}
