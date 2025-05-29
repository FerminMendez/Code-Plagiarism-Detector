package codejam2012.qualifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	private int noOfCases;
	private int currentCase;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	String str;
	
	String a,b;
	long aLong, bLong;
	long noOfRecycledNumbers;
	
	public static void main(String[] args) throws Exception {
		new RecycledNumbers().solveProblem("input/2012Qualifier/C-small-attempt0.in.txt", "input/2012Qualifier/C-small-attempt0.out.txt");
	}
	
	private void solveProblem(String inputFileName, String outputFileName) throws Exception {
		reader = new BufferedReader(new FileReader(inputFileName));
		writer = new BufferedWriter(new FileWriter(outputFileName));
		
		try {
			String str = reader.readLine();
			noOfCases = Integer.parseInt(str);
			currentCase = 0;
			
			for(int i=0;i<noOfCases;i++) {
				readInput();
				process();
				writeOutput();
			}
		} finally {
			reader.close();
			writer.flush();
			writer.close();
		}
	}
	
	private void process() throws Exception {
		noOfRecycledNumbers = 0;
		int length = a.length();
		
		for(long nLong = aLong; nLong < bLong; nLong++) {
			String n = Long.toString(nLong);
			Set<Long> recycled = new HashSet<Long>();
			
			for(int index=1; index < length; index++) {
				boolean lowerLimitBreached = true;
				for(int i=0;i<length;i++) {
					char nChar = n.charAt(i);
					char mChar = n.charAt((index+i)%length);
					
					if(mChar > nChar) {
						lowerLimitBreached = false;
						break;
					} else if(mChar < nChar) {
						lowerLimitBreached = true;
						break;
					}
				}
				if(lowerLimitBreached)
					continue;
				
				boolean upperLimitBreached = false;
				for(int i=0;i<length;i++) {
					char mChar = n.charAt((index+i)%length);
					char bChar = b.charAt(i);
					
					if(bChar > mChar) {
						upperLimitBreached = false;
						break;
					} else if(bChar < mChar) {
						upperLimitBreached = true;
						break;
					}
				}
				if(upperLimitBreached)
					continue;
				
				StringBuilder strBuilder = new StringBuilder();
				for(int i=0;i<length;i++)
					strBuilder.append(n.charAt((index+i)%length));
				long recycledNum = Long.parseLong(strBuilder.toString());
				if(!recycled.contains(recycledNum)) {
					recycled.add(recycledNum);
					noOfRecycledNumbers++;
				}
			}
		}
	}
	
	private void readInput() throws Exception {
		currentCase++;
		str = reader.readLine();
		String[] strArr = str.split(" ");
		a = strArr[0];
		b = strArr[1];
		aLong = Long.parseLong(a);
		bLong = Long.parseLong(b);
	}
	
	private void writeOutput() throws Exception {
		writer.write("Case #" + currentCase + ": ");
		writer.write("" + noOfRecycledNumbers);
		writer.write("\n");
	}
}
