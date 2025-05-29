// Recycled Numbers

import java.io.*;
import java.util.*;

public class RecycledNumbers {
	public static void main(String[] args) throws Exception {
		String inputPath = args[args.length-2];
		String outputPath = args[args.length-1];
		
		BufferedReader br = new BufferedReader(new FileReader(inputPath));
		int numberOfTestCases = Integer.parseInt(br.readLine());
		
		StringBuilder output = new StringBuilder();
		
		for (int i=1; i<=numberOfTestCases; i++) {
			String[] components = br.readLine().split(" ");
			int minValue = Integer.parseInt(components[0]);
			int maxValue = Integer.parseInt(components[1]);
			
			int numberOfPairs = 0;
			
			ArrayList<String> list = new ArrayList<String>();
			
			for (int value=minValue; value<=maxValue; value++) {
				String vString = Integer.toString(value);
				if (list.indexOf(vString) == -1) {
					boolean mainItemAdded = false;
					int numberOfSubpairs = 0;
					int vStringLength = vString.length();
					for (int vStringIndex=1; vStringIndex<vString.length(); vStringIndex++) {
						StringBuilder sb = new StringBuilder(vString);
						String part = sb.substring(0, vStringIndex);
						sb.delete(0, vStringIndex);
						sb.append(part);
						
						String newValueString = sb.toString();
						int newValue = Integer.parseInt(newValueString);
						int newValueLength = Integer.toString(newValue).length();
						if ((vStringLength==newValueLength) && (vString.equals(newValueString) == false) && (list.indexOf(newValueString) == -1) && (newValue >= minValue) && (newValue <= maxValue)) {
							if (mainItemAdded == false) {
								mainItemAdded = true;
								list.add(vString);
//								System.out.println(vString);
								numberOfSubpairs++;
							}
							numberOfSubpairs++;
							list.add(newValueString);
//							System.out.println(newValueString);
						}
					}
					for (int s=numberOfSubpairs-1; s>0; s--) {
						numberOfPairs+=s;
					}
//					System.out.println("Pair: " + numberOfPairs + " Sub: " + numberOfSubpairs);
				}
			}
			System.out.println("Case #" + i + ": " + numberOfPairs + "\n");
			output.append("Case #" + i + ": " + numberOfPairs + "\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
		String outputString = output.toString();
		bw.write(outputString, 0, outputString.length());
		bw.close();
	}
}