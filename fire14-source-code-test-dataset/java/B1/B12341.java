import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class C {
	static ArrayList<Integer>[] list;
	static long[] ten;
	static int limit;

	public static void main(String[] args) throws IOException {
		initializeTens();
		initializeList();
		System.out.println("initialized");
		
		Scanner in = new Scanner(new FileReader("input.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output"));

		int T = in.nextInt(), start, end;
		for(int i = 1; i <= T; i++)
		{
			start = in.nextInt(); end = in.nextInt();
			
			int ans = cntPairs(start, end);
			bw.write("Case #" + i + ": " + ans);
			bw.newLine();
		}
		
		bw.close();
		System.out.println("end");
	}

	private static int cntPairs(int start, int end) {
		int cnt = 0;
		boolean[] v = new boolean[end+1];
		for(int i = start; i <= end; i++)
			if(list[i] != null && !v[i])
			{
				v[i] = true;
				for(int k : list[i])
					if((k >= start && k <= end) && !v[k]){
						cnt++;
					}
			}
		return cnt;
	}

	private static void getPairs(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(n);
		int len = getLength(n);

		for (int i = 1; i < len; i++) {
			long num = n * ten[i];
			num = num + n / ten[len - i];
			num = num % ten[len];
			
			int res = (int)num;
			if(res < limit && !ans.contains(res) && len == getLength(res))
				ans.add(res);
		}

		if (ans.size() > 1)
			for (int k : ans)
				list[k] = ans;
	}
	
	public static int getLength(int n){
		return (int) (Math.log10(n) + 1e-6) + 1;
	}
	
	private static void initializeList() {
		int start = 1, end = 2000001;
		limit = end;
		list = new ArrayList[end];
		for (int i = start; i < end; i++)
			if (list[i] == null)
				getPairs(i);
	}

	private static void initializeTens() {
		ten = new long[8];
		ten[1] = 10;
		for (int i = 2; i < ten.length; i++)
			ten[i] = 10 * ten[i - 1];
	}
}
