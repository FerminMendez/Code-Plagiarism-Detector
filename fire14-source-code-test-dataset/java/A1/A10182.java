import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Googlers {

	public static void main(String args[]) throws IOException {
		int num = 0;
		int N = 0;
		int number = 1;

		int S = 0;
		int P = 0;
		String[] a = new String[103];

		FileInputStream fstream = new FileInputStream("d:/B-small-attempt2.in");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String readLine;
		readLine = br.readLine();

		num = Integer.valueOf(readLine);
		// System.out.println(num);

		FileWriter fstreamw = new FileWriter("d:/B-small-attempt2.out");
		BufferedWriter out = new BufferedWriter(fstreamw);

		while ((readLine = br.readLine()) != null) {
			int[] b = new int[100];
			a = new String[103];
			int count = 0;
			a = readLine.split(" ");
			N = Integer.valueOf(a[0]);
			S = Integer.valueOf(a[1]);
			P = Integer.valueOf(a[2]);
			for (int i = 0; i < N; i++) {
				b[i] = Integer.valueOf(a[i + 3]);
				// System.out.println(b[i]);
			}
			for (int i = 0; i < N; i++) {
				if(P==0){
					count++;
				}else if((P>0)&&(b[i] - P)>=0){
					
				
				float temp = b[i] - P - P + 1;
				int normal = P - 1;
				int surprise = P - 3;
				if(temp>=normal){
					count++;
				}else if((temp>=surprise)&&(S>0)){
					S--;
					count++;
				}
				}

			}

			out.write("Case #");
			out.write(String.valueOf(number));
			out.write(": ");
			out.write(String.valueOf(count));
			out.write("\r\n");
			number++;

			// System.out.println("count=" + count);
			// System.out.println(-1 / 2.0f);
		}

		out.close();
	}
}
