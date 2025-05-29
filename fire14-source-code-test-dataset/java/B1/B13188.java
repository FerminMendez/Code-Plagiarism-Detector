package proba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

	private static Set<String> list;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new FileInputStream("C-small-attempt0.in"));
		int cases = s.nextInt();
		s.nextLine();

		for (int i = 0; i < cases; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			Set<MN> set = new HashSet<MN>();
			if (s.hasNextLine())
				s.nextLine();
			
			
			for(int j=A;j<= B;j++) {
				String string = String.valueOf(j);
				char[] arr = string.toCharArray();
				for (int k = 1; k < arr.length; k++) {
					StringBuilder sb = new StringBuilder();
					String sub = string.substring(arr.length - k);
					String sub1 = string.substring(0,arr.length -k);
					sb.append(sub);
					sb.append(sub1);
					int num = Integer.valueOf(sb.toString());
					if (j <  num && num <= B) {
						MN mn = new MN(j,num);
						set.add(mn);
					}
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + set.size());

		}
	}

	private static class MN {
		int m;
		int n;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MN other = (MN) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}
		public MN(int m, int n) {
			super();
			this.m = m;
			this.n = n;
		}
		public int getM() {
			return m;
		}
		public void setM(int m) {
			this.m = m;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		
		
	}
}
