package c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import b.Dancing;

public class Recycled {
	public static void main(String[] args) throws IOException {
//		System.out.println(new Recycled().solve(1111, 2222));
		BufferedReader br = new BufferedReader(new FileReader("src/c/C-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/c/out"));
		
		int row = Integer.parseInt(br.readLine());
		System.out.println("ROW : " + row);
		
		Recycled rec = new Recycled();
		
		for(int i=0; i<row; i++) {
			String[] line = br.readLine().split(" ");
			
			String res = "Case #" + (i+1) + ": " + rec.solve(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			bw.write(res + "\n");
			System.out.println(res);
		}
		
		bw.close();
		br.close();
	}

	public int solve(int a, int b) {
		int cnt = 0;
		for(int i=a; i<=b; i++) {
			for(int j=i; j<=b; j++) {
				if (recycled(i,j)) cnt++;
			}
		}
		return cnt;
	}

	private boolean recycled(int in, int im) {
		if (im<10 || in<10 || im == in) return false;
		
		String n = String.valueOf(in);
		String m = String.valueOf(im); 
		
		if (n.length() < m.length()) {
			n = "00000000000".substring(0, m.length() - n.length()) + n;
		}

		if (checkDigits(n, m)) {
//			System.out.print(n + "\t" + m + "\t");
			if (checkRotate(n, m)) {
//				System.out.println(n + "\t" + m);
//				System.out.println("X");
				return true;
			}
			else {
//				System.out.println();
				return false;
			}
		}
		
		return false;
	}
	
	private boolean checkRotate(String n, String m) {
		int len = n.length();
		for(int i=len-1; i>0; i--) {
			boolean correct = true;
			for(int j=0;j<len;j++) {
				int ni = (i+j >= len) ? (i+j-len) : i+j;
//				System.out.print("\n- " + ni + " " + j);
				if (n.charAt(ni) != m.charAt(j)) {
					correct = false;
					break;
				}
			}
			if (correct == true) return true;
		}
		return false;
	}

	int d[] = new int[10];
	
	private boolean checkDigits(String n, String m) {
		clearD();
		
		for(int i=0; i<n.length(); i++) {
			d[n.charAt(i)-'0']++;
			d[m.charAt(i)-'0']--;
		}
		
		for(int i=0; i<10; i++) {
			if (d[i] != 0) return false;
		}
		
		return true;
	}

	private void clearD() {
		for(int i=0; i<10; i++) {
			d[i] = 0;
		}
	}
}
