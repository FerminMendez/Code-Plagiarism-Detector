package codeJam;

import java.util.ArrayList;


import utilities.FileReadWrite;

public class RecycledNumbers {

	public static ArrayList<int[]> myDic;
	public static void main(String[] args)
	{
		FileReadWrite myFile = new FileReadWrite();
		String outputString ="";
		ArrayList<String> lines = myFile.readFile();
		int N = Integer.parseInt(lines.get(0));
		
		int A, B, counter;
		for (int i = 1; i < lines.size(); i++) 
		{
			counter=0;
			String[] w= lines.get(i).split(" ");
			A = Integer.parseInt(w[0]);
			B = Integer.parseInt(w[1]);
			System.out.println("A="+A+"  B="+B);
			String tempLine = "Case #"+(i)+": ";
			myDic = new ArrayList<int[]>();
			for (int j = A; j <= B; j++) 
			{
				if(!RecycledNumbers.hasSameDigits(j))
				{
					int[] h = RecycledNumbers.getOtherNumbers(j);
					for (int k = 0; k < h.length; k++) 
					{
						if(h[k]<=B && h[k]>=A && j<h[k])	
						{
//							System.out.println(j + " " + h[k]);
							int[] g = new int[2];
							g[0]=j;
							g[1]=h[k];
							if(!RecycledNumbers.exist(g))
							{
								myDic.add(g);
								counter++;
							}
						}
					}
				}
			}

			System.out.println("counter="+counter);
			System.out.println("myDic.size()="+myDic.size());
			System.out.println();
			outputString = outputString + tempLine + counter + "\n";
		}
		System.out.println(outputString);
		myFile.writeFile(outputString);
		
		
	}

	public static boolean hasSameDigits(int x) 
	{
		String str = Integer.toString(x);
		if(str.length()==1)
			return true;
		if(str.length()>1)
		{
			int c = 0;
			int d = 0;
			for (int i = 1; i < str.length(); i++) 
			{
				 if(str.charAt(i)=='0')
					 c++;
				 if(str.charAt(i)==str.charAt(0))
					 d++;
			}
			if(c==str.length()-1)
			{
				return true;
			}
			else
			{
				if(d==str.length()-1)
					return true;
				else
					return false;
			}
		}
		return true;
	}
	
	public static int[] getOtherNumbers (int x)
	{
//		System.out.println("x="+x);
//		System.out.println();
		String str = Integer.toString(x);
		int length = str.length();
		int[] y = new int[length-1];
		int counter = 0;
		String temp1, temp2, temp3;
		for (int i = 0; i < str.length(); i++) 
		{
			counter = i+1;
//			System.out.println("counter="+counter);
			if(counter==str.length())
				continue;
			temp1 = str.substring(counter);
//			System.out.println("temp1="+temp1);
			temp2 = str.substring(0, counter);
//			System.out.println("temp2="+temp2);
			temp3 = temp1 + temp2;
//			System.out.println("temp3="+temp3);
			if(temp3.charAt(0)=='0')
				temp3=RecycledNumbers.excludeLeadingzeros(temp3);
			y[i]=Integer.parseInt(temp3);
		}
		return y;
	}
	
	public static String excludeLeadingzeros (String str)
	{
		for (int i = 0; i < str.length(); i++) 
			if(str.charAt(i)!='0')
			{
				str = str.substring(i);
				break;
			}
		return str;
	}
	
	public static boolean exist (int[] g)
	{
		for (int i = 0; i < myDic.size(); i++) 
		{
			int[] j = myDic.get(i);
			if(j[0]==g[0] && j[1]==g[1])
				return true;
		}
		return false;
	}
	
	
}
