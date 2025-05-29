package dance;

import java.util.*;

public class dance {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for(int l=0;l<T;l++){
			int n = input.nextInt();
			int s = input.nextInt();
			int p = input.nextInt();
			int t[] = new int[n];
			int score[][] = new int[n][3];
			int max[] = new int[n];
			boolean flag = false;
			int ans = 0;
			for(int i=0;i<n;i++){
				t[i] = input.nextInt();
				if(t[i]%3==0){
					score[i][0] = t[i]/3;
					score[i][1] = t[i]/3;
					score[i][2] = t[i]/3;
					max[i] = t[i]/3;
					flag = true;
				}
				else if(t[i]%3==1){
					score[i][0] = t[i]/3;
					score[i][1] = t[i]/3;
					score[i][1] = t[i]/3 + 1;
					max[i] = t[i]/3 + 1;
					flag = false;
				}
				else{
					score[i][0] = t[i]/3;
					score[i][1] = t[i]/3 + 1;
					score[i][2] = t[i]/3 + 1;
					max[i] = t[i]/3 + 1;
					flag = true;
				}
				if(max[i]>=p){
					//System.out.println("max  for "+t[i]+" is "+max[i]);
					ans++;
				}
				else if(flag && p-max[i] == 1 && s>0){
					if(!(t[i]%3==0 && t[i]/3==0)){
						ans++;
						s--;
					}
				}
			}
			System.out.println("Case #"+(l+1)+": "+ans);
		}
	}

}
