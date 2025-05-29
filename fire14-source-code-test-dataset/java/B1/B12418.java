import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = 0;
		int A = 0;
		int B = 0;
		int n = 0;
		int m = 0;
		int tmp = 0;
		int totalPasses = 0;
		int passCtr = 0;
		int pairs = 0;
		int movDig = 0;
		int prevN = 0; //These 4 variables are to capture possible duplicates
		int prevM = 0;
		int prevN2 = 0;
		int prevM2 = 0;
		String currentCase = null;
		String inputFilename = "C-small-attempt0.in";
		String outputFilename = "C-small-attempt0.out";
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(outputFilename));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		FileInputStream fStream = null;
		try {
			fStream = new FileInputStream(inputFilename);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataInputStream in = new DataInputStream(fStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		
		try {
			T = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i=0;i<T;i++) {
			try {
				currentCase = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			A = Integer.parseInt(currentCase.substring(0,currentCase.indexOf(' ')));
			B = Integer.parseInt(currentCase.substring(currentCase.indexOf(' ')).trim());
			
			n = A;
			pairs = 0;
			while (n <= B) {
				totalPasses = Integer.toString(n).length()-1;
				passCtr = 0;
				
				tmp = n;
				while (passCtr < totalPasses) {
					movDig = tmp % 10;
					tmp = tmp / 10;
					m = tmp + movDig * ((int) Math.pow(10, totalPasses));
					
					if ((A <= n) && (n < m) && (m <= B)) {
						pairs++;
						if ((prevN == n && prevM == m) || (prevN2 == n && prevM2 == m)) {
							pairs--;
						}
						prevN2 = prevN;
						prevM2 = prevM;
						prevN = n;
						prevM = m;
					}
					tmp = m;
					passCtr++;
							
				}
				n++;
			}
			
			try {
				out.write("Case #"+(i+1)+": "+pairs+'\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
