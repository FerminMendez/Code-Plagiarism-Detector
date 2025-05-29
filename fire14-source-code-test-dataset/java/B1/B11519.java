import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class RecycledNumbers {

	static int t, a, b;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("numbers.in"));
		t = reader.nextInt();
		for (int c = 1; c <= t; c++) {
			a = reader.nextInt();
			b = reader.nextInt();
			int cuenta = 0;
			for (int n = a; n < b; n++) {
				cuenta += eval(n);
			}
			System.out.println("Case #"+c+": "+cuenta);
		}
	}
	
	static int eval(int n){
		String s = ""+n;
		int l = s.length();
		int cuenta = 0;
		int nn;
		ArrayList<Integer> nns = new ArrayList<Integer>();
		for (int i = 1; i < l; i++) {
			s = rotar(s);
			if (s.charAt(0)=='0') continue;
			nn = Integer.parseInt(s);
			if (nn>n && nn<=b && !nns.contains(nn)){
				cuenta++;
				nns.add(nn);
			}
		}
		return cuenta;
	}
	
	static String rotar(String s){
		return s.substring(1) + s.charAt(0); 
	}
}
