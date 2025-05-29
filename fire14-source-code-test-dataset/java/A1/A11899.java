import java.io.*;
import java.util.*;

public class B{
	public static ArrayList<Case> cases = new ArrayList<Case>();
	public static void main (String [] args){
		
		parseFile();
		for(int i=0; i<cases.size(); i++){
			//System.out.print(cases.get(i).n +" ");
			//System.out.print(cases.get(i).s +" ");
			//System.out.print(cases.get(i).p +" ");
			//for(int j=0; j< cases.get(i).totals.size(); j++){
				//System.out.print(cases.get(i).totals.get(j) + " ");
			//}
			System.out.println("Case #" +(i+1)+": " + play(cases.get(i)));
		}
		
	}
	
	static void parseFile(){
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("b-small.in"));
			int caseCnt = Integer.parseInt(br.readLine());
			ArrayList<String> al = null;
			StringTokenizer st = null;
			
			for(int i=0; i<caseCnt; i++){
				al = new ArrayList<String>();
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					al.add(st.nextToken());
				}
				
				Case c = new Case();
				c.n = Integer.parseInt(al.get(0));
				c.s = Integer.parseInt(al.get(1));
				c.p = Integer.parseInt(al.get(2));				
				for(int j=3; j<al.size(); j++){
					c.totals.add(al.get(j));
				}
				cases.add(c);
			}
		}catch(IOException ioe){
			try{br.close();}catch(Exception e){}
		}
	}
	
	static int play(Case c){
		int nLimit = c.p *3 - 2;
		if(nLimit < 0){nLimit = 0;}

		int ans = 0;
		//System.out.println("nLimit="+nLimit);
		for(int i=0; i<c.totals.size(); i++){
			int total = Integer.parseInt(c.totals.get(i));
			if (c.p ==0){ans ++; continue;}
			if (c.p >0 && total == 0){continue;}
			if(c.p ==1 && total>0){ans ++; continue;}
			//System.out.println("total="+total);
			if(total>= nLimit){
				ans ++;
			}else if((total == (nLimit-1))||(total == (nLimit-2))){
				if (c.s <=0){
				}else{
					ans ++;
					c.s --;
				}
			}
		}
		return ans;
	}
	
	static class Case{
		int n;
		int s;
		int p;
		ArrayList<String> totals = new ArrayList <String>();
	}
} 
