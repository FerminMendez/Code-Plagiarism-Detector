package year2012.qualification.c;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String[] args) throws Exception{
		//GCJ共通
		String filename = "src/year2012/qualification/c/C-small-attempt0";
		PrintWriter out = new PrintWriter(new File(filename + ".out"));
		Scanner scan = new Scanner(new File(filename + ".in"));
		
		final int T = scan.nextInt();
		for(int i=0;i<T;i++){
			int ans=0;
			int A = scan.nextInt();
			int B = scan.nextInt();
			
			for(int n=A;n<B;n++){
				int m_memo = -1;
				
				char[] na = String.valueOf(n).toCharArray();
				//例えばnが123のとき、231,312が[A,B)の中にあるか調べる
				//この例だとk=2回ループ
				for(int k=1;k<na.length;k++){
					char[] ma = rotate(na, k);
					int m = Integer.parseInt(String.valueOf(ma));
					if(A <=n
						&& n < m
						&& m <= B
						&& m != m_memo){
						
						m_memo = m;
						ans++;
					}
				}
				
			}
			//出力
			out.printf("Case #%d: %s\n", i+1, ans);
		}
		out.flush();
	}
	
	
	/**
	 * 配列をn個左にずらした新しい配列を返します。
	 * @param in
	 * @param n
	 * @return
	 */
	private static char[] rotate(final char[] in, int n){
		if(n>=in.length){
			throw new IllegalArgumentException("n= " + n + ", in.length = "
					+ in.length + "となっています。n<in.lengthにしてください。");
		}
		char[] out = new char[in.length];
		
		//1,2,3,4を2個左にずらす場合、まず左側の2個を退避する
		char[] tmp = new char[n];
		for(int i=0;i<n;i++){
			tmp[i] = in[i];
		}
		//次にin[n]からin[in.length]までをout[0]からout[in.length - 2]までにコピー
		for(int i=0;i<in.length-n;i++){
			out[i] = in[i+n];
		}
		//最後にout[length-n,length]にtmp[0,n]から値をもどす
		for(int i=in.length-n;i<in.length;i++){
			out[i] = tmp[i-in.length+n];
		}
		return out;
	}
}
