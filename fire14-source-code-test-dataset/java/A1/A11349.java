import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DancingWithGooglers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner in;
		in = new Scanner(new FileReader("B-small.in"));
		FileWriter output = new FileWriter("B-small.out");
		
		int T = in.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int pass = 0;
			
			for(int j = 1; j <= N; j++) {
				int x = in.nextInt();
				if(p > x) continue;
				int remaining = x-p;
				if( (remaining/2) >= (p-1) ) {
					pass++;
				} else if ( ( (remaining/2) == (p-2) ) && (S > 0) ) {
					pass++;
					S--;
				}
			}
			
			output.write("Case #" + i + ": " + pass + "\n");
		}
		
		in.close();
		output.flush();
		output.close();

	}

}
