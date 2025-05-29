import java.io.*;
import java.util.*;

public class DancingWithGooglers {
	public static void main(String... args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(
				System.getProperty("user.home") + "/Desktop/googlers.in"));

		Map<Integer, TripleCounter> dictionary = new HashMap<Integer, TripleCounter>();

		for (int x = 0; x <= 10; x++) {
			dictionary.put(x + x + x, new TripleCounter(x, x, x, false));
			if (x >= 10)
				continue;
			dictionary
					.put(x + x + x + 1, new TripleCounter(x, x, x + 1, false));
			dictionary.put(x + x + 1 + x + 1, new TripleCounter(x, x + 1,
					x + 1, false));
		}

		Map<Integer, TripleCounter> specialdictionary = new HashMap<Integer, TripleCounter>();

		for (int x = 0; x <= 8; x++) {
			specialdictionary.put(x + x + x + 2, new TripleCounter(x, x, x + 2,
					true));
			specialdictionary.put(x + x + 2 + x + 2, new TripleCounter(x,
					x + 2, x + 2, true));
			specialdictionary.put(x + x + 1 + x + 2, new TripleCounter(x,
					x + 1, x + 2, true));
		}

		int times = Integer.parseInt(br.readLine());

		for (int i = 0; i < times; i++) {
			googlers(br.readLine(), dictionary, specialdictionary, i + 1);
		}

	}

	public static void googlers(String line,
			Map<Integer, TripleCounter> dictionary,
			Map<Integer, TripleCounter> specialdictionary, int num) {
		String[] split = line.split(" ");

		int special = Integer.parseInt(split[1]);
		int p = Integer.parseInt(split[2]);
		List<Integer> scores = new ArrayList<Integer>();
		int count = 0;

		for (int i = 3; i < split.length; i++) {
			scores.add(Integer.parseInt(split[i]));
		}

		for (int i : scores) {
			TripleCounter c = dictionary.get(i);
			if (c != null && c.hasGreaterOrEqualTo(p)) {
				count++;
				continue;
			}
			
			c = specialdictionary.get(i);
			if (special > 0) {
				if (c != null && c.hasGreaterOrEqualTo(p)) {
					count++;
					special--;
				}
			}
		}
		
		System.out.println("Case #" + num + ": " + count);
	}

}

class TripleCounter {

	public int x, y, z;
	public boolean special;

	public TripleCounter(int x, int y, int z, boolean special) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.special = special;
	}

	public boolean hasGreaterOrEqualTo(int num) {
		return (x >= num || y >= num || z >= num);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + special + ")";
	}

}
