import java.io.*;
import java.util.*;

public class Dancing {
	
	class Case{
		int surprises;
		int bestscore;
		int[] scores;
		int counter;

		public Case(int[] input){
			this.surprises = input[1];
			this.bestscore = input[2];
			scores = new int[input[0]];
			System.arraycopy(input, 3, this.scores, 0, scores.length);			
		}

		public int getResult(){

			for(int i=0; i<scores.length; i++){
				//System.out.println(" Score "+scores[i]);
				
				if(bestscore == 0){
					counter++;
					continue;
				}
				else if(bestscore != 0 && scores[i] / bestscore >= 3){
					//System.out.println("success");					
					counter++;
					continue;
				}
				else if((scores[i] - bestscore) >= 0 && (scores[i] - bestscore) % 2 == 0){
					if((scores[i] - bestscore)/2 == bestscore - 1){
						//System.out.println("success");
						counter++;
						continue;
					}
					else if(((scores[i] - bestscore)/2 == bestscore - 2) && (surprises > 0)){
						//System.out.println("success");
						counter++;
						surprises--;
						continue;
					}
				}
				else{
					if(scores[i] - 2 * bestscore >= 0 && (scores[i] - 2 * bestscore) == bestscore - 1){
						//System.out.println("success");
						counter++;
						continue;
					}
					else if(scores[i] - (2 * bestscore) >= 0 && ((scores[i] - (2 * bestscore) + 3) == bestscore) && (surprises > 0)){
						//System.out.println("success");
						counter++;
						surprises--;
						continue;
					}
				}
			}

			return counter;
		}
	}

	public Dancing(String file){
		BufferedReader in = null;
		PrintWriter out = null;

		try{
		    in = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file+"/input.txt"))));
			out = new PrintWriter(new BufferedWriter(new FileWriter(file+"/output.txt")), true);

			int caseId = 1;
			int result = 0;
			String line = null;
			Case c = null;

			in.readLine(); //no of cases

			while ((line = in.readLine()) != null)   {
				c = new Case(getIntArray(line));
				result = c.getResult();
				System.out.println("Case #"+caseId+ ": "+result);
				out.println("Case #"+caseId+ ": "+result);

				caseId++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{ out.close(); } catch(Exception ignored){}
			try{ in.close(); } catch(Exception ignored){}
		}

	}

	public String[] getStringArray(String str){
		return str.split("\\s+");
	}

	public int[] getIntArray(String str){
		String[] sArray = getStringArray(str);
		int[] iArray = new int[sArray.length];
		for(int i=0; i<sArray.length; i++){
			iArray[i] = Integer.parseInt(sArray[i]);
		}

		return iArray;
	}
		
	public static void main(String args[]) throws Exception {
		Dancing obj = new Dancing(args[0]);
	}
	
}