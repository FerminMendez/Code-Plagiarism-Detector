import java.io.File;
import java.util.*;

public class ProblemC {

	
	public static void main(String[] args) throws Exception  {

		Scanner sc = new Scanner(new File("C:\\C-small-attempt0.in"));
		//Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine().trim());
		for(int i = 0; i < cases; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #" + (i + 1) + ": " + solve(a,b));
		}
	}

	
	private static int solve(int a, int b) {
		int [][]vis = new int[b + 1][b + 1];
		int count = 0;
		
		for(int i = a; i <= b; i++){
			int []arr = getPair(i);
			
			for(int j : arr){
				if((j >= a) && (j <= b) && (i != j) && vis[i][j] != 1){
					vis[i][j] = 1;
					vis[j][i] = 1;
					//System.out.println(i + " " + j);
					count++;
				}
			}
		}
		return count;
	}


	private static int[] getPair(int i) {
		int []ret = new int[]{};
		
		String str = String.valueOf(i);
		if(str.endsWith("0")){
		}
		else if(i < 10){
		} else if (i < 100){
			int a1 = i %10;
			int a2 = i/10;
			int a3 = a1*10 + a2;
			ret = new int[]{a3};
		} else if (i <= 1000){
			int a1 = i % 10;
			int a2 = ((i - a1)/10) % 10;
			int a3 = i/100;
			
			int a4 = a1*100 + a3*10 + a2;
			int a5 = a2*100 + a1*10 + a3;
			
			ret = new int[]{a4,a5};
		}
		return ret;
	}
}
