/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author KazakhPride
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner in = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new File("output.txt"));

        int n = in.nextInt();
        int t = 0;
        int s = 0;
        int p = 0;
        
        for (int j = 1; j <= n; j++) {
            out.print("Case #" + j + ": ");
            t = in.nextInt();
            s = in.nextInt();
            p = in.nextInt();
            int count = 0;
            int ar[] = new int[t];
            for (int i = 0; i < ar.length; i++) {
                ar[i] = in.nextInt();
            }
            
            for( int i = 0; i < ar.length; i++ ){
                if(ar[i]%3 == 0){
                    int base = ar[i]/3;
                    //int second = first;
                    //int third = second;
                    if(base >= p){
                        count++;
                    }
                    else{
                        if(s > 0 && base > 0 && base + 1 >= p){
                            count++;
                            s--;
                        }
                    }
                }
                else if(ar[i]%3==1){
                    int base = ar[i]/3;
                    
                    if(base >= p || base + 1 >= p){
                        count++;
                    }
                    else{
                        if(s > 0 && base + 1 >= p){
                            count++;
                            s--;
                        }
                    }
                }
                if( ar[i]%3 == 2 ){
                    int base = ar[i]/3;
                    
                    if(base + 1 >= p || base >= p){
                        count++;
                    }
                    else{
                        if( s > 0 && base + 2 >= p ){
                            count++;
                            s--;
                        }
                    }
                }
            }
            out.println(count);
        }
        in.close();
        out.close();
    }
}