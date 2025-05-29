import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class Gcj2 {
	private static Map<Integer, LinkedHashSet<Triplet>> pointsTripletMap = new TreeMap<Integer, LinkedHashSet<Triplet>>();

	private static void loadPointsTripletMap() {
		for (int i = 0; i <= 30; i++) {
			pointsTripletMap.put(Integer.valueOf(i),
					new LinkedHashSet<Triplet>());
		}

		for (int a = 0; a <= 10; a++) {
			for (int b = 0; b <= 10; b++) {
				for (int c = 0; c <= 10; c++) {
					try {
						int pointsSum= a + b + c;
						Triplet triplet = new Triplet(a,b,c);
						pointsTripletMap.get(Integer.valueOf(pointsSum)).add(
								triplet);
					} catch (NotValidTripletRuntimeException ex) {
						//bad practice! 
					}
				}
			}
		}
	}

	static {
		loadPointsTripletMap();
		System.out.println(pointsTripletMap);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = args[0];
		String output = args[1];

		try {
			File fileInput = new File(input);
			System.out.println(fileInput.getAbsolutePath());
			FileReader fr = new FileReader(fileInput);
			BufferedReader br = new BufferedReader(fr);

			File fileOutput = new File(output);
			FileWriter fw = new FileWriter(fileOutput);
			BufferedWriter bw = new BufferedWriter(fw);

			String numberOfCases = br.readLine();
			Integer n = Integer.parseInt(numberOfCases.trim());

			for (int i = 0; i < n; i++) {
				int result = 0;
				String line = br.readLine();
				String[] lineArgs = line.split(" ");
				int googlers = Integer.parseInt(lineArgs[0]);
				int surprisingTriplets = Integer.parseInt(lineArgs[1]);
				int pointsNumberMin = Integer.parseInt(lineArgs[2]);

				int[] googlersResults = new int[lineArgs.length - 3];
				for (int m = 3; m < lineArgs.length; m++) {
					int mGooglerResult = Integer.parseInt(lineArgs[m]);
					googlersResults[m - 3] = mGooglerResult;
				}

				Arrays.sort(googlersResults);

				for (int m = 0; m < googlersResults.length; m++) {
					LinkedHashSet<Triplet> triplets = pointsTripletMap
							.get(Integer.valueOf(googlersResults[m]));

					Triplet choosenTriplet = null;
					for (Triplet triplet : triplets) {
						if (triplet.getC() >= pointsNumberMin) {
							if (choosenTriplet == null) {
								choosenTriplet = triplet;
							} else if (choosenTriplet.isSurprising()
									&& !triplet.isSurprising()) {
								choosenTriplet = triplet;
							}
						}
					}

					if (choosenTriplet != null) {
						if (!choosenTriplet.isSurprising()) {
							result++;
						} else if (surprisingTriplets > 0) {
							result++;
							surprisingTriplets--;
						}
					}
				}

				String msg = "Case #" + (i + 1) + ": " + result;
				System.out.println(msg);
				if (i > 0) {
					bw.newLine();
				}
				bw.write(msg);

			}

			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Triplet {
	private final int pointsA, pointsB, pointsC;


	public Triplet(int pointsA, int pointsB, int pointsC) {
		int[] ints = new int[3];
		ints[0] = pointsA;
		ints[1] = pointsB;
		ints[2] = pointsC;

		Arrays.sort(ints);

		if (ints[2] - ints[0] > 2) {
			throw new NotValidTripletRuntimeException(
					"Points in triplet can't vary more than 2 points!");
		}

		this.pointsA = ints[0];
		this.pointsB = ints[1];
		this.pointsC = ints[2];
	}

	boolean isSurprising() {
		if (pointsC - pointsA > 1) {
			return true;
		} else {
			return false;
		}
	}

	public int getA() {
		return pointsA;
	}

	public int getB() {
		return pointsB;
	}

	public int getC() {
		return pointsC;
	}

	private int[] getMinMax(int... ints){
		int[] minMax = new int[2];
		minMax[0]=10;
		minMax[1]=0;
		for (int i : ints) {
			minMax[0] = Math.min(minMax[0], i);
			minMax[1] = Math.max(minMax[1], i);
		}
		return minMax;
	}

	@Override
	public int hashCode() {
		// Using Joshua Bloch's recipe:
		int result = 17;
		result = 37 * result + pointsA;
		result = 37 * result + pointsB;
		result = 37 * result + pointsC;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Triplet) {
			Triplet triplet = (Triplet) obj;
			if (this.getA() == triplet.getA() && this.getB() == triplet.getB()
					&& this.getC() == triplet.getC()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "" + pointsA + "," + pointsB + "," + pointsC;
	}
}

class NotValidTripletRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotValidTripletRuntimeException(String message) {
		super(message);
	}

}

