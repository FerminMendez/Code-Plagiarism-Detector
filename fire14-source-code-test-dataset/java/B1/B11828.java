import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.Math;

public class C
{
	public static void main(String[] args) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			System.out.print("Case #" + t + ": ");
			
			String[] star = br.readLine().split(" ");
			int A = Integer.parseInt(star[0]);
			int B = Integer.parseInt(star[1]);
			String up = star[1];
			
			int count = 0;
			LinkedList<String> list = new LinkedList<String>();
			for(int i = A; i <= B; i++) {
			
				String current = Integer.toString(i);
				String next = current;
				list.clear();
				for(int a = 0; a < current.length() - 1; a++) {
					next = next.charAt(next.length() - 1) + next.substring(0, next.length() - 1);
					//System.out.println(next);
					if(!list.contains(next)) {
						list.add(next);
						if(current.compareTo(next) < 0 && next.compareTo(up) <= 0) count++;
					}
				}
			
			}
			System.out.println(count);
		}
	}
}