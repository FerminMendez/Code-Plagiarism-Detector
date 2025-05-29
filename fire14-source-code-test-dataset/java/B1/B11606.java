import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class GoogleRecycler {
	public static void main(String args[]) throws IOException{
		Scanner scan = new Scanner(System.in);
		PrintWriter print = new PrintWriter(new FileWriter("GoogleRecycler.out"));
		Integer cases = Integer.parseInt(scan.nextLine());
		for(int i=0; i<cases; i++){
			long A = scan.nextLong();
			long B = scan.nextLong();
//			System.out.println("A: " + A + " B: " + B);
			int total = 0;
			
			for(long n = A; n < B; n++){
				for(long m = n+1; m <= B; m++){
					//System.out.println(n + ", " + m);
					if(check(n,m)){
						total++;
//						System.err.println(n + ", " + m );
					}
				}
			}
			print.println("Case #" + (i+1) + ": " + total);
			System.out.println("Case #" + (i+1) + ": " + total);
			
		}
		print.flush();
		print.close();
	}

	public static boolean check(long a, long b){
		String num1 = String.valueOf(a);
		String num2 = String.valueOf(b);
		
		if(num1.length() != num2.length()){
			System.err.println("ERROR!!!!!");
		}

		String part1 = "";
		String part2 = "";
		for(int i=0; i < num2.length(); i++ ){
			String sub = num2.substring(0,i);
			if(num1.contains(sub)){
				part1 = sub;
			}else{
				break;
			}
		}
		for(int i=part1.length(); i<= num1.length();i++){
			String sub = num2.substring(part1.length(), i);
			if(num1.contains(sub)){
				part2 = sub;
			}else{
				break;
			}
		}

		if(part1.length() + part2.length() != num1.length()){
			return false;
		}

		if(part2.concat(part1).equals(num1)){
			return true;
		}

		return false;
	}
}
