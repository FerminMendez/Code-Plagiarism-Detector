import java.io.*;
import java.util.*;
import java.math.*;

public class C
{
  static int[] size={1,10,100,1000};
	public static void main(String[] args) throws Exception
	{
    int T;	
		RandomAccessFile in = new RandomAccessFile(args[0],"r");
		T=Integer.parseInt(in.readLine());
		


		for (int i=1; i<=T; i++)
		{
      String line=in.readLine();      
      String[] temp=line.split(" ");
      int a=Integer.parseInt(temp[0]);
      int b=Integer.parseInt(temp[1]);      
      String ans=solve(a,b);
      System.out.println("Case #"+i+": "+ans);
    }

		in.close();
	}
	

	public static String solve(int a, int b)
  {
    int total=0;
    for (int i=a; i<=b; i++) total+=count(i,b);
    return ""+total;
  }
  
  public static int count(int start, int max)
  {
    //System.out.println("Start "+start);
    String temp=""+start;
    int N=temp.length();
    
    int a=start;
    int count=0;
    for (int i=0; i<N-1; i++)
    {
      a=rotate(a,size[N-1]);
      //System.out.println(a);
      if (a>start && a<=max) count++;
    }
    
    return count;
  }
  
  public static int rotate(int a, int n)
  {
    int last=a%10;
    return a/10+n*last;
  }
  
  public static void print(int[] b)
  {
    for (int i=0; i<b.length; i++) System.out.print(b[i]);
    System.out.println();
  }
}