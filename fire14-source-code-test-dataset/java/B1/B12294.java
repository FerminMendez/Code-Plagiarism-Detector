import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class RecycledNumbers {

	public static void main(String [] args) throws NumberFormatException, IOException {
		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.FileReader(
						"C:\\Users\\AhmedMTM\\Desktop\\C-small-attempt0.in"));
		int no = Integer.parseInt(r.readLine());
		int[] results = new int[no];
		Arrays.fill(results, 0);
		for (int t = 0; t < no; t++) {
			String[] input = r.readLine().split(" ");

			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			
			for(int j=B; j>A; j--) {
				for(int k=A; k<j; k++) {
					String one = ""+k;
					String two = ""+j;
					if(one.length() == two.length()) {
						for(int l=0; l<one.length(); l++) {
							if(one.equals(two)) {
								//System.out.println(one);
								results[t]++;
							}
							one = one.substring(one.length()-1, one.length())+one.substring(0, one.length()-1);
						}
					}
				}
			}
			
			try {
				FileWriter outFile = new FileWriter(
						"C:\\Users\\AhmedMTM\\Desktop\\output.txt");
				PrintWriter out = new PrintWriter(outFile);
				for (int i = 0; i < results.length; i++) {
					out.println("Case #"+(i+1)+": "+results[i]);
				}

				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		}
	}
}
