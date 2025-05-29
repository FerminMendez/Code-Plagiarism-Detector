package Dancing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dancing {

	public static int[] result = new int[3];
	public static List<ArrayList<Integer[]>> lstScore = new ArrayList<ArrayList<Integer[]>>();
	public static ArrayList<Integer[]> lst;
	public static int numCase = 0;
	public static int max = -1;
	
	//Number of googler
	public static int N;
	public static int p;
	//Number of surprising
	public static int S;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		readFile();
	}
	
	public static void readFile() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("B-small-attempt1.in")));
		numCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < numCase; i++) {
			String[] arrStr = br.readLine().split(" ");
			N = Integer.valueOf(arrStr[0]);
			S = Integer.valueOf(arrStr[1]);
			p = Integer.valueOf(arrStr[2]);
			int n = arrStr.length;
			int[] total = new int[N];
			for (int j = 3; j < n; j++) {
				total[j - 3] = Integer.valueOf(arrStr[j]);				
			}
			lstScore = new ArrayList<ArrayList<Integer[]>>();
			for (int k = 0; k < total.length; k++) {
				result[0] = (int)Math.floor(total[k] / 3) - 1;	
				if (result[0] < 0) {
					result[0] = 0;
				}
				lst = new ArrayList<Integer[]>();				
				process(0, total[k]);
				lstScore.add(lst);
				//boolean[] mark = new boolean[]
			}
			if (S == 0) {
				ArrayList<Integer[]> lstInt = new ArrayList<Integer[]>();
				int numLstScore = lstScore.size();
				for (int j = 0; j < numLstScore; j++) {
					lstInt.add(lstScore.get(j).size() == 2 ? lstScore.get(j).get(1) : lstScore.get(j).get(0));
				}
				writeOut(i + 1, count(lstInt, p));
			} else {
				boolean[] mark = new boolean[N];
				Arrays.fill(mark, false);
				max = -1;
				select(0, mark, 0);
				writeOut(i + 1, max);
			}
		}
	}
	
	public static int select(int indexSurprise, boolean[] markSurprise, int surprise) {
		
		if (surprise == S) {
			ArrayList<Integer[]> lstInt = new ArrayList<Integer[]>();
			int numLstScore = lstScore.size();
			for (int j = 0; j < numLstScore; j++) {
				lstInt.add(markSurprise[j] ? lstScore.get(j).get(0) : lstScore.get(j).size() == 2 ? lstScore.get(j).get(1) : lstScore.get(j).get(0));
			}
			if (count(lstInt, p) > max) {
				max = count(lstInt, p);
			}
		} else {
			int n = lstScore.size();
			for (int i = indexSurprise; i < n; i++) {
				if (lstScore.get(i).size() > 1) {
					markSurprise[i] = true;
					select(i + 1, markSurprise, surprise + 1);
					markSurprise[i] = false;
				}
			}
		}
		
		return 0;
	}
	
	public static int count(ArrayList<Integer[]> lstCount, int atLeast) {
		
		int n = lstCount.size();
		int c = 0;
		for (int i = 0; i < n; i++) {
			Integer[] t = lstCount.get(i);
			for (int j = 0; j < 3; j++) {
				if (t[j] >= atLeast) {
					c++;
					break;
				}
			}
		}
		return c;
	}
	
	public static void writeOut(int order, int result) {
		
		System.out.format("Case #%d: %d\n", order, result);
	}
	
	public static void process(int n, int total) {
		
		if (n == 3) {
			if (result[0] + result[1] + result[2] == total) {
				if (result[1] - result[0] <= 2 && result[2] - result[1] <= 2
						&& result[2] - result[0] <= 2) {
					lst.add(new Integer[]{result[0], result[1], result[2]});
					//System.out.println(result[0] + "," + result[1] + "," + result[2]);
				}
			}
			return;
		} 
		int startNumber = 0;
		if (n > 0) {
			startNumber = result[n - 1];
		} else {
			startNumber = result[0];
		}
		for (int i = startNumber; i <= 10; i++) {
			if (i <= total) {
				result[n] = i;
				process(n + 1, total);
			}
		}
		
	}
}
