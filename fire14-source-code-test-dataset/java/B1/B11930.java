import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ProblemC {
	public static void main(String [] args){
		doIt();
	}

	public static void doIt(){

		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("C-small-attempt0.out"));
			FileInputStream fstream = new FileInputStream(new File("C-small-attempt0.in"));
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int testLines = Integer.parseInt(br.readLine());
			int caseCounter = 0;
			while ((strLine = br.readLine()) != null) {
				int possibs = 0;
				String[] str = strLine.split(" ");
				List<Integer> numbers = new ArrayList<Integer>();
				int  small = Integer.parseInt(str[0]);
				int  large = Integer.parseInt(str[1]);
				System.out.println(small + " " + large);
				for (int i = small ; i <= large ; i++){
					numbers.add(i);
				}
				for(int n : numbers){
					int len = String.valueOf(n).length();
					if (len == 1) continue;
					if (len == 2 && (String.valueOf(n)).substring(1, 2) != "0") {
						String strN = (String.valueOf(n)).substring(1, 2) + (String.valueOf(n)).substring(0, 1);
						System.out.println(strN);
						if (n < Integer.parseInt(strN) && Integer.parseInt(strN) <= large){
							possibs++;
						}
					}
					else if (len == 3) {
						String strN = (String.valueOf(n)).substring(2, 3) + (String.valueOf(n)).substring(0, 2);
						if (n < Integer.parseInt(strN) && Integer.parseInt(strN) <= large && (String.valueOf(n)).substring(2, 3) != "0"){
							possibs++;
						}
						String strNN = (String.valueOf(n)).substring(1, 3) + (String.valueOf(n)).substring(0, 1);
						if (n < Integer.parseInt(strNN) && Integer.parseInt(strNN) <= large && (String.valueOf(n)).substring(1, 2) != "0"){
							possibs++;
						}
					}
					else if (len == 4) {
						String strN = (String.valueOf(n)).substring(3, 4) + (String.valueOf(n)).substring(0, 3);
						if (n < Integer.parseInt(strN) && Integer.parseInt(strN) <= large && (String.valueOf(n)).substring(3, 4) != "0"){
							possibs++;
						}
						String strNN = (String.valueOf(n)).substring(2, 4) + (String.valueOf(n)).substring(0, 2);
						if (n < Integer.parseInt(strNN) && Integer.parseInt(strNN) <= large && (String.valueOf(n)).substring(2, 3) != "0"){
							possibs++;
						}
						String strNNN = (String.valueOf(n)).substring(1, 4) + (String.valueOf(n)).substring(0, 1);
						if (n < Integer.parseInt(strNNN) && Integer.parseInt(strNNN) <= large && (String.valueOf(n)).substring(1, 2) != "0"){
							possibs++;
						}
					}
				}
				System.out.println(possibs);
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
