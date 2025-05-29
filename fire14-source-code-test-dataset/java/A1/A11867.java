import java.io.*;
import java.math.*;
import java.util.*;

class Main{

	static BufferedReader br;
	static PrintWriter pw;
	static File in;
	static File out;
	static String name="B-small-attempt0";
	
	
	public static void main(String[] args){
		try{
			in=new File(name+".in");
			out=new File(name+".out");
			br=new BufferedReader(new FileReader(in));
			pw=new PrintWriter(new BufferedWriter(new FileWriter(out)));
			
			int nbCase = Integer.parseInt(br.readLine());
			
			
			for (int n=1;n<=nbCase;n++){
				String line=br.readLine();
				
				int googlers=Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line=line.substring(line.indexOf(" ")+1);
				
				int surprise=Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line=line.substring(line.indexOf(" ")+1);
				
				int min=Integer.parseInt(line.substring(0,line.indexOf(" ")));
				line=line.substring(line.indexOf(" ")+1);
				
				int scoreSurprise=min+Math.max(0,min-2)*2;
				int score=min+Math.max(0,min-1)*2;
				
				int count=0;
				for (int i=0;i<googlers;i++){
					int point;
					if (i==googlers-1) point=Integer.parseInt(line);
					else{
						point=Integer.parseInt(line.substring(0,line.indexOf(" ")));
						line=line.substring(line.indexOf(" ")+1);
					}
					
					if (point>=score) count++;
					else{
						if (surprise!=0){
							if (point>=scoreSurprise){
								surprise--;
								count++;
							}
						}
					}
				}
				
				pw.println("Case #"+n+": "+count);
			}
			
			
			pw.flush();
			pw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
