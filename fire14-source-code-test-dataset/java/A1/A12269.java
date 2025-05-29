import java.io.*;
import java.util.Scanner;

public class B {

public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
     PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        int noOfCases = sc.nextInt();

for (int caseNum = 0; caseNum < noOfCases; caseNum++){
	int noOfGooglers = sc.nextInt();
	int supprizing = sc.nextInt();
	int bestScore = sc.nextInt();
	int scores[] = new int[noOfGooglers];
	int result = 0;
	for (int i = 0; i < noOfGooglers; i++) {
		scores[i] = sc.nextInt();
	}
	
	int suppLowest = ((bestScore-1)*3)-1;
	int normLowest = (bestScore*3)-2;
	
	for (int i = 0; i < scores.length; i++) {
		if(scores[i]==0){
			if(bestScore==0){
				result++;
			}
		}
		else if(scores[i]>=normLowest){
			result++;
		}
		else if(scores[i]>=suppLowest){
			if(supprizing>0){
				result++;
				supprizing--;
			}
		}
		
	}
	
     pw.print("Case #" + (caseNum + 1) + ": " + result);
     
     if(caseNum < noOfCases-1)
     	pw.println("");
}
     

     pw.flush();
     pw.close();
     sc.close();
}
}

