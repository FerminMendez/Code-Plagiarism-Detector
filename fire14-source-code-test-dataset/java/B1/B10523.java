package gcj2012qr;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import com.google.*;

/**
 * @author Roman Kosenko <madkite@gmail.com>
 */
public class RecycledNumbers extends SingleThreadSolution<Object> {
	public static void main(String[] args) throws Exception {
		solve(new SolutionFactory<Object>() {
			public Callable<Object> read(BufferedReader br) throws IOException {
				String[] ss = br.readLine().split(" ");
				assert ss.length == 2;
				return new RecycledNumbers(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
			}
		}, "google/src/gcj2012qr/" + "C-small-attempt0.in");
	}
	private final int a, b;
	public RecycledNumbers(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public String call() throws Exception {
		int result = 0;
		for(int i = a; i < b; i++) {
			int p = 1;
			for(int t = i / 10; t != 0; p *= 10)
				t /= 10;
			for(int t = i;;) {
				t = t / 10 + p * (t % 10);
				if(t == i)
					break;
				if(t > i && t <= b)
					result++;
			}
		}
		return Integer.toString(result);
	}
}
