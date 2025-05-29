/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

import java.io.*;

/**
 *
 * @author ken
 */
public class Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
            
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            
            int inputSize = Integer.parseInt(br.readLine());
            int currentCase = 1;
            //while ((strLine = br.readLine()) != null) {
            while (inputSize > 0) {
                strLine = br.readLine();
                int min = Integer.parseInt(strLine.split(" ")[0]);
                int max = Integer.parseInt(strLine.split(" ")[1]);
                
                int counter = 0;
                for (int i = min; i <= max; i++) {
                    
                    for (int j = i; j <= max; j++) {
                       if (isRecycled(Integer.toString(i), Integer.toString(j))) {
                           counter ++;
                       }
                    }
                }
                System.out.println("Case #" + currentCase + ": " + counter);
                inputSize --;
                currentCase++;
            }
            
            in.close();
            
            //System.out.println("hello".substring(0, 1));
            //System.out.println("hello".substring(1));
            //System.out.println(isRecycled("12345","34512"));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    
    public static boolean isRecycled(String x, String y) {
        if (x.length() != y.length()) {
            return false;
        }
        for (int i = 1; i < x.length() + 1; i++) {
            String newString =  x.substring(i)+x.substring(0, i);
            //System.out.println(newString);
            if (newString.equalsIgnoreCase(y) && !newString.equalsIgnoreCase(x))
                return true;
        }
        return false;
    }
}
