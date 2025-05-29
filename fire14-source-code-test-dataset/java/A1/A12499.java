import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CodeJam {

//	public static final String INPUT_FILE_PATH = "D://CodeJamInput.txt";
	public static final String INPUT_FILE_PATH = "D://B-small-attempt0.in";
	public static final String OUTPUT_FILE_PATH = "D://CodeJamOutput.txt";

	public static List<String> readInput() {
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					INPUT_FILE_PATH));
			try {
				String line = null;

				while ((line = input.readLine()) != null) {
					list.add(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

	public static void writeOutput(List<String> output) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(OUTPUT_FILE_PATH));
			for (String line : output) {
				writer.println(line);
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}
	
	public static void main(String[] args) {
		List<DanceFloor> danceFloors = DanceFloor.parseFromFile(CodeJam.readInput());
		List<String> output = new ArrayList<String>();

		for(int i = 0; i < danceFloors.size(); i++) {
			System.out.println(danceFloors.get(i));
			String line = "";
			line += "Case #" + (i + 1) + ": " + danceFloors.get(i).calculate();
			output.add(line);
		}
		
		CodeJam.writeOutput(output);
	}
}

class DanceFloor {

	private List<Integer> tripletsTotalCounts;
	private int surpriseCount;
	private int targetScore;
	private int dancersCount;

	public DanceFloor(List<Integer> tripletsTotalCounts, int surpriseCount,
			int targetScore, int dancersCount) {
		this.tripletsTotalCounts = tripletsTotalCounts;
		this.surpriseCount = surpriseCount;
		this.targetScore = targetScore;
		this.dancersCount = dancersCount;
	}

	public int calculate() {
		int result = 0;
		
		if (targetScore == 0) return dancersCount;
		
		for (int i = 0; i < tripletsTotalCounts.size(); i++) {
			int total = tripletsTotalCounts.get(i);

			if (total < (targetScore * 3 - 4)) {
				tripletsTotalCounts.remove(i--);
			} else if (total == 0) {
				tripletsTotalCounts.remove(i--);
			}
		}
		
		for (int i = 0; i < tripletsTotalCounts.size(); i++) {
			int total = tripletsTotalCounts.get(i);

			if ((surpriseCount > 0) && (total == targetScore * 3 - 4)) {
				result++;
				surpriseCount--;
				tripletsTotalCounts.remove(i--);
			} else if ((surpriseCount == 0) && (total == targetScore * 3 - 4)) {
				tripletsTotalCounts.remove(i--);
			}
		}
		
		for (int i = 0; i < tripletsTotalCounts.size(); i++) {
			int total = tripletsTotalCounts.get(i);

			if ((surpriseCount > 0) && (total == targetScore * 3 - 3)) {
				result++;
				surpriseCount--;
				tripletsTotalCounts.remove(i--);
			} else if ((surpriseCount == 0) && (total == targetScore * 3 - 3)) {
				tripletsTotalCounts.remove(i--);
			}
		}
		
		result += tripletsTotalCounts.size();
		
		return result;
	}

	public static List<DanceFloor> parseFromFile(List<String> readInput) {
		List<DanceFloor> result = new ArrayList<DanceFloor>();
		int testCaseCount = Integer.parseInt(readInput.get(0));

		for (int i = 0; i < testCaseCount; i++) {
			String line[] = readInput.get(i + 1).split(" ");

			List<Integer> totalCounts = new ArrayList<Integer>();
			for (int j = 0; j < Integer.parseInt(line[0]); j++) {
				totalCounts.add(Integer.parseInt(line[3 + j]));
			}

			result.add(new DanceFloor(totalCounts, Integer.parseInt(line[1]),
					Integer.parseInt(line[2]), Integer.parseInt(line[0])));
		}

		return result;
	}

	@Override
	public String toString() {
		return "dancersCount = " + dancersCount + "; surpriseCount = " + surpriseCount 
								 + "; targetScore = " + targetScore + "; tripletsTotalCounts" 
								 + tripletsTotalCounts.toString();
	}
}

