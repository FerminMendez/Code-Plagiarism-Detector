import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		int A, B, result,len,i,j,k;
		String that,original;
		String test="";
		ArrayList<String> poss = new ArrayList<String>();
		for(int zz = 1; zz <= T;zz++){
			result=0;
			A = in.nextInt();
			len = String.valueOf(A).length();
			poss = new ArrayList<String>();
			B = in.nextInt();
			in.nextLine();
			for (i = A; i <= B; i++){
				poss.add(String.valueOf(i));
			}
			for (i = 0; poss.size() > 0; i++){
				that = poss.get(0);
				poss.remove(0);
				original=that;
				for (k=0; k < len; k++){
					test=test+that.charAt(len-1);
					for (j=0; j < (len-1); j++){
						test=test+that.charAt(j);
					}
					if (that.charAt(len-1) != '0' && poss.contains(test)){
						result++;
						//System.out.format("(%s,%s)\n",original,test);
					}
					that=test;
					test="";
				}
			}
			System.out.format("Case #%d: %d\n",zz, result);
		}
	}
}
