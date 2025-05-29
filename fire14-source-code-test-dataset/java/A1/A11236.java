import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int c = 0; c < cases; c++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]); // Number of Googlers
			int S = Integer.parseInt(line[1]); // Number of surprising triplets
			int p = Integer.parseInt(line[2]); // How many achieved at least this score
			
			int pNormal = 0;
			int pSurprising = 0;
			
			for(int i = 3; i < line.length; i++) {
				int n = Integer.parseInt(line[i]);
				
				if(n == 0) {
					if(n >= p)
						pNormal++;
				}
				else if(n % 3 == 0) {
					if((n/3) >= p)
						pNormal++;
					else if((n/3)+1 >= p)
						pSurprising++;
				}
				else if(n % 3 == 1) {
					if((n/3)+1 >= p)
						pNormal++;
				}
				else {
					if((n/3)+1 >= p) {
						pNormal++;
					}
					else if((n/3)+2 >= p) {
						pSurprising++;
					}
				}
			}
			
			if(pSurprising > S)
				pSurprising = S;
			
			System.out.println("Case #"+(c+1)+": "+(pNormal+pSurprising));
		}
	}
}
