import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Q2 {

	public static void readFile() {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("Q2-Small");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	static int surpriseCount = 0;
	static int S = 0;

	static boolean isGreater(int totalNumbers, int p) {
		int single = totalNumbers/3;
		if(single>=p) {
			return true;
		}
		int remainder = totalNumbers%3;
		if(remainder==1) {
			single++;
			if(single>=p) {
				return true;
			}
			return false;
		}
		if(remainder==2) {
			single++;
			if(single>=p) {
				return true;
			}
			if(surpriseCount<S && single>0) {
				single++;
				if(single>=p) {
					surpriseCount++;
					return true;
				}
			}
			return false;
		}
		if(remainder==0) {
			if(surpriseCount<S && single>0) {
				single++;
				if(single>=p) {
					surpriseCount++;
					return true;
				}
			}
			return false;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println("Hello");
		try{

			File file = new File("Q2_Small_Answer.out");
			PrintStream output = new PrintStream(file);


			Scanner scanner = new Scanner(new File("Q2-Small"));
			int numberOfCases = scanner.nextInt();
			//		System.out.println(numberOfCases);
			int greaterCount = 0;
			for (int c = 0;c<numberOfCases;c++)   {
				int N = scanner.nextInt();
				//			System.out.println(N);
				S = scanner.nextInt();
				//			System.out.println(S);
				int p = scanner.nextInt();
				//			System.out.println(p);
				greaterCount = 0;
				surpriseCount = 0;
				for (int i = 0;i<N;i++)   {
					int totalNumbers = scanner.nextInt();
					//				System.out.print(totalNumbers+", ");
					if(isGreater(totalNumbers, p)) {
						//					System.out.println("YES");
						greaterCount ++;
					} else {
						//					System.out.println("NO");
					}
				}
//				System.out.println("Case #"+(c+1)+": "+greaterCount);
				output.println("Case #"+(c+1)+": "+greaterCount);
			}
			output.close();
			System.out.println("Your file has been written");  			

			/*

			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("Q2-Small");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line

//			strLine = br.readLine();
			int numberOfCases = in.readInt();//Integer.parseInt(strLine);
			System.out.println(numberOfCases);
			for (int i = 0;i<numberOfCases;i++)   {
				int n = in.readInt();
				System.out.println(n);
			}
			//Close the input stream
			in.close();*/
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}	
}
