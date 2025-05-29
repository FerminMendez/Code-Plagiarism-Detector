/**
 *
 * @author amit
 */
import java.io.*;
import java.util.HashSet;
import java.util.Set;
//import java.util.Arrays;
//import java.math.BigInteger;

public class GCJ {

	BufferedReader rin;
	BufferedWriter wout;
	int numCases;

	public String calculate(long A, long B) {
		long count =0;
		for(long i=A;i<B;i++){
			String s = Long.toString(i);
			int Bl = Long.toString(B).length();
			int Al = s.length();
			//System.out.println("\n"+s);
			//System.out.println("\n" + Al + " " + Bl);
			Set<Long> set = new HashSet<Long>();
			for(int k=0;k<=Bl-Al;k++) {

				//System.out.println("\n"+s);

				
				for(int j=0;j<s.length();j++){
					//System.out.println("\nS: " + s);
					s = s.substring(s.length()-1) + s.substring(0, s.length()-1);
					//System.out.println("\nS new: " + s);
					long num = Long.parseLong(s);
					if (num>=A && num<=B && i<num) {
						if(!set.contains(num)) {
							set.add(num);
							//System.out.println("\nCounted: " + i + " " + num);
							count++;
						}
					}

				}
				//System.out.println("\nS newnew: " + s);
				s = "0" + s;
			}
		}
		return Long.toString(count);
	}

	public String getNextInput() {
		try {
			String line = rin.readLine();
			String[] aVars = line.split(" ");
			long A = Long.parseLong(aVars[0]);
			long B = Long.parseLong(aVars[1]);
			return calculate(A,B);

		} catch (IOException e) {
			System.out.println("File Error! Could not read line from file");
		}
		return null;
	}

	public void writeNextOutput(String s) {
		try {
			wout.write(s);
			wout.write("\n");
		} catch (IOException e) {
			System.out.println("Error! Could not write to the file!");
		}
	}

	public GCJ(String s1, String s2) {
		try {
			rin = new BufferedReader(
					new FileReader(s1));
			wout = new BufferedWriter(new FileWriter(s2));
			numCases = Integer.parseInt(rin.readLine());

			for(int i=1; i <= numCases; i++){
				System.out.println("case#" + i);
				String sout = getNextInput();
				sout = "Case #" + Integer.toString(i) + ":" + " " + sout;
				writeNextOutput(sout);
				//System.out.println("case#" + i);
			}
			rin.close();
			wout.close();
		} catch (IOException e) {
			System.out.println("File error");
			System.exit(0);
		}
	}

	public static void main(String[] args) {/*
        if (args.length!=2) {
        System.out.println("Enter input file!");
        System.exit(0);
        }*/
		GCJ a = new GCJ("infile.txt", "out.txt");
	}
}
