package CodeJam;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Recycled_Numbers {

	/**
	 * @param args
	 */
	String rotation(String A, int nRot) {
		String rotA = A.substring(0, nRot);
		A = A.substring(nRot, A.length());
		A = A + rotA;		
		return A;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String outputFile = System.getenv("USERPROFILE")+ "\\Documents\\C-small.out";
		String inputFile = System.getenv("USERPROFILE")	+ "\\Documents\\C-small-attempt1.in";

		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		DataInputStream reader = new DataInputStream(new FileInputStream(inputFile));
		Recycled_Numbers re = new Recycled_Numbers();

		int T = Integer.valueOf(reader.readLine());
		for (int s = 1; s <= T; s++) {
			String line = reader.readLine();

			long A = Long.valueOf(line.substring(0, line.indexOf(" ")));
			long B = Long.valueOf(line.substring(line.indexOf(" ") + 1,line.length()));
			int n = 0;
			
			for (long i = A; i < B; i++) {
				String rot = Long.toString(i);
				String k = rot;

				for (int j = 1; j < rot.length(); j++) {
					k = re.rotation(rot, j);					
					if (k.equals(rot))
						break;
					if ((Long.valueOf(k) >= i) && (Long.valueOf(k) <= B)) {
						n++;						
					}

				}
			}
			writer.write("Case #" + s + ": " + n);
			writer.newLine();
		}
		writer.close();
		reader.close();
	}
}