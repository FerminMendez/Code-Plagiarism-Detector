import java.util.*;
import java.io.*;

public class dancers {
	public static int test(int[] n){
		int counter = 0;
		int counter2 = 0;
		for(int i = 3; i < n[0] + 3; i++){
			if(n[i] >= (n[2]*3 - 2)){
				counter++;
			} else if((n[i] < n[2]*3 - 2) && (n[i] >= n[2]*3 - 4)){
				if((n[2]*3-4 < 0) && n[i] == 0){
					continue;
				}
				counter2++;
			}
		}
		
		if(counter2 <= n[1]){
			counter += counter2;
		} else{
			counter += + n[1];
		}
		
		return counter;
	}
	public static void main(String[] args) throws IOException{
		Scanner reader = new Scanner(new File("dancers.in"));
		PrintWriter out = new PrintWriter(new File("dancers.out"));
		
		int n = reader.nextInt();
		int[][] set = new int[n][103];
		for(int i = 0; i < n; i++){
			set[i][0] = reader.nextInt();
			for(int j = 1; j < set[i][0] + 3; j++){
				set[i][j] = reader.nextInt();
			}
		}
		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			res[i] = test(set[i]);
			out.println("Case #" + (i+1) + ": " + res[i]);
		}
		
		out.close();
		System.exit(0);
	}
}