import java.util.Scanner;


public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < cases; i++) {
			Scanner line = new Scanner(sc.nextLine());
			int triplets = line.nextInt();
			int surprise = line.nextInt();
			int threshold = line.nextInt();
			
			int enough = 0;
			int borderline = 0;
			
			while(line.hasNextInt()) {
				int score = line.nextInt();
				if(score == 0) {
					if(threshold == 0) {
						enough++;
					}
				}
				else if(score == 1) {
					if(threshold <= 1) {
						enough++;
					}
				}
				else {
					int maxS, maxNS;
					
					int mod = score % 3;
					int div = score / 3;
					if(mod == 0) {
						maxS = div+1;
						maxNS = div;
					}
					else if(mod == 1) {
						maxS = div+1;
						maxNS = div+1;
					}
					else {
						maxS = div+2;
						maxNS = div+1;
					}
					
					if(threshold <= maxNS) {
						enough++;
					}
					else {
						if(threshold <= maxS) {
							borderline++;
						}
					}
					
				}
			}
			
			System.out.printf("Case #%d: %d\n", i+1, enough + Math.min(borderline, surprise));
		}

	}

}

