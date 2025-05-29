public class ProblemB extends FileWrapper {

	private int N[] = null;
	private int S[] = null;
	private int P[] = null;
	private int t[][] = null;
	
	public ProblemB(String fileName) {
		this.processInput(fileName);
		this.calculate();
		this.processOutput(OUTPUT);
	}

	private int getResult(int caseNum) {
		int total = 0;
		for (int i=0; i<this.t[caseNum].length; i++) {
			if (this.t[caseNum][i]/3 >= this.P[caseNum]) {
				total++;
			}else if (this.t[caseNum][i]/3 == this.P[caseNum] - 1) {
				if (this.t[caseNum][i]%3 >= 1) {
					total++;
				}else if (S[caseNum] > 0 && this.t[caseNum][i]/3 > 0) {
					total++;
					S[caseNum]--;
				}
			}else if (this.t[caseNum][i]/3 == this.P[caseNum] - 2 && this.t[caseNum][i]%3 == 2  && this.t[caseNum][i]/3 > 0 && S[caseNum] > 0) {
				total++;
				S[caseNum]--;
			}
		}
		return total;
	}
	
	@Override
	protected void processInput(String fileName) {
		try {
			this.openReadFile(fileName);
			this.caseNum = Integer.parseInt(this.readLine());
			this.output = new String[this.caseNum];
			this.N = new int[this.caseNum];
			this.S = new int[this.caseNum];
			this.P = new int[this.caseNum];
			this.t = new int[this.caseNum][];
			for (int i = 0; i < this.caseNum; i++) {
				String elem[] = this.readLine().split(" ");
				this.N[i] = Integer.parseInt(elem[0]);
				this.S[i] = Integer.parseInt(elem[1]);
				this.P[i] = Integer.parseInt(elem[2]);
				this.t[i] = new int[N[i]];
				for (int j=0; j<N[i]; j++) {
					this.t[i][j] = Integer.parseInt(elem[3+j]);
				}
			}
			this.closeReadFile();
		} catch (Exception e) {
		}
	}

	@Override
	protected void calculate() {
		for (int i=0; i<this.caseNum; i++) {
			this.output[i] = CASE + (i+1) + ": " + this.getResult(i);
		}
	}

	public static void main(String argv[]) {
		if (argv.length > 0) {
			new ProblemB(argv[0]);
		} else {
			new ProblemB("B-small-attempt1.in");
		}
	}

}