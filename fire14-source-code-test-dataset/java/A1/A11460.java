import java.util.Scanner;

public class problemB {

	private static final StringBuilder output = new StringBuilder();

	private static int i = 1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		s.nextLine();
		for (int i = 0; i < tests; i++) {
			addLine(String.valueOf(getMaxDancers(s.nextLine())));
		}
		System.out.println(showLine());

	}

	private static int getMaxDancers(String line) {
		String[] values = line.split(" ");
		int surprising = Integer.parseInt(values[1]);
		int score = Integer.parseInt(values[2]);
		int minScore = score * 3 - 2;
		int minSurp = minScore - 2;
		int numOfDancers = 0;
		for(int i = 3; i < values.length; i++){
			int sumOfPoints = Integer.parseInt(values[i]);
			if(sumOfPoints >= minScore){
				numOfDancers++;
			}
			else if(sumOfPoints > 1 && sumOfPoints >= minSurp && surprising > 0){
				numOfDancers++;
				surprising--;
			}
		}
		return numOfDancers;
	}

	private static void addLine(String s){
		output.append("Case #");
		output.append(i);
		output.append(": ");
		output.append(s);
		output.append("\n");
		i++;
	}


	public static String showLine(){
		return output.toString();
	}
}
