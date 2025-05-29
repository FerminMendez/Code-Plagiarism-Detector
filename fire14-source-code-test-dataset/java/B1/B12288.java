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
			int a = sc.nextInt();
			int b = sc.nextInt();
			int res = 0;
			for(int t = a; t <= b; t++) {
				String oppa = t + "";
				int len = (t + "").length();
				for (int u = 0; u + 1 < len; u++) {
					if(oppa.charAt(u + 1) != '0') {
						int v = Integer.parseInt(oppa.substring(u + 1, len) + oppa.substring(0, u + 1));
						if (t == v)
							break;
						if (a <= v && v <= b) {
							res++;
						}
					}
				}
			}
			pw.print("Case #" + (i + 1) + ": " + (res / 2));
			pw.println();
		}
		pw.close();
	}
}
