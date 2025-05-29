import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> answer = read("/home/zehortigoza/Downloads/codejam/c/input.txt");
		int tt = 0;
		int amount = 1;
		for (int i = 0; i < answer.size(); i++) {
			String line = answer.get(i);
			if (i == 0) {
				tt = Integer.parseInt(line);
			} else {
				if (tt >= amount) {
					HashMap<String, Boolean> count = new HashMap<String, Boolean>();

					String[] splited = line.split(" ");
					String a = splited[0];
					String b = splited[1];
					int aInt = Integer.parseInt(a);
					int bInt = Integer.parseInt(b);

					if (! (a.length() == 1 && b.length() == 1)) {
						ArrayList<Integer> range = range(aInt, bInt);
						
						for (int z = 0; z < range.size(); z++) {
							String currentN = range.get(z)+"";
						    String currentM = range.get(z)+"";
						    int length = currentM.length();
						    
						    for (int j = 0; j < length; j++) {
						    	currentM = currentM.charAt(length-1) + currentM.substring(0, length - 1);
							    
							    int currentNInt = Integer.parseInt(currentN);
							    int currentMInt = Integer.parseInt(currentM);
							    
							    if (currentMInt <= bInt && currentMInt > currentNInt && currentMInt >= aInt) {							    	
							    	if(count.get(currentN+currentM) == null) {
							    		count.put(currentN+currentM, true);
							    	}						    	
						        }
						    }
						}
					}

					System.out.println("Case #" + amount + ": " + count.size());
					amount++;
				}
			}
		}
	}

	private static ArrayList<Integer> range(int start, int end) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (start > end) {
			System.out.println("error to build range");
			return null;
		}

		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		return list;
	}

	private static ArrayList<String> read(String url) {
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(url));
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return lines;
	}
}
