import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CopyOfMain {

	public static void main(String[] args) throws FileNotFoundException {
		String file = "B-small-attempt0";
		Scanner in = new Scanner(new File(file + ".in"));
		PrintWriter out = new PrintWriter(new File(file + ".out"));

		int T = in.nextInt();
		for(int t=1; t<=T; t++){
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			
			int[] scores = new int[N];
			int[] bst = new int[N];
			int[] dmax = new int[N];
			
			int nextp=0;
			int prevp=0;
			for(int i=0; i < scores.length; i++){
				int s = scores[i] = in.nextInt();
				if(s%3==0){
					bst[i]=s/3;
					dmax[i] = bst[i]>0?1:0;
				}else if(s%3 ==1){
					bst[i]=s/3 + 1;
					dmax[i] = 0;
				}else{
					bst[i]=s/3 + 1;
					dmax[i] = 1;
				}
				
				if(bst[i]>=p)
					nextp++;
				if(bst[i]==p-1&& dmax[i]>0)
					prevp++;
			}			
			out.println("Case #" + t + ": "+(nextp+Math.min(S, prevp)));//+Math.min(S, prevp));			
		}
		
		
		in.close();
		out.close();
	}
}
