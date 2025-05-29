import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;


public class DancingWithGooglers {

	public static int isPossible(int score, int pointUnderConsideration, 
					      int surprisingTriplets)
	{
		int twoScore = score - pointUnderConsideration;
		
		if (twoScore < 0) {
			return 0;
		}
		
		// pt_under_con = 4; total score = 24; 8 8 8; 24 - 4 >= 2*4;
		if (twoScore >= pointUnderConsideration * 2) {
			return 1;
		}
		
		// 8 7 7; pt under consideration is 8; 16 - 14 <= 2;
		if ((pointUnderConsideration * 2) - twoScore <= 2) {
			return 1;
		}
		
		if ((pointUnderConsideration * 2) - twoScore  > 2 && 
		    (pointUnderConsideration * 2) - twoScore  <=4 &&
			 surprisingTriplets > 0)
		{
			return 2;
		}
		return 0;
	}
	
	public static int parseTestCase(String line)
	{
		String [] splitLine = line.split(" ");
		
		int numGooglers = Integer.parseInt(splitLine[0]);
		int surprisingTriplets = Integer.parseInt(splitLine[1]);
		int minPt = Integer.parseInt(splitLine[2]);
		
		int toRet = 0;
		
		for (int i = 0 + 3; i < numGooglers + 3; i++) {
			int score = Integer.parseInt(splitLine[i]);
			
			int retValOfFun = DancingWithGooglers.isPossible(score, minPt, surprisingTriplets);
			if (retValOfFun > 0) {
				toRet++;
			}
			if (retValOfFun == 2) {
				surprisingTriplets--;
			} 			
		}
		return toRet;	
	}
	
	public static void main(String [] args) throws IOException
	{
//		System.out.println(DancingWithGooglers.parseTestCase("2 1 1 8 0"));
		
		DataInputStream in = new DataInputStream(System.in);
		
		 
		System.out.println("Enter the input file name : ");
		String fileName = in.readLine();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("c:/gcj/myOp2.txt"));
		
		int numCases = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < numCases; i++) {
			String line = br.readLine();
			bw.write("Case #" + (i+1) + ": " + DancingWithGooglers.parseTestCase(line) + "\n");
		}
		bw.close();
		br.close();
	}
}
 