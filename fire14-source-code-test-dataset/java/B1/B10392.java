import java.io.*;
import java.util.*;

class B
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("B.in"));
			PrintWriter pw = new PrintWriter(new FileWriter("B.out"));
			int X = Integer.parseInt(br.readLine());

			for(int i=0; i<X; i++)
			{
				String[] S = br.readLine().split(" ");
				int A = Integer.parseInt(S[0]);
				int B = Integer.parseInt(S[1]);
				int R = 0;

				int x = 1;
				int n = 0;
				while(A/x > 0) {
					n++;
					x *= 10;
				}

				for(int j=A; j<B; j++) {
					Set<Integer> seen = new HashSet<Integer>();
					for(int k=1; k<n; k++) {
						int p1 = j % (int)Math.pow(10, k);
						int p2 = (int) Math.pow(10, n-k);
						int p3 = j / (int)Math.pow(10, k);
						int y = p1*p2 + p3;
						
						if(j < y && !seen.contains(y) && y <= B) {
							seen.add(y);
							R++;
						}
					}
				}

				pw.printf("Case #%d: %d\n", i+1, R);
				pw.flush();
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}
}
