/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author VISHAL
 */
public class Googlers {
    public static void main(String args[]) throws IOException{
        Scanner in=new Scanner(new File("H:\\in.txt"));
        FileWriter fout=new FileWriter("H:\\out.txt");
        PrintWriter outfile=new PrintWriter(fout);
//        Scanner in=new Scanner(System.in);
        int t;
        t=in.nextInt();
        for(int i=0;i<t;i++){
            int n,p,s;
            n=in.nextInt();
            s=in.nextInt();
            p=in.nextInt();
            int count=0;
            for(int j=0;j<n;j++){
                int s1;
                s1=in.nextInt();
                if(s1<p)
                    continue;
               if(s1>=3*p-2)
                   count++;
               else if(s!=0 && s1>=3*p-4)
               {
                   s--;
                   count++;
               }
            }
           outfile.println("Case #"+(i+1)+": "+count);
        }
  outfile.close();
    }

}
