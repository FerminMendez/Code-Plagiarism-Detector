import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class A {
	
	static int findRecycledNumbers(int a, int b) {
		int count = 0;
		boolean[] arr = new boolean[b+1];
		
		for (int i = a; i <= b; i++) {
			String num = Integer.toString(i);
			for (int k = 0; k < arr.length; k++) arr[k] = false;
			for (int j = 1; j < num.length(); j++) {
				String dNum = num.substring(j) + num.substring(0, j);
				int x = Integer.parseInt(dNum);
				if (x >= a && x <= b && !arr[x]) arr[x] = true;
				else continue;
				if (x >= a && x <= b && i < x) {
					System.out.println(a + " - " + b + ": " + i + " " + x);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String args[]) throws IOException {		
		Scanner sc = new Scanner(new File("input"));
		FileWriter fstream = new FileWriter("output");
		BufferedWriter out = new BufferedWriter(fstream);
	
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			out.write("Case #" + (i+1) + ": " + findRecycledNumbers(a, b) + "\n");
		}
		
		out.close();
	}
}
