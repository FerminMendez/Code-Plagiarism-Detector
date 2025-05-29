import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class C {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		int tt = sc.nextInt();
		int cc = 0;
		for(int t = 0; t < tt; ++t) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int len =String.format("%d", B).length(); 
			int ans = 0;
			for(int n = A; n < B; ++n) {
				for(int m = n+1; m <= B; ++m) {
					String x = String.format("%d", n);
					String y = String.format("%d", m);
					boolean found = false;
					for(int i = 1; i < len; ++i) {
						String z = x.substring(i) + x.substring(0, i);
						if(z.equals(y)) {
							found = true;
							break;
						}
					}
					if(found) ans++;
				}
			}
			System.out.format("Case #%d: %s\n", ++cc, ans);
		}
	}
}
