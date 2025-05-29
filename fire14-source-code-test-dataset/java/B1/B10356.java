/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recycled;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Calido
 */
class myobj
{
	long n;
	long m;
	public myobj(long n,long m)
	{
		this.n=n;
		this.m=m;
	}
}

public class Recycled {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
	{
		ArrayList list=new ArrayList();
		int t;
		long a,b,cnt;
		try
		{
			Scanner scnr=new Scanner(new File(args[0]));
			PrintWriter out=new PrintWriter(new File(args[1]));
			
			t=scnr.nextInt();
			for(int i=1;i<=t;i++)
			{
				//cnt=0;
				list.clear();
				a=scnr.nextLong();//inputing a
				b=scnr.nextLong();//inputing b
				for(long j=a;j<=b;j++)
				{
					long n=j;
					long m;
					long tmp1;
					int len=String.valueOf(n).length();
					for(int k=1;k<len;k++)
					{
						tmp1=n % (long)Math.pow(10,k);
						m=tmp1* (long)Math.pow(10,len-k);
                                                //System.out.print(tmp1+" ");
						tmp1=n / (long)Math.pow(10,k);
						//System.out.print(tmp1+" ");
                                                m=m+tmp1;
                                                
						if(n<m && m<=b)
						{
                                                    //System.out.print(n+":"+m+" ");
                                                    addtolist(list,new myobj(n,m));
							//cnt++;
						}
					}
				}
                                out.println("Case #"+i+": "+list.size());
                                System.out.println("Case #"+i+": "+list.size());
			}
                        
			out.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File Not Found.");
		}
		
	}
	public static void addtolist(ArrayList list,myobj item)
	{
		boolean flag=false;
		for(int i=0;i<list.size();i++)
		{
			myobj tmp=(myobj)list.get(i);
			if(tmp.n==item.n && tmp.m==item.m)
			{
				flag=true;
			}
		}
		if(flag==false)
		{
			list.add(item);
		}
	}

}
