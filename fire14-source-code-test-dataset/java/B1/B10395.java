package googlejam;

import java.io.*;
import java.util.Scanner;

public class GoogleJam {

    
    static boolean isRec (String a, String b)
    {
        for (int i = 0; i < a.length()-1; i++)
            if ((a.substring(i+1) + a.substring(0,i+1)).equals(b))
                return true;
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        int t;
        Scanner sc = new Scanner(new File("C-small-attempt0.in"));
        FileWriter fw = new FileWriter("output.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        t = sc.nextInt();
        long[] ar = new long[50];
        for (int i = 0; i < t; i++)
        {
            long a,b;
            a = sc.nextLong();
            b = sc.nextLong();
            long sum = 0;
            
            for (long j = a; j < b; j++)
            {
                for (long z = j+1; z <= b; z++)
                    if(isRec(String.valueOf(j),String.valueOf(z)))
                        sum++;
            }
            
            ar[i] = sum;
        }
        for (int i = 0; i < t; i++)
        {
            bw.write("Case #"+(i+1)+ ": " +new Long(ar[i]).toString());
            bw.newLine();
        }
        bw.close();
    }
}
