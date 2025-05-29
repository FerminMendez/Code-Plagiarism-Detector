import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {

	public static void main(String[] args) throws IOException {
		int nCases;
		String filename="B-small-attempt0";
		//String filename="TestB";
		Scanner reader = new Scanner (new FileReader(filename + ".in"));
		PrintWriter writer = new PrintWriter(new FileWriter(filename + ".out"));

		nCases = reader.nextInt();
		for (int i=0; i<nCases; i++){
			writer.print("Case #" + (i+1)+": ");
		
			int nDancers= reader.nextInt();
			int S = reader.nextInt();
			int p = reader.nextInt();
			int out = 0; //output
			
			for (int j=0;j<nDancers;j++){
				int temp = reader.nextInt();
				if (temp > 3*p-3)
					out++;
				else if (S>0 && (temp == 3*p-3 || temp == 3*p-4) && p!=1){
					out ++;
					S--;
				}
			}
			
			writer.println(out);
		}
		writer.flush();

	}

}
