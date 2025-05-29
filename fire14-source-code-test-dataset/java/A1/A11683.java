import java.util.Scanner;


public class QuestionB extends Question{
	
	private int N;
	private int S;
	private int p;
	private int[] dancers;

	public QuestionB(Result result, Counter counter)
	{
		super(result, counter);
	}

	@Override
	public void readInput(Scanner scanner) {
		N = scanner.nextInt();
		S = scanner.nextInt();
		p = scanner.nextInt();
		dancers = new int[N];
		for (int i = 0; i < N; i++) {
			dancers[i] = scanner.nextInt();
		}
	}
	
	@Override
	public String solution() {
		int counter = 0;
		for (int i = 0; i < N; i++) {
			if (dancers[i]>=3*p-Math.min(2,dancers[i]*2))
				counter++;
			else if (dancers[i]>=3*p-Math.min(4,dancers[i]*2) && S>0) {
				S--;
				counter++;
			}
		}
		return Integer.toString(counter);
	}


}
