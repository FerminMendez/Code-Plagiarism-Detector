import java.io.*;

public class Dancing{
	
	public static void main(String args[]){
		
		try{
			
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			PrintWriter out = new PrintWriter(args[0] + "_out");
			
			String strLine = br.readLine();
			int cases = Integer.parseInt(strLine);
				
			for (int i = 0; i < cases; i++){
				
				strLine = br.readLine();
				String[] this_literals = strLine.split(" ");
				int[] this_line = new int[this_literals.length];
				for (int j = 0; j < this_literals.length; j++) this_line[j] = Integer.parseInt(this_literals[j]);
				
				int number_of_googlers = this_line[0];
				int number_of_surprises = this_line[1];
				int best_result = this_line[2];
				
				int candidates = 0;
				
				for (int googler = 0; googler < number_of_googlers; googler++){
					
					int unsurprising = 0;
					int surprising = 0;
					
					for (int score1 = 0; score1 <= 10; score1++){
						for (int score2 = 0; score2 <= 10; score2++){
							for (int score3 = 0; score3 <= 10; score3++){
								
								if (score1 + score2 + score3 == this_line[googler+3] &&
									score1 - score2 < 2 && score1 - score2 > -2 &&
									score2 - score3 < 2 && score2 - score3 > -2 &&
									score1 - score3 < 2 && score1 - score3 > -2){ 
									System.out.println("case " + i + " googler " + googler + " score1 " + score1 + " score2 " + score2 + " score3 " + score3);
									if (Math.max(score1,Math.max(score2,score3)) >= best_result) unsurprising++;
									}
									
								if (score1 + score2 + score3 == this_line[googler+3] &&(
									((score1 - score2 == 2 | score1 - score2 == -2) &&
									score2 - score3 < 2 && score2 - score3 > -2 &&
									score1 - score3 < 2 && score1 - score3 > -2)
									|
									(score1 - score2 < 2 && score1 - score2 > -2 &&
									(score2 - score3 == 2 | score2 - score3 == -2) &&
									score1 - score3 < 2 && score1 - score3 > -2)
									|
									(score1 - score2 < 2 && score1 - score2 > -2 &&
									score2 - score3 < 2 && score2 - score3 > -2&&
									(score1 - score3 == 2 | score1 - score3 == -2)))
									
									|
									
									(
									((score1 - score2 == 2 | score1 - score2 == -2) &&
									(score2 - score3 == 2 | score2 - score3 == -2) &&
									score1 - score3 < 2 && score1 - score3 > -2)
									|
									(score1 - score2 < 2 && score1 - score2 > -2 &&
									(score2 - score3 == 2 | score2 - score3 == -2) &&
									(score1 - score3 == 2 | score1 - score3 == -2))
									|
									((score1 - score2 == 2 | score1 - score2 == -2) &&
									score2 - score3 < 2 && score2 - score3 > -2&&
									(score1 - score3 == 2 | score1 - score3 == -2)))){ 
									System.out.println("case " + i + " googler " + googler + " score1 " + score1 + " score2 " + score2 + " score3 " + score3 + "(*)");
									if (Math.max(score1,Math.max(score2,score3)) >= best_result) surprising++;
									}
									
								
							}
						}
					}
					
					if (unsurprising > 0) candidates++;
					else if (surprising > 0 && number_of_surprises > 0){
						candidates++;
						number_of_surprises--;
					}
					
				}
				
				out.println("Case #" + (i+1) + ": " + candidates);
				
				}
				
			
		
			in.close();
			out.close();
			
		}
		
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
	}
		
}
	
