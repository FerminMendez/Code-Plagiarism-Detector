import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;


public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C-small.in"));
		PrintWriter out =new PrintWriter(new FileWriter("C-small.out"));
		int T = Integer.parseInt(br.readLine());		
		
		
		
		for(int i = 0; i <T;i++)
		{
			
			String input = br.readLine();
		
			StringTokenizer st = new StringTokenizer(input);
			int n = new Integer(st.nextToken());
			int m = new Integer(st.nextToken());
			int count =0;
			for(int j=n;j<=m;j++)
			{
				Set s = new HashSet();
				int k = j;
				int b=10;
				while(k/b>0)
				{
					int first = k/b;
					int second = k%b;
					String res = Integer.toString(second)+Integer.toString(first);
					int ires = Integer.parseInt(res);
					if(ires != j&& ires>j && ires <=m )	
					{
						count++;
						
					}
					if(ires==j)
						break;
					b=b*10;
				}
							
			} 
						
			out.println("Case #"+(i+1)+": " +count);
		}
			
		br.close();
		out.close();
		}
	}

