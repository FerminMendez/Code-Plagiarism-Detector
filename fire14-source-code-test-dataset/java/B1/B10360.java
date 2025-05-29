import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;


public class C {

	/**
	 * @param args
	 */
	static String n;
	static int count = 0;
	static String h;
	static int t ;
	static ArrayList<Integer> memo  = new ArrayList<Integer>();
	static ArrayList<Integer> old  = new ArrayList<Integer>();
	
	public static int solve(int s, int e){
		count = 0 ;
		memo.clear();
		old.clear();
		
		for (int i = s; i <= e; i++) {
			n = i+"";
			in:for (int j = 0; j < n.length(); j++) {
				
				h = n.substring(n.length()-j) + n.substring(0,n.length()-j);
				t = Integer.parseInt(h);
				
				if (t <= e && t>i ) {
					for (int k = 0; k < memo.size(); k++) {
						if (memo.get(k)==t && old.get(k)==i)
							continue in;
					}
					memo.add(t);
					old.add(i);
					count++;
				}
			}
			
		}		
		return count;
	}
	
	
	static BitSet v1  = new BitSet(2000000);
	static int [] index = new int[2000000];
	
	public static int solve2(int s, int e){
		count = 0;
		v1.clear();
		Arrays.fill(index, 0,0,e);

		for (int i = s; i <= e; i++) {
			n = i+"";
			for (int j = 0; j <= n.length(); j++) {
				
				h = n.substring(n.length()-j) + n.substring(0,n.length()-j);
				t = Integer.parseInt(h);

				if (t <= e && t >i ) {
						if (v1.get(i) && index[i]==t)
							continue;
						count++;
						v1.set(i);
						index[i] = t ;
				}
			}
		}
		
		return count;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("c.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("c.out"));
		int n;
		int t = Integer.parseInt(br.readLine().trim());
		String ss[];
		
		for (int i = 1; i <= t; i++) {
		ss= br.readLine().split(" ");
		n = solve2(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
//		System.out.println("Case #"+i+": "+n);
		bw.write("Case #"+i+": "+n);
		bw.newLine();
		}
		
	bw.close();
	}
}
