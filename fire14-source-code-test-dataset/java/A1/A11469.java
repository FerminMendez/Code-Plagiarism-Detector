import java.util.Scanner;


public class DancingWithGooglers {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		//Read in the T int -- Test Cases
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			int num = 0;
			//START OF CODE
			int N = sc.nextInt(); //Num of googlers
			int S = sc.nextInt(); //Surprising Triplets
			int p = sc.nextInt();
			int ti [] = new int[N];
			for (int n = 0; n < N; n++) {
				ti[n] = sc.nextInt();
			}
			
			
			for (int i = 0; i < ti.length; i++) {
				//Do not care if scores are above p
				//Only lower than p and if need be adjusted
				if(ti[i] == 0 && p == 0){
					num++;
				} else if(ti[i] == 0){
					
				} else if(ti[i] / 3 >= p || (ti[i] / 3 == p-1 && ti[i] % 3 != 0)){
					num++;
				} else if(S !=0 && ((ti[i] / 3 == p-2 && ti[i] % 3 == 2 ) || (ti[i] / 3 == p-1))){
					num++;
					S--;
				}
			}
			//END OF CODE
			//OUTPUT
			System.out.format("Case #%d: %d\n", t, num);
		}
	}
}
