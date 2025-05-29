import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecNumbers {
	
	static Scanner in;
	static PrintWriter out;
	
	
	public static boolean isRecycled(int n, int m){
		boolean recycled = false;
		String first = Integer.toString(n);
		String second = Integer.toString(m);
		int len = first.length();
		
		for(int i = 0; i < len; i++){
			if(len > 2){
				first = "" + first.charAt(len - 1) + first.substring(0,len - 1);	
			} else if (len == 2){
				first = "" + first.charAt(1) + first.charAt(0);
			} else {
				return false;
			}
			
			if(first.equals(second)){
				recycled = true;
			}
		}
		
		return recycled;
	}
	
	public static void main(String[] args) throws Exception {
		in = new Scanner(new File("C-small-attempt0.in"));
		out = new PrintWriter(new File("C-small.out"));

		//Read file
		int A;
		int B;
		int T = in.nextInt();
		//for each case do
		for (int i = 1; i <= T; i++){
			A = in.nextInt();
			B = in.nextInt();
			int count = 0;
			out.print("Case #" + i + ": ");
			for(int j = A; j <= B; j++){
				for(int k = j + 1; k <= B; k++){
					if(isRecycled(j, k) && j > 10 && k > 10){
						count++;
					}
				}
			}
			out.print(count);
			out.println();
		}

		out.close();	
	}
}