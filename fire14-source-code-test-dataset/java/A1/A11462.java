package it.simone.google.code.jam2012;

public class Dancer implements GoogleCodeExercise {

	int surprise = 0;
	int googlers = 0;
	int p = 0;

	@Override
	public String execute(String line) {

		int result = 0;

		String[] data = line.split(" ");
		googlers = Integer.parseInt(data[0]);
		surprise = Integer.parseInt(data[1]);
		p = Integer.parseInt(data[2]);

		for (int i = 3; i < data.length; i++) {

			int total = Integer.parseInt(data[i]);
			result += analize(total);
		}
//		if (surprise >= 1)
//			System.out.println("WARNING");
		return "" + result;
	}

	@Override
	public void initialize() {

	}

	private int analize(int total) {
		int avg = total / 3;
		int rem = total % 3;
		int maxVote = avg;
		
		
		if (avg >= p) {
			maxVote = avg;
		} else if (rem == 1) {
			maxVote = avg + 1;
		} else if (rem == 2) {
			if ((avg + 1) >= p)
				maxVote = avg + 1;
			else if (surprise > 0) {
				if ((avg + 2) >= p) {
					maxVote = avg + 2;
					surprise--;
				} else
					maxVote = avg + 1;
			}
		} else if (rem == 0 && avg!=0) {
			if ((avg + 1) >= p && surprise > 0) {
				maxVote = avg + 1;
				surprise--;
			}
		}

		if (maxVote >= p)
			return 1;
		else
			return 0;
	}

}
