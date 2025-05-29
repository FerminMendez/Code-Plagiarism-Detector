import java.util.Scanner;

public class ProblemB {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		int lineCount = Integer.valueOf(in.nextLine());
		int[] lines = new int[lineCount];
		
		for(int n = 0; n < lineCount; n++) {
			int N = in.nextInt(), 
				S = in.nextInt(), 
				p = in.nextInt();
			
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				int score= in.nextInt();
				int single = score / 3;
				
				switch (score % 3) {
				case 0:
					if (single >= p) {
						max++;
					} else {
						if (S > 0 && score >= 2 && score <= 28 && single + 1 >= p) {
							max++;
							S--;
						}
					}
					break;
				case 1:
					if (single + 1 >= p) {
						max++;
					}
					break;
				case 2:
					if (single +1 >= p) {
						max++;
					} else {
						if (S > 0 && score >= 2 && score <= 28 && single + 2 >= p) {
							max++;
							S--;
						}
					}
				}
			}
			
			lines[n] = max;
			
			in.nextLine();
		}
		
		for(int i = 1; i <= lineCount; i++) {
			System.out.println("Case #" + i + ": " + lines[i-1]);
		}
	}
}