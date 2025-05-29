package jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Jam3 {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("C:/jam/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:/jam/output.txt"));
        int pow[] = new int[]{
            1,
            10,
            100, 
            1000,
            10000,
            100000,
            1000000,
            10000000,
            100000000,
            1000000000};
        int nr = new Integer(reader.readLine());
        
        for (int i = 0; i < nr; i++) {
            Set<String> set = new HashSet<String>();
          //  System.out.println("------------  ");
            String in = reader.readLine();
            int A = Integer.parseInt(in.split(" ")[0]);
            int B = Integer.parseInt(in.split(" ")[1]);
            //System.out.println("A = " + A);
            //System.out.println("B = " + B);
            int cyfr = 1+ (int) Math.log10(A);
            //System.out.println("cyfr = " + cyfr);
            int out = 0;
            for(int j = A; j<=B; j++){
               // System.out.println("j = " + j);
                for(int k =1 ; k<cyfr; k++){                    
                    int start = j / pow[k];
                    int end = j % pow[k];
                   // System.out.println("" + start + "||"+end);
                    int nowa = end * pow[cyfr - k] + start;
                   // System.out.println(k+ " nowa = " + nowa);
                    if((nowa < j )&&(nowa >=A) && (nowa <=B) ){
                        set.add(""+nowa+"_"+j);
                    }
                }
                
            }
            
            System.out.println("Case #"+(i+1)+": "+set.size());
           
            writer.write("Case #"+(i+1)+": "+set.size());
            writer.newLine();
                    
        }
        writer.close();
    }
}
