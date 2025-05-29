import java.util.Scanner;


public class Q2 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(Q2.class.getResourceAsStream("B-small-attempt1.in"));
		
		int n = s.nextInt();
		
		int nt = 1;
		while (n-- > 0) {
			
			int resp = 0;
			
			int ng = s.nextInt();
			int ex = s.nextInt();
			int nm = s.nextInt();
			
			if (nm == 0) {
				resp = ng;
				while (ng-- > 0) {
					int nota = s.nextInt();
				}	
			} else if (nm == 1) {
				while (ng-- > 0) {
					int nota = s.nextInt();
					if (nota >= 1) {
						resp++;
					}
				}	
			} else {
				while (ng-- > 0) {
					int nota = s.nextInt();
					
					if (nota >= nm * 3 - 2) {
						resp++;
					} else if (nota >= nm * 3 - 4 && ex > 0) {
						resp++;
						ex--;
					}
				}
			}
			
			System.out.println("Case #" + nt + ": " + resp);
			
			nt++;
		}
		
	}

}
