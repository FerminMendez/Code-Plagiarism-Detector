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

			int A = scanner.nextInt();
			int B = scanner.nextInt();

			String AA = String.valueOf(A);
			String BB = String.valueOf(B);

			int dd = AA.length(); // digit

			int ans = 0 ;
			int n,idx;
			int[] m = new int[dd];
			int[] f = new int[dd];
			for ( n = A ; n < B ; n++ ) {
				for (idx = 1 ; idx < dd ; idx++ ) {
					m[idx] = this.recycle ( n , idx );
					f[idx] = 0 ; 
					if ( String.valueOf(m[idx]).length() == dd ) {
						if ( m[idx] > n && m[idx] <= B ) {
							f[idx]=1;
							ans++;
						}
					}
				}

				for ( int i=0 ; i < dd ; i++ ){
					if ( f[i] == 1 ) {
						for ( int j = i+1 ; j < dd ; j++) {
							if ( m[i] == m[j] ) {
								ans--;
							}
						}
					}
				}
			}

			pw.println("Case #" + (t+1) + ": " + ans);
		}
	}
	public int recycle (int i, int index){
		return Integer.parseInt ( this.recycle ( String.valueOf(i),index ) ) ;
		
	}

	public String recycle (String s, int index){
		return s.substring(index, s.length()) + s.substring( 0, index );
	}
}
