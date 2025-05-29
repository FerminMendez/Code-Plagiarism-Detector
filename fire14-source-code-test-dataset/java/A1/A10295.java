import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable
{
	static Scanner scanner;
	static BufferedReader input;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception
	{
		new Thread(new Main()).start();
	}

	public void run()
	{
		try
		{
			input = new BufferedReader(new FileReader("input.txt"));
			scanner = new Scanner(input);
			pw = new PrintWriter(new File("output.txt"));

			solve();
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void solve() throws Exception
	{
		int T = scanner.nextInt();
		for(int t = 0; t < T; t++)
		{
			int N = scanner.nextInt(); // the number of Googlers
			int S = scanner.nextInt(); // the number of surprising triplets of scores
			int P = scanner.nextInt(); // Given the total points for each Googler, as well as the number of surprising triplets of scores, what is the maximum number of Googlers that could have had a best result of at least p?

			int [] ti = new int[N];    // the total points of the Googlers.
			for(int i = 0; i < N; i++){
				ti[i]=scanner.nextInt();
			}

			//--- judge

			int r, s; 
			int ans = 0;
			int cand = 0;
			for(int i = 0; i < N; i++){
				r = ti[i]/3;
				s = ti[i]%3;

				if ( s == 0 ) {
					if ( r >= P ) {
						ans++;
					} else if ( r+1 >= P && r-1 >=0 ) {
						cand++;
					} 
				} else if ( s == 1 ) {
					if ( r+1 >= P ) {
						ans++;
					}
				} else {
					if ( r+1 >= P ) {
						ans++;
					} else if ( r+2 >= P ) {
						cand++;
					} 
				}
			}
			ans = ans + Math.min (cand, S);
			pw.println("Case #" + (t+1) + ": " + ans);
		}
	}
}
