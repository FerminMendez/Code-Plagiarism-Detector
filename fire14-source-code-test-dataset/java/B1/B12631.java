

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecycledNumbers {
	
	public static final String INPUT = "C-small-attempt0.in";
	public static final String OUTPUT = "output";
	
	public static void main(String args[]) throws IOException{
		Scanner s = UtilGoogle.readFile(INPUT);
		PrintWriter w = UtilGoogle.writeFile(OUTPUT);
		int t = Integer.parseInt(s.nextLine());
		
		for(int i = 0; i < t; i++){
			Integer A = s.nextInt();
			Integer B = s.nextInt();
			Integer N = calculateRecycleds(A, B);
			
			w.println("Case #" + (i + 1) + ": " + N);
		}
		s.close();
		w.close();
	}
	
	public static Integer calculateRecycleds(Integer A, Integer B){
		Integer qtd = 0;
		
		for(Integer i = A; i < B; i++){
			for(Integer j = i + 1; j <= B; j++){
				if(isRecycled(i, j)) qtd++;
			}
		}
		return qtd;
	}
	
	public static boolean isRecycled(Integer n, Integer m){
		String first = String.valueOf(n);
		String second = String.valueOf(m);
		
		for(int i = 0; i < first.length() - 1; i++){
			String temp = second.substring(i + 1, first.length());
			temp = temp.concat(second.substring(0, i+1));
			if(temp.equals(first)) return true;
		}
		return false;
	}
}
