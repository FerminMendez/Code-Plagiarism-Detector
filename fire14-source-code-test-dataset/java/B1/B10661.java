package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Hashtable;

public class RecycledNumbers {
	public static void main(String[] args) {
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("F:/codingContest/recyledNumbersInput.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("F:/codingContest/output.txt"));
			String strLine;
			
			int T=0;
			
		    if ((strLine = br.readLine().trim()) != null)   {
		    	T = Integer.parseInt(strLine);
		    	if(T >= 1 && T <= 50){
		    		int A, B, count;
		    		String p1, p2, p;
		    		Hashtable<String, String> prev = null;
				    for(int testCase = 0; testCase < T; testCase++){
				    	strLine = br.readLine().trim();
					    A = Integer.parseInt(strLine.substring(0, strLine.indexOf(' ')));
					    B = Integer.parseInt(strLine.substring(strLine.indexOf(' ')).trim());
					    count = 0;
					    prev = new Hashtable<String, String>();
					    if((A + "").length() == (B + "").length()){
					    	for (int i = A, j; i < B; i++) {
								for (j = 1; j < (i + "").length(); j++) {
									p1 = (i + "").substring(0, (i + "").length()-j);
									p2 = (i + "").substring((i + "").length()-j);
									p = p2 + p1.substring(0, p1.length());
									if((i + "").length() == (Integer.parseInt(p)+"").length() && B >= Integer.parseInt(p) && i < Integer.parseInt(p) && !prev.containsKey(i+","+p)){
										prev.put(i+","+p, "");
										count++;
									}
								}
							}
					    }
					    bw.write("Case #"+(testCase+1)+": "+ count);
					    bw.newLine();
				    }
				    bw.flush();
				    bw.close();
				    br.close();
		    	}
		    }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
