import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Recycle {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(in.readLine());
		int counter = 0;
		while(t>0){
			t--; counter++;
			int ans=0;
			String data = in.readLine();
			String[] ss = data.split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			//System.out.println(a + " "+ b);
			
			for(int i=a; i<b; i++){
				int  x = findSolutions(i, b);
				ans += x;
			}
			out.write("Case #"+ counter +": "+ans +"\n");
		}
		in.close();
		out.close();
	}

	private static int  findSolutions(int currentNumber, int m) {
		String s = Integer.toString(currentNumber);
		int len = s.length();
		String tmp = s;
		int ans = 0;
		Set<String> hashSet = new HashSet<String>();
		for(int i=0; i<len; i++){
			char c = tmp.charAt(0);
			tmp = tmp.substring(1);
			tmp += c;
			int generatedNumber = Integer.parseInt(tmp);
			String key = Integer.toString(currentNumber)+Integer.toString(generatedNumber);
			boolean contains = hashSet.contains(key);
			if(!contains)
				hashSet.add(key);
			if(generatedNumber > currentNumber && generatedNumber<= m && !contains){
				ans++;
			}
		}
		return ans;
	}

}
