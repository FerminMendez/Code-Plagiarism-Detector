import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		OutputBuilder output = new OutputBuilder();
		int tests = s.nextInt();
		s.nextLine();
		for (int i = 0; i < tests; i++) {
			output.addLine(String.valueOf(getMaxDancers(s.nextLine())));
		}
		System.out.println(output.toString());
	}

	private static int getMaxDancers(String line) {
		String[] parameters = line.split(" ");
		int surprising = Integer.parseInt(parameters[1]);
		int minScore = Integer.parseInt(parameters[2]);
		int minNorm = minScore * 3 - 2;
		int minSurp = minNorm - 2;

		int dancers = 0;
		for(int i = 3; i < parameters.length; i++){
			int sum = Integer.parseInt(parameters[i]);
			if(sum >= minNorm || (sum > 1 && sum >= minSurp && surprising-- > 0)){
				dancers++;
			}
		}
		return dancers;
	}

	private static class OutputBuilder{

		private final StringBuilder output = new StringBuilder();

		private int i = 1;

		void addLine(String s){
			this.output.append("Case #");
			this.output.append(this.i);
			this.output.append(": ");
			this.output.append(s);
			this.output.append("\n");
			this.i++;
		}

		@Override
		public String toString(){
			return this.output.toString();
		}
	}

}
