import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		for (int count = 1; count <= size; count++){
			
			int lowB = s.nextInt();
			int highB = s.nextInt();
			int pairCount = 0;
			int bits = (lowB+"").length();
			int mod = (int)Math.pow(10, (bits-1));
			Set<Integer> seen = new HashSet<Integer>();
			//System.out.println("(" + lowB + ", " + highB + "), " + "bits = " + bits + ", mod = " + mod);
			for (int i = lowB; i <= highB; i++){
				 
				int num1 = i;
				int num2 = i;
				seen.clear();
				for (int j = 1; j < bits; j++){
					int div = num2 / mod;
					int modular = num2 % mod;
					num2 = modular * 10 + div;
					
					if (num2 < lowB || num2 <= num1 || num2 > highB || seen.contains(num2)) continue;
					//System.out.println("(" + num1 + ", " + num2 + ")");
					pairCount++;
					seen.add(num2);
				}
			}
		System.out.println("Case #" + count+ ": " + pairCount);	
		}
		
		
		
	}

}
