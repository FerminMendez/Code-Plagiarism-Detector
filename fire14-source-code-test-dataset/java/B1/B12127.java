import java.io.*;
import java.util.HashMap;
public class RecycledNumbers {
	
	public static void main(String[] arg) {
		String output,line = null;
		int t,a,b, count, caseNum;
		String[] inp; 
		
		try {
			BufferedReader is = new BufferedReader(new FileReader("infile.txt"));
			FileWriter writer = new FileWriter("output.txt");
			line = is.readLine();
			t = Integer.parseInt(line);
			for(caseNum=1; caseNum<=t; caseNum++) {
				line = is.readLine();
				inp = line.split(" ");
				
				a = Integer.parseInt(inp[0].trim());
				b = Integer.parseInt(inp[1].trim());
				
				count = generateRotatedNumbersCount(a, b);
				output = "Case #" + caseNum + ": " + count + "\n";
				writer.write(output.toCharArray());
			}
			writer.close();
		} catch (NumberFormatException ex) {
			System.out.println("Not a valid number: " + line);
		} catch (IOException e) {
			System.out.println("Unexpected IO ERROR: " + e);
		}
	}
	
	public static int generateRotatedNumbersCount(int a, int b) { 
		HashMap<Integer, Boolean> map;
		HashMap<Integer, Boolean> masterList = new HashMap<Integer, Boolean>();
		String num;
		char[] temp;
		int i,j,k,len;
		int n, count=0;
		
		for (k=a; k<=b; k++) {
			if (masterList.containsKey(k))
				continue;
			num = Integer.toString(k);
			char[] digits = num.toCharArray();
			
			len = digits.length;
			
			map = new HashMap<Integer, Boolean>();
			for (i=0; i<len; i++) {
				temp = new char[len];
				for (j=0; j<len; j++) {
					if (i+j<len)
						temp[j] = digits[i + j];
					else
						temp[j] = digits[i + j - len];
				}
				
				n = Integer.parseInt(new String(temp));
				if (n >= a && n <= b) {
					
					map.put(n, true);
					masterList.put(n, true);
				}
			}
			len = map.size();
			count += (len*(len-1))/2;
		}
		return count;
	}
}