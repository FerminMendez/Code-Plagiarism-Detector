package b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Dancing {
	List<Integer> ss = new ArrayList<>();
	int n;
	int min;
	int sp;
	int cnt = 0;
	
	public Dancing(int min, int sp, int[] sc) {
		this.min = min;
		this.n = sc.length;
		this.sp = sp;
		for(int s : sc) {
			ss.add(s);
		}
	}

	public static void main(String[] args) throws IOException {
//		System.out.println(new Dancing(5, 1, new int[] {15, 13, 11}).solve());
//		System.out.println(new Dancing(8, 0, new int[] {23, 22, 21}).solve());
//		System.out.println(new Dancing(1, 1, new int[] {8, 0}).solve());
//		System.out.println(new Dancing(8, 2, new int[] {29, 20, 8, 18, 18, 21}).solve());
		
		BufferedReader br = new BufferedReader(new FileReader("src/b/B-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/b/out"));
		
		int row = Integer.parseInt(br.readLine());
		System.out.println("ROW : " + row);
		
		for(int i=0; i<row; i++) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int sp = Integer.parseInt(line[1]);
			int min = Integer.parseInt(line[2]);
			int[] sc = new int[n];
			for(int j=0; j<n; j++) {
				sc[j] = Integer.parseInt(line[3+j]);
			}
			
			String res = "Case #" + (i+1) + ": " + new Dancing(min, sp, sc).solve();
			bw.write(res + "\n");
			System.out.println(res);
		}
		
		bw.close();
		br.close();
	}

	private int solve() {
		for(Iterator<Integer> it = ss.iterator(); it.hasNext();) { 
			int s = it.next();
			int rest = s - min;
			if (rest < 0) continue;
			if (rest /2 >= Math.max(min-1,0)) {
				cnt++;
				it.remove();
			}
		}
		
		Collections.sort(ss, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2- o1;
			}
		});
		
		for(Iterator<Integer> it = ss.iterator(); it.hasNext();) {
			int s = it.next();
			int rest = s - min;
			if (rest < 0) continue;
			if (rest / 2 >=  Math.max(min-2, 0) && sp > 0) {
				cnt++;
				sp--;
				it.remove();
			}
		}
		
		return cnt;
	}
}
