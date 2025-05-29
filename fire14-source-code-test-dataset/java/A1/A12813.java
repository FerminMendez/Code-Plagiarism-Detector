
import java.io.*;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ankur
 */
public class DacingWithTheGooglers {

    public static void main(String[] args) {
        try
	{
	    FileWriter fout = new FileWriter("out");
	    BufferedWriter out = new BufferedWriter(fout);
	    try
	    {
		Scanner in = new Scanner(new File("in"));
                int T = in.nextInt();
                System.out.println(T);
                for(int i=0; i<T; ++i)
                {
                    int N = in.nextInt();
                    int S = in.nextInt();
                    int p = in.nextInt();
                    int t;
                    int ans = 0;
                    
                        for(int j=0; j<N; ++j)
                        {
                            t = in.nextInt();
                            if(p==0)
                            {
                                ans = N;
                            }
                            else
                            {
                                if(t >= (3*p - 4) && t > 0)
                                {
                                    if(t >= (3*p - 2))
                                        ans++;
                                    else
                                    {
                                        if(S != 0)
                                        {
                                            S--;
                                            ans++;
                                        }
                                    }
                                }
                            }
                        }
                    
                    out.write("Case #" + (i+1) + ": " + ans);
                    out.newLine();
                }
                out.close();
            }catch(FileNotFoundException e)
	    {
		System.out.println("ERROR: File Not Found!");
	    }
	}catch(IOException x)
	{
	    System.out.println("ERROR: Can't create output file");
	}
    }
}
