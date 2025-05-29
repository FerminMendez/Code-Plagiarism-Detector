import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new File("B-small-attempt0.out")));
			
			Scanner sc = new Scanner(new File("B-small-attempt0.in"));
			
			int T = sc.nextInt();
			sc.nextLine();
			
			for (int tc = 1; tc<=T; tc++) {
				int y = 0, y2 = 0;
				int N = sc.nextInt();
				int S = sc.nextInt();
				int p = sc.nextInt();
				for (int i = 0; i<N; i++) {
					int t = sc.nextInt();
					
					if(t/3>=p || (t/3==p-1 && t%3>0)) {
						y++;
					} else if((t/3==p-1 && t%3==0) || (t/3==p-2 && t%3==2)) {
						if(S>0 && t>=2 && t<=28) {
							y++;
							S--;
						}
					}
				}
				
				
				
				System.out.format("Case #%d: %d%n", tc, y);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

}
