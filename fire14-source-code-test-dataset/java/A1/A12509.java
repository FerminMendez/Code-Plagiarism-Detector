import java.io.File;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

public class DWTG {
	
	public static void main(String[] args) throws Exception{
		File input = new File("B-small-attempt2.in");
		File output = new File("output.out");
		FileWriter fw = new FileWriter(output);
		Scanner s = new Scanner(input);
		
		int numloops = s.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int n=0; n<numloops; n++){
			sb.append("Case #" + (n+1) + ": ");
			//System.out.println("Case: " + (n+1));
			int numGooglers = s.nextInt();
			int numSurprises = s.nextInt();
			int minscore = s.nextInt();
			int maxwithscore = 0;
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			for(int i=0; i<numGooglers; i++){
				int curnum = s.nextInt();
				
				//System.out.println("Curnum: "+curnum+" ceil: "+Math.ceil(((float)curnum)/3));
				if(Math.ceil(((float)curnum)/3) >= minscore){
					//System.out.println("Added "+Math.ceil(((float)curnum)/3)+" "+minscore);
					maxwithscore++;
					continue;
				}
				
				if(curnum == 0)
					continue;
				
				if((int) Math.ceil(((float)curnum)/3) == curnum/3){
					al.add( (int) Math.ceil(((float)curnum)/3) +1);
					//System.out.println((int) Math.ceil(((float)curnum)/3) +1);
				} else{
					al.add( (int) Math.ceil(((float)curnum)/3));
					//System.out.println( Math.ceil(((float)curnum)/3));
				}
			}
			
			Collections.sort(al);
			Collections.reverse(al);
			
			int i=numSurprises;
			
			while(i>0 && !al.isEmpty()){
				int curnum = al.get(0);
				
				curnum++;
				
				//System.out.println(curnum + " " +minscore);
				
				if(curnum >= minscore){
					maxwithscore++;
				}
				
				al.remove(0);
				i--;
			}
			
			sb.append(maxwithscore + "\n");
		}
		
		fw.write(sb.toString());
		//System.out.println(sb.toString());
		fw.close();
	}
}
