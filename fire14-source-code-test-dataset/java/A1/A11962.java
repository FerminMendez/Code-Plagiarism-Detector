import java.lang.*;
import java.util.*;
import java.io.*;

public class B
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; ++i) {
			int N = 0, S = 0, p = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			int r = 0;
			for (int j = 0; j < N; ++j) {
				int t = Integer.parseInt(st.nextToken());
				if ((t / 3 + ((t % 3 > 0) ? 1 : 0)) >= p)
					++r;
				else if ((t / 3 + t % 3) >= p && S > 0) {
					--S;
					++r;
				}
				else if (t > 0 && (t / 3 + 1) >= p && S > 0) {
					--S;
					++r;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + r);
		}
	}
}
