package recycledNumbers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import common.FileRead;

public class ConNumMain 
{
	public static int intSize(int num)
	{
		if(num <10)
		{
			return 1;
		}
		else if(num<100)
		{
			return 2;
		}
		else if(num<1000)
		{
			return 3;
		}
		else if(num <10000)
		{
			return 4;
		}
		else if(num < 100000)
		{
			return 5;
		}
		else if(num < 1000000)
		{
			return 6;
		}
		else 
		{
			return 7;
		}
	}

	public static void main(String args[])
	{
		StringBuffer sb,sb1;
		BufferedWriter out=null;
		FileWriter fstream=null;
		int intcase=0,a,b;
		ArrayList<Integer> arr,arr1,arr2;
		boolean flag=false;
		String str1=null;
		try
		{
			
			sb=FileRead.read();
			String str[]=sb.toString().split("\n");
			fstream = new FileWriter("D:/tony/code jam/Recycledf Numbfers/C-small-attempt0.out");
			out=new BufferedWriter(fstream);
			for(int i=1;i<=(Integer.parseInt(str[0]));i++)
			{
				arr1=new ArrayList<Integer>();
				arr2=new ArrayList<Integer>();
				a=Integer.parseInt(str[i].split(" ")[0]);
				b=Integer.parseInt(str[i].split(" ")[1]);
				if(a<10)
				{
					a=10;
				}
				for(int j=a;j<=b;j++)
				{
					if(j>1111)
					{
						j=j+1-1;
					}
					str1=String.valueOf(j);
					arr=new ArrayList<Integer>();
					for(int k=1;k<intSize(j);k++)
					{
						//arr.add(Integer.rotateRight(j, k+1));
						sb1=new StringBuffer(""); 
						for(int r=1;r<str1.length();r++)
						{
							sb1=sb1.append(str1.charAt(r));
						}
						sb1=sb1.append(str1.charAt(0));
						str1=sb1.toString();
						arr.add(Integer.parseInt(sb1.toString()));
					}
					for(int m=0;m<arr.size();m++)
					{
						if(arr.get(m)>=a && arr.get(m)<=b && !arr.get(m).equals(j))
						{
							flag=false;
							for(int p=0;p<arr1.size();p++)
							{
								if((arr1.get(p).equals(j) && arr2.get(p).equals(arr.get(m))) || (arr2.get(p).equals(j) && arr1.get(p).equals(arr.get(m))))
								{
									flag=true;
									break;
								}
							}
							if(flag==false)
							{
								arr1.add(j);
								arr2.add(arr.get(m));
							}
							
						}
						
					}
				}
				out.write("Case #"+(++intcase)+": "+arr1.size()+"\n");
			}
			
		}
		 catch (Exception e)
		  {
			  System.err.println("Error: " + e.getMessage());
		  }
		finally
		{
			try
			{
				out.close();
				fstream.close();
			}
			 catch (Exception e)
			  {
				  System.err.println("Error: " + e.getMessage());
			  }
		}
		
	}
}
