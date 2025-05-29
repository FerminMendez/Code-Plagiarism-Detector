import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class dancing {
	public static void main(String[] args) {
		dancing dance = new dancing();
         dance.readFile("test.txt");
	}

	public void readFile(String filename){
	int i = 1;
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new 
				FileReader(filename));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	String newLine;
		try {
			newLine = reader.readLine();
			while ((newLine = reader.readLine()) != null) {
				evalline(newLine,i);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void evalline(String line,int casenum){
		int len = line.length();
		Scanner sc = new Scanner(line);
		int n = sc.nextInt();
		int s= sc.nextInt();
		int score = sc.nextInt();
		int good = 0;
		int maybe = 0;
		int minscore = 2 * (score-1) + score;
		int minscorespecial = minscore - 2;
		System.out.print("Case #" + casenum + ": ");
		while(sc.hasNextInt()){
			int curr = sc.nextInt();;
			if(curr >= score){
			if(curr >= minscore){
				good++;
			}
			else if(curr >= minscorespecial){
				maybe++;
			}
			}
		}
		int tot = good + Math.min(maybe, s);
		System.out.println(tot);
			
		
	}
}
	
