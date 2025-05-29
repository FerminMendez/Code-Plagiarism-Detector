import java.io.File;
import java.util.Scanner;

public class Googlers {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("resource/B-small-attempt2.in"));
		int T = sc.nextInt(); 
		int i = 1;
		while (i<=T) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int t[] = new int[N];
			for(int j=0; j<N; j++){
				t[j] = sc.nextInt();
			}
			System.out.println("Case #"+i+": "+process(N, S, p, t));
			i++;
		}
	}
	private static int process(int n, int s, int p, int[] t) {
		int counter = 0;
		if(p==0) return t.length;
		for(int i=0; i<n; i++){
			if( t[i] <= 3*((p-2)>=0? (p-2): 0) + 1) {
				//Never happen
				continue;
			}
			else if(t[i] >= 3 * p - 2){
				//Not surprising
				counter++;
		    }
			else {
				//Surprising
				if(s>0){
					s--;
					counter++;
				}
			}
		}
		return counter;
	}
}
