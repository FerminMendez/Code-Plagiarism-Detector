import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class ProblemB {

	static String inputfile = "B-small2.in";
	static String outputfile = "B-small2.out";

		public static void main(String args[]) throws Exception {
			
			BufferedReader in = new BufferedReader(new FileReader(inputfile));
			PrintWriter out = new PrintWriter(new FileWriter(outputfile));
			String line = in.readLine();
			String[] inputdata =line.split(" ");

			int[] totals = new int[100];
			int TCASES = Integer.parseInt(inputdata[0]);

			for (int i=1;i<=TCASES;i++){

				int max = 0;
				line = in.readLine();
				inputdata =line.split(" ");

				int N = Integer.parseInt(inputdata[0]);
				int S = Integer.parseInt(inputdata[1]);
				int p = Integer.parseInt(inputdata[2]);

				for (int j=0;j<N;j++){
					int t = Integer.parseInt(inputdata[3+j]);
					if (t>=(3*p-2)) {
						max++;
					}
					else if (t>=(3*p-4) && p>=2 && S!=0) {
						max++;
						S--;
					}
				}
				out.println("Case #"+i+": "+max);
			}

			in.close();
			out.flush();
			out.close();

		}
}
