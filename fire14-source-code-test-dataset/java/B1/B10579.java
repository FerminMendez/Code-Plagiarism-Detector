import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Recycled {

	public static void main(String[] args) throws IOException {
		ArrayList<Pair> al = new ArrayList<Pair>();
		int count = 0;
		for (int r = 0; r <= 2000000; r++) {
			if (r % 1000 == 0) {
				System.out.println(r);
			}
			String A = Integer.toString(r);
			for (int r1 = 1; r1 < A.length(); r1++) {
				String B = A.substring(r1) + A.substring(0, r1);
				if (!A.equals(B) && Integer.parseInt(A) > Integer.parseInt(B)) {
					al.add(new Pair(Integer.parseInt(A), Integer.parseInt(B)));
//					System.out.println((count++)+" "+A + " " + B);
				}
			}
		}

		Collections.sort(al);
		//remove duplicates
		Pair last=null;
		for (int r=0;r<al.size()-1;r++){
			if (al.get(r).equals(last)){al.remove(r);last=null;r--;}
			else last=al.get(r);
		}

		int[] ala = new int[al.size()];
		int[] alb = new int[al.size()];
		count = 0;
		for (Pair l : al) {
			alb[count] = l.B;
			ala[count] = l.A;
//			System.out.println(l.A+" "+l.B);
			count++;
			if (count % 1000 == 0) {
				System.out.println(count);
			}

		}

		Scanner sc = new Scanner(new File("C-small-attempt3.in"));
//		Scanner sc = new Scanner(new File("Ctest.in"));
		FileWriter fstream = new FileWriter("Cout.txt");
		BufferedWriter outp = new BufferedWriter(fstream);

		int tc = sc.nextInt();
		for (int r = 0; r < tc; r++) {
			count = 0;

			int A = sc.nextInt();
			int B = sc.nextInt();

			int indA = rank(A, ala);
			int indB = rank(B, ala);
//			System.out.println(A + " " + ala[indA]);
//			System.out.println(B + " " + ala[indB]);

			// System.out.println(A+" "+indA+" "+al.get(indA));
			// System.out.println(B+" "+indB+" "+al.get(indB));
			// System.out.println("--");
			for (int u = 0; u <=2000000; u++) {
				if (alb[u]>=A &&ala[u]<=B){
//					System.out.println(ala[u]+" "+alb[u]);
					count++;
				}
			}

			System.out.println("Case #" + (r + 1) + ": " + (count));
			outp.write("Case #" + (r + 1) + ": " + (count)+"\n");
			// outp.write("Case #" + (r + 1) + ": " + fin + "\n");
		}
		outp.flush();
		fstream.close();
	}

	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
//			 System.out.println(lo+" "+mid+" "+hi);
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			if ((mid>0 && mid <a.length-1)
					&&(key < a[mid + 1] && key > a[mid - 1])||key==a[mid])
				return mid;
			if (mid==0)return 0;
			if (mid==a.length-1)return a.length-1;
		}
		return -1;
//		return lo + (hi - lo) / 2;
	}

	static class Pair implements Comparable<Pair> {
		int A;
		int B;

		public Pair(int a, int b) {
			A = a;
			B = b;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.A < arg0.A)
				return -1;
			if (this.A == arg0.A)
				return 0;
			return 1;
		}
		
		@Override
		public int hashCode(){
			return A*10000000+B;
		}
		
		@Override
		public boolean equals(Object other){
			if (other==null)return false;
			if (other==this)return true;
			if (A==((Pair)other).A&&B==((Pair)other).B)return true;
			return false;
		}
	}

}
