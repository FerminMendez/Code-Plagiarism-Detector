import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			int dig=digi(A);
			int mdig=minDig(A);
			int mdig10=mdig*10;
			int curr=A;
			int count=0;
			//System.out.println(A+" "+B+" "+dig+" "+mdig+" "+mdig10+" "+curr);
			HashSet<Long> set = new HashSet<Long>(); 
			while(curr<=B) {
				int curr2=curr;
				for(int i=0;i<dig;i++) {
					int lastdig=curr2%10;
					curr2=curr2/10+lastdig*mdig;
					if(lastdig!=0&&curr<curr2&&curr2<=B) {
						long uniq=curr*200000001L+curr2;
						if(!set.contains(uniq)) {
							set.add(uniq);
							count++;
						}
					}
					//System.out.println(curr+ " "+curr2);
				}
				curr++;
				if(curr==mdig10) {
					mdig*=10;
					mdig10*=10;
					dig++;
				}
			}
			System.out.println("Case #"+(t+1)+": "+count);
		}
	}
	static int digi(int i) {
		int n=0;
		while(i>9) {
			i/=10;
			n++;
		}
		return n;
	}
	static int minDig(int i) {
		int n=1;
		while(i>9) {
			i/=10;
			n*=10;
		}
		return n;
	}
}
