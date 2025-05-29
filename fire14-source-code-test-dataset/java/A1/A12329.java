import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int z=1;z<=cases;++z) {
			System.out.print("Case #" + z + ": ");
			int googlers = in.nextInt();
			int surprizes = in.nextInt();
			int goodScore = in.nextInt();
			int[] scores = new int[googlers];
			for(int i=0;i<googlers;++i) {
				scores[i] = in.nextInt();
			}
			Arrays.sort(scores);
			int answer = 0;
			int magicNumber = 3*goodScore-2;
			int minNumber = 3*goodScore-4;
			for(int i=googlers-1;i>=0;--i) {
				if (scores[i] >= magicNumber) {
					++answer;
				}
				else if (scores[i] >= minNumber && surprizes != 0) {
					if (scores[i] <= 28 && scores[i] >= 2) {
						++answer;
						--surprizes;
					}
				}
			}
			System.out.println(answer);
		}
	}
}