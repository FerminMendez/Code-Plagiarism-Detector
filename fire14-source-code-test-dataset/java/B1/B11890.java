import java.io.*;

class RecycledNumbers
{
	static int A,B,result;
	public static void main(String args[]) throws IOException
	{
		FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
		DataInputStream dstream = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(dstream));
		FileWriter fw = new FileWriter("output.txt");
		BufferedWriter out = new BufferedWriter(fw);
		
		int lines = Integer.parseInt(br.readLine());		//lines LINES OF INPUT TO FOLLOW
		
		for(int j=0;j<lines;j++)                        //EACH LINE FROM SECOND LINE
		{
			result=0;
		
			out.write("Case #"+(j+1)+": ");
		
			
			
			String str = br.readLine();
			String strAray[] = str.split(" ");
			A = Integer.parseInt(strAray[0]);
			B = Integer.parseInt(strAray[1]);
			
			for(int i=B;i>A;i--)
			{
				result = result+howMany(i);
				
				
			}
			
			out.write(Integer.toString(result));// write result
			out.newLine();
		}		
		fstream.close();
		out.close();
		//log.close();
	}
	static int howMany(int m) throws IOException
	{	
		int n,no=0;
		
		int length = (Integer.toString(m)).length();
		if(length==1)
		{
		
			return 0;
		}
		
		for(int i=1;i<length;i++)
		{
			n=rotate(i,m,length);
					
			if(A<=n && n<m && m<=B)
				no++;
		}
		
		return no;
	}
	static int rotate(int j, int m, int length) throws IOException
	{
		
		
	
		
		
		String s = Integer.toString(m);
		int[] intArray = new int[length];
		int number = 0;
	
 
		for (int i = 0; i < length; i++)
		{
			intArray[i] = Character.digit(s.charAt(i), 10);
		}
		for(int i=0;i<j;i++)					//rotate m , i times
		{
			int temp = intArray[0];
			for(int k=0;k<(length-1);k++)
			{
				intArray[k] = intArray[k+1];
			}
			intArray[length-1] = temp;
		}
		for(int i=0;i<length;i++)
		{
			number = number*10 + intArray[i];
		}
		
		return number;
	}
	
	
}