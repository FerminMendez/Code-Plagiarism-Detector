import java.io.*;
import java.util.*;

public class ProblemC {
	public static void main(String[] args) {
		try {
			// Create file
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			// Close the output stream
			Scanner in = new Scanner(System.in);
			int count = in.nextInt();
			for (int i=1; i<=count; i++){
				int A = in.nextInt();
				int B = in.nextInt();
				int ret = 0;
				for (int j=A; j<B; j++){
					for (int k=j+1; k<=B; k++){
						if (areRecycledPair(j,k)) ret++;
					}
				}
				String s = "Case #" + i + ": " + ret + "\n";
				out.write(s);
			}
			
			
			
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static boolean areRecycledPair(int A, int B){
		String a = A + "";
		String b = B + "";
		for (int i=0; i<a.length(); i++){
			a = a.charAt(a.length()-1) + a.substring(0,a.length() - 1);
			if (a.equals(b)) return true;
		}
		return false;
	}
}

