import java.util.*;
import java.io.*;

public class C{
	
	public static void main(String[] args) throws IOException{
		Scanner inp = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("c-small.out"));
		
		int numCases = inp.nextInt();
		
		for (int cas = 0; cas < numCases; cas++){
			pw.print("Case #" + (cas+1) + ": ");
			
			/* case input */
			int A = inp.nextInt();
			int B = inp.nextInt();
			/* end case input */
			
			int ABak = A;
			int numDigits = 0;
			while (ABak > 0){
				ABak /= 10;
				numDigits++;
			}
			
			int ans = 0;
			
			/* main logic */
			for (int i = A; i < B; i++){
				
				Set<Integer> validMs = new HashSet<Integer>();
				for (int j = 1; j < numDigits; j++){
					int b = shift(i, j, numDigits);
					
					if (b <= B && b > i){
						validMs.add(new Integer(b));
					}
				}
				ans += validMs.size(); 
			}
			pw.println(ans);
		}
		pw.close();
	}
	
	public static int shift(int x, int k, int l){
		//int d = (int) Math.pow(10, k);
		int d = 1;
		for (int p = 1; p <= k; p++){
			d *= 10;
		}
		int tmp = x % d;
		int d2 = 1;
		for (int p = 1; p <= (l - k); p++){
			d2 *= 10;
		}
		tmp *= d2;
		return ((x/d) + tmp);
	}
}
