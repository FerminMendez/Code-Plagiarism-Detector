/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aymen
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int[] v = new int[1000];
        int[] tabMin = new int[100];
        
        String outputFile = System.getenv("USERPROFILE") + "\\Documents\\B-small.out";
        String inputFile = System.getenv("USERPROFILE") + "\\Documents\\B-small.in";
        //String outputFile = System.getenv("USERPROFILE") + "\\Documents\\output.txt";
        //String inputFile = System.getenv("USERPROFILE") + "\\Documents\\input.txt";                
        
        BufferedWriter os = new BufferedWriter(new FileWriter(outputFile));
        DataInputStream is = new DataInputStream(new FileInputStream(inputFile));
        
        int T = Integer.valueOf(is.readLine());
        System.out.println("T " + T);
        for (int i = 0; i < T; i++) {
            String list = is.readLine();
            list += " ";
            int n = Integer.valueOf(list.substring(0, list.indexOf(" ")));
            list = list.substring(list.indexOf(" ") + 1);
            int s = Integer.valueOf(list.substring(0, list.indexOf(" ")));
            list = list.substring(list.indexOf(" ") + 1);
            int p = Integer.valueOf(list.substring(0, list.indexOf(" ")));
            list = list.substring(list.indexOf(" ") + 1);
            int valMin = 3 * p - 4;
            if (valMin < 0) s = 0;
            int number = 0;            
            int surp = 0;
            
            for (int j = 0; j < s; j++) {
                tabMin[j] = 0;
            }
            
            for (int j = 0; j < n; j++) {
                int val = Integer.valueOf(list.substring(0, list.indexOf(" ")));
                if (val >= valMin){
                    if ((val == valMin) || (val == valMin + 1)){                        
                        surp += 1;
                        if (surp <= s){
                            number += 1;
                        }                        
                    }else number += 1;
                }                
                list = list.substring(list.indexOf(" ") + 1);
            }
            
            
            
            int m = i + 1;
            System.out.println("number " + number);
            os.write("Case #" + m + ": " + number);
            os.newLine();
            System.out.println("");
        }
        is.close();
        os.close();    
    }
}
