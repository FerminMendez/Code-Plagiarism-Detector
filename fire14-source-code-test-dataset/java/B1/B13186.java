import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Recycled_numbers {

	 public static boolean isSubString(String text1, String text2) {
	        return isSubString(text1, text2, false);
	    }

	    private static boolean isSubString(String text1, String text2, boolean afterMatch) {
	        if (text1.length()==0) {
	            return true;
	        }
	        if (text2.length()==0) {
	            return false;
	        }
	        return (text1.charAt(0)==text2.charAt(0) && isSubString(text1.substring(1), text2.substring(1), true)) ||
	               (!afterMatch && isSubString(text1, text2.substring(1), false));
	    }
	    
	public static boolean isRecycledPair(int a, int b){
		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);
		if((s1.length() == s2.length()) && s1.length()>0){
			String s1s1 = s1+s1;
			return isSubString(s2,s1s1);
		}
		
		return false;
	}
	
	public static int recycle(int a, int b){
		int n;
		int m;
		int count=0;
		for(n=a;n<b;n++){
			for(m=n+1;m<=b;m++){
				if(isRecycledPair(n,m))
					count++;
			}
		}
		return count;
	}
	
	public static void solve() throws IOException {
		Scanner sc = new Scanner(new FileReader("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("C-small-attempt0.out"));
		
		int nbCases = sc.nextInt();
		
		for (int caseNum = 0; caseNum < nbCases; caseNum++) {
			pw.print("Case #" + (caseNum + 1) + ": ");
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int res = recycle(a,b);
			
			pw.println(res);
		}
		
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static void main(String args[]) throws IOException{
		solve();
	}

}
