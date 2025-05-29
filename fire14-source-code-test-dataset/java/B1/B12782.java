import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProblemC {
	
	public static void main(String[] args){
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			
			String line = in.readLine();

			int numLines = Integer.parseInt(line);

			for(int i = 1; i <= numLines; i++){
				
				System.out.print("Case #" + i + ": ");
				
				line = in.readLine();
				
				String[] nums = line.split(" ");
				
				int A = Integer.parseInt(nums[0]);
				int B = Integer.parseInt(nums[1]);
				
				int size = nums[0].length();
				
				int count = 0;
				
				for(int n = A; n < B; n++){
					String nStr = String.valueOf(n);
					ArrayList<String> pairs = new ArrayList<String>();
					for(int k = 1; k < size; k++){
						String mStr = nStr.substring(k, size) + nStr.substring(0, k);
						int m = Integer.parseInt(mStr);
						if(m > n && m <= B){
							String nm = n + "," + m;
							if(!pairs.contains(nm)){
								pairs.add(nm);
								count++;
							}
						}
					}
				}
				
				System.out.println(count);
			}
		}catch(IOException e){
			
		}
	}
}