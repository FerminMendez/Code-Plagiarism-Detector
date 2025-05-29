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
			System.setOut(new PrintStream(new File("C-small-attempt0.out")));
			
			Scanner sc = new Scanner(new File("C-small-attempt0.in"));
			
			int T = sc.nextInt();
			sc.nextLine();
			
			for (int t = 1; t<=T; t++) {
				int y = 0;
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				for (int n = A; n<B; n++) {
					String s = Integer.toString(n);
					
					for (int j = 1; j < s.length(); j++) {
						String s2 = s.substring(j, s.length()) + s.substring(0, j);
						int m = Integer.parseInt(s2);
						if(n<m && m<=B) {
							y++;							
						}
					}
				}
				
				System.out.format("Case #%d: %d%n", t, y);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

}
