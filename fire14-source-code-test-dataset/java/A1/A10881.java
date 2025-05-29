import java.io.*;

public class ProblemB {
	static int[] cycles;
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =  Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++){
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int S = Integer.parseInt(input[1]);
			int p = Integer.parseInt(input[2]);
			int max = Math.max(3*p - 2, p); // p, p-1, p-1
			int min = Math.max(3*p - 4, p); // p, p-1, p-2 OR p, p-2, p-2
			int count = 0;
			for(int j = 0; j < N; j++){
				int sum = Integer.parseInt(input[j+3]);
				if(sum >= max) count++;
				else if(sum >= min && S > 0){
					//System.out.println(sum);
					count++; 
					S--;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);
			
		}
	}
}
