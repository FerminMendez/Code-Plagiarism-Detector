import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class B {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B-small.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("B-small.out"));
		
		
		int T = new Integer(br.readLine());
		for(int cases =0;cases< T; cases ++)
		{
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int N = new Integer(st.nextToken());
			int S = new Integer(st.nextToken());
			int p =new Integer(st.nextToken());
			
			int count =0;
	
			int[] scores = new int[N];
			for(int i =0;i<N;i++)
				scores[i] = new Integer(st.nextToken());
			for(int j=0;j<N;j++)
			{
				int score = scores[j];
				int l = score - 3*p;
				if(l>=0)
				{
					count++;
				}
				else if(l==-1 || l==-2)
				{
					count++;
				}
				else if((l==-3 || l==-4) && S>0 && score >=3*p-4 && score>p)
				{
					count++;
					S--;
				}
				
			}
			pw.println("Case #" +(cases+1) +": " +count);
		}
		
		pw.close();
		br.close();
		

	}

}
