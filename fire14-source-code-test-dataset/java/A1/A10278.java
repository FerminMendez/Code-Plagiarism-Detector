package gcj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Gcj {
	private static final String path = "/home/me/dev/gcj/";
	private BufferedReader br = null;
	private String[] tokens;
	private int itoken,ntokens;
	
	static public void err(String e) {
		System.out.println("\n**\n"+e+" :-)\n");
		System.exit(1);
	}
	
	public Gcj(String filename) {
		try {
			br = new BufferedReader(new FileReader(path + filename));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String rawLine() {
		String line = null;
		
		try {
			line = br.readLine();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
	
	
	public String[] readLine() {
		
		String line = rawLine();
		
		if (line == null) {
			tokens = null;
			ntokens = 0;
		}
		else {
			tokens = line.trim().split("\\s+");
			ntokens = tokens.length;
		}
		itoken = 0;
		
		return tokens;
	}
	
	private String nextToken() {
		String err = null;
		if (ntokens < 1) err = "There is no token";
		else if (itoken >= ntokens) err = "No more token";
		else {
			return tokens[itoken++];
		}
		
		Gcj.err(err);
		return null;
	}
	
	public String sToken() {
		return nextToken();
	}

	public String[] sBunch() {
		String[] l = new String[ntokens-itoken];
		int i=0;
		while (itoken < ntokens) l[i++] = tokens[itoken++];
		return l;
	}

	public char cToken() {
		return nextToken().charAt(0);
	}

	public char[] cBunch() {
		char[] l = new char[ntokens-itoken];
		int i = 0;
		while (itoken < ntokens) l[i++] = tokens[itoken++].charAt(0);
		return l;
	}

	public int iToken() {
		return Integer.parseInt(nextToken());
	}

	public int[] iBunch() {
		int[] l = new int[ntokens-itoken];
		int i = 0;
		while (itoken < ntokens) l[i++] = Integer.parseInt(tokens[itoken++]);
		return l;
	}
	
	public long lToken() {
		return Long.parseLong(nextToken());
	}

	public long[] lBunch() {
		long[] l = new long[ntokens-itoken];
		int i = 0;
		while (itoken < ntokens) l[i++]  = Long.parseLong(tokens[itoken++]);
		return l;
	}
	
	public double dToken() {
		return Double.parseDouble(nextToken());
	}

	public double[] dBunch() {
		double[] l = new double[ntokens-itoken];
		int i = 0;
		while (itoken < ntokens) l[i++] = Double.parseDouble(tokens[itoken++]);
		return l;
	}
	
	// --
	
	public void terminate() {
		try {
			if (br != null) br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	
	// --- OUTPUT ---
	
	public static void outcase(int n, boolean rc) {
		System.out.print("Case #" + n + ": ");
		if (rc) System.out.print("\n");
	}
}
