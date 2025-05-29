import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Prob3 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter output = new PrintWriter(new File("output3.txt"));
		String result = "";
		int tests = scan.nextInt();
		for(int t = 0; t < tests; t++){
			int A = scan.nextInt();
			int B = scan.nextInt();
			int count  = 0;
			for(int run = A; run <= B; run++){
				String m = new Integer(run).toString();
				for(int i = 0; i < m.length()-1; i++){
					int n = Integer.parseInt(m.substring(i+1) + m.substring(0, i+1));
					if(n <= B && n >= A){
						if(n == run);
						else{
							count++;
						}
					}
				}
			}
			System.out.print("Case #" + (t+1) + ": " + (count/2)+"\n");
			result += "Case #" + (t+1) + ": " + (count/2)+"\n";
		}
		output.write(result);
		output.close();
	}

}
