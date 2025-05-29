import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class C {
	
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
		
		private void write(String output) {
			try {
				out.write(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void writeLine(String output) {
			try {
				write(output);
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
			int count = 0;
			int[] line = in.readIntLine();
			for(int num = line[0]; num <= line[1]; num++) {
				int[] possibs = getPossib(num);
				for (int j = 1; j < possibs.length; j++) {
					if(possibs[j] == -1)
						continue;
					if(possibs[j] > num && possibs[j] <= line[1]) {
						count++;
					}
				}
			}
			out.writeLine("Case #" + i + ": " + count);
		}
		in.close();
		out.close();
	}
	
	public int[] getPossib(int num) {	/*returns possibilities*/
		int digit = Integer.toString(num).length();
		int[] possib = new int[digit];
		possib[0] = num;
		for (int i = 1; i < possib.length; i++) {
			int next = possib[i-1];
			int lastd = next%10;
			next = next/10+lastd*exponent(possib.length-1);
			if(!hasSame(next, possib))
				possib[i] = next;
			else possib[i] = -1;
		}
		return possib;
	}
	
	public boolean hasSame(int number, int[] possib) {
		for (int i = 0; i < possib.length; i++) {
			if(number == possib[i])
				return true;
		}
		return false;
	}
	
	private int exponent(int exp) {
		int a = 1;
		for (int i = 0; i < exp; i++) {
			a = a*10;
		}
		return a;
	}
	
	public static void main(String[] args) {
		C m = new C();
		m.process(args);
	}

}
