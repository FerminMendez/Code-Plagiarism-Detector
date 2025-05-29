import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.Math;

public class B
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			System.out.print("Case #" + t + ": ");
			
			
			String str = br.readLine();
			String[] starr = str.split(" ");
			
			int n = Integer.parseInt(starr[0]);
			int s = Integer.parseInt(starr[1]);
			int p = Integer.parseInt(starr[2]);
			int count = 0;
			for(int i = 3; i < n+3; i++) {
			
				int num = Integer.parseInt(starr[i]);
				if(num == 0) {
					if(p == 0) count++;
				}
				else {
					
					int val = (num+2)/3;
					if(val >= p) {
						count++;
					}
					else if(s > 0 && (num%3 == 0 || num%3 == 2) && val == p - 1) {
						count++;
						s--;
					}					
				}
			}
			
			
			System.out.println(count);
		}
	}
}