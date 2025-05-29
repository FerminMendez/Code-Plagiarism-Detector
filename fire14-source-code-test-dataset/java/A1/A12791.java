package qualification_round;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class danceGooglers {

	private static void readFile () {

		String str, temp[];
		int T, n, i, s, p, totals[];
		
		try {
			FileInputStream fistream = new FileInputStream("src/qualification_round/B-small-attempt1.in");
			DataInputStream dis = new DataInputStream(fistream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			
			// Read the number of test cases
			str = br.readLine();
			T = Integer.parseInt(str);
			System.out.println ("Number of test cases:" + T);
			
			// Read the test cases
			for (int tCtr = 0; tCtr < T; tCtr++) {
				
				System.out.print("Case #" + (tCtr+1) + ": ");
				
				// Read each line of input file
				str = br.readLine();
				
				// processInput(str);
				writeFile((tCtr+1), processInput(str));
				
			}
			dis.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File is not found");
		} catch (IOException ioe) {
			System.out.println ("IO Error");
		}
		
	}
	
	private static int processInput (String str) {
		
		int n, s, p, total, quo, rem;
		int res = 0, sur = 0;
		
		String temp[] = str.split(" ");
		n = Integer.parseInt(temp[0]);
		s = Integer.parseInt(temp[1]);
		p = Integer.parseInt(temp[2]);
		
		for (int i = 0; i < n; i++) {
			total = Integer.parseInt(temp[i+3]);
		
			if (total >= p) {
				quo = total / 3;
				rem = total % 3;
				
				if (quo >= p) {
					res++;
				} else if (rem == 2) {
					if ((quo + 1) >= p) {
						res++; 
					} else if ((quo + 2) >= p && sur < s) {
						sur++; res++;
					}
				} else if (rem == 1) {
					if ((quo + 1) >= p) {
						res++;
					}
				} else if (rem == 0) {
					if ((quo + 1) >= p && sur < s) {
						sur++; res++;
					}
				}
			}
		}
		
		System.out.println(res);
		return res;
	}
	
	private static void writeFile (int n, int Res) {
		try {
			FileOutputStream fostream = new FileOutputStream("src/qualification_round/B-small-attempt1.out", true);
			DataOutputStream dos = new DataOutputStream(fostream);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(dos));

			bw.write("Case #" + n + ": " + Res);
			bw.newLine();
			
			bw.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File is not found");
		} catch (IOException ioe) {
			System.out.println ("IO Error");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		readFile();
	}

}
