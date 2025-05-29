import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B {


	public static void main (String[] args)
	{


		try {
			//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/B-small-attempt0.in"))));
			PrintWriter pw = new PrintWriter(System.out);
			int cases = Integer.parseInt(in.readLine());	
			for (int i = 0; i < cases; i++) {
				int max=0;
				String[] data = in.readLine().split(" ");
				int N = Integer.parseInt(data[0]);
				int S = Integer.parseInt(data[1]);
				int p = Integer.parseInt(data[2]);
				int[] sums = new int[N];
				for (int j = 0; j < N; j++) {
					sums[j] = Integer.parseInt(data[j+3]);
				}
				if(p==0)
				{
					max=N;
				}
				else if (p==1)
				{
					for (int j = 0; j < sums.length; j++) {
						if(sums[j]>0)
							max++;
					}
				}
				else{
				for (int j = 0; j < sums.length; j++) {
					if(sums[j]>=3*p-2)
						max++;
					else if(sums[j]>=3*p-4 && S>0)
					{
						max++;
						S--;
					}
					
				}
				}

				
				System.out.println("Case #"+(i+1)+": "+max);
			}
			pw.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
