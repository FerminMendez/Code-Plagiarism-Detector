import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Arrays;

public class DancingWithTheGooglers {
	public static int testSize = 0;
	
	public static int[] convertString2Nums(int n, String str) {
		int[] result = new int[n];
		
		int begIndex = 0;
		int endIndex = 0;
		
		for(int i = 0; i < n - 1; i++) {
			endIndex = str.indexOf(' ', begIndex);
			result[i] = Integer.parseInt(str.substring(begIndex, endIndex));
			begIndex = endIndex + 1;
		}
		result[n - 1] = Integer.parseInt(str.substring(begIndex, str.length()));
		return result;
	}
	
	public static boolean isPossibleScore(int score, int P) {
		if(0 == P) return true;
		if(score < P) return false;
		int remain = (score - P) >> 1;
		if(P - remain > 1)
			return false;
		return true;
	}
	
	public static boolean isSurprisePossible(int score, int P) {
		if(0 == P) return true;
		if(score < P) return false;
		int remain = (score - P) >> 1;
		if(P - remain > 2)
			return false;
		return true;	
	}
	
	public static int maxDancers(String input) {
		int result = 0;
		String[] params = input.split(" ");
		int N = Integer.parseInt(params[0]);
		int S = Integer.parseInt(params[1]);
		int P = Integer.parseInt(params[2]);
		
		int[] a = new int[N];
		int numOfSurprise = 0;
		
		for(int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(params[i + 3]);
		}
		
		Arrays.sort(a);
		for(int i = N - 1; i >= 0 ; i--) {
			if(isPossibleScore(a[i], P)) {
				result++;
			} else {
				if(numOfSurprise < S && isSurprisePossible(a[i], P)) {
					result++;
					numOfSurprise++;
				}
			}
		}
		/*
		
		int i = 0;
		while(a[i] < P ) {
			i++;
			if(i >= N)
				break;
		}
		
		if(i == N)
			return 0;
		
		int j = 0;
		for(j = 0; j < S && j + i < N; j++) {
			result ++;
		}
		
		if(j + i < N) {
			for(int k = j + i; k < N; k++) {
				if(isPossibleScore(a[k], P))
					result++;
			}
		}
		*/
		return result;
	}

	public static void Output(String inPath, String outPath) {
		try {
			FileInputStream fstream = new FileInputStream(inPath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			File of = new File(outPath);
			of.delete();
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outPath), true));
			
			String line = br.readLine();
			
			int[] parameters = convertString2Nums(1, line);
			int numOfTest = parameters[0];
			
			String str = new String();
			for(int i = 0; i < numOfTest; i ++) {
				line = br.readLine();
				str = new String("Case #" + (i+1) + ": " + maxDancers(line));
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}	 
			
			in.close();
			bw.close();
		} catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	//public static 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inFile  = new String();
		String outFile = new String();
		testSize = 1;
		switch(testSize) {
			case 0:
				inFile = new String("./B-test.in");
				outFile = new String("./B-test.out");
				break;
				
			case 1:
				inFile = new String("./B-small-attempt1.in");
				outFile = new String("./B-small-attempt1.out");
				break;
				
			case 2:
				inFile = new String("./A-large-practice.in");
				outFile = new String("./A-large-practice.out");
				break;
			default:
				break;
		}		
		Output(inFile, outFile);
	}


}
