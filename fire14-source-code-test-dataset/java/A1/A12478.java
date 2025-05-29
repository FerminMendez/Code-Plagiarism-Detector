import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DancingGooglers {
	
	public static int num (int c,int p,int [] g){
		int n = 0;
		for (int i =0;i<g.length;i++){
			if (g[i]>=p+p+p-2){
				n++;
			}
			else if (g[i]>=p+p+p-4){
				if (c>0){
					n++;
					c--;
				}
			}
		}
		return n;
	}
	
	public static void main (String [] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
		int t = Integer.parseInt(br.readLine());
		for (int i =0;i<t;i++){
			StringTokenizer s1 = new StringTokenizer(br.readLine());
			int [] g = new int [Integer.parseInt(s1.nextToken())];
			int c = Integer.parseInt(s1.nextToken());
			int p = Integer.parseInt(s1.nextToken());
			for (int j =0;j<g.length;j++){
				g[j] = Integer.parseInt(s1.nextToken());
			}
			if (p>1){
				System.out.printf("Case #%d: %d\n",i+1,num(c,p,g));
			}
			else {
				int n = 0;
				for (int j =0;j<g.length;j++){
					if (g[j]>=p+p+p-2){
						n++;
					}
				}
				System.out.printf("Case #%d: %d\n",i+1,n);
			}
		}
	}
}
