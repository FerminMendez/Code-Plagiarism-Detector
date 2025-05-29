import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class ProblemB {
	public static void main(String [] args){
		doIt();
	}

	public static void doIt(){

		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("B-small-attempt5.out"));
			FileInputStream fstream = new FileInputStream(new File("B-small-attempt5.in"));
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int testLines = Integer.parseInt(br.readLine());
			int caseCounter = 0;
			while ((strLine = br.readLine()) != null) {
				int possibs = 0;
				String[] str = strLine.split(" ");
				int  n = Integer.parseInt(str[0]);
				int  s = Integer.parseInt(str[1]);
				int  p = Integer.parseInt(str[2]);
				for (int i = 3 ; i < str.length ; i++) {
					int score = Integer.parseInt(str[i]);
 					if(score >= (3*p -2)){
						possibs++;
					} else if(s > 0 && score >= (3*p -4) && score >= 2){
						s--;
						possibs++;
					}
				}
				caseCounter++;
				out.write("Case #" + caseCounter + ": " + possibs);
				out.newLine();
			}
			in.close();
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
