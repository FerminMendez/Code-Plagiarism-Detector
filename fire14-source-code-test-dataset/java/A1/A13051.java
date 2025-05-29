import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {
	HashMap<Integer, HashSet<ArrayList<Integer>>> pre = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
	{
		for(int a = 0; a <= 10; a++)
			for(int b = 0; b <= a; b++)
				for(int c = 0; c <= b; c++){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(a);
					tmp.add(b);
					tmp.add(c);
					Integer sum = a + b + c;
					if(a - c > 2) continue;
					if(pre.get(sum) == null)
						pre .put(sum, new HashSet<ArrayList<Integer>>());
					pre.get(sum).add(tmp);
				}
	}
	/*
	 * 18 = 6 6 6, 5 6 7 
	 * 19 = 5 7 7, 6 6 7 
	 * 20 = 6 7 7 
	 * 21 = 7 7 7, 6 7 8 
	 * 28 = 8 10 10
	 */
	private boolean isSurprize(ArrayList<Integer> a){
		return (a.get(0) - a.get(2)) == 2;
	}
	private boolean canBeSurprize(int a) {
		for(ArrayList<Integer> t: pre.get(a))
			if(isSurprize(t)) return true;
		return false;
	}
	private int getBestScore(int a, boolean surprize){
		int best = -1;
		for(ArrayList<Integer> t: pre.get(a))
		{
			if(surprize != isSurprize(t))
				continue;
			if(best < t.get(0))
				best = t.get(0);
		}
		return best;
	}
	private void printState(int a){
		for(ArrayList<Integer> t: pre.get(a)){
			for(Integer i: t)
				System.out.print(i + " ");
			System.out.print(", ");
		}
		System.out.println();
	}
	private void run() throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("B-small-attempt0.in"));
		System.setOut(new PrintStream(new FileOutputStream("b.out")));
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
//				printState(arr[j]);
			}
			Arrays.sort(arr);
			int bes[] = new int[n];
			for(int j = n - 1; j >= 0; j--){
				int bestS = getBestScore(arr[j], true);
				int bestNS = getBestScore(arr[j], false);
				if(bestNS >= p){
					bes[j] = bestNS;
					continue;
				}
				if(s > 0 && bestS >= p)
				{
					bes[j] = bestS;
					s--;
					continue;
				}
				
				bes[j] = bestNS;
			}
			int res = 0;
			for(int j = 0; j < bes.length; j++)
				if(bes[j] >= p) res++;

			System.out.println("Case #" + (i + 1) + ": " + res);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		B b = new B();
		b.run();
	}
}
