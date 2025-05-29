import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.System.*;

public class RecycledNumbers{
	static HashSet<Integer> set;
	static int ctr, low, high;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int ii = Integer.parseInt(br.readLine());
		for(int jj=0; jj<ii; jj++){
			String[] ss = br.readLine().trim().split("\\s+");
			low = Integer.parseInt(ss[0]);
			high = Integer.parseInt(ss[1]);
			set = new HashSet<Integer>();
			ctr = 0;
			for(int i=low; i<=high; i++){
				if(!set.contains(i)){
					generate(i+"");
				}
			}
			out.printf("Case #%d: %d\n", jj+1, ctr);
		}
	}
	static void generate(String s){
		String ss = s+s;
		int tmp = 0;
		for(int i=0; i<s.length(); i++){
			int x = Integer.parseInt(ss.substring(i, i+s.length()));
			if(x>=low && x<=high && !set.contains(x)){
				// out.println(x);
				set.add(x);
				tmp++;
			}
		}
		// out.println();
		ctr+=(tmp*(tmp-1)/2);
	}
}