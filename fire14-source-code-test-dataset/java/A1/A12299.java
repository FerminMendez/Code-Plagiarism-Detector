import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Solution {
	
	boolean debug = true;
	boolean writeToFile = true;
	
	BufferedReader reader = null;
	BufferedWriter writer = null;
	
	public Solution() throws Exception {
		InputStream inputStream;
		if (debug) {
			inputStream = new FileInputStream("in.txt");
		} else { 
			inputStream = System.in;
		}
		reader = new BufferedReader(new InputStreamReader(inputStream));
		
		OutputStream outputStream;
		if (debug && writeToFile) {
			outputStream = new FileOutputStream("out.txt");
		} else {
			outputStream = System.out;
		}
		writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		
		readInput();
		process();
		
		reader.close();
		writer.close();
	}
	
	private void readInput() throws Exception {
		int T = Integer.parseInt(reader.readLine());
		for (int i=0; i<T; i++) {
			String[] line = reader.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int P = Integer.parseInt(line[2]);

			int count = 0;
			int min = P*3 - 2;
			for (int j=0; j<N; j++) {
				int ti = Integer.parseInt(line[3+j]);
				if (ti>=min) {
					count++;
				} else if ((S>0) && (ti>=P) && (ti>=min-2)) {
					S--;
					count++;
				}
			}
			writer.write("Case #" + (i+1) + ": " + count + "\n");
		}
	}
	
	private void process() {
		
	}
	
	public static void main(String[] args) throws Exception {
		new Solution();
	}

}
