import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Dancing {

	private static final String fileInName = "file.in";
	private static final String fileOutname = "file.out";
	
	
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("Init");
		
		FileWriter fw = new FileWriter(fileOutname);
		BufferedReader br = new BufferedReader(new FileReader(fileInName));
		
		
		int numCases = Integer.parseInt(br.readLine());
		System.out.println("Num cases: " + numCases);
		
		for(int numCase = 1; numCase <= numCases; numCase++){
			
			String[] caseIn = br.readLine().split(" ");
			
			int numG = Integer.parseInt(caseIn[0]);
			int numS = Integer.parseInt(caseIn[1]);
			int pScore = Integer.parseInt(caseIn[2]);
			
			System.out.println("\tNumG: " + numG + "\n\tNumS: " + numS + "\n\tpScore: " + pScore);
			
			int[] totalPoints = new int[caseIn.length - 3];
			
			for (int i = 0; i < totalPoints.length; i++){
				totalPoints[i] = Integer.parseInt(caseIn[i + 3]);
			}
			
			for(int i = 0; i < totalPoints.length; i++){
				System.out.println("\t\ti: " + totalPoints[i] + ":: Triplet: " + printArray(calculateTriplet(totalPoints[i])));
			}
			
			int numGBestp = 0;	//Result 
			
			for(int i = 0; i < totalPoints.length; i++){
				
				int[] t = calculateTriplet(totalPoints[i]);
				
				if(withNormalScore(pScore, t)){
					numGBestp++;
				}else if(numS > 0 && withSorpriseScore(pScore, t)){
					numS--;
					numGBestp++;
				}
				
			}
			
			fw.write("Case #" + numCase +": " + numGBestp +"\n");
			
			System.out.println("\tRes: " + numGBestp);
			System.out.println("--------------");
			
		}
		
		br.close();
		fw.close();
		
	}
	
	private static int[] calculateTriplet(int score){
		
		int[] res = new int[3];
		
		int baseScore = score / 3;
		
		int modScore = score % 3;
		
		for(int i = 0; i < res.length; i++){
			
			res[i] = baseScore;
			
			if(modScore > 0){
				res[i] = res[i] + 1;
				modScore--;
			}
			
		}
		return res;
	}
	
	private static boolean withNormalScore(int target, int[] triplet){
		return triplet[0] >= target;
	}
	
	private static boolean withSorpriseScore(int target, int[] triplet){
		
		int a = (triplet[0] + 1);
		
		return a >= target && (a - triplet[1]) < 3 && (triplet[2] - 1) >= 0;
	}
	
	private static String printArray(int[] res){
		String s = "[";
		
		for(int i = 0; i < res.length; i++){
			s+=" " + res[i];
			if(i < res.length - 1){
				s+=",";
			}
		}
		
		return s+"]";
	}
}
