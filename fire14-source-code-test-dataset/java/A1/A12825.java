import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Second {

	int surprises;
	boolean isSurprisesLeft = false;

	int min;
	int[] scores;

	int result;

	public Second(String[] input) {

		scores = new int[Integer.valueOf(input[0])];
		surprises = Integer.valueOf(input[1]);
		if (surprises > 0) {
			isSurprisesLeft = true;
		}

		min = Integer.valueOf(input[2]);

		for (int i = 3; i < input.length; i++) {
			scores[i - 3] = Integer.valueOf(input[i]);
		}
	}

	public static void main(String[] args) throws IOException {

		List<String> result = new ArrayList<>();
		for (String input : FileRW.readFile("input.txt")) {
			result.add(new Second(input.split("\\s")).process());
		}
		FileRW.writeOutput("output.txt", result);
	}

	private String process() {
		for (int i = 0; i < scores.length; i++) {
			if (suites(scores[i])) {
				result++;
			}
		}
		return String.valueOf(result);
	}

	public boolean suites(int n) {
		
		if(min == 0){
			return true;
		}
		
		
		n = n - min;
		
		if(n < 0){
			return false;
		}
		
		int avg = n / 2;

		if (avg >= min - 1) {
			return true;
		} else if (isSurprisesLeft && (avg >= (min - 2))) {
			surprises--;
			checkSupr();
			return true;
		} else {
			return false;
		}
	}

	private void checkSupr() {
		if (surprises == 0) {
			isSurprisesLeft = false;
		}
	}

}
