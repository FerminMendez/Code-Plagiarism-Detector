package qualification.taskB;

public class Task {

	private int T;
	private int S;
	private int P;
	private int[] googlers;

	public Task(int t, int s, int p, int[] googlers) {
		super();
		T = t;
		S = s;
		P = p;
		this.googlers = googlers;
	}

	public String execute() {
		int result = 0;
		for (int googler : googlers) {
			int mod = googler % 3;
			int div = (googler - mod) / 3;
			if (googler != 0) {
				if (div >= P) {
					result++;
				} else if ((P - div) == 1 && mod >= 1) {
					result++;
				} else if ((P - div) == 2 && mod == 2 && S > 0) {
					S--;
					result++;
				} else if ((P - div) == 1 && mod == 0 && S > 0) {
					S--;
					result++;
				}
			} else {
				if(P == 0){
					result++;
				}
			}
		}
		return result + "";
	}

}
