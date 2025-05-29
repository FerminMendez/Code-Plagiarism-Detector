import java.io.*;
import java.util.*;
import java.math.*;

public class C {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input.txt"));
		PrintWriter output = new PrintWriter("output.txt");
		int T = input.nextInt();
		for (int z = 1; z <= T; z++) {
			//SOLVE CASE
			int N = input.nextInt();
			int M = input.nextInt();
			int count = 0;
			for (int i = N; i < M; i++) for (int j = i+1; j <= M; j++) {
				String sN = Integer.toString(i);
				sN += sN;
				if (isRecycled(sN, j))
					count++;
			}
			
			
			//PRINT CASE OUTPUT
			System.out.println("Case #" + z + ": " + count);
			output.println("Case #" + z + ": " + count);
		}
		output.close();
	}
	
	public static boolean isRecycled(String sN, int M) {
		String sM = Integer.toString(M);
		if (sN.contains(sM))
			return true;
		return false;
	}
}
