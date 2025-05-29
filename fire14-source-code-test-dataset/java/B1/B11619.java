import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Recycled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tests;
		try{
			BufferedReader stdin = new BufferedReader(new FileReader(args[0]));
			tests = Integer.parseInt(stdin.readLine());
			for(int i = 0; i < tests; i++){
				System.out.print("Case #"+(i+1) + ": ");
				solve(stdin.readLine());
				System.out.println();
			} 
		}catch(IOException e){
			e.printStackTrace();
		}
		System.exit(0);

	}
	
	private static void solve(String s){
		String [] nums = s.split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int total = 0;
		for(int m = a+1; m <= b; m++){
			for(int n = a; n < m; n++){
				total += canRecycle(n,m);
			}
		}
		System.out.print(total);
	}
	
	private static int canRecycle(int n, int m){
		int total = 0;
		String s = "" + n;
		int len = s.length();
		int[] digits = new int[len];
		boolean descending = true;
		for(int i = 0; i < len-1; i++)
			descending &= (digits[i]>digits[i+1]);
		if(!descending){
			String num = "" + n;
			String match = "" + m;
			num = num.substring(len-1).concat(num.substring(0, len-1));
			while(!num.equals(s)){
				if(num.equals(match))
					total += 1;
				num = num.substring(len-1).concat(num.substring(0, len-1));
			}
			
		}
		//System.out.println(total);
		return total;
	}
}
