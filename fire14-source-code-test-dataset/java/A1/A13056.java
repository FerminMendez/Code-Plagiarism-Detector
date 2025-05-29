import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// lets get the data in
			FileInputStream fstream = new FileInputStream("E:/workspace_java/DancingWiththeGooglers/src/input.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			// open file for writing
			FileWriter fwstream = new FileWriter("E:/workspace_java/DancingWiththeGooglers/src/output.out");
			BufferedWriter out = new BufferedWriter(fwstream);
			
			// declare variables
			int i,j;
			int numCases;
			String[] strArr;
			
			// get number of cases
			strLine = br.readLine();
			numCases = Integer.parseInt(strLine);
			
			// declare specific vars
			int numGooglers;
			int numSurprises;
			int surprisesTaken = 0;
			int bestScore;
			ArrayList<Integer> totalScores = new ArrayList<Integer>();
			int tempScore;
			int avg;
			int aboveBest;
			int one = 0, two = 0, three = 0;
			int total;
			
			// loop through cases
			for(i=0;i<numCases;i++){
				// read case
				strLine = br.readLine();
				strArr = strLine.split(" ");
				
				numGooglers = Integer.parseInt(strArr[0]);
				numSurprises = Integer.parseInt(strArr[1]);
				bestScore = Integer.parseInt(strArr[2]);
				
				// reset counter
				aboveBest = 0;
				surprisesTaken = 0;
				
				//System.out.println(bestScore);
				// read total scores
				for(j=1; j<=numGooglers; j++) {
					tempScore = Integer.parseInt(strArr[2+j]);
					avg = (int) Math.floor(tempScore / 3);
					
					if((3 * avg) == tempScore) {
						// our average is evenly split
						one = two = three = avg;
					} else if((3 * avg) == (tempScore - 1)) {
						// we need to increase one digit
						one = two = avg;
						three = avg + 1;
					} else if((3 * avg) == (tempScore - 2)) {
						// we need to increase two digits
						one = avg;
						two = avg + 1;
						three = avg + 1;
					}
					
					
					
					// check if we are above best
					if((one >= bestScore) || (two >= bestScore) || (three >= bestScore)){
						aboveBest++;
					} else if(surprisesTaken < numSurprises && tempScore != 0 && three < 10 && one > 0) {
						// a surprise ultimately is just adding one to the highest and subtract one from lowest
						three += 1;
						one -= 1;
						if(three >= bestScore) {
							aboveBest++;
							surprisesTaken++;
						}
					}
					
					total = one + two + three;
					
					//System.out.println(one + " " + two + " " + three);
				}
				System.out.print("Case #"+(i+1)+": ");
				out.write("Case #"+(i+1)+": ");
				System.out.println(aboveBest);
				out.write(Integer.toString(aboveBest));
				out.newLine();
			}
			
			
			//System.out.print("Case #"+(i+1)+": ");
			//out.write("Case #"+(i+1)+": ");
			//System.out.println(seanP2sum);
			//out.write(Integer.toString(seanP2sum));
			//out.newLine();
			
			
			out.close();
			in.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}
}