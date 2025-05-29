import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Prob {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("C-small-practice.in"));
		FileWriter fw = new FileWriter("C-small-practice.out");
		int t = sc.nextInt();
		//Mapping m = new Mapping();
		for (int i = 1; i <= t; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			
			
			
			
			fw.write("Case #"+i+": "+Hehe.n(A, B)+"\n");
			
		}
		fw.close();
	}
}
