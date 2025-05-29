import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		br.readLine();
		int c = 1;
		for(String s = br.readLine(); s != null ;s = br.readLine()){
			int[] vals = strToInt(s.split(" "));
			int special = 0;
			int possible = 0;
			float score = vals[2];
			for(int i = 3; i < vals.length; i++){
				if(isSpecial(score, vals[i])){
					special++;
				}else if(canBeSpecial(score, vals[i])){
					possible ++;
				}
			}
			
			System.out.println("Case #" + c + ": " + (special + Math.min(possible, vals[1])));
			c++;
		}
		
		
	}
	
	private static boolean isPossible(float s, float num){
		return((num) >= s);
	}
	
	
	private static boolean isSpecial(float s, float num){
		return(isPossible(s, num) && (num/3+1) > s);
	}
	
	private static boolean canBeSpecial(float s, float num){
		return(isPossible(s, num) && (num/3+2) > s + 0.5);
	}
	
	private static int[] strToInt(String[] s){
		int[] ret = new int[s.length];
		for(int i = 0; i < s.length; i++){
			ret[i] = Integer.parseInt(s[i]);
		}
		return ret;
	}
	

}
