import java.io.*;
import java.util.*;

public class Googlers {

	public static int surprise = 0;
	public static int beatTarget = 0;
	
	public static boolean bestScore(int totalScore, int targetScore) {
		
		int bestNoSurprise = (int) Math.ceil(totalScore/3.0);
		
		// If this googler beat the target score
		if(bestNoSurprise>=targetScore) {
			beatTarget += 1;
			return true;
		}
		
		// These are scores that can be a surprise, if there is surprise left
		else if(totalScore%3!=1&&totalScore>1&&totalScore<29&&surprise>0) {
			
			// Test if surprising the score would help
			if(bestNoSurprise<targetScore&&(bestNoSurprise+1)>=targetScore) {
				
				surprise-=1;
				beatTarget += 1;
				return true;
				
			}
	
		}
		
		// These are scores that had no hope
		return true;
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = null;
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileWriter("output.txt"));
			input = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException h) {
			System.out.println("File not found 1");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("File not found 2");
			System.exit(0);
		}
		
		int count = Integer.parseInt(input.nextLine());
		
		
		for(int i=0;i<count;i+=1) {
			String[] line = input.nextLine().split("[ ]+");
			beatTarget = 0;
			int googlers = Integer.parseInt(line[0]);
			surprise = Integer.parseInt(line[1]);
			int targetScore = Integer.parseInt(line[2]);
			
			for(int y=3;y<line.length;y+=1) {
				bestScore(Integer.parseInt(line[y]),targetScore);
			}
			
			output.println("Case #" + (i+1) + ": " + beatTarget);
			
		}
		

		
		
		
		
		output.close();
		

	}

}
