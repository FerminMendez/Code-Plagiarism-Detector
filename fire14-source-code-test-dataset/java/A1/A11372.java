import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class googler {
	public static void main(String[] args) throws Exception {
		int n;
		int res;
		int threshold;
		int cheat;
		int goo;
		int test;
		int div;
		int rem;
		String[] temp;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(read.readLine());
		
		for (int j=1; j<=n; j++) {
			temp = read.readLine().split(" ");
			res = 0;
			goo = Integer.parseInt(temp[0]);
			cheat = Integer.parseInt(temp[1]);
			threshold = Integer.parseInt(temp[2]);
			
			for (int i=0; i<goo; i++) {
				test = Integer.parseInt(temp[i+3]);
				div = test/3;
				rem = test%3;
				
				if (div >= threshold) {
					res++;
					
				}
				else if (threshold - div == 1) {
					if (rem > 0){
						res++;
						
					}
					else if (cheat > 0 && div > 0) {
						cheat--;
						res++;
						
					}
				}
				else if ((threshold - div == 2) && rem == 2 && cheat > 0) {
					cheat--;
					res++;
					
				}
			}
			
			write.write(String.format("Case #%d: %d\n", j, res));
			
		}
		write.flush();
	}
}
			
			
			