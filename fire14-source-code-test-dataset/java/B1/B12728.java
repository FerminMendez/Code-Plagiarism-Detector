/*
 *Do you ever become frustrated with television because you keep seeing the same things, 
 *recycled over and over again? Well I personally don't care about television, 
 *but I do sometimes feel that way about numbers.
 *Let's say a pair of distinct positive integers (n, m) is recycled if you can obtain m by 
 *moving some digits from the back of n to the front without changing their order. For example, 
 *(12345, 34512) is a recycled pair since you can obtain 34512 by moving 345 from the end of 12345 to the front.
 *Note that n and m must have the same number of digits in order to be a recycled pair. Neither n nor m can have leading zeros.
 *Given integers A and B with the same number of digits and no leading zeros, 
 *how many distinct recycled pairs (n, m) are there with A = n < m = B?
 *
 **/

import java.io.*;
public class Recycled_Numbers
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("g:/H.txt"))));
			int n=Integer.parseInt(br.readLine());
			String str=null;
			int A,B;
			String arr[]=new String[n];
			String array[];
			File f=new File("g:/OutputX.txt");
			f.createNewFile();
			int count=0;
			int temp1,temp2;
			boolean result=false;
			for(int i=0;i<n;i++)
			{
				str=br.readLine();
				count=0;
				array=str.split(" ");
				A=Integer.parseInt(array[0]);
				B=Integer.parseInt(array[1]);
				temp1=A;
				for(;temp1<B;temp1++)
				{
					for(int j=temp1+1;j<=B;j++)
					{
						result=getResult(temp1,j);
						if(result)
							 count++;
					}
				}
				arr[i]=new String("Case #"+(i+1)+": "+count);
			}
			FileWriter bout=new FileWriter(f);
			for(int i=0;i<n;i++)
			{
				bout.append(arr[i]+"\n");			
			}
			bout.close();
		}
		
		catch(IOException e1)
		{
			e1.printStackTrace();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public static boolean getResult(int A,int B)
	{
		boolean flag=true;
		String str=B+"";
		String str1=null;
		int length=str.length();
		//System.out.println(str);
		if(length==1)
		{
			if(A==B)
				return true;
			else 
				return false;
		}
		int count=0;
		//System.out.println("B Number"+B);
		while(A!=B&&flag)
		{
			count++;
			//System.out.println("Count"+count);
			//System.out.println("Length"+length);
			//System.out.println("last " +str.substring(length-count,length) + "first" +str.substring(0,length-count+1));
		    str1=str.substring(length-count,length)+str.substring(0,length-count);
		    //System.out.println("new Number " +str1);
		    B=Integer.parseInt(str1);	
		    if(A==B)
		    	return true;
		    if(length==count+1)
		    	flag=false;		
		    		
		}
		return false;
	}
}