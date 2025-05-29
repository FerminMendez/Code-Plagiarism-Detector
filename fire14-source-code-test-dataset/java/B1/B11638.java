/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 *
 * @author christian
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            FileInputStream fstream = new FileInputStream(args[0]);
            
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            /*FileOutputStream ostream = new FileOutputStream(args[1]);
            DataOutputStream out = new DataOutputStream(ostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));*/
        
            int testcases = Integer.parseInt(br.readLine());
            
            for (int i =0; i < testcases; i++) {
                String line = br.readLine();
                int a = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                int b = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                
                int length = line.indexOf(" ");
                
                //System.out.println(line + " = " + a + " " + b + ", Length: " + length);
                
                LinkedList[] pairs = new LinkedList[b];
                for (int k = 0; k < b; k++) {
                    pairs[k] = new LinkedList();
                }
                
                //for each number in range
                for (int m = a; m < b; m++) {
                    
                    //for each substring in current number
                    for (int cut = 1; cut < length ; cut++) {
                        //rotate
                        String mstring = Integer.toString(m);
                        int n = Integer.parseInt(mstring.substring(cut) + mstring.substring(0, cut));
                        
                        //store values in list if not already present
                        if (!pairs[m].contains(n) && m < n && n < b+1 && n > a){
                            pairs[m].add(n);
                            //System.out.println(m + " + " + n);
                        }
                    }
                  
                }
                
                int recycledpairs = 0;
                for (int k = 0; k < b; k++) {
                    recycledpairs += pairs[k].size();
                }
                
                // save values
                System.out.println( "Case #" + (i+1) + ": " + recycledpairs);
                //bw.write("Case #" + "i" + ": " + recycledpairs);
                //bw.newLine();
                
               
            }
            
            in.close();
            //out.close();
            
        } catch (Exception e) {
            
            //Catch exception if any
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }
}
