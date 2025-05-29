import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingWithTheGooglers {

	static int surprise;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("small-B.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("small-B.out"));
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= n; i++){
			String [] nums = in.readLine().split(" ");
			
			int m = Integer.parseInt(nums[0]);
			surprise =  Integer.parseInt(nums[1]);
			int best =  Integer.parseInt(nums[2]);
			
			int total = 0;
			
			for(int j = 0; j < m; j++)
				if(check(Integer.parseInt(nums[j + 3]), best))
					total++;
			
			out.write("Case #" + i + ": " + total);
			if(i < n)
				out.write("\n");
		}
		in.close();
		out.close();
	}
	
	static boolean check(int score, int max){
		
		int third = score / 3;
		int rem = score % 3;
		
		if(third >= max)
			return true;
		
		if(third == max - 2)
			if(rem == 2){
				if(surprise > 0){
					surprise --;
					return true;
				}
				return false;
			}
			else
				return false;
		
		if(third == max - 1)
			if(rem > 0)
				return true;
			else if(surprise > 0 && third > 0){
				surprise --;
				return true;
			}
		
		return false;
	}

}
