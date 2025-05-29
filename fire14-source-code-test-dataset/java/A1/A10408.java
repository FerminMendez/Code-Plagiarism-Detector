import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		int N, S, p, sure, av, note, result;
		
		for(int zz = 1; zz <= T;zz++){
			result=0;
			N = in.nextInt();
			S = in.nextInt();
			p =  in.nextInt();
			sure = p + (p-1) + (p-1);
			if (sure < p)
				sure =p;
			av = p + (p-2) + (p-2);
			if (av < p)
				av = p;
			for (int i = 1; i <= N; i++){
				note = in.nextInt();
				if (note >= sure){
					result++;
				} else if (( note < sure ) && (note >= av)){
					if (S > 0){
						S--;
						result++;
					}
				}
			}
			in.nextLine();
			System.out.format("Case #%d: %d\n",zz, result);
		}
	}
}
