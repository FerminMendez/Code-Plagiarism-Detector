/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Stefanos
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String input, temp;
        String output = "";
        int left, right;
        int i = 0, bingo;
        int cases, size;
                
        try {  
            FileReader fr = new FileReader(new File("C-small-attempt0.in"));  
            BufferedReader br = new BufferedReader(fr);
            
            FileWriter fstream = new FileWriter("C-small-attempt0.out");
            BufferedWriter out = new BufferedWriter(fstream);

            cases = Integer.parseInt(br.readLine());
            i = 0;

            while(i < cases) {
                input = br.readLine();
                output += "Case #"+(++i)+": "; 
                String[] split = input.split(" ");
                bingo = 0;
                
                if (split[0].length()>1) {
                    left = Integer.parseInt(split[0]);
                    right = Integer.parseInt(split[1]);
                    
                    for (int j=left; j<right; j++) {
                        for (int k=j+1; k<=right; k++) {
                            String num = Integer.toString(k);
                            size = num.length();
                        
                            for(int m=0; m<size-1; m++) {
                            
                                int concat = Integer.parseInt(num.substring(m+1, size)+num.substring(0, m+1));
                                
                                if(j == concat) { bingo++; break;}                     
                            }                       
                        }
                    }
                    
                    
                }
                out.write(output+bingo);
                output = "\n";
            }

            out.close();
            br.close();
            
        }catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
    }
}
