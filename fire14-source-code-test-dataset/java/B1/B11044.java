import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Code3 {


	
	private BufferedReader reader = null;
	PrintStream out = null;
	
	public static void main(String[] args) throws Exception {
		String file = "C-small-attempt0";
		Code3 code2 = new Code3();
		try {
	    code2.reader = new BufferedReader(new FileReader("source/" + file + ".in"));
		code2.out = new PrintStream(new FileOutputStream("source/" + file + ".out"));
		code2.runCases();
		} finally {
			code2.reader.close();
			code2.out.close();
		}
	}
	
	private void runCases() throws IOException {
		int cases = getInt();
		for (int c = 1; c <= cases; c++) {
			out.print("Case #" + c + ": ");
			execute();
			out.print("\n");
		}
	}
	
	private String readNext() throws IOException {
		String s = reader.readLine();
		return s;
	}
	
	private int getInt() throws IOException{
		String s= this.readNext();
		return Integer.valueOf(s);
	}
	
	private void execute() throws IOException {
		String s = this.readNext();		
		Code3DataStructure ds = new Code3DataStructure();
		StringTokenizer st = new StringTokenizer(s," ");
			ds.setA(Integer.parseInt(st.nextToken()));
			ds.setB(Integer.parseInt(st.nextToken()));
			System.out.println("=========================");
			this.processData(ds);
			System.out.println("=========================");
		out.print(ds.getResult());
		
	}
	
	private void processData(Code3DataStructure ds) {
		if(ds.getA()==ds.getB()) {
			ds.setResult(0);
			return;
		}
		int recyclePairCount = 0;
		for (int i = ds.getA(); i < ds.getB(); i++) {
			for (int j = i+1; j < ds.getB(); j++) {
				if(isRecyclePair(i, j)) {
					recyclePairCount++;
				}
			}
		}
		ds.setResult(recyclePairCount);
	}
	
	private boolean isRecyclePair(int m, int n) {
		boolean recyclePair = false;
		if((m+"").length() == (n+"").length()) {
			int length = (m+"").length();
			for (int i = 1; i <= length; i++) {
				int rotatedValue = rotateNumber(m, i);
				if(rotatedValue == n) {
					return true;
				}
			}
		}
		return recyclePair;
	}
	
	private static int denomination(int baseDenomination, int amount) {
		int denomination = 1;
		for (int i = 0; i < amount; i++) {
			denomination*=baseDenomination;
		}
		return denomination;
	}
	private static int rotateNumber(int m,int chunkSize) {
		int chunk = m%(denomination(10,chunkSize));
		int leftover = m/(denomination(10,chunkSize));
		int leftoverSize = (leftover+"").length();
		int output = chunk*(denomination(10,leftoverSize))+leftover;
		return output;
	}
	
	
}
