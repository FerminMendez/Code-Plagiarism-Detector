import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Problem2 {
	private static HashSet<String> circularSet = new HashSet<String>();
	
	private static void shift(final long orgNumber_,final long numberN_,final long numberM_){
		String orgStr = (""+orgNumber_);
		if(orgStr.length() < 2){
			return;
		}
		
		String retString = null;
		String cirKey = null;
		long shifted = -1;
		for(int i=0;i<orgStr.length();i++){
			retString = orgStr.substring(i+1)+orgStr.substring(0,i+1);
			if(retString.charAt(0) == '0'){
				return;
			}
			
			shifted = Long.parseLong(retString);
			
			if(shifted > 0 && shifted != orgNumber_ && shifted >= numberN_ && shifted <= numberM_){
				cirKey = orgNumber_ < shifted ? orgStr+"_"+shifted : shifted+"_"+orgStr;
				if(!circularSet.contains(cirKey)){
//					System.out.println(cirKey);
					circularSet.add(cirKey);
//				}else{
//					System.out.println(cirKey);
				}
			}
		}
		
		
	}
	
	public static void main(String args[]){
		File inputFile = new File(args[0]);
		File outputFile = new File(args[0]+"_out");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
			int testCases = Integer.parseInt(br.readLine());
			
			String givenNumbers = null;
			for(int i=0;i<testCases;i++){
				givenNumbers = br.readLine();
				StringTokenizer strToken = new StringTokenizer(givenNumbers, " ");
				
				long numberN = Long.parseLong(strToken.nextToken());
				long numberM = Long.parseLong(strToken.nextToken());
				for(long start = numberN ; start <= numberM ; start++){
					shift(start, numberN, numberM);
				}
				
				String result = "Case #"+(i+1)+": "+circularSet.size()+"\n";
				System.out.print(result);
				bw.write(result);
				bw.flush();
				
				circularSet.clear();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
