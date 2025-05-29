package qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dancing {

	public static void main(String[] s){
		doIt();
	}

	private static void doIt() {
		Scanner s=null;
		try {s = new Scanner(new File("B-small-attempt0.in"));}
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		PrintWriter out=null;
		try {out = new PrintWriter(new FileWriter("a.out"));} 
		catch (IOException e) {e.printStackTrace();}
		
		int cases=s.nextInt();
		
		for(int idx=0;idx<cases;idx++){
			int number=s.nextInt();
			int surprising=s.nextInt();
			int targetScore=s.nextInt();
			int valid=0;
			for(int idy=0;idy<number;idy++){
				int current=s.nextInt();
				
				if(current%3==0 && current/3>=targetScore) valid++;
				else if(current%3!=0 && current/3+1>=targetScore) valid++;

				else if(surprising>0 && current/3+1==targetScore  && current>1){
					surprising--;
					valid++;
				} 
				else if(surprising>0 && current%3==2 && current/3+2==targetScore){
					surprising--;
					valid++;
				} 
				
			}
			
			int index=idx+1;
			out.println
			("Case #"+index+": "+valid);
		}
		
		
		out.close();
	}
}
