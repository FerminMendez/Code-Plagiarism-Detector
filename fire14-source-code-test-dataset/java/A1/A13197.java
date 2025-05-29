import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("B-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B.out"));
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int surpMin = p*3 - 4;
			int normMin = p*3 - 2;
			int ans = 0;
			for(int j = 0; j < N; j++){
				int sum = scan.nextInt();
				if(p==0){
					ans++;
				}
				else if(sum >= normMin){
					ans++;
				}
				else if((sum >= surpMin) && (p != 1 || sum > 0) && S > 0){
					ans++;
					S--;
				}
			}
			out.write("Case #" + i + ": "+ ans + "\n");
		}
		out.close();
	}
}
