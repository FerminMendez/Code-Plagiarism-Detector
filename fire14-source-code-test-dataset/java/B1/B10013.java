import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws Exception {
		String inputfilename = args[0];
		String outputfilename = args[1];
		BufferedReader br = new BufferedReader(new FileReader(inputfilename));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputfilename));
		int cases = Integer.valueOf(br.readLine());
		for(int i = 0; i < cases; i++) {
			String[] ele = br.readLine().split(" ");
			int A = Integer.valueOf(ele[0]);
			int B = Integer.valueOf(ele[1]);
			int result = C.solve(A,B);
			bw.write("Case #" + (i + 1) + ": " + result + "\n");
		}
		br.close();
		bw.close();
	}
	
	public static int solve(int A,int B) {
		int cnt = 0;
		//System.out.println("\nDoing " + A + " " + B);
		String Astr = String.valueOf(A);
		String Bstr = String.valueOf(B);
		for(int cur = A; cur <= B; cur++) {
			String cstr = String.valueOf(cur);
			//System.out.println("\n" + cstr + "\n");
			Set<String> tset = new HashSet<String>();
			for(int i = 1; i < cstr.length(); i++)
			{
				String tmp = cstr.substring(i) + cstr.substring(0,i);
				//System.out.println(" " + tmp);
				if(tmp.compareTo(cstr) > 0 && tmp.compareTo(Bstr) <= 0 && !tset.contains(tmp)) {
					cnt++;
					tset.add(tmp);
					//System.out.print(" " + cstr + "!!" +tmp);
				}
			}
		}
		return cnt;
	}
}