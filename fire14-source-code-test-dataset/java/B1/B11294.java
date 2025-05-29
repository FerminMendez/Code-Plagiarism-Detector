import java.util.*;
import java.io.*;

public class Solution {
	public void doMain() throws Exception {
		Scanner sc = new Scanner(new FileReader("/home/vivek/workspace/codejam2012problem2/src/input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("/home/vivek/workspace/codejam2012problem2/src/output.txt"));
		//Scanner sc = new Scanner(System.in);
		//PrintWriter pw = new PrintWriter(System.out);
		int T = sc.nextInt();
		//sc.nextLine();		
		for (int j = 0; j < T; j++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			int count=0;
			pw.print("Case #" + (j + 1) + ": ");			
			for(long i=a;i<=b;i++){
				String N=i+"";
				String M=i+"";int n=M.length();				
				int check=0;
				List<Long> al=new ArrayList<Long>();
				for(int k=0;k<n;k++){					
					M=M.charAt(n-1)+M;
					M=M.substring(0,n);	
					if(!al.contains(new Long(Long.parseLong(M))) &&  Long.parseLong(M)<=b && Long.parseLong(N)<Long.parseLong(M) && a<Long.parseLong(M))
						count++;
					al.add(Long.parseLong(M));
					
				}							
			}			
			pw.println(count);
		}		
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Solution().doMain();
	}
}