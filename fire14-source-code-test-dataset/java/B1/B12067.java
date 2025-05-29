package com.ivantod.codejam2012;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Numbers {

	private void process() throws Exception {
		
		Scanner s=new Scanner(System.in);
		int numCases=s.nextInt();
		s.nextLine();

		for (int ca=1; ca<=numCases; ca++) {
			int A=s.nextInt();
			int B=s.nextInt();
			Set<String> pairs=new HashSet<String>();
			
			for (int i=A; i<=B; i++) {
				String num=Integer.toString(i);
				String flip=Integer.toString(i);
				for (int j=num.length(); j>1; j--) {
					flip=flip.charAt(flip.length()-1)+flip.substring(0,flip.length()-1);
					if (!flip.startsWith("0") && !num.equals(flip) &&
							!pairs.contains(num+"_"+flip) && !pairs.contains(flip+"_"+num) &&
							Integer.parseInt(flip) >= A && Integer.parseInt(flip) <= B) {
						pairs.add(num+"_"+flip);
					}
				}
				
			}
			
			System.out.println("Case #"+ca+": "+pairs.size());
		}
	}
	
	
	public static void main(String[] args) {
		Numbers b=new Numbers();
		try {
			b.process();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}