import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

public class Googlerecycle {
	public static void main (String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		Writer out = null;
		Writer debug = null;
		try {
			fr = new FileReader(args[0]);
			br = new BufferedReader(fr);
			out = new OutputStreamWriter(new FileOutputStream("googlerecycle-result.txt"));
			debug = new OutputStreamWriter(new FileOutputStream("googlerecycle-debug.txt"));
			String numOfLine = br.readLine();
			int line = 0;
			if (numOfLine != null) {
				line = Integer.valueOf(numOfLine);
			} else {
				return;
			}

			String lineData;
			String[] recycleArray;

			for (int i = 1; i <= line; i++) {
				HashMap<String, HashSet<String>> resultMap = new HashMap<String, HashSet<String>>();
				String resultLine = "";
				int recycledCounter = 0;
				lineData = br.readLine();
				recycleArray = lineData.split(" ");

				if (recycleArray[1].length() != 1) {
					int lowerLimit = Integer.valueOf(recycleArray[0]);
					int upperLimit = Integer.valueOf(recycleArray[1]);

					String iterator;

					for (int j = lowerLimit; j <= upperLimit; j++) {
						iterator = String.valueOf(j);
						String doubleLower = iterator + iterator;
						String iteratorCycled;
						int iteratorLength = iterator.length();
						for (int k = 1; k < iteratorLength; k++) {
							iteratorCycled = doubleLower.substring(k, k + iteratorLength);
							if (!iteratorCycled.startsWith("0") && (!iteratorCycled.equals(iterator))) {
								int recycled = Integer.valueOf(iteratorCycled);
								if (recycled <= upperLimit && recycled >= lowerLimit) {
									if (!resultMap.isEmpty()) {
										if (resultMap.containsKey(iteratorCycled)) {
											HashSet<String> resultSet = resultMap.get(iteratorCycled);
											if (resultSet.contains(iterator)) {
												debug.write("already exist pair: " + iterator + ", " + iteratorCycled + "\n");
											} else {
												if (resultMap.containsKey(iterator)){
													HashSet<String> resultSet2 = resultMap.get(iterator);
													if (!resultSet2.contains(iteratorCycled)) {
														recycledCounter++;
														debug.write(iterator + ", "  + iteratorCycled + "\n");
														resultSet2.add(iteratorCycled);
														resultMap.put(iterator, resultSet2);
													} else {
														debug.write("already exist exact pair: " + iterator + ", " + iteratorCycled + "\n");
													}
												}
												else {
													recycledCounter++;
													debug.write(iterator + ", "  + iteratorCycled + "\n");

													HashSet<String> resultSet2 = new HashSet<String>();
													resultSet2.add(iteratorCycled);
													resultMap.put(iterator, resultSet2);
												}
											}
										} else {
											if (resultMap.containsKey(iterator)){

												HashSet<String> resultSet = resultMap.get(iterator);
												if (!resultSet.contains(iteratorCycled)) {
													recycledCounter++;
													debug.write(iterator + ", "  + iteratorCycled + "\n");
													resultSet.add(iteratorCycled);
													resultMap.put(iterator, resultSet);
												} else {
													debug.write("already exist exact pair: " + iterator + ", " + iteratorCycled + "\n");
												}
											} else {
												recycledCounter++;
												debug.write(iterator + ", "  + iteratorCycled + "\n");

												HashSet<String> resultSet = new HashSet<String>();
												resultSet.add(iteratorCycled);
												resultMap.put(iterator, resultSet);
											}
										}
									} else {
										recycledCounter++;
										debug.write(iterator + ", "  + iteratorCycled + "\n");

										HashSet<String> resultSet = new HashSet<String>();
										resultSet.add(iteratorCycled);
										resultMap.put(iterator, resultSet);
									}
								}
							} else {
								debug.write("not valid recycled: " + iterator + ", " + iteratorCycled + "\n");
							}
						}
					}
				}
				debug.write("\n");

				resultLine = "Case #" + i + ": " + recycledCounter;
				out.write(resultLine);
				if (i != line) {
					out.write("\n");
				}
				System.out.println(resultLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
				out.close();
				debug.close();
			} catch(Exception e) {}
		}
	}
}
