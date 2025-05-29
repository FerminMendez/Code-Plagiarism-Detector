import java.util.*;
import java.io.*;

public class q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("C:/Users/Raja/workspace/GCJ/src/in.txt");
		
		
		int N,S,p;
		int[] sums;
		int norm,surp,ans;
		
		try{
			Scanner s = new Scanner(file);
			int num = Integer.parseInt(s.nextLine());
			for (int i = 0;i<num;i++){
				norm = 0;
				surp = 0;
				N = s.nextInt();
				S = s.nextInt();
				p = s.nextInt();
				sums = new int[N];
				for (int j = 0; j < N; j++){
					sums[j] = s.nextInt();
				}
				Arrays.sort(sums);
				for (int j = 0; j < N; j++){
					if (sums[j] >= 3*p-2)
						norm++;
					else if (sums[j] >= 3*p-4 && sums[j] > 1)
						surp++;
				}
				if (surp > S)
					ans = norm + S;
				else
					ans = norm + surp;
				
				System.out.println("Case #"+(i+1)+": "+ans);
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}

}
