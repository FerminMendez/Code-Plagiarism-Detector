import java.io.*;
import java.util.*;
import java.lang.*;

class Pair {
	public int x;
	public int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static boolean equals(Pair a, Pair b) {
		return (((a.x == b.x) && (a.y == b.y)) || ((a.x == b.y) && (a.y == b.x)));
	}
}

public class Recycle {
	private static HashMap<Integer, HashSet<Integer>> map;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new FileReader(new File("/Users/atai/Play/Codejam/input.txt")));
		PrintWriter prn = new PrintWriter(new FileWriter("output.txt"));
		
		int numTests = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < numTests; i++) {
			String[] arg = br.readLine().trim().split(" ");
			int min = Integer.parseInt(arg[0]);
			int max = Integer.parseInt(arg[1]);
			
			int total = 0;
			map = new HashMap<Integer, HashSet<Integer>>();
			for (int j = min; j <= max; j++) {
				// for each number check to see how many pairs there are
				Integer rand = new Integer(j);
				int len = rand.toString().length();
				int stock = (int)Math.pow(10,len);
				for (int k = 0; k < len-1; k++) {
						int c = (int)Math.pow(10,k+1);
						int r = j % c;
						if (r == 0)
							continue;
						// leading zero?
						if (r < (int)Math.pow(10,k))
							continue;
						
						int recycle = (j+stock*r)/c;
						if ((recycle > j) && (recycle <= max)) {
							System.out.println(j + ", " + recycle);
							if (map.containsKey(j)) {
								if (map.get(j).add(recycle))
									total++;
							} else {
								HashSet<Integer> temp = new HashSet<Integer>();
								temp.add(recycle);
								map.put(j, temp);
								total++;
							}
						}
				}						
			}
			prn.printf("Case #%d: %d\n", i+1, total);
		}
		
		prn.close();
	}
}
