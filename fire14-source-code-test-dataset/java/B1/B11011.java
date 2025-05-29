import java.util.*;
import java.io.*;

public class C{
	static ArrayList< ArrayList<Integer> > mem = new ArrayList< ArrayList<Integer> >();
	static int lenAB = -1;
	static boolean udah[] = new boolean[2000005];
		
	public static void compute(int x){
		int div = 10, gen, mul = 1;
		for (int i = 0 ; i < lenAB-1 ; i ++)mul*=10;
		HashSet<Integer> set = new HashSet<Integer>();
		while(mul > 1){
			gen = x/div + (x%div)*mul;
			if (x%div!=0 && x!=gen && !set.contains(gen)){
				mem.get(x).add(gen);
				set.add(gen);
			}
			div*=10;
			mul/=10;
		}
		udah[x] = true;
	}
	
	public static void main(String args[])throws Exception{
		for (int i = 0 ; i < 2000005 ; i ++){
			mem.add	(new ArrayList<Integer>());
			udah[i] = false;
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		String input;
		int t, a, b, sum = 0;
		
		t = Integer.parseInt(in.readLine());
		for (int k = 1 ; k <= t ; k ++){
			tok = new StringTokenizer(in.readLine());
			input = tok.nextToken();
			lenAB = input.length();
			a = Integer.parseInt(input);
			b = Integer.parseInt(tok.nextToken());
			sum = 0;
			for (int i = a ; i < b ; i ++){
				if (!udah[i]){
					compute(i);
				}
				int len = mem.get(i).size(), res;
				for (int j = 0 ; j < len ; j ++ ){
					res = mem.get(i).get(j);
					if (i < res && res <= b){
						sum++;
					}
				}
			}
			System.out.println("Case #" + k + ": " + sum);
		}
	}
}