import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Prob3 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		String filePath = "C://Users//Apoorv//Desktop//test1.txt";
		String filePath = "C://Users//Apoorv//Downloads//C-small-attempt0.in";
		BufferedReader br2 = new BufferedReader(new InputStreamReader(
				new DataInputStream(new FileInputStream(filePath))));

		FileWriter fstream = new FileWriter(
				"C://Users//Apoorv//Dropbox//Code//workspace//CodeJam//src//tempAnswer.txt");
		BufferedWriter out = new BufferedWriter(fstream);

		String str = null;
		long count = 0;
		Integer numCases = 0;
		numCases = Integer.parseInt(br2.readLine());
		for (int curCase = 0; curCase < numCases; curCase++) {
			System.out.print("Case #" + (curCase + 1) + ": ");
			out.write("Case #" + (curCase + 1) + ": ");
			str = br2.readLine();
			String[] tokens = str.split(" ");
			
			int num1 = Integer.parseInt(tokens[0]);
			int num2=  Integer.parseInt(tokens[1]);
			int curLength = getLength(num1);
			int countOfPossibilities=0;
			for (Integer curNumber = num1;curNumber<num2;curNumber++){
				String numString1 = curNumber.toString();
				char[] charArray1 = numString1 .toCharArray();
				for(int curIteration = curLength;curIteration>1;curIteration--){
					char[] charArrayBuilding = new char[charArray1.length];
					for(int i=0;i<curLength;i++){
						charArrayBuilding[i] = charArray1[(curIteration-1+i) % (curLength)];	
					}
					StringBuilder g = new StringBuilder();
					for(int i=0;i<charArrayBuilding.length;i++){
//						System.out.print(charArrayBuilding[i]);
						g.append(charArrayBuilding[i]);
					}
//					System.out.print(",");
					
					
					int newNumber=Integer.parseInt(g.toString());
					if(newNumber>curNumber && newNumber<=num2 && getLength(newNumber)==curLength){
						countOfPossibilities++;
						System.out.print(newNumber + ",");
//						out.write(newNumber + ",");
					}
				}
			}
			System.out.println(countOfPossibilities);
			out.write(countOfPossibilities + "\n");
		}
		out.close();
	}

	private static int getLength(int num1) {
		int exponent = 1;
		while(true){
			num1/=10;
			if(num1==0){
				return exponent;
			}
			else
				exponent++;
		}		
	}
}

