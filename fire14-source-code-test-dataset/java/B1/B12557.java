import java.util.Scanner;


public class RecNum {
	public static void main(String[] args) {
		Scanner reader = new Scanner (System.in);
		int nCases = reader.nextInt();
		for(int i=1; i<=nCases; i++) {
			int A = reader.nextInt();
			int B = reader.nextInt();
			int digits = 0;
			int nPair = 0;
			int tmp = A;
			while(tmp > 0) {
				digits++;
				tmp = tmp/10;
			}
			for(int j=A; j<=B; j++) {
				for(int k=1; k<digits; k++) {
					int divider = new Double(Math.pow(10, k)).intValue();
					int timer = new Double(Math.pow(10, digits-k)).intValue();
					int last = j%divider;
					int newInt = last*timer + j/divider;
					if(newInt>j && newInt<=B) {
						nPair++;
					}
				}
			}
			System.out.println("Case #" + i + ": " + nPair);
		}
	}
}
