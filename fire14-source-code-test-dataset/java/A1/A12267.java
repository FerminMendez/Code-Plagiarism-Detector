import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		int tn = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < tn; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int cnt = 0;
			int cnts = 0;
			for(int j = 0; j < n; j++) {
				int oppa = sc.nextInt();
				if(oppa >= Math.max(p - 1, 0) * 2 + p)
					cnt++;
				else if(oppa >= Math.max(p - 2, 0) * 2 + p)
					cnts++;
			}
			
			pw.print("Case #" + (i + 1) + ": " + (cnt + Math.min(s, cnts)));
			pw.println();
		}
		pw.close();
	}
}
