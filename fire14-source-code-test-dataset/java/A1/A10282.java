package qual1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		for (int i=0; i<=10; i++) {
			System.out.println(Math.max((i-2)+(i-2)+i,i));
		}
		
		
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("B-small-attempt4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small-attempt4.out")));

		HashMap<Integer, ArrayList<String>> debug = new HashMap<Integer, ArrayList<String>>();

		int cases = Integer.parseInt(f.readLine());
		for (int zz = 1; zz <= cases; zz++) {
			String x = f.readLine();
			StringTokenizer st = new StringTokenizer(x);
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());  //At least p for BEST score.
			int[] points = new int[n];
			int ans = 0;

			// Assume p = 5
			int magicNum = Math.max((p - 2) + (p - 2) + p,p); // 3 3 5 or 3 4 5
			// magicNum and MagicNum+1 are always be surprising

			// 3 5 5 or 4 4 5
			// magicNum+2 may be surprising or not.

			//p=0 -2 -2 0
			//p=1 -1 -1 1
			//p=2  0  0 2
			//p=3  1  1 3
			//p=4  2  2 4 
			
			for (int xx = 0; xx < n; xx++) {
				points[xx] = Integer.parseInt(st.nextToken());
				
				if (p==0 || p==1) {
					if (points[xx]>=p)
						ans++;
					continue;
				}
				
				if (s > 0 && (points[xx] == magicNum || points[xx] == magicNum + 1)) {
					s--;
					ans++;
				} else if (points[xx] >= magicNum + 2) {
					ans++;
				}
			}
			out.println("Case #" + zz + ": " + ans);

		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}