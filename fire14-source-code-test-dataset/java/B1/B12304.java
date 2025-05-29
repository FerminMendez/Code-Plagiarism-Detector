/**
 * 
 */
package GoogleCodeJam2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author MArunkumar
 *
 */
public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("RecycledNumbersInput.txt"));
		FileWriter fw = new FileWriter("RecycledNumbersOutput.txt");
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++){
			String datas[] = br.readLine().split(" ");
			int A = Integer.parseInt(datas[0]);
			int B = Integer.parseInt(datas[1]);
			int result = 0;
			for(int n=A; n<B; n++){
				int r = n;
				String nStr = String.valueOf(n);
				String rStr = String.valueOf(r);
				if(!(rStr.length()<2)){
					do{
						rStr = shiftLeft(rStr);
						r = Integer.parseInt(rStr);
						String trStr = String.valueOf(r);
						if(trStr.length() == nStr.length() && r>n && r<=B){
							result++;
						}
					}while(r!=n);
				}
			}
			fw.write("Case #"+i+": "+result+"\n");
		}
		fw.close();
	}
	
	private static String shiftLeft(String rStr){
		char[] rChars = rStr.toCharArray();
		char temp = rChars[0];
		for(int i=0; i<rChars.length-1; i++){
			rChars[i] = rChars[i+1];
		}
		rChars[rChars.length-1] = temp;
		return new String(rChars);
	}

}
