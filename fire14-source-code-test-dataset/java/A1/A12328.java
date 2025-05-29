/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author linlin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File file=new File("B-small-attempt0.in");
        FileOutputStream o=new FileOutputStream("a.txt");
        Scanner s=new Scanner(file);

        int t=Integer.valueOf(s.nextLine());
        for(int i=1;i<=t;i++){
            int out=0;
            String line=s.nextLine();
            String[] num=line.split(" ");
            int n=Integer.valueOf(num[0]);
            int s1=Integer.valueOf(num[1]);
            int p=Integer.valueOf(num[2]);
            int high=p*3;
            for(int k=0;k<2;k++){
                if(high>0)
                    high--;
            }
            int low=high;
            for(int k=0;k<2;k++){
                if(low>0)
                    low--;
            }
            int m=2;
            for(int j=0;j<n;j++){
                m++;
                int score=Integer.valueOf(num[m]);

                if(score<p)
                    continue;

                if(score>=high)
                    out++;
                else if((score>=low)){
                    if(s1>0){
                    s1--;
                    out++;
                    }
                }

            }

            String output="Case #"+i+": "+out+"\r\n";
            o.write(output.getBytes());

        }
    }

}
