import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Prob2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String filePath = "C://Users//Apoorv//Downloads//B-small-attempt2.in";
//		String filePath = "C://Users//Apoorv//Desktop//test1.txt";
		BufferedReader br2 = new BufferedReader(new InputStreamReader(
				new DataInputStream(new FileInputStream(filePath))));

		String str = null;
		long count = 0;
		Integer numCases = 0;
		numCases = Integer.parseInt(br2.readLine());
		for (int curCase = 0; curCase < numCases; curCase++) {
			System.out.print("Case #" + (curCase + 1) + ": ");
			Integer answer=0;
			str = br2.readLine();
			String[] tokens = str.split(" ");
			int numGoogle = Integer.parseInt(tokens[0]);
			int numCrazy =  Integer.parseInt(tokens[1]);
			int minScore =  Integer.parseInt(tokens[2]);
			int usedCrazy =0;
			for (int curTotal=0;curTotal<numGoogle;curTotal++){
				int curScore = Integer.parseInt(tokens[3+curTotal]);
				double avgValue = (double)curScore/3.0;
				if(avgValue >= minScore)
					answer++;
				else if(avgValue > (minScore -1))
					answer++;
				else if(usedCrazy < numCrazy && curScore>= minScore && curScore > (3*minScore-5)){
					answer++;
					usedCrazy++;
				}
			}
			System.out.println(answer);
		}
	}
}
