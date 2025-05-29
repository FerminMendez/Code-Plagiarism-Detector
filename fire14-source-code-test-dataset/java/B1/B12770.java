public class ProblemC extends FileWrapper {

	private int A[] = null;
	private int B[] = null;
	private int digt[] = null;
	
	public ProblemC(String fileName) {
		this.processInput(fileName);
		this.calculate();
		this.processOutput(OUTPUT);
	}

	@Override
	protected void processInput(String fileName) {
		try {
			this.openReadFile(fileName);
			this.caseNum = Integer.parseInt(this.readLine());
			this.output = new String[this.caseNum];
			this.A = new int[this.caseNum];
			this.B = new int[this.caseNum];
			this.digt = new int[this.caseNum];
			for (int i = 0; i < this.caseNum; i++) {
				String elem[] = this.readLine().split(" ");
				this.A[i] = Integer.parseInt(elem[0]);
				this.B[i] = Integer.parseInt(elem[1]);
				this.digt[i] = elem[0].length()-1;
			}
			this.closeReadFile();
		} catch (Exception e) {
		}
	}

	@Override
	protected void calculate() {
		for (int i=0; i<this.caseNum; i++) {
			int total = 0;
			this.output[i] = CASE + (i+1) + ": ";
			if (this.digt[i] == 0) {
				this.output[i] += total;
				continue;
			}
			int div = 10;
			for (int x=1; x<this.digt[i]; x++) {
				div *= 10;
			}
			for (int j=A[i]; j<B[i]; j++) {
				int value = j;
				for (int x=0; x<this.digt[i]; x++) {
					value = value%div*10+value/div;
					if (value>j && value<=B[i]) {
						total++;
					}else if (value==j) {
						break;
					}
				}
			}
			this.output[i] += total;
		}
	}

	public static void main(String argv[]) {
		if (argv.length > 0) {
			new ProblemC(argv[0]);
		} else {
			new ProblemC("C-small-attempt0.in");
		}
	}

}