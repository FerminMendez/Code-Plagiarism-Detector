/**
 * 
 */
package code.google.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author sunilkumarp
 *
 */
public abstract class Template {
	
	int testcases = 0;
	
	int casePoniter = 0;
	
	PrintWriter writer = null;
	
	BufferedReader reader = null;
	
	String line = null;
	
	int linePointer = -1;
	
	int linePerTestCase = 1;
	
	char lastChar = '!';
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Template template = (Template) Class.forName(args[1]).newInstance(); 
			template.start(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}

	}



	/**
	 * @param args
	 */
	protected void start(String[] args) {
		InputStream io = null;
		OutputStream os = null;
		
		
		
		try {
			
			io = Template.class.getResourceAsStream(args[0]);
			reader = new BufferedReader(new InputStreamReader (io));
			os = new FileOutputStream(new File(args[0].substring(0, args[0].length() -2 )+ "out"));
			writer = new PrintWriter(os);
			testcases = Integer.valueOf(reader.readLine());
			
			solveProblem();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(System.out);
			}

			try {
				reader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(System.out);
			}

			try {
				io.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(System.out);
			}

			try {
				os.flush();
				os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(System.out);
			}
		}
	}

	public void solveProblem() throws Exception {
		long sTime = System.nanoTime();
		for (;++casePoniter <= testcases;) {
			long sTimeCase = System.nanoTime();
			writeOutput(casePoniter, solveProblemForATestCase());
			System.out.println("Time taken for test case" + "[" + casePoniter + "]:" + (System.nanoTime() - sTimeCase));
		}

		System.out.println("Total time for all test cases:" + (System.nanoTime() - sTime));
	}
	
	protected Object solveProblemForATestCase() throws Exception {
		initializeTestCase();
		printInput();
		return doSolveProblem();
	}

	protected abstract Object doSolveProblem() throws Exception;

	protected abstract void printInput() throws Exception;

	protected abstract void initializeTestCase() throws Exception;

	protected void writeOutput (int caseNo, Object result) {
		String str = "Case #" + caseNo + ": " + result;
		System.out.println("==========" + str + "=============");
		writer.println(str);
	}
	
	public char readChar() throws IOException {
		return lastChar = (char)reader.read();
	}
	
	public char readCharFromLine() throws IOException {
		int length = line.length();
		
		if (linePointer >= length - 1) {
			throw new IllegalStateException("Line has already ended.");
		}
		
		return line.charAt(++linePointer);
	}
	
	public String readLine() throws IOException {
		line = reader.readLine();
		linePointer = -1;
		return line;
	}
	
	public int readNextInteger() {
		int val = 0;
		int length = line.length();
		
		if (linePointer >= length) {
			throw new IllegalStateException("Line has already ended.");
		}
		
		while(++linePointer < length) {
			if (Character.isDigit(lastChar = line.charAt(linePointer))) {
				val = val * 10 + Character.digit(lastChar, 10);
			} else {
				break;
			}
		}
		
		return val;
	}
	
}
