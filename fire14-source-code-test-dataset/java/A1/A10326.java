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
                n=sc.nextInt();
                s=sc.nextInt();
                p=sc.nextInt();
                pts=new int[n];
                memo=new int[n+1][s+1];
                marked=new boolean[n+1][s+1];
                for(int i=0;i<n;i++)pts[i]=sc.nextInt();
                System.out.println("Case #"+test+": "+find(0,s));
				test++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static int find(int pos,int sur)
    {
        if(pos==n)
        {
            if(sur==0)return 0;
            return -10000;
        }
        if(marked[pos][sur])return memo[pos][sur];
        marked[pos][sur]=true;
        int max=-10000;
        for(int p1=0;p1<=10;p1++)
        {
            for(int p2=0;p2<=10;p2++)
            {
                int p3=pts[pos]-p1-p2;
                if(p3>=0&&p3<=10)
                {
                    int arr[]=new int[3];
                    arr[0]=p1;
                    arr[1]=p2;
                    arr[2]=p3;
                    Arrays.sort(arr);
                    if(arr[2]-arr[0]==2&&sur>0)
                    {
                        if(arr[2]>=p)
                        {
                            max=Math.max(max,1+find(pos+1,sur-1));
                        }
                        else
                        {
                            max=Math.max(max,find(pos+1,sur-1));
                        }
                    }
                    else if(arr[2]-arr[0]<2)
                    {
                        if(arr[2]>=p)
                        {
                            max=Math.max(max,1+find(pos+1,sur));
                        }
                        else
                        {
                            max=Math.max(max,find(pos+1,sur));
                        }
                    }
                }
            }
        }
        memo[pos][sur]=max;
        return max;

    }

}


