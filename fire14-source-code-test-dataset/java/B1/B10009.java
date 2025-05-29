import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Recycled {

	private static final String fileInName = "file.in";
	private static final String fileOutname = "file.out";
	
	public static void main(String[] args) throws IOException{

		System.out.println("Init");
		
		FileWriter fw = new FileWriter(fileOutname);
		BufferedReader br = new BufferedReader(new FileReader(fileInName));
		
		int numCases = Integer.parseInt(br.readLine());
		System.out.println("Num cases: " + numCases);
		
		for(int numCase = 1; numCase <= numCases; numCase++){
			
			String[] caseData = br.readLine().split(" ");
			
			int numA = Integer.parseInt(caseData[0]);
			int numB = Integer.parseInt(caseData[1]);
			
			Map<String, List<String>> prevCalcs = new HashMap<String, List<String>>();
			
			System.out.println("\tA: " + numA +"  B: " + numB);
			
			int numRec = 0;	//Result
			
			for(int i = numA; i < numB; i++){
				
				String nS = String.valueOf(i);
				
				String mS = null;
				
				for( int j = 1; j < nS.length(); j++){
					
					mS = generateRecycled(nS, j);
					
					if(isValid(nS, mS, numB, prevCalcs)){
						numRec++;
						System.out.println("\t\tRecycled: (" + nS +", " +mS +")");
						addToPrevCalcs(nS, mS, prevCalcs);
					}
					
				}
				
			}
			
			System.out.println("\tRes: " + numRec);
			
			fw.write("Case #" + numCase +": " + numRec +"\n");
			
		}
		
		fw.close();
		br.close();
		
	}
	
	private static String generateRecycled(String n, int numToMove){
		
		return n.substring(n.length() - numToMove, n.length()) + n.substring(0, n.length() - numToMove);
		
	}
	
	private static boolean isValid(String nS, String mS, int numB, Map<String, List<String>> map){
		return !mS.startsWith("0") && Integer.parseInt(nS) < Integer.parseInt(mS) 
				&& numB >= Integer.parseInt(mS) && (!map.containsKey(nS) || !map.get(nS).contains(mS));
	}
	
	private static void addToPrevCalcs(String nS, String mS, Map<String, List<String>> map){

		if(!map.containsKey(nS)){
			map.put(nS, new ArrayList<String>());
		}
		
		map.get(nS).add(mS);
		
	}
	
}
