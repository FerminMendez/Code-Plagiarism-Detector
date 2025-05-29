package dancinggooglers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DancingGooglers {

    public static void main(String[] args) {

        String input;
        String output = "";
        int i = 0, googler, div, under, valid, remains;
        int cases, surp, point;
                
        try {  
            FileReader fr = new FileReader(new File("B-small-attempt0.in"));  
            BufferedReader br = new BufferedReader(fr);
            
            FileWriter fstream = new FileWriter("B-small-attempt0.out");
            BufferedWriter out = new BufferedWriter(fstream);

            cases = Integer.parseInt(br.readLine());
            i = 0;

            while(i < cases) {
                input = br.readLine();
                output += "Case #"+(++i)+": "; 
                String[] split = input.split(" ");
                
                surp = Integer.parseInt(split[1]);
                point = Integer.parseInt(split[2]);
                under = 0;
                valid =0;

                for (int j=0; j<Integer.parseInt(split[0]); j++){
                    
                    googler = Integer.parseInt(split[3+j]);
                    div = googler - point*3;
                    remains = googler - point;

                    if((div > -3)&&(remains >= 0)){ valid++; }
                    
                    else if((div > -5)&&(remains >= 0)){ under++; }   
                }
                
                if(under <= surp) { valid += under; }
                else { valid += surp; }

                output += valid;

                out.write(output);
                output = "\n";
            }

            out.close();
            br.close();
            
        }catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
        
    }
}
