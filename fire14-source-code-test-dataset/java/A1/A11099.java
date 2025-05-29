import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Dashboard {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		caseHandler ch = new caseHandler(2, 1, 1, new int[]{8,0});
		System.out.println(ch.solveCase());
		*/
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter("anwser.txt"));
			
			int numTestCases = Integer.parseInt(br.readLine());
			for(int i=0;i<numTestCases;i++){
				String[] currLine = br.readLine().split(" ");
				int N = Integer.parseInt(currLine[0]);
				int S = Integer.parseInt(currLine[1]);
				int P = Integer.parseInt(currLine[2]);
				int[] scores = new int[currLine.length-3];
				for(int j=3; j<currLine.length;j++){
					scores[j-3] = Integer.parseInt(currLine[j]);
				}
				caseHandler ch = new caseHandler(N, S, P, scores);
				//System.out.println("Case #"+(i+1)+": "+ch.solveCase());
				bw.write("Case #"+(i+1)+": "+ch.solveCase());
				bw.newLine();
			}
			bw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
