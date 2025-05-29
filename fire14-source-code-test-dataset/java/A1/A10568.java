import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class DancingWithTheGooglers {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader (new FileReader("B-small.in"));
		PrintWriter out = new PrintWriter(new FileWriter("B-small.out"));
		
		int t = Integer.parseInt(f.readLine());
		for (int i = 0; i < t; i++){
			int c = 0;
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] ti = new int[n];
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j ++){
				ti[j] = Integer.parseInt(st.nextToken());
				if (ti[j] % 3 == 0){
					if (ti[j] / 3 >= p)
						c++;
					else if (ti[j] / 3 == (p-1) && s > 0 && ti[j] >= 2){
						s--;
						c++;
					}
				}
				else if (ti[j] % 3 == 1){
					if ((ti[j] / 3) + 1 >= p)
						c++;					
				}
				else{
					if (ti[j] / 3 >= p-1)
						c++;
					else if (ti[j] / 3 == (p-2) && s > 0){
						s--;
						c++;
					}
				}
					
				
			}
			out.println("Case #" + (i+1) + ": " + c);
			
			
		}
		out.close();
		System.exit(0);
		
		
		
	}
}
