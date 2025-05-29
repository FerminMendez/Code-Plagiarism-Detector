import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class P3 {
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.nextLine()); 
		for (int i = 0; i < t; i++) { 
			String[] x = scan.nextLine().split(" "); 
			int a = Integer.parseInt(x[0]); 
			int b = Integer.parseInt(x[1]);
			
			long count = 0;
			for (int j = a; j <= b; j++) { 
				count += find(j, b);
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
		
	}
	
	public static long find(int x, int limit) { 
		long result = 0;
		String s = String.valueOf(x);
		Set<Integer> set  = new HashSet<Integer>();
		for (int i = 1; i < s.length() ; i++) { 
			if (s.charAt(i) != '0') { 
				String first = s.substring(0, i); 
				String second = s.substring(i, s.length());
				
				int number = Integer.parseInt(second + first);
				if (!set.contains(number) && number > x && number <= limit) { 
					result += 1;
					set.add(number);
				}
			}
		}
		return result;
	}
}
