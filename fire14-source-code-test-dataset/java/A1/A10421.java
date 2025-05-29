package qualification.taskB;

import Parser.MyReader;
import Parser.MyWriter;

public class Main {

	public static void main(String[] args) {
		MyReader myReader = new MyReader(
				"/Users/shami13/Downloads/B-small-attempt0.in");
		MyWriter myWriter = new MyWriter(
				"/Users/shami13/Downloads/B-small-attempt0.out");

		int taskLength = Integer.parseInt(myReader.read());
		for (int i = 1; i <= taskLength; i++) {
			String[] taskString = myReader.read().split(" ");
			int T = Integer.parseInt(taskString[0]);
			int S = Integer.parseInt(taskString[1]);
			int P = Integer.parseInt(taskString[2]);
			int[] googlers = new int[T];
			for(int p = 3; p < taskString.length; p++){
				googlers[p-3] = Integer.parseInt(taskString[p]);
			}
			
			Task task = new Task(T,S,P,googlers);
			String result = task.execute();
			myWriter.writeString("Case #" + i + ": " + result);
			System.out.println("Case #" + i + ": " + result);
		}
		myWriter.close();
	}
}
