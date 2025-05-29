import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Main
{

	/**
	 * @param args
	 */
//	public static void main(String[] args)
//	{
//		try
//		{
//			Map<Character, Character> m = new HashMap<Character, Character>();
//			start_googlerese("ejp mysljylc kd kxveddknmc re jsicpdrysi","our language is impossible to understand",m);
//			start_googlerese("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd","there are twenty six factorial possibilities",m);
//			start_googlerese("de kr kd eoya kw aej tysr re ujdr lkgc jv","so it is okay if you want to just give up",m);
//			
//			m.put('z','q');
//			m.put('q','z');
//			
//			int a=0;
//			a= a+1;
//			
//			char letter;
//			for (letter='a'; letter <= 'z'; letter++)
//			{
//				if(m.containsKey(letter))
//					System.out.println(letter+" "+m.get(letter));
//				else
//					System.out.println(letter+" "+"!!!");
//			}
//			
//			googlerese(m);
//			
//		}
//		catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
	
	
	public static void main(String[] args)
	{
		try
		{
			recycled();
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	

	
	
	public static void recycled() throws IOException
	{
		ArrayList<String[]> input = Tools.getInput("C:\\Users\\Yannick\\Dropbox\\GCJ_JAVA\\Q_2012\\C-small.in");
		ArrayList<String> output = new ArrayList<String>();
		
		int num_cases = Integer.parseInt(input.get(0)[0]);
		
		Set<Integer> done = new HashSet<Integer>();
		
		
		
		//!!!!!!!!!!!!!!!!!!! num_cases
		for (int i=0;i<num_cases;i++)
		{
			int length = input.get(i+1)[0].length();
			int lower = Integer.parseInt(input.get(i+1)[0]);
			int upper = Integer.parseInt(input.get(i+1)[1]);
			
			int result=0;
			
			int mult = (int) Math.pow(10,length-1);
			
			Set<Integer> ms = new HashSet<Integer>(length-1);
			
			for (int n=lower;n<=upper;n++)
			{
				int m=n;				
				ms.clear();
				
				for(int j=0;j<length-1; j++)
				{
					
					int last = m - 10*(m/10);
					m = m-last;
					m = m/10;
					m = m + last * mult;
									
					
					if(m>n && m<=upper && !ms.contains(m))
					{
						System.out.println(n+" "+m);
						result++;
						ms.add(m);
					}
					
				}
			}			
			
			
			StringBuilder sbO = new StringBuilder();
			sbO.append("Case #"+(i+1)+": ");
			sbO.append(result);
			output.add(sbO.toString());
		}
		
		Tools.saveOutputSingle("C:\\Users\\Yannick\\Dropbox\\GCJ_JAVA\\Q_2012\\C-small.out", output);
	}
	
	
	public static void start_googlerese(String input, String output, Map<Character, Character> m) throws IOException
	{		
		if(input.length()!=output.length())
			throw new IOException();
		
		for(int i=0;i<input.length();i++)
		{
			m.put(input.charAt(i),output.charAt(i));
		}
	}
	
	public static void googlerese(Map<Character, Character> m) throws IOException
	{
		ArrayList<String> input = Tools.getInputSingle("C:\\Users\\Yannick\\Dropbox\\GCJ_JAVA\\Q_2012\\A-small.in");
		ArrayList<String> output = new ArrayList<String>();
		
		int num_cases = Integer.parseInt(input.get(0));
		
		for (int i=0;i<num_cases;i++)
		{
			String strI = input.get(i+1);
			StringBuilder sbO = new StringBuilder();
			sbO.append("Case #"+(i+1)+": ");
			for(int j=0; j<strI.length();j++)
			{
				sbO.append(m.get(strI.charAt(j)));
			}
			output.add(sbO.toString());			
		}
			
				
		Tools.saveOutputSingle("C:\\Users\\Yannick\\Dropbox\\GCJ_JAVA\\Q_2012\\A-small.out", output);
	}
	

	public static void minimum_scalar_product() throws IOException
	{
		ArrayList<String[]> input = Tools.getInput("D:\\Documents\\Dropbox\\GCJ_JAVA\\1A_2008\\A-large-practice.in");
		ArrayList<String[]> output = new ArrayList<String[]>();
		
		
		int T = Integer.parseInt(input.get(0)[0]);
		
		for (int i=0;i<T;i++)
		{
			int pointer = i*3+1;
			int n = Integer.parseInt(input.get(pointer)[0]);
			
			ArrayList<Integer> vectorA = new ArrayList<Integer>();
			ArrayList<Integer> vectorB = new ArrayList<Integer>();

			for(int j=0;j<n;j++)
			{
				vectorA.add(Integer.parseInt(input.get(pointer+1)[j]));
				vectorB.add(Integer.parseInt(input.get(pointer+2)[j]));
			}
			
			Collections.sort(vectorA);
			Collections.sort(vectorB);
			
			long sum=0;
			
			for (int j=0;j<n;j++)
				sum += ((long) vectorA.get(j))*vectorB.get(n-j-1);
			
			String[] output_line = new String[1];
			output_line[0] = "Case #"+(i+1)+": "+sum;
			output.add(output_line);			
		}		
		
		Tools.saveOutput("D:\\Documents\\Dropbox\\GCJ_JAVA\\1A_2008\\A-large-practice.out", output);
	}
	
	public static void dancing() throws IOException
	{
		ArrayList<String[]> input = Tools.getInput("C:\\Users\\Yannick\\Dropbox\\GCJ_JAVA\\Q_2012\\B-small.in");
		ArrayList<String> output = new ArrayList<String>();
		
		int num_cases = Integer.parseInt(input.get(0)[0]);
		
		for (int i=1;i<=num_cases;i++)
		{
			int result=0;
			
			int N=Integer.parseInt(input.get(i)[0]);
			int S=Integer.parseInt(input.get(i)[1]);
			int p=Integer.parseInt(input.get(i)[2]);
			int a,b,c;
			for(int j=0;j<N;j++)
			{
				int goog = Integer.parseInt(input.get(i)[3+j]);
				a = goog/3;
				b = (goog-a)/2;
				c = goog-a-b;
				
				if( a>=p || b>=p || c>=p )
					result++;
				else
				{
					if(S>0 && ( (a==b && a==p-1 && a>0) || (a==c && a==p-1 && a>0) || (b==c && b==p-1 && b>0) ) )
					{
						S--;
						result++;
					}
				}
				
			}

			
			StringBuilder sbO = new StringBuilder();
			sbO.append("Case #"+(i)+": ");
			sbO.append(result);
			output.add(sbO.toString());
		}
		
		Tools.saveOutputSingle("C:\\Users\\Yannick\\Dropbox\\GCJ_JAVA\\Q_2012\\B-small.out", output);
	}

}
