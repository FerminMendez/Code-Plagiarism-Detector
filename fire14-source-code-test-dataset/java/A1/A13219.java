import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Test{	
	int output;
	char[] mapping;
	String line;
	int S;
	int P;
	int[] Ti;
	
	public Test(String line){
		Scanner lineReader = new Scanner(line);
		int N = lineReader.nextInt();
		S = lineReader.nextInt();
		P = lineReader.nextInt();
		Ti = new int[N];
		for (int i = 0; i < N; i++){
			Ti[i] = lineReader.nextInt();
		}
	}
	
	public int getOutput(){
		return output;
	}

	public void solve(){
		for (int x: Ti){
			if(P == 0){
				output++;
			}
			else if((x >= P*3 -2  && x > 0)){
				output++;
			}
			else if(x >= P*3 -4 && S > 0  && x > 0 && P > 1){
				output++;
				S--;
			}
		}
	}
	
	public char translate(char c){
		if (c == ' '){
			return c;
		}
		boolean changeCase = false;
		if(c != Character.toLowerCase(c)){
			c = Character.toLowerCase(c);
			changeCase = true;
		}
		char toReturn = mapping[Character.valueOf(c) - Character.valueOf('a')];
		if(changeCase){
			toReturn = Character.toUpperCase(toReturn);
		}
		return toReturn;
	}
	
}

public class ProblemB {
	
	public static void main(String[] args) throws IOException{
		File inputFile = new File("input.txt");
		Scanner scan = new Scanner(inputFile);
		int loopCount = scan.nextInt();
		scan.nextLine();
		FileWriter outputFile = new FileWriter("output.txt");
		for(int i = 1; i <= loopCount; i++){
			Test start = new Test(scan.nextLine());
			start.solve();
			outputFile.write("Case #"+i+": " + start.getOutput());
			if(i < loopCount){
				outputFile.write("\r\n");
			}
		}
		outputFile.close();
	}
}
