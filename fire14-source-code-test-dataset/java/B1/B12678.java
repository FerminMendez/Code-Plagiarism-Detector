import java.io.*;
import java.util.HashMap;

class GoogleRecycle{
	
	public static int[] findNext(String s, int n)
	{
		int a[]= new int[n];
		for (int i =0; i<s.length();i++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(s.substring(i));
			sb.append(s.substring(0,i));
			Integer temp = Integer.parseInt(sb.toString());
			if(temp.toString().length()==s.length())
				a[i]=Integer.parseInt(sb.toString());
			else 
				a[i]=0;
		}
		return a;
	}

	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("C-small-attempt0.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fstream = new FileWriter("output.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		int testcases = Integer.parseInt(br.readLine());
		
		for (int i=1;i<=testcases;i++)
		{
			
			String line = br.readLine();
			int start = Integer.parseInt(line.substring(0, line.indexOf(' ')));
			int temp =start;
			int n =0;
			while(temp>0)
			{
				temp=temp/10;
				n++;
			}
			line = line.substring(line.indexOf(' ')+1);
			int end = Integer.parseInt(line);
			int count =0;
			for (int j=start;j<=end;j++)
			{
				int[] a =new int[n];
				Integer x = j;
				a= findNext(x.toString(),n);
				HashMap<Integer,String> map = new HashMap<Integer,String>();
				int flag = 0;
				for (int p: a)
				{
					
					if(p>j && p<=end && p!=0 && !map.containsKey(p))
					{
						map.put(p, null);
						count++;
					}
				
				}
				
			}
			//System.out.println("Reached here also");
			out.write("Case #"+i+": "+count);
			if(i!=testcases)
			{
				out.write("\n");
			}
		
		}
		out.close();
		br.close();
	}
}