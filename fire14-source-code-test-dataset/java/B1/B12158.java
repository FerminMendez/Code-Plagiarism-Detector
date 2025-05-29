/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam_recyclingnumbers;

import java.io.*;

/**
 *
 * @author Ulyss
 */
public class GoogleCodeJam_RecyclingNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        
        BufferedReader br = new BufferedReader(new FileReader("C-small.in"));
        
        PrintWriter pw = new PrintWriter("C-small.out");
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
        
            int total = 0;
            
            String line = br.readLine();
            
            String[] numbers = line.split(" ");
            
            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);
            
            System.out.println(A + " : " + B);
            
            for(int lowIndex = A; lowIndex < B; lowIndex++){
                
                for(int highIndex = lowIndex+1; highIndex <= B; highIndex++){
                    
                    if( isRecycled(lowIndex, highIndex) ){
                        
                        System.out.println(" Yes!!! " + lowIndex + " - " + highIndex);
                        total++;
                    }
                }
            }
            
            pw.print("Case #" + (i+1) + ": " + total);
            if( i < T-1 ){
                
                pw.println();
            }
        }
        
        br.close();
        pw.close();
    }
    
    public static boolean isRecycled(int n, int m){
        
        if( n < 10 ){
            
            return false;
        }
        if( n < 100 ){
            
            if( n % 10 == m / 10 && n / 10 == m % 10 ){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        
        if( n < 1000 ){
            
            String nLine = String.valueOf(n);
            String mLine = String.valueOf(m);
            
            if( ( nLine.charAt(2) == mLine.charAt(0) && nLine.charAt(0) == mLine.charAt(1) && nLine.charAt(1) == mLine.charAt(2) ) ||
                ( nLine.charAt(0) == mLine.charAt(2) && nLine.charAt(1) == mLine.charAt(0) && nLine.charAt(2) == mLine.charAt(1) ) ){
                
                return true;
            }
        }
        
        return false;
    }
    
    
}
