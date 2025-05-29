package qual1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));

		int cases = Integer.parseInt(f.readLine());
		for (int zz = 1; zz <= cases; zz++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] list = new int[b-a+1];
			for (int i=a; i<=b; i++) {
				list[i-a] = i;
			}
			
			HashMap<Integer,ArrayList<Integer>> dump = new HashMap<Integer, ArrayList<Integer>>();
			
			long ans = 0;
			for (int i=a; i<=b; i++)  {
				if (list[i-a]==0)
					continue;
				String x = i+"";
				ArrayList<Integer> xzc = new ArrayList<Integer>();
				for (int j=1; j<x.length(); j++) {
					int t1 = (int) (i%(Math.pow(10,j)));
					int tx = (int) (t1*(Math.pow(10,(x.length()-j))));
					int t2 = (int) (tx + i/(Math.pow(10,j)));
					if (t2==i)
						continue;
					if (t2>=a && t2<=b) {
						if (list[t2-a]==0) {
							continue;
						}
						list[t2-a] = 0;
						xzc.add(t2);
					}
				}
				dump.put(i, xzc);
			}
			
			for (int key : dump.keySet()) {
				ArrayList<Integer> xzc = dump.get(key);
				if (xzc.isEmpty())
					continue;
				//Collections.sort(xzc);
				//System.out.println(key+" : "+xzc);
				if (xzc.size()==1)
					ans++;
				else
					ans+= ((xzc.size()+1)*(xzc.size())/2);
					
			}
			System.out.println("Case #" + zz + ": "+ans);
			
			out.println("Case #" + zz + ": "+ans);
		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}