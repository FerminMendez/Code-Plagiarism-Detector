/**
 * 
 */
package pandit.codejam;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author Manu Ram Pandit
 * 
 */
public class DancingWithGooglersUpload {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fStream = new FileInputStream(
				"input.txt");

		Scanner scanner = new Scanner(new BufferedInputStream(fStream));
		Writer out = new OutputStreamWriter(new FileOutputStream("output.txt"));

		int T = scanner.nextInt();
		int N,S,P,ti;
		int counter = 0;
		for (int count = 1; count <= T; count++) {
			N=scanner.nextInt();
			S = scanner.nextInt();
			counter = 0;
			P = scanner.nextInt();
			for(int i=1;i<=N;i++){
				ti=scanner.nextInt();
				if(ti>=(3*P-2)){
					counter++;
					continue;
				}
				else if(S>0){
					if(P>=2 && ((ti==(3*P-3)) ||(ti==(3*P-4)))) {
					S--;
					counter++;
					continue;
					}
				}
				
			}
			// System.out.println("Case #" + count + ": " + counter);
			out.write("Case #" + count + ": " + counter + "\n");
		}
		fStream.close();
		out.close();

	}

}
