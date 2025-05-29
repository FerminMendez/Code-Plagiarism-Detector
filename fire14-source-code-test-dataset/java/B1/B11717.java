import java.util.ArrayList;
import java.util.Scanner;


public class QuestionC extends Question{

	private int A;
	private int B;
	private int significant;
	private int digits;

	public QuestionC(Result result, Counter counter)
	{
		super(result, counter);
	}

	@Override
	public void readInput(Scanner scanner) {
		A = scanner.nextInt();
		B = scanner.nextInt();
		digits = Integer.toString(A).length();
		significant = (int)Math.pow(10, digits-1);
	}
	
	@Override
	public String solution() {
		int counter = 0;
		ArrayList<Integer> used = new ArrayList<Integer>();
		for (int i = A; i < B; i++) {
			int shifted = i;
			for (int j = 0; j < digits-1; j++) {
				shifted = (shifted%10)*significant+shifted/10;
				if (shifted > i && shifted <= B && !used.contains(shifted)) {
					counter++;
					used.add(shifted);
				}
			}
			used.clear();
		}
		return Integer.toString(counter);
	}


}
