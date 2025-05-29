
import java.util.*;
import java.io.*;

import javax.xml.ws.handler.MessageContext.Scope;

public class Googlers{
	
	public static List<Integer> processed=new ArrayList<Integer>();
	public static List<Integer> scores;
	
	public static void main(String[] args){
		
		String fn = "C:\\Users\\Ashu\\Desktop\\B-small-attempt0(1).in";
		String fnOut = toFnOut(fn);
		String out=null;
		try{
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new FileReader(fn));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fnOut));
			String line = null;
			int NCase = Integer.valueOf(br.readLine());
			int suprise=0;
			int bestScore=0;
			int noOfGooglers=0;
					
			for(int icase=0;icase<NCase;icase++){
				line=br.readLine();
				scores=new ArrayList<Integer>();
				StringTokenizer st=new StringTokenizer(line);
				if(st.hasMoreTokens()){
					noOfGooglers=Integer.valueOf(st.nextToken());
					suprise=Integer.valueOf(st.nextToken());
					bestScore=Integer.valueOf(st.nextToken());
					for(int i=0;i<noOfGooglers;i++){
						scores.add(Integer.valueOf(st.nextToken()));
					}
				}
				
				int result = findBestScore(suprise,bestScore,scores);
				out = "Case #"+(icase+1)+": "+result;
				System.out.println(out);
				bw.write(out,0,out.length());
				bw.newLine();
			  
			}
			
			br.close();
			bw.close();
			//stdin.close();
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	
	static int findBestScore(int surprise, int bestScore, List<Integer> scores){
		int result=0;
		int surpriseCount=0;
		int minTotalBestScore=(bestScore-1)*3+1;
		if(minTotalBestScore<0){
			result=scores.size();
			return result;
		}
		for(int i=0;i<scores.size();i++){
			if(scores.get(i)>=minTotalBestScore)
				result++;
		}
		if(surprise>0 && (minTotalBestScore-2)>0){
			for(int i=0;i<scores.size();i++){
				if(scores.get(i)>=(minTotalBestScore-2) && scores.get(i)<(minTotalBestScore)){
					result++;
					surpriseCount++;
				}
			
				if(surpriseCount==surprise)
					break;
			}
		}
		return result;
	}
	
	
	static String toFnOut(String fn){
		if(fn.lastIndexOf('.')!=-1){
			return fn.substring(0,fn.lastIndexOf('.'))+".out";
		}else return fn + ".out";
	}
}
