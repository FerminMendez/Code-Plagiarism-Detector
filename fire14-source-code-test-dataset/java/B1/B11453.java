import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
class CodeJamTools

// http://snippets.dzone.com/posts/show/1335
{
	public static String readFileAsString(String filePath) {
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	        f.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	    return new String(buffer);
	}


	//http://www.daniweb.com/software-development/java/threads/94567
	public static void writeStringToFile(String filename, String output) {

		PrintStream fout;
		try {
			fout = new PrintStream(new FileOutputStream (filename));
			fout.print(output);
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int[] readIntsFromRow(String row) {
		String[] cText = row.split("\\s");
		int[] result = new int[cText.length];
		for (int i=0; i<cText.length; i++) {
			result[i] = new Integer(cText[i]);
		}
		return result;
	}

	public static long[] readLongsFromRow(String row) {
		String[] cText = row.split("\\s");
		long[] result = new long[cText.length];
		for (int i=0; i<cText.length; i++) {
			result[i] = new Long(cText[i]);
		}
		return result;
	}

	public static Set<Long> readLongsSetFromRow(String row) {
		String[] cText = row.split("\\s");
		Set<Long> result = new TreeSet<Long>();
		for (int i=0; i<cText.length; i++) {
			result.add(new Long(cText[i]));
		}
		return result;
	}



	public static double[] readDoublesFromRow(String row) {
		String[] cText = row.split("\\s");
		double[] result = new double[cText.length];
		for (int i=0; i<cText.length; i++) {
			result[i] = new Double(cText[i]);
		}
		return result;
	}

	public static String pilkuta(String t) {
		String res = "[";
		for (int i=0; i<t.length(); i++) {
			if (i>0)
				res += ", ";
			res += t.substring(i,i+1);
		}
		res += "]";
		return res;
	}


	// http://www.proglogic.com/code/java/calculator/lcm.php

	public static long leastCommonMultiplier (long m, long n){
		return m * (n / greatestCommonDivisor(m, n));
	}

	public static long greatestCommonDivisor (long m, long n){
		long x;
		long y;
		while(m%n != 0){
			x = n;
			y = m%n;
			m = x;
			n = y;
		}
		return n;
	}

	//http://www.vogella.de/articles/JavaAlgorithmsPrimeFactorization/article.html:

	public static List<Integer> primeFactors(int number) {
		int n = number;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		return factors;
	}
}
	