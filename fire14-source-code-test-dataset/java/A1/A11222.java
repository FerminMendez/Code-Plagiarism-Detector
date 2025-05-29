package qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class B {
	static int surprise=0;
	static int[] findMin(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
			for(int j=i+1;j<a.length;j++)
			if(a[i]>a[j])
			{
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		
		return a;
				
	}
	
	static boolean checkTriplet(int a, int b, int c, int maxScore)
	{
		if(Math.abs(a-b)>2 || Math.abs(a-c)>2 || Math.abs(b-c)>2)
			return false;
		if(Math.abs(a-b)==2 || Math.abs(a-c)==2 || Math.abs(b-c)==2)
			if((a>=maxScore || b>=maxScore || c>=maxScore) && surprise>0)
			{
				surprise--;
				return true;
			}
			else return false;
		if(a>=maxScore || b>=maxScore || c>=maxScore)
			return true;
		return false;
		
		
	}
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner sin=new Scanner(new File("C:\\Users\\DELL\\Desktop\\CodeJam\\B-small-attempt1.in"));
		PrintStream ps=new PrintStream(new File("C:\\Users\\DELL\\Desktop\\CodeJam\\BOut.out"));
		int cases=sin.nextInt();
		for(int i=1;i<=cases;i++)
		{
			int num=sin.nextInt();
			surprise=sin.nextInt();
			int maxScore=sin.nextInt();
			int count=0;
			int[] scores=new int[num];
			for(int j=0;j<num;j++)
				scores[j]=sin.nextInt();
			
			scores=findMin(scores);
			
			for(int j=0;j<scores.length;j++)
			{
				//System.out.println(" for "+scores[j]);
				if(maxScore>scores[j])
					continue;
				int div=scores[j]/3;
				int rem=scores[j]-div;
				if(rem<maxScore)
					continue;
				if(checkTriplet(div,rem/2,rem-rem/2, maxScore))
				{
					//System.out.println("check pass for "+div+" "+rem/2+" "+(rem-rem/2));
					count++;
				}
				else if(checkTriplet(div,maxScore,rem-maxScore,maxScore))
				{
					count++;
				}
			}
			
			ps.println("Case #"+i+": "+count);
			
		}
		ps.close();
	}

}
