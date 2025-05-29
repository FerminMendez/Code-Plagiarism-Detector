package com.g0414.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Problem {
	public final String FILE_PATH = "C:/data/workspace/googleCodeJam/src/" + "com/g0414/a/";
	public final String FILE_BASE = "A-small-attempt0";
	// public final String FILE_BASE = "sample";
	public final String INPUT_FILE = FILE_PATH + FILE_BASE + ".in";
	public final String OUTPUT_FILE = FILE_PATH + FILE_BASE + ".txt";
	
	long testN = -1;
	ArrayList<Test> testList = new ArrayList<Test>();
	
	public static void main(String[] args) {
		try {
			Problem p = new Problem();
			p.init();
			p.printResult();
			p.end();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printResult() throws ProblemException {
		long i = 1;
		for (Test p : testList) {
			prlong("Case #" + i + ": " + p.check());
			i++;
		}
	}
	
	public static boolean flag = true;
	FileWriter outputFile = null;
	public void prlong(String str) throws ProblemException {
		try {
			// ファイルの削除、ファイルの新規オープン
			if (flag) {
				flag = false;
				File fw01 = new File(OUTPUT_FILE);
				fw01.delete();
				outputFile = new FileWriter(OUTPUT_FILE, true);
			}
			outputFile.write(str + "\r\n");
			System.out.println(str);
		} catch (IOException e) {
				throw new ProblemException(e.getMessage(),e);
		}
	}
	
	public void end() throws ProblemException {
		try {
			outputFile.close();
		} catch (IOException e) {
			throw new ProblemException(e.getMessage(),e);
		}
	}
	
	public void init() throws ProblemException {
		try {
			FileReader in = new FileReader(INPUT_FILE);
			BufferedReader br = new BufferedReader(in);
			String line;
			testN = Long.parseLong(br.readLine());
			while ((line = br.readLine()) != null) {
				String[] ch = line.split(" ");
				System.out.println(line);
				/*
				ch = line.split(" ");
				long n = Long.parseLong(ch[0]);
				long s = Long.parseLong(ch[1]);
				long p = Long.parseLong(ch[2]);
				ArrayList<Long> tList = new ArrayList<Long>();
				for (int i = 3; i < ch.length; i++) {
					tList.add(Long.parseLong(ch[i]));
				}
				*/
				testList.add(new Test(line.toCharArray()));
			}
			br.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);
			throw new ProblemException(e.getMessage(),e);
		}
	}
	
	
	public class Test {
		char c[];

		public Test (char c[]) {
			this.c = c;
		}
		
		public String check () {
			char cc[] = new char[c.length];
			for (int i = 0; i < c.length; i++) {
				cc[i] = replace(c[i]);
			}
			return "" + new String(cc);
		}
		
		/*
		Input
		3
		ejp mysljylc kd kxveddknmc re jsicpdrysi
		rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd
		de kr kd eoya kw aej tysr re ujdr lkgc jv
		
		
		Output
		our language is impossible to understand
		there are twenty six factorial possibilities
		so it is okay if you want to just give up
		*/
		
		private char replace (char cc) {
			switch (cc) {
			case 'a': return 'y';
			case 'b': return 'h';
			case 'c': return 'e';
			case 'd': return 's';
			case 'e': return 'o';
			case 'f': return 'c';
			case 'g': return 'v';
			case 'h': return 'x';
			case 'i': return 'd';
			case 'j': return 'u';
			case 'k': return 'i';
			case 'l': return 'g';
			case 'm': return 'l';
			case 'n': return 'b';
			case 'o': return 'k';
			case 'p': return 'r';
			case 'q': return 'z';
			case 'r': return 't';
			case 's': return 'n';
			case 't': return 'w';
			case 'u': return 'j';
			case 'v': return 'p';
			case 'w': return 'f';
			case 'x': return 'm';
			case 'y': return 'a';
			case 'z': return 'q';
			case ' ': return ' ';
			}
			return '!';
		}
		
		@Override
		public String toString() {
			String list = "";
			for (int i = 0; i < c.length; i++) {
				list += c[i];
			}
			return "(" + list + ")";
		}
	}
	
	
	public class ProblemException extends Exception {
		private static final long serialVersionUID = 2080823058826051635L;
		public ProblemException(String message) {
			super(message);
		}
		public ProblemException(String message, Throwable e) {
			super (message, e);
		}
	}
	
	/*
	 * 
Case #1: 1
Case #2: 256
Case #3: 4
Case #4: 674
Case #5: 461
	 * 
	 */
}
