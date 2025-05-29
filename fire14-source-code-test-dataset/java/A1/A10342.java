/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Calido
 */
public class Googlers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int t,n,s,p,ti,cnt;
		try
		{
			Scanner scnr=new Scanner(new File(args[0]));
			PrintWriter out=new PrintWriter(new File(args[1]));
			t=scnr.nextInt();
			System.out.println("T: "+t);
			for(int i=1;i<=t;i++)
			{
				cnt=0;
				n=scnr.nextInt();//reading number of googlers
				s=scnr.nextInt();//reading special case
				p=scnr.nextInt();//reading point
				for(int j=0;j<n;j++)
				{
					ti=scnr.nextInt();
					if(ti>=(p+(2*(p-1))))
					{
						cnt++;
					}
					else if(ti>=(p+(2*(p-2))))
					{
						if(ti>=2 && ti<=28)
						{
							if(s>0)
							{
								cnt++;
								s--;
							}
						}
					}
				}
	
				//output to File
				out.println("Case #"+i+": "+cnt);
                                System.out.println("Case #"+i+": "+cnt);
			}
			out.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File Not Found.");
		}

    }
}
