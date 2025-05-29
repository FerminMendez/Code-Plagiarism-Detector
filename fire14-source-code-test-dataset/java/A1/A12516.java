import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class B {
	
	private class OutputDelegate {

		BufferedWriter out;
		
		private OutputDelegate(String fileName) {
			try {
				out = new BufferedWriter(new FileWriter(fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void writeLine(String output) {
			try {
				out.write(output);
				out.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void close() {
			try {
		        if (out != null)
		        {
		            out.close();
		        }
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class InputDelegate {

		BufferedReader in;
		
		private InputDelegate(String fileName){
			try {
				in = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private int[] readIntLine() {
			String line;
			String income[] = null;
			try {
				if ((line = in.readLine()) != null) {
					income = line.split(" ");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int array[] = new int[income.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = (Integer.parseInt(income[i]));
			}
			return array;
		}

		private void close() {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void process(String[] args) {
		InputDelegate in = new InputDelegate(args[0]);
		OutputDelegate out = new OutputDelegate(args[1]);
		int cases = in.readIntLine()[0];
		for (int i = 1; i <= cases; i++) {
			int[] line = in.readIntLine();
			int contnum = line[0];
			int surpr = line[1];
			int p = line[2];
			int[] contestants = new int[contnum];
			for (int j = 3; j < line.length; j++) {
				contestants[j-3] = line[j];
			}
			int[] triplets = new int[2];
			triplets[0] = p*3-4;
			triplets[1] = p*3-3;
			int output = 0;
			for (int j = 0; j < contnum; j++) {
				if(contestants[j] == 0) {
					if(p == 0) {
						output++;
						continue;
					}
					else continue;
				}
				if(contestants[j] > triplets[1]) {
					output++;
				} else if(contestants[j] == triplets[0] || contestants[j] == triplets[1]) {
					if(surpr > 0) {
						surpr--;
						output++;
					}
				}
			}
			out.writeLine("Case #" + i + ": " + output);
		}
		in.close();
		out.close();
	}
	
	public static void main(String[] args) {
		B m = new B();
		m.process(args);
	}
	
}
