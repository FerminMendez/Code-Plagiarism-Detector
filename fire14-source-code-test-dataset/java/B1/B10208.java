
import java.io.*;
import java.util.*;

public class RN {
	private static String fileName = RN.class.getSimpleName().replaceFirst("_.*", "");
	private static String inputFileName = "D:\\santosh\\cj12\\"+fileName + ".in";
	private static String outputFileName = "D:\\santosh\\cj12\\"+fileName + ".out";
	private static Scanner in;
	private static PrintWriter out;
	 
	
	private static int rotateAndCount(int num, int b, HashMap<String, String> map) {
		String str1 = new Integer(num).toString();
		char[] arr = str1.toCharArray();
		int len = arr.length;
		if(len <= 1) {
			return 0;
		}
		int cnt = 0;
		String str = str1 + str1;
		for (int i = 0; i < len-1; i++) {
              char ch = arr[len - 1];
              for (int j = len - 1; j > 0; j--) {
            	  arr[j] = arr[j - 1];
              }
              arr[0] = ch;
              String str2 = new String(arr);
              int c2 = Integer.parseInt(str2);
              if(c2 != num && (c2 >= num) && (c2 <= b) && str.contains(str2)) {
            	  if(!map.containsKey(str1+","+str2)) {
            		  map.put(str1+","+str2, null);
            		  cnt ++;
            	  }
              }
        }
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		if (args.length >= 2) {
			inputFileName = args[0];
			outputFileName = args[1];
		}
		in = new Scanner(new FileReader(inputFileName));
		out = new PrintWriter(outputFileName);
		int tests = in.nextInt();
		//in.nextLine();
		int a, b;
		HashMap<String, String> map;
		for (int t = 1; t <= tests; t++) {
			a = in.nextInt();
			b = in.nextInt();
			map = new HashMap<String, String>();
			System.out.println("A == "+a+" B =="+ b);
			int totalCnt = 0;
			while(a <= b) {
				totalCnt += rotateAndCount(a, b, map);
				a++;
			}
			System.out.println("Case #" + t + ": "+totalCnt);
			out.println("Case #" + t + ": "+totalCnt);
		}
		in.close();
		out.close();
	}
}

