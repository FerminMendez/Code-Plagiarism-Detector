package qualification.taskC;


public class Task {

	private int a;
	private int b;
	private boolean[][] table;

	public Task(int a, int b, boolean[][] table) {
		this.a = a;
		this.b = b;
		this.table = table;
	}

	public String execute() {
		int result = 0;
		for (int i = a; i <= b; i++){
			for(int p = a; p <= b; p++){
				if(table[i][p]){
					result++;
				}
			}
		}
		return result/2 + "";
	}

}
