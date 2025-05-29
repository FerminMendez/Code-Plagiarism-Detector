import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class REcycledNumbers {
	
	public static void main(String args[]) throws Exception {
		String line = "";
		BufferedReader br =	new BufferedReader(new FileReader("/Users/ravipalacherla/Documents/workspace/CodeJam/src/input.txt"));
		int T = Integer.parseInt(br.readLine());
		int j=0;
		while((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line," ");
			String strA = st.nextToken();
			String strB = st.nextToken();
			int intA = Integer.parseInt(strA);
			int intB = Integer.parseInt(strB);
			int count = 0;
			
			int intn = intA;
			while(intn < intB) {
				String strn = Integer.toString(intn);
				for(int i = strn.length()-1; i>0;i--) {
					String	strm = strn.substring(i)+strn.substring(0,i);
					if(strm.charAt(0) == '0') continue;
					int intm = Integer.parseInt(strm);
					if( ((""+intn).length() != (""+intm).length()) || ((""+intn).length() != (""+intA).length())) continue;
					if(intn == intm) continue;
					if ( ( intA <= intn) && (intn < intm) && (intm <= intB) ) {
					//	System.out.println("intN is " + intn + " intM is "+ intm);
						count ++;
					}
				}
				intn++;
			}
			j++;
			System.out.println("Case #"+ j +": "+count);
		}
	}
}
