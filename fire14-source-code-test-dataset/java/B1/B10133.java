import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int numCase = 0;
		BufferedReader br = null;
		PrintWriter pr = null;

		try {

			br = new BufferedReader(new FileReader(args[0]));
			pr = new PrintWriter(new FileWriter("a.out"));

			numCase = Integer.parseInt(br.readLine());

			String line;
			String[] arr;

			for (int i = 0 ; i < numCase ; i++){

				line = br.readLine();
				arr = line.split(" ");
				String A = arr[0];
				String B = arr[1];
				long Along = Long.parseLong(A);
				long Blong = Long.parseLong(B);

				long count = 0;

				if (A.length() == 1)
					count = 0;
				else {
					for (long Nlong = Along; Nlong < Blong ; Nlong++){
						
						String N = "" + Nlong;
						
						long LastM = -1;
						
						for (int j = 1 ; j < N.length(); j++){
							String M = N.substring(j, N.length())+N.substring(0, j);
							
							long Mlong = Integer.parseInt(M);
							
							if (Mlong > Nlong && Mlong <= Blong && LastM != Mlong){
								count++;
								LastM = Mlong;
							}
						}

					}
				}
				
				pr.println("Case #" + (i+1) + ": " + count);
			}
			pr.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (pr != null)
				pr.close();
			if (br != null)
				br.close();
		}

	}

}