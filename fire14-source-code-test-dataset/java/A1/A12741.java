package gcj2012.Pre;

import java.util.Scanner;

public class B {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] a){
				
		long numCases = Long.parseLong(sc.nextLine());
		for(long kase = 0 ; kase < numCases ; kase++){
			String[] ss = sc.nextLine().split(" ");
			int n = Integer.parseInt(ss[0]);
			int s = Integer.parseInt(ss[1]);
			int p = Integer.parseInt(ss[2]);
			int[] scores= new int[n];
			for(int i = 0 ; i < n ; i++)
				scores[i] = Integer.parseInt(ss[3+i]);			
			
			int ret = 0;
			if(p == 0){
				ret = n;
			}else if(p == 1){
				for(Integer i : scores){
					if(i > 0){
						ret++;
					}
				}				
			}else{
				int canCntSurNotNeed = 0;
				int canCntSurNeed = 0;
				int canSurOnly = 0;
				int canCntOnly = 0;
				for(int i = 0 ; i < n ; i++){
					if(scores[i] > 28){
						canCntOnly++;
					}else if(scores[i] >= p+p-1+p-1){
						canCntSurNotNeed++;
					}else if(scores[i] >= p+p-2+p-2){	
						canCntSurNeed++;
					}else if(scores[i] >= 2){
						canSurOnly++;
					}
				}
				if(s <= canCntSurNeed){
					ret = canCntOnly + canCntSurNotNeed + s;
				}else{
					ret = canCntOnly + canCntSurNotNeed + canCntSurNeed;
				}
			}
			
			System.out.println("Case #" + (kase+1) + ": " + ret);
		}
	}
		
}
