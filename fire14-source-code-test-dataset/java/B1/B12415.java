import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;


public class Recycle {
	
	public static void main(String[] args) throws IOException {
		long time = System.currentTimeMillis();
		File iFile = new File("A-large-practice.in");
		BufferedReader in= new BufferedReader(new FileReader(iFile));
		
		File oFile = new File("A-large-practice.out");
		FileOutputStream fos = new FileOutputStream(oFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		PrintStream out = new PrintStream(bos);
			
		int numCases = Integer.parseInt(in.readLine());
		
		for(int i=0; i<numCases; i++){
			String[] inputString = in.readLine().split(" ");
			int A = Integer.parseInt(inputString[0]);
			int B = Integer.parseInt(inputString[1]);
			
			int result = recycle(A, B);
			
			System.out.println("Case #"+(i+1)+": "+result);
			out.println("Case #"+(i+1)+": "+result);
		}
		
		
		long duration = System.currentTimeMillis() - time;
		System.out.println(duration+"ms taken");
		out.close();
	}
	
	private static int recycle(int A, int B){
		int result = 0;
		
		for(int i=A; i<B; i++){
			result += recycleNumber(i, B);
		}
		return result;
	}
	
	private static int recycleNumber(int i, int B){
		String iRep = Integer.toString(i);

		Set<String> possibleMs = new HashSet<String>();
		for(int rotate=1; rotate<iRep.length(); rotate++){
			String thisRot = iRep.substring(rotate)+ iRep.substring(0, rotate);
			int thisNum = Integer.parseInt(thisRot);
			if(thisNum > i && thisNum<=B){
				possibleMs.add(thisRot);
			}
		}
		
		return possibleMs.size();
	}
}