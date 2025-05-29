import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Arrays;

public class RecycledNumbers {

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
	
	public static boolean isExist(String[] a, String b, int length) {
		for(int i = 0; i < length; i++) {
			if(b.equalsIgnoreCase(a[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static int numOfRecycleNumbers(int A, int B) {
		int result = 0;
		String str = new String();
		int length = (new Integer(A)).toString().length();
		String[] recycleStr = new String[length - 1];
		int uniqueRecStr = 0;
		int pair = 0;
		for(int i = A; i <= B; i++) {
			str = new String((new Integer(i)).toString() + (new Integer(i)).toString());
			recycleStr = new String[length - 1];
			uniqueRecStr = 0;
			for(int j = 1; j < length; j++) {
				String substr = new String(str.substring(j, j + length));
				if(false == isExist(recycleStr, substr, uniqueRecStr)) {
					recycleStr[uniqueRecStr] = substr;
					uniqueRecStr++;
				}
			}
			for(int j = 0; j < uniqueRecStr; j++) {
				pair = Integer.parseInt(recycleStr[j]);
				if(pair > i && pair <= B) {
					//System.out.println("pair " + (result+1) + ": " + i + " " + pair);
					result ++;
				}
			}
		}
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
				parameters = convertString2Nums(2, line);
				str = new String("Case #" + (i+1) + ": " + numOfRecycleNumbers(parameters[0], parameters[1]));
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
				inFile = new String("./C-test.in");
				outFile = new String("./C-test.out");
				break;
				
			case 1:
				inFile = new String("./C-small-attempt0.in");
				outFile = new String("./C-small-attempt0.out");
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
