/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saransh
 */
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;


public class Main {

    static int pts[];
    static int n,s,p;
    static int memo[][];
    static boolean marked[][];
    public static void main(String[] args)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
			int test=1;
            while(t-->0)
            {
                int A=sc.nextInt();
				int B=sc.nextInt();
				int count=0;
				for(int i=A;i<=B;i++)
				{
					String str=i+"";
					HashSet<Integer> set=new HashSet<Integer>();
					for(int i1=0;i1<=str.length();i1++)
					{
						String tmp=str.substring(i1)+str.substring(0,i1);
						if(tmp.charAt(0)!='0')
						{
							int temp=Integer.parseInt(tmp);
							if(temp>i&&temp<=B&&!set.contains(temp))
							{
								set.add(temp);
								count++;
							}	
						}
					}
				}
				System.out.println("Case #"+test+": "+count);
				test++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    

}


