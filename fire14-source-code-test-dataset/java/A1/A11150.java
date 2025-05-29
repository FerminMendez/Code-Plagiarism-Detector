import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;


public class Dancing {

	public static void main(String[] args) throws Exception {
		Dancing object = new Dancing();
		object.solve(object.getClass().getSimpleName().toLowerCase());
		}	

	private boolean canHave(int total, int p, boolean surprise) {		
		int diffMax = 1;
		if (surprise)
			diffMax = 2;
		
		for (int t3=p; t3<=10; t3++)			
			for (int t2diff=0; t2diff<=diffMax; t2diff++)
				for (int t1diff=0; t2diff+t1diff<=diffMax; t1diff++)
				{
					int t2 = t3 - t2diff;
					int t1 = t2 - t1diff;
					
					if (t1 < 0 || t2 < 0)
						continue;
					
					if (t1+t2+t3 == total)
						return true;
				}
				
		return false;
	}
	
		private void solve(String filePrefix) throws Exception {
			
			StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader(filePrefix + ".in")));
			PrintWriter pw = new PrintWriter(new FileWriter(filePrefix + ".out"));
			
			st.nextToken();
			int testsCount = (int) st.nval;			
			
			for (int tc=0; tc<testsCount; tc++)
			{
				st.nextToken();
				int n = (int) st.nval;
				
				st.nextToken();
				int s = (int) st.nval;
				
				st.nextToken();
				int p = (int) st.nval;
				
				ArrayList<Integer> total = new ArrayList<Integer>();
				
				for (int i=0; i<n; i++)
				{
					st.nextToken();
					total.add((int) st.nval);
				}
				
				Collections.sort(total);
				Collections.reverse(total);
				
				int result = 0;
				
				for (int i=0; i<n; i++)
				{
					if (canHave(total.get(i), p, false))
					{
						result++;
						continue;
					}
					
					if (s > 0 && canHave(total.get(i), p, true))
					{
						result++;
						s--;
						continue;
					}
					
					/* nothing, break */
					break;
				}
				
				pw.write("Case #" + (tc+1) + ": " + result + "\n");
			}
			
			pw.flush();
			pw.close();
			
		}
}
