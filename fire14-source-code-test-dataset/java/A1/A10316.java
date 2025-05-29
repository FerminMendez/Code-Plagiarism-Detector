package ProblemB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Common {
	static String filename="C:\\eclipse-jee-indigo-SR2-win32\\eclipse\\projects\\goole codejam 2012\\Qualification\\src\\ProblemB\\B-small-attempt0.in";
	static BufferedReader br;
	
	static String output;
	public static void main (String[] args) throws NumberFormatException, IOException{
		br = new BufferedReader(new FileReader(filename));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\eclipse-jee-indigo-SR2-win32\\eclipse\\projects\\goole codejam 2012\\Qualification\\src\\ProblemB\\output.txt"));
		int n;
		n = Integer.parseInt(br.readLine());
		String[] splitArr;
		int[] input;
		for (int i=1;i<=n;++i){
			splitArr=br.readLine().split(" ");
			input= new int [splitArr.length];
			for (int j=0; j< splitArr.length;++j){
				input[j] = Integer.parseInt(splitArr[j]);
			}
			bw.append("Case #"+i+": "+process(input)+"\n");
			bw.flush();
		}
		bw.close();
	}

	static int process (int[] input){
		int result=0;
		int explicitSurprisesFound=0;
		int limit=input[2]*3-4, surpriseLimit=limit+2;
		boolean notException = 1 != input[2];
		for (int i=3;i<input.length;++i){
			if (limit <= input[i]){
				if (limit <=input[i] && surpriseLimit > input[i]){
					if(notException){
						if(explicitSurprisesFound < input[1]){
							++explicitSurprisesFound;
							++result;
						}
					}
				}else {
					++ result;
				}
			}
		}
		return result;
	}
}
