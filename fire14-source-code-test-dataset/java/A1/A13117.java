

import java.io.*;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshuahm
 */
public class codejamB {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader inFile = new FileReader("B-small-attempt3.in");
        Scanner in = new Scanner(inFile);
        FileWriter outFile = new FileWriter("B-small-attempt3.out");
        PrintWriter out = new PrintWriter(outFile);
        int T= in.nextInt();
        for(int k=0;k<T;k++)
        {
            int N= in.nextInt();
            int S= in.nextInt();
            int p= in.nextInt();
            int[] total= new int[N];
            for(int i=0;i<N;i++)
                total[i]= in.nextInt();
            int possible=0;
            int surprising=0;
            for(int i=0;i<N;i++)
            {
                if(total[i]>3*p-3)
                    possible++;
                else if(total[i]>Math.max(3*p-5,0))
                    surprising++;
            }
            out.println("Case #"+ (k+1) +": "  + (possible + Math.min(surprising, S)));
        }
        in.close();
        out.close();
    }
}
