import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			File dataFile = new File(args[0]);
			File outputFile = new File(args[1]);
			if (dataFile.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(dataFile));
				FileWriter writer = new FileWriter(outputFile, false);

				int maxIteration = Integer.valueOf(reader.readLine());
				int currentLine = 0;
				String line;
				
				while ((line = reader.readLine()) != null && currentLine < maxIteration) {
					int result = 0;
					HashMap<Integer, List<Integer>> recycled = new HashMap<Integer, List<Integer>>();
					String[] AB = line.split(" ");
					for (int min = Integer.valueOf(AB[0]), max = Integer.valueOf(AB[1]), i = min ; i < max ; i++) {
						String currVal = String.valueOf(i);
						String rotatedVal = currVal;
						for (int j = 0; j < currVal.length() - 1; j++){
							rotatedVal = rotateRight(rotatedVal);
							if (String.valueOf(Integer.valueOf(rotatedVal)).length() != String.valueOf(Integer.valueOf(currVal)).length())
								continue;
							int iVal = Integer.valueOf(rotatedVal);
							if (iVal >= min && iVal <= max && iVal != i) {
								int key, val;
								if (i < iVal) {
									key = i;
									val = iVal;
								} else {
									key = iVal;
									val = i;
								}
								if (recycled.containsKey(key)) {
									List<Integer> allVal = recycled.get(key);
									if (allVal != null) {
										if (!allVal.contains(val)) {
											allVal.add(val);
											result++;
										}
									}
								} else {
									List<Integer> addedVal = new ArrayList<Integer>();
									addedVal.add(val);
									recycled.put(key, addedVal);
									result++;
								}
							}
						}
					}

					writer.write("Case #" + ++currentLine + ": " + result + "\n");
				}
				reader.close();
				writer.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	private static String rotateRight(String sInput) {
		int len = sInput.length();
		char[] outstring = sInput.toCharArray();
		
		char ch = outstring[len - 1];
		for (int j = len -1; j > 0; j--) {
			outstring[j] = outstring[j - 1];
		}
		outstring[0] = ch;
		return String.valueOf(outstring);
	}
}
