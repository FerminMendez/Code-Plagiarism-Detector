/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code3;

  import java.io.File;
 import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
   import java.lang.IllegalStateException;
import java.util.Arrays;
   import java.util.NoSuchElementException;
   import java.util.Scanner;

/**
 *
 * @author nhan
 */
public class Code3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner input;
        input = new Scanner( new File( "B-small-attempt0.in" ) );
        FileOutputStream fos= new FileOutputStream("B-small-attempt0.out",false); 
        try (PrintWriter pw = new PrintWriter(fos)) {
            int t,n,s,p;
            
            t=input.nextInt();
            
            for (int i=1;i<=t;i++){
                System.out.print("Case #"+i+": ");
                pw.print("Case #"+i+": ");
                
                n=input.nextInt();
                s=input.nextInt();
                p=input.nextInt();
                
                int count = 0;
                int count0 = 0;
                for (int j=0;j<n;j++){
                    int x = input.nextInt();
                    int y = x/3;
                    int z = x%3;
                if ((p-y)<=0) count++;
                      switch(p-y){
                            
                                   
                            case 2:{
                                if (z==2){ count0++; count++;}
                                break;
                            }
                            case 1:{
                                if (x!=1 && x!=0) {
                                count++;
                                if (z==0)  count0++; break;
                                }
                            }
                        }
                        
                }//end for , end line s
               
                     if (s<=count0){
                        pw.print(count-count0+s);
                        
                     } else if (s>count0 && s<=n){
                        pw.print(count);
                       
                     } else {
                        pw.print("0");
                       
                     }
                
                
                
                pw.print("\n");
            }    
            
            pw.close();
        }
    }
}
