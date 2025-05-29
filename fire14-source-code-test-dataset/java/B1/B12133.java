import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		LinkedList<String> list = readFile("C:/Users/Wurschti/workspace2/2012_3_recycled/src/input.txt");
		int counter = 1;
		int result = 0;
		LinkedList<Pair> resultList = new LinkedList<Pair>();

		for (String s : list) {
			resultList = new LinkedList<Pair>();
			String[] pair = s.split(" ");
			if (pair.length < 2) {
				result = 0;
			} else {
				int min = Integer.parseInt(pair[0]);
				int max = Integer.parseInt(pair[1]);
				
				int counter2 = min;
				while (counter2 < max) {
					String intToUse = counter2 + "";
					for (int i = 0; i < intToUse.length(); i++) {
						char[] intAsCharArray = intToUse.toCharArray();
						for (int j = 0; j < intAsCharArray.length - 1; j++) {
							intAsCharArray[j] = intAsCharArray[j + 1];
						}
						intAsCharArray[intAsCharArray.length - 1] = intToUse.charAt(0);
						
						intToUse = "";
						for (char c : intAsCharArray) {
							intToUse += c;
						}
						
						//evtl contains umschreiben
						int resultNumber = Integer.parseInt(intToUse);
						Pair p = new Pair(counter2, resultNumber);
						if (!isIn(p, resultList) && resultNumber <= max && resultNumber > counter2) {
							resultList.add(p);
						}
						
					}
					
					counter2++;
				}
			}
			
		
			
			System.out.format("Case #%d: %s\n", counter, resultList.size());
			counter++;
		}
	}
	
	private static boolean isIn(Pair p, LinkedList<Pair> list) {
		for (Pair p2 : list) {
			if (p.first == p2.first && p.second == p2.second) {
				return true;
			}
		}
		return false;
	}
	
	
	public static LinkedList<String> readFile(String filename)
			throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		File file = new File(filename);

		if (!file.exists()) {
			System.out.println("file not found");
			return null;
		}

		BufferedReader in = new BufferedReader(new FileReader(file));

		// read vocables
		String input = in.readLine();
		input = in.readLine();

		while (input != null) {
			list.add(input);
			input = in.readLine();
		}

		in.close();
		return list;
	}
}
