package contest;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
	BufferedReader in;

	public Input(BufferedReader in) {
		this.in = in;
	}

	//

	public String readStr() {
		return readStr(in);
	}

	public int readInt() {
		return readInt(in);
	}

	public int[] readIntArr() {
		return readIntArr(in, " ");
	}

	public List<Integer> readIntList() {
		return readIntList(in, " ");
	}

	public List<String> readStrList() {
		return readStrList(in, " ");
	}

	//

	public String readStr(BufferedReader in) {
		try {
			return in.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int readInt(BufferedReader in) {
		return Integer.parseInt(readStr(in));
	}

	public int[] readIntArr(BufferedReader in) {
		return readIntArr(in, " ");
	}

	public int[] readIntArr(BufferedReader in, String delimiter) {
		String[] tokens = readStr(in).split(delimiter);
		int[] ints = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			ints[i] = Integer.parseInt(tokens[i]);
		}
		return ints;
	}

	public List<Integer> readIntList(BufferedReader in) {
		return readIntList(in, " ");
	}

	public List<Integer> readIntList(BufferedReader in, String delimiter) {
		String[] tokens = readStr(in).split(delimiter);
		List<Integer> ints = new ArrayList<Integer>(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			ints.add(Integer.parseInt(tokens[i]));
		}
		return ints;
	}

	public List<String> readStrList(BufferedReader in, String delimiter) {
		return Arrays.asList(readStr(in).split(delimiter));
	}
}
