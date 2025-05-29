import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers 
{
	public static void main(String[] args) {
		
		Scanner mark = new Scanner(System.in);
		
		int t = mark.nextInt();
		int A, B, counter;
		mark.nextLine();
		
		for (int i = 0; i < t; i++) 
		{
			
			A = mark.nextInt();
			B = mark.nextInt();
			counter = 0;
			
			mark.nextLine();
						
			
			// This is for N
			for (int n = A; n < B; n++) 
			{
				
				HashSet<Integer> ans = new HashSet<Integer>();

				String strval = String.valueOf(n).trim();
				int count = strval.length();
				
				for (int j = 1; j < count; j++) 
				{
					String beg = strval.substring(0, j);
					String end = strval.substring(j);
//					System.out.println(beg+end+" "+end+beg);
					
					int m = Integer.parseInt( end.concat(beg) );
					
					if( (m > n) && (m <= B))
						ans.add(m);
					
				}			
				
				counter += ans.size();
			}
	
			System.out.printf("Case #%d: %d\n",i+1,counter);
			
		}
	}
}
