import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dancing {

	public static int findmax(int N, int S, int p, ArrayList<Integer> googlers){
		int legit = 0;
		int surprise = 0;
		for(int g : googlers){
			if ( g >= (3*p) - 2){
				legit++;
			}
			else if(g > 0 && g >= (3*p) - 4){
				surprise++;
			}
		}
		return legit + Math.min(S, surprise);
	}//Dancing.findmax()


	public static void main(String[] args) throws IOException{

		String inputFile = args[0];
		String outputFile = args[1];
		File file = new File(inputFile);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		
		int numCases = Integer.parseInt(reader.readLine());
		
		for (int i = 1; i <= numCases; i++){
			int caseNumber = i;
			String[] arguments = reader.readLine().split(" ");
			int N = Integer.parseInt(arguments[0]);
			int S = Integer.parseInt(arguments[1]);
			int p = Integer.parseInt(arguments[2]);
			ArrayList<Integer> googlers = new ArrayList<Integer>();
			for(int j = 0; j < N; j++){
				googlers.add(Integer.parseInt(arguments[j+3]));
			}
			
			writer.write("Case #" + caseNumber + ": " + Dancing.findmax(N,S,p,googlers));
			writer.newLine();
		}
		reader.close();
		writer.close();
	}//Dancing.main()
}//Dancing
