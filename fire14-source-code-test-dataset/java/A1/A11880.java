import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class problemB {

	public static void main(String[] args) throws Exception{
		new problemB().run();
	}
	
	public void run() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("inputB.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		int T = Integer.parseInt(in.readLine());
		int maxS[] = new int[31];
		int maxJ[] = new int[31];
		Arrays.fill(maxS, -1);
		Arrays.fill(maxJ, -1);
		for(int x = 0; x<=10; x++)
			for(int y = 0; y<=10; y++)
				for(int z = 0; z<=10; z++){
					if(Math.abs(x-y) > 2 || Math.abs(x-z)>2 || Math.abs(y-z)>2)continue;
					int sum = x+y+z;
					if(Math.abs(x-y) == 2 || Math.abs(x-z) == 2 || Math.abs(y-z) == 2) {
						maxS[sum] = Math.max(maxS[sum], Math.max(x, Math.max(y, z)));
						continue;
					}
					maxJ[sum] = Math.max(maxJ[sum], Math.max(x, Math.max(y, z)));
				}
		for(int i=0; i<=30; i++){
			//System.out.println(i+" maxS = "+maxS[i]+" \t maxJ = "+maxJ[i]);
		}
		for(int step = 1; step <= T; step++){
			String []sp = in.readLine().split(" ");
			int n = Integer.parseInt(sp[0]), s = Integer.parseInt(sp[1]), p = Integer.parseInt(sp[2]);
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(sp[i+3]);
			//System.out.println(Arrays.toString(a));
			int leftS = s, answer = 0;
			boolean used[] = new boolean[n];
			for(int i=0; i<n; i++){
				if(maxJ[a[i]] >= p){
					answer++;
					used[i] = true;
					
				} else if(leftS > 0 && maxS[a[i]] >= p){
					leftS--;
					answer++;
				}
			}
			//System.out.println(Arrays.toString(used)+"  "+leftS);
			//System.out.println("Case #"+step+": "+answer);
			out.println("Case #"+step+": "+answer);
		}
		out.close();
	}
}
