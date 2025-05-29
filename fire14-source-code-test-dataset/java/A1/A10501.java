package gcj2012qr;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.google.*;

/**
 * @author Roman Kosenko <madkite@gmail.com>
 */
public class DancingWithTheGooglers extends SingleThreadSolution<Object> {
	public static void main(String[] args) throws Exception {
		solve(new SolutionFactory<Object>() {
			public Callable<Object> read(BufferedReader br) throws IOException {
				String[] ss = br.readLine().split(" ");
				int n = Integer.parseInt(ss[0]);
				assert ss.length == n + 3;
				int s = Integer.parseInt(ss[1]);
				int p = Integer.parseInt(ss[2]);
				int[] t = new int[n];
				for(int i = 0; i < n; i++)
					t[i] = Integer.parseInt(ss[3 + i]);
				return new DancingWithTheGooglers(t, s, p);
			}
		}, "google/src/gcj2012qr/" + "B-small-attempt1.in");
	}
	private final int t[], s, p;
	public DancingWithTheGooglers(int[] t, int s, int p) {
		this.t = t;
		this.s = s;
		this.p = p;
	}
	public String call() throws Exception {
		int result = 0, surprises = s;
		//noinspection ForLoopReplaceableByForEach
		for(int i = 0; i < t.length; i++) {
			int max = (t[i] + 2) / 3;
			if(max + 1 == p && surprises > 0 && (t[i] % 3 == 2 || t[i] % 3 == 0 && t[i] > 0)) {
				surprises--;
				result++;
			} else if(max >= p)
				result++;
		}
		return Integer.toString(result);
	}
}
