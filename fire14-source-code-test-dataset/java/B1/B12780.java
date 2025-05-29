package gcj2012.Pre;

import java.util.*;

public class C {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] f){
				
		long numCases = Long.parseLong(sc.nextLine());
		for(long kase = 0 ; kase < numCases ; kase++){
			String[] ss = sc.nextLine().split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			HashSet<Pair> hs = new HashSet<Pair>();
			
			for(int i = a ; i <= b ; i++){
				int first = i;	
				String fs = ""+first;
				int len = ("" + a).length();
				for(int j = 1 ; j < len ; j++){
					int second = Integer.parseInt(fs.substring(j) + fs.substring(0, j));
					if(a <= second && second <= b && (""+second).length() == len && first != second){
						hs.add(new Pair(first, second));
					}
				}
			}
			
			System.out.println("Case #" + (kase+1) + ": " + hs.size());
		}
	}
	/**
	 * 
4
1 9
10 40
100 500
1111 2222
Case #1: 0
Case #2: 3
Case #3: 156
Case #4: 287


	 */
	
	public static class Pair{
		public int first, second;
		public Pair(int f, int s){
			if(f < s){
				this.first = f;
				this.second = s;
			}else{
				this.first = s;
				this.second = f;
			}
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + first;
			result = prime * result + second;
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
			Pair other = (Pair) obj;
			if (first != other.first)
				return false;
			if (second != other.second)
				return false;
			return true;
		}
		
		
	}
}
