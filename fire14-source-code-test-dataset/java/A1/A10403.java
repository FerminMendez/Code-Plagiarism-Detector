import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;


public class Dancing {

	public static void main(String[] args) throws IOException{
		FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String inputCnt = br.readLine();
		FileOutputStream outFile = new FileOutputStream("output.txt");
		DataOutputStream out = new DataOutputStream(outFile);
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(out));

		int cnt = Integer.parseInt(inputCnt);
		for(int line=1;line<=cnt;line++){
			
			String inputString = br.readLine();
			Scanner sc = new Scanner(inputString);
			String outputString = "Case #"+line+": ";
			int numTotal = sc.nextInt();
			int numSuprise = sc.nextInt();
			int p = sc.nextInt();
			int expectNoSuprise = p*3-2;
			int expectWithSuprise = p*3-4;
			if(expectWithSuprise<1)
				expectWithSuprise =1;
			int sumNoSuprise = 0;
			int potential = 0;
			for(int i= 1; i <= numTotal; i++){
				int score = sc.nextInt();
				if(score >= expectNoSuprise){
					sumNoSuprise++;
				}
				else if(score >= expectWithSuprise){
					potential ++;
				}
			}
			int realPotential = Math.min(numSuprise, potential);
			int result = sumNoSuprise+realPotential;
			outputString+=result+"";
			wr.write(outputString);
			wr.newLine();
			wr.flush();

		}
		wr.close();
		out.close();
		br.close();
		in.close();
		fstream.close();
		outFile.close();
	}
}
