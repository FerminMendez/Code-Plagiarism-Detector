import java.io.*;
import java.util.*;

/**
 *
 * @author kronenthaler
 */
public class B {
	static HashMap<Integer, Set<ArrayList<Integer>>> cache = new HashMap<Integer, Set<ArrayList<Integer>>>();
	public static void main(String arg[]){
		try{
			int max = 0;
			for(int i=0;i<=10;i++){
				for(int j=0;j<=10;j++){
					for(int k=0;k<=10;k++){
						if(Math.abs(i-j)<=2 && Math.abs(j-k)<=2 && Math.abs(i-k)<=2){
							if(cache.get(i+j+k)==null)
								cache.put(i+j+k, new HashSet<ArrayList<Integer>>());
							ArrayList<Integer> a = new ArrayList<Integer>();
							a.add(i);
							a.add(j);
							a.add(k);
							Collections.sort(a);
							cache.get(i+j+k).add(a);
							max = Math.max(max, cache.get(i+j+k).size());
						}
					}
				}
			}

			Scanner in = new Scanner(new FileInputStream("b-small.in"));
			//Scanner in = new Scanner(new FileInputStream("b-large.in"));
			System.setOut(new PrintStream("b.out"));
			int T = in.nextInt();
			for(int cases=1;cases<=T;cases++){
				int n = in.nextInt();
				int s = in.nextInt();
				int p = in.nextInt();
				int g[] = new int[n];
				
				for(int i=0;i<n;i++){
					g[i] = in.nextInt();
				}

				System.out.printf("Case #%d: %d\n",cases, bt(g,s,p,0,0));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	static int bt(int[]g, int s, int p, int acum, int current){
		if(current == g.length) return s==0?acum:-1;
		int max = -1;
		Set<ArrayList<Integer>> a = cache.get(g[current]);
		for(ArrayList<Integer> arr : a){
			if(Math.abs(arr.get(0)-arr.get(2))==2){
				if(s!=0)
					max = Math.max(max, bt(g, s-1, p, acum + (arr.get(2)>=p?1:0), current+1));
			}else{
				max = Math.max(max, bt(g, s, p, acum + (arr.get(2)>=p?1:0), current+1));
			}
		}
		return max;
	}
}
