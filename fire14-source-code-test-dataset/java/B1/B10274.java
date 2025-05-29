

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class C {

	static int countBiggerRotated(int n, int B) {
		int count = 0;
		LinkedList<Integer> l = new LinkedList<Integer>();
		int t = n;
		while(t > 0) {
			l.addFirst(t%10);
			t/=10;
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < l.size(); i++) {
			int m = 0;
			for (int j = i; j < l.size(); j++) {
				m = 10*m + l.get(j);
			}
			for (int j = 0; j < i; j++) {
				m = 10*m + l.get(j);
			}
			if(m > n && m <= B && !hs.contains(m)) {
				++count;
				hs.add(m);
//					System.out.println("(" + n + "," + m + ")");
			}
		}
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int count = 0;
			for (int j = A; j < B; j++) {
				count += countBiggerRotated(j, B);
			}
			System.out.println("Case #" + i + ": " + count);
		}
	}

}
