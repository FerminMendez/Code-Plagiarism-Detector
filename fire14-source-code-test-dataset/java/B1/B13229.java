import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/William/Desktop/C-small-attempt0.in"));
			String strLine;
			
			FileWriter fostream = new FileWriter("/Users/William/Desktop/output.txt");
			BufferedWriter out = new BufferedWriter(fostream);
			
			strLine = br.readLine();
			int numOfLine = Integer.parseInt(strLine);
			
			for (int i=1;i<numOfLine+1;i++) {
				strLine = br.readLine();
				
				String splitedStr[] = strLine.split(" ");
				String first = splitedStr[0];
				String second = splitedStr[1];
				
				int firstNum = Integer.parseInt(first);
				int secondNum = Integer.parseInt(second);
								
				int count = 0;
				for (int k=firstNum;k<=secondNum;k++) {

					Integer kInt = new Integer(k);
					String kStr = kInt.toString();
					
					HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

					for (int j=1;j<kStr.length();j++) {
						String digit = kStr.substring(kStr.length()-j);
						String rest = kStr.substring(0, kStr.length()-j);
						
						String newStr = digit + rest;
						if (newStr.charAt(0)=='0') {
							continue;
						}
						
						int newNum = Integer.parseInt(newStr);
						
						ArrayList<Integer> list;
						if (map.get(k)==null) {
							list = new ArrayList<Integer>();
						}
						else {
							list = map.get(k);
						}
						
						boolean contains = false;
						for (Integer m : list) {
							if (m.intValue()==newNum) {
								contains = true;
								break;
							}
						}
						
						if (contains) {
							continue;
						}
						
						list.add(newNum);
						map.put(k, list);
						
						if ((newNum>k) && (newNum<=secondNum)) {
//							System.out.println("(" + k + " , " + newNum + ")");
							count ++;
						}
					}
				}
				System.out.println("Case #" + i + ": " + count);
				out.write("Case #" + i + ": " + count + "\n");
			}
			out.close();
			br.close();
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
