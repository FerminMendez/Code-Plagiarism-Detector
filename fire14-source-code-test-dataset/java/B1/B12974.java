package hu.hke.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {
	
	static RecycledNumbers rn = new RecycledNumbers();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readAndCalculate(args[0], args[1]);
	}
	private static void readAndCalculate(String inputF, String outputF) {
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			String line = null;
			input =  new BufferedReader(new FileReader(inputF));
			output = new BufferedWriter(new FileWriter(outputF));
			boolean first = true;
			int expectedRows = 0;
			int actualRows = -1;
			while ((( line = input.readLine()) != null) && (actualRows < expectedRows)) {
				System.out.print(actualRows+1);
				System.out.println("----------------------------------------------------");
				if (first) {
					first = false;
					expectedRows = Integer.parseInt(line);
				} else {
					output.write("Case #" +(actualRows+1)+": "+ rn.recicledNumbers(line));
					if (actualRows +1 < expectedRows) {
						output.write("\n");
					}
				}
				actualRows++;
			}
			
			input.close();
			output.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		
	}
	private String recicledNumbers(String line) {
		C c = new C(line);
		return c.calculate();
	}
	
	class C {
		int a;
		int b;
		
		public C(String line) {
			String[] numbers = line.split(" ");
			a = Integer.parseInt(numbers[0]);
			b = Integer.parseInt(numbers[1]);
		}

		public String calculate() {
			int result = 0;
			for (int i = a; i<b; i++) {
				int calculate = calculate(i);
				result += calculate;
			}
			return Integer.toString(result);
		}

		private int calculate(int i) {
			int[] digits = getDigits(i);
			int recycledCount = 0;
			int cycled = 0;
			List<Integer> counted = new ArrayList<Integer>();
			for (int j = 1; j < digits.length; j++) {
				if (digits[j]>=digits[0]) {
					cycled = cycle(digits, j);
					if ( (i<cycled) && (cycled <=b)) {
						if (!counted.contains(cycled)) {
//							System.out.println("i: "+i+" cycled:" +cycled + " digits j:" +digits[j]);
							counted.add(cycled);
							recycledCount++;
						}
					}
				}
			}
			return recycledCount;
		}

		private int cycle(int[] digits, int j) {
			int result = 0;
			int n = 1;
			for (int k= 1; k<=j; k++) {
				result += digits[j-k] *n;
				n = n*10;
			}
			for (int k = j; k<digits.length; k++) {
				result += digits[digits.length - k +j -1 ] *n;
				n = n*10;
			}
			return result;
		}

		private int[] getDigits(int i) {
			// TODO Auto-generated method stub
			int[] result = null;
			int length = 0;
			int n = i;
			while (n!=0) {
				length++;
				n = n/10;
			}
			n = i;
			result = new int[length];
			for (int j = 0; j<length; j++) {
				result[length-j-1] = n%10;
				n = n/10;
			}
			return result;
		}
	}

}
