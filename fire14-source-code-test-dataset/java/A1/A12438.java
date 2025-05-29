import java.util.Scanner;


public class dance {
	public static void main(String... args){
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		int[] counts = new int[cases];
		for(int i = 0;i<cases;i++){
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int sUsed = 0; // special cases used
			
			int[] nums = new int[n];
			int[][] scores = new int[n][3];
			for(int k=0;k<n;k++){
				nums[k] = in.nextInt();
				int mod = nums[k] % 3;
				int div = nums[k] /3;
				if (mod == 2 && sUsed < s && div + 2 == p){
					scores[k][0] = div + 2;
					scores[k][1] = div;
					scores[k][2] = div;
					sUsed +=1;
				} else if(mod == 0 && div + 1 == p && sUsed <s && div > 0){
					scores[k][0] = div+ 1;
					scores[k][1] = div;
					scores[k][2] = div-1;
					sUsed += 1;
				}else if (mod == 2){
					scores[k][0] = div + 1;
					scores[k][1] = div + 1;
					scores[k][2] = div;
				} else {
					scores[k][0] = div + mod;
					scores[k][1] = div;
					scores[k][2] = div;
				}
			}
			//count 
			int count = 0;
			for(int k = 0;k<n;k++){
				if(scores[k][0] >= p){
					count++;
				}
			}
			counts[i] = count;
			
		}
		for(int i = 0;i<cases;i++){
			System.out.printf("Case #%d: %d\n",i+1,counts[i]);
		}
		
	}
}
