import java.util.*;
import java.io.*;

public class Solution {
	public void doMain() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));		
		int CaseNumber = Integer.parseInt(in.readLine());		
		for (int cas=1; cas <= CaseNumber; cas++) {
			int nbr = 0 ;			
			String[] str = in.readLine().split(" ");
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			if(A < 10) {
				pw.println("Case #"+cas+": "+nbr);
			}
			else if(A==B){
				pw.println("Case #"+cas+": "+nbr);
			}
			else{
				ArrayList<String> n = new ArrayList<String>();
				for(int i=A; i<=B; i++){
					String st = Integer.toString(i);
					int l = st.length();
					for(int j=l-1; j>0 ; j--){
						String s = st;
						s = s.substring(j) + s;
						s = s.substring(0,l);
						
						if(Integer.parseInt(s) >A && Integer.parseInt(s) <B && Integer.parseInt(s)!=i && !n.contains(""+i+"-"+s) && !n.contains(s+"-"+i)){
							n.add(s+"-"+i);
							n.add(""+i+"-"+s);
							nbr++;
						}
					}	
				}
				pw.println("Case #"+cas+": "+nbr);
			}
		}
		
		in.close();
		pw.flush();
		pw.close();
	}
	
	public static void main(String[] args) throws Exception {
		(new Solution()).doMain();
	}
}