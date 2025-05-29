import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;


public class User {

	private static final String FILENAME = "C-small-attempt0.in";
	private static final String OUTFILENAME = "C-small-attempt0.out";
	public static String newline = System.getProperty("line.separator");

	public static void main(String[] args) throws Exception {
		
	//	System.out.println(decoder.keySet());
	//	System.out.println(decoder.values());
		
		PrintWriter out = new PrintWriter(new FileWriter(OUTFILENAME));
	//	PrintStream out = System.out;
		

		FileReader fr = null;
		try {
			fr = new FileReader(FILENAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader input = new BufferedReader(fr);
		
		String[] line;
		String n;
		int digCount;
		String m;
		int recycledPairs = 0;
		
		int T = Integer.parseInt(input.readLine());
		
		for (int t=0; t<T; t++){
			HashMap<String, TreeSet<Integer>> digitMap = new HashMap<String, TreeSet<Integer>> ();
			recycledPairs = 0;
			line = input.readLine().split(" ");
			n = line[0];
			m = line[1];
			int nInt = Integer.parseInt(n);
			int mInt = Integer.parseInt(m);
						
			for (int i = nInt; i<=mInt; i++){
				String myChars = findChars(i); 
				if (digitMap.containsKey(myChars)){
					digitMap.get(myChars).add(i);
				//	System.out.println ("adding "+ i + " to "+ myChars + " new size is " + digitMap.get(myChars).size());
				}
				else {
					TreeSet<Integer> myTreeSet = new TreeSet<Integer>();
					myTreeSet.add(i);
					digitMap.put(myChars, myTreeSet);
				//	System.out.println ("adding "+ i + " to "+ myChars + " new size is " + digitMap.get(myChars).size());
				}
			}
			
			for (TreeSet<Integer> myTreeSet : digitMap.values()){
				if (myTreeSet.size()>1){
					Integer[] setArray = myTreeSet.toArray(new Integer[0]);
					int saLen = setArray.length;
					for (int i = 0; i<saLen; i++)
						for (int j = i+1; j<saLen;j++)
							if(recycled(setArray[i], setArray[j])) recycledPairs++;
				}
			}
			
/*
			for (int i = 0; i<7; i++)	
				for (int j = 0; j<magSet.get(i).size(); j++)
					for (int k = j+1; k<magSet.get(i).size();k++)
						if(recycled(magSet.get(i).get(j), magSet.get(i).get(k))) recycledPairs++;
	*/					
				
			out.println("Case #" + (t+1) + ": "+recycledPairs);
		}
			
		input.close();
		fr.close();
		out.close();
	}

	private static boolean recycled(Integer n, Integer m) {
		
		//System.out.println("recycling: " + n + "; "+ m);
		
		String nStr = n.toString();
		int strLen = nStr.length();
		String mStr = m.toString();
		
		for (int i=0; i < strLen-1; i++){
			nStr = moveDigit(nStr);
		//	System.out.println("comparing: " + nStr + "; "+ mStr);
			if (nStr.equals(mStr)) return true;
		}
		
		return false;
	}

	private static String findChars(int i) {
		char[] myCharArray= Integer.toString(i).toCharArray();
		Arrays.sort(myCharArray);
		return new String(myCharArray);
	}


	private static int countDigits(String next) {
		// TODO Auto-generated method stub
		return next.length();
	}

	private static String moveDigit(String n){
		StringBuffer nString = new StringBuffer(n);
		if (nString.length() == 1) return n; 
		StringBuffer resultString = new StringBuffer();
		resultString.append(nString.charAt(nString.length()-1));
		resultString.append(nString.substring(0, nString.length()-1));
		
		return new String(resultString);
	}
	
	private static int countDigits (int i){
		StringBuffer nString = new StringBuffer(Integer.toString(i));
		 return nString.length(); 
	}

}
