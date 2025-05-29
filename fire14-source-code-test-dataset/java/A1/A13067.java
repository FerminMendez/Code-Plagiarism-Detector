package com.g0414.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Problem {
	public final String FILE_PATH = "C:/data/workspace/googleCodeJam/src/" + "com/g0414/b/";
	public final String FILE_BASE = "B-small-attempt1";
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
				ch = line.split(" ");
				long n = Long.parseLong(ch[0]);
				long s = Long.parseLong(ch[1]);
				long p = Long.parseLong(ch[2]);
				ArrayList<Long> tList = new ArrayList<Long>();
				for (int i = 3; i < ch.length; i++) {
					tList.add(Long.parseLong(ch[i]));
				}
				Test test = new Test(n,s,p,tList);
				testList.add(test);
			}
			br.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);
			throw new ProblemException(e.getMessage(),e);
		}
	}
	
	
	public class Test {
		long n = -1;
		long s = -1;
		long p = -1;
		ArrayList<Long> tList = null;
		
		public Test (long n, long s, long p, ArrayList<Long> tList) {
			this.n = n;
			this.s = s;
			this.p = p;
			this.tList = tList;
		}
		
		public String check () {
			ArrayList<Dance> danceList = new ArrayList<Dance> ();
			for (long t : tList) {
				long high = t / 3;
				if (t % 3 > 0) {
					high ++;
				}
				long highPlus = high;
				if (t % 3 != 1 && t / 3 > 0) {
					highPlus ++;
				}
				Dance dance = new Dance(high, highPlus);
				danceList.add(dance);
			}
			int result = 0;
			int surprisingUpper = 0; // surprisingがあったら昇格可能
			for (Dance dance : danceList) {
				if (dance.getHigh() >= p) {
					result ++;
				} else if (dance.getHighPlus() >= p) {
					surprisingUpper ++;
				}
			}
			// System.out.println("sur=" + surprisingUpper + ", s=" + s);
			if (surprisingUpper > s) {
				result += s;
			} else {
				result += surprisingUpper;
			}
			return "" + result;
		}
		
		
		@Override
		public String toString() {
			String list = " ";
			for (Long l : tList) {
				list += l + ",";
			}
			return "(" + n + "," + s + "," + p + ")" + list;
		}
	}
	
	private class Dance {
		long high;
		long highPlus;
		public Dance(long high, long highPlus){
			this.high = high;
			this.highPlus = highPlus;
		}
		public long getHigh() {
			return high;
		}
		public long getHighPlus() {
			return highPlus;
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
