package ch7.rec;

import java.util.HashSet;
import java.util.Scanner;

public class Recycled {
	
	static HashSet p = new HashSet();
	
	int count = 0;
	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);		
		int no = sc.nextInt();
		
		for(int i = 1; i <= no; i++) {
			
			p.clear();
			int low = sc.nextInt();
			int high = sc.nextInt();
			
			for(int l = low; l <= high; l++) {
				recycle(low, high, l);
			}
			System.out.println(p.size());
			
		}		
	}
	
	public static void recycle(int low, int high, int no) {
		
		String s = Integer.toString(no);
		for(int i = 0 ; i < s.length(); i++) {			
			String rec = s.substring(i) + s.substring(0,i);
			int r = Integer.parseInt(rec);
			if(r != no && r >= low && r <= high) {		
				int min = Math.min(r, no);
				int max = Math.max(r, no);
				String a = Integer.toString(min)+""+Integer.toString(max);
				if(!(p.contains(a))) {
					p.add(a);
				}
				
			}
		}
		
	}
}