import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class RecycledNumbers {

	private static int lowRange = 0, highRange = 0;
	private static ArrayList<Integer> list = null;
	private static ArrayList<Integer> newList = null; 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(
					"C-small-attempt0.in");

			// Convert our input stream to aw
			// DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			
			FileOutputStream out = new FileOutputStream("C-small-attempt0.out");
			PrintStream p = new PrintStream(out);



			int lineNo = 1;
			// Continue to read lines while
			// there are still some left to read
			while (in.available() != 0) {
				if (lineNo == 1) {
					cases(in.readLine(), in, p);
				}
				lineNo++;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void cases(String firstLine, DataInputStream in, PrintStream p)
			throws IOException {
		int casesNo = Integer.parseInt(firstLine);
		for (int i = 0; i < casesNo; i++) {
//			System.out.print("Case #" + (i + 1) + ": ");
			p.print("Case #" + (i + 1) + ": ");
			String line = in.readLine();
			numbers(line, p);
		}

	}

	private static void numbers(String line, PrintStream p) {
		String[] range = line.split(" ");
		lowRange = Integer.parseInt(range[0]);
		highRange = Integer.parseInt(range[1]);
		int[] numbers = new int[highRange - lowRange + 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = lowRange + i;
		}
		list = new ArrayList<Integer>();
		newList = new ArrayList<Integer>();
		int total = recycled(numbers);
//		System.out.println(total);
		p.println(total);
	}

	private static int recycled(int[] numbers) {
		int total = 0;
		int dupliTotal = 0;
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			int length = (int)(Math.log10(num)+1);
			int max = maxTen(length);
			int min = 10;
			while (num/min > 0){
				int rem = num%min;
				int remNum = num/min;
				max /= min;
				int newNum = rem*max + remNum;
				if(newNum>num){
					if (newNum <= highRange && newNum > lowRange) {

						// System.out.println(num + "->" + newNum);
						if (list.contains(num))
							if (newList.get(list.indexOf(num))==newNum)
								dupliTotal++;
						list.add(num);
						newList.add(newNum);
						total++;
					}
				}
				min*=10;
				max = maxTen(length);
			}
		}
		return total-dupliTotal;
	}
	
	private static int maxTen(int length){
		int result = 1;
		int len = (int)(Math.log10(result)+1);
		while(len!=length){
			result*= 10;
			len = (int)(Math.log10(result)+1);
		}
		return result*10;
	}

}
