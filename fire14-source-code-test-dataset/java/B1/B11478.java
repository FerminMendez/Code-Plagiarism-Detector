package qualification.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {

	public static void main(String[] args) {
		int totalCase = 0;
		int a = 0;
		int b = 0;
		FileInputStream is = null;
		try {
			is = new FileInputStream(args[0]);
			Scanner scan = new Scanner(is);
			totalCase = scan.nextInt();
			for (int i = 0; i < totalCase; i++) {
				a = scan.nextInt();
				b = scan.nextInt();
				solve(i, a, b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void solve(int caseNo, int a, int b) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = a; i <= b; i++) {
			String num = Integer.toString(i);	
			if (num.matches("^["+num.substring(0,1)+"]+$")) {
				//System.out.println(num);
				continue;
			}
			if (num.matches("^[1-9][0]+$")) {
				//System.out.println(num);
				continue;
			}
			s.add(i);
		}
		
		int answer = 0;
		for(int n = a; !s.isEmpty() && n <= b; n++) {
			if (!s.contains(n)) {
				continue;
			}
			String ns = Integer.toString(n, 10);
			int length = ns.length();
			Set<Integer> dup = new HashSet<Integer>();
			for (int j = 1; j < length; j++) {
				String ms = ns.substring(length-j) + ns.substring(0, length-j);
				//System.out.println(ns+":"+ms);
				int m = Integer.parseInt(ms);
				if (!s.contains(m)) {
					continue;
				}
				if (m < a || b < m || n >= m) {
					continue;
				}
				s.remove(m);
				if (!dup.contains(m)) {
					dup.add(m);
				}
				answer++;
			}
			int size = dup.size();
			if (size > 1) {
				answer = answer + size * (size - 1) / 2;
			}
			s.remove(n);
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Case #");
		sb.append(caseNo+1);
		sb.append(": ");
		sb.append(answer);
		System.out.println(sb.toString());
		
	}
}
