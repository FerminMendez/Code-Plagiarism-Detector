public class CodeJamLineParser {
	private final String[] tokens;
	private int position;
	
	public CodeJamLineParser(String line) {
		tokens = line.split("\\s");
		position = 0;
	}
	
	public boolean hasNextField() {
		return hasNextFields(1);
	}
	
	public int remainingFields() {
		return tokens.length - position;
	}
	
	public boolean hasNextFields(int count) {
		return remainingFields() >= count;
	}
	
	public String readNextStr() {
		return tokens[position++];
	}
	
	public int readNextInt() {
		return Integer.parseInt(readNextStr());
	}
	
	public int[] readNextIntList(int numOfInts) {
		int[] result = new int[numOfInts];
		for (int i = 0; i < numOfInts; ++i) {
			result[i] = readNextInt();
		}
		return result;
	}
}
