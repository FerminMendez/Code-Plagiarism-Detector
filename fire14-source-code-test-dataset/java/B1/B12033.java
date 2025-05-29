import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;


public class RecycledNumber {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));		
		
		int inputlength = Integer.parseInt(br.readLine());
		String line = null;
		int casenum = 1;
		while( (line = br.readLine()) != null){
			String start = line.split(" ")[0];
			String end = line.split(" ")[1];			
			String output = "Case #"+casenum+": ";
			output += getRecycledNumber(start, end);			
			if(casenum!=inputlength) output+="\n";
			bw.write(output);			
			casenum++;
		}
		bw.close();		
		
	}
	
	public static int getRecycledNumber(String start, String end){
			
		int startnum = Integer.parseInt(start);
		int endnum = Integer.parseInt(end);
		int numofdigit = start.length();
		
		HashSet<String> hs = new HashSet<String>();		
		
		for(int i = startnum; i <=endnum ; i++){
			
			String source = String.valueOf(i);
			String rotated = String.valueOf(i);
			
			int numofrotation = 1;			
			while(numofrotation<numofdigit){				
				rotated = getRotatedString(rotated);								
				if(rotated.charAt(0) != '0' && !source.equals(rotated) && startnum <= Integer.parseInt(rotated) && Integer.parseInt(rotated) <= endnum){					
					if(source.compareTo(rotated)>0){
						hs.add(source+rotated);
					}else{
						hs.add(rotated+source);
					}							
				}				
				numofrotation++;
			}
			
		
		}
				
		return hs.size();
	}
	
	
	public static String getRotatedString(String source){		
		return source.substring(source.length()-1)+source.substring(0, source.length()-1);
	}
	
//	public static int getRecycledNumber2(String start, String end){
//		int startnum = Integer.parseInt(start);
//		int endnum = Integer.parseInt(end);
//		int numofdigit = start.length();
//		
//		int result =0;
//		
//		for (int i = startnum ; i <=endnum ; i++){			
//			for(int j = i+1 ; j <= endnum ; j++){
//				int numofrotation = 1;
//				while(numofrotation<numofdigit){
//					
//					if (j == Integer.parseInt(getRotatedString(String.valueOf(i)))){
//						result++;
//					}
//										
//					numofrotation++;
//				}
//				
//			}			
//		}
//				
//		return result;
//	}
	
}
