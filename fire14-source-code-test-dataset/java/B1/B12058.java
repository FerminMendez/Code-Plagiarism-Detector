import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class prob2 {
	private static long oneTest(int a, int b){
		boolean [] bool=new boolean[b+1];
		long res=0;
		for(int i=a; i<=b; i++){
			if(bool[i]) continue;
			res+=pairs(i, bool, a, b);
		}
		return res;
	}
	private static long pairs(int j, boolean []bool, int a, int b){
		String str=Integer.toString(j);
		int len=str.length();
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0; i<=str.length(); i++){
			int c=Integer.parseInt(str);
			if(Integer.toString(c).length()!=len||(c<a||c>b)) {
				str=str.substring(len-1)+str.substring(0,len-1);
				continue;
			}
			str=str.substring(len-1)+str.substring(0,len-1);
			bool[c]=true;
			set.add(c);
			
		}
		long res=set.size();
		res*=(set.size()-1);
		res/=2;
		return res;
	}
	public static void main(String args[]) throws IOException{
		PrintWriter out=new PrintWriter(new FileWriter("result.txt"));
		BufferedReader in=new BufferedReader(new FileReader("C-small-attempt0.in"));
		//BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	//	System.out.print(oneTest(10, 40));
		int n=Integer.parseInt(in.readLine());
		for(int i=1; i<=n; i++){
			String str=in.readLine();
			out.print("Case #"+i+": ");
			StringTokenizer tok=new StringTokenizer(str);
			out.print(oneTest(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
			out.println();
			System.out.println(i);
		}
		
		out.flush();
		System.out.println("over");
		
	}
}
