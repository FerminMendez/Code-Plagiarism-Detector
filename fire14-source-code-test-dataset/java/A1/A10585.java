/////     put all imports here    /////////

import java.io.*;
import java.util.*;                // for system.out n stuff
import static java.lang.Math.*;    

///////////////////////////////////////////

public class Dancing {
	public static void main(String[] args) throws FileNotFoundException{
		
		//  handy scanner that everyone uses
		//  nextInt() nextLong() ect. 
	    //  these actually return int and long
		//  happy coding
		Scanner in = new Scanner(System.in);
		
		
		int NumCases = in.nextInt();
		for(int CasesDone=0; CasesDone < NumCases; CasesDone++){
			
			
			
					
			//dont forget to delete the last output from GoogleOut
			System.setOut(new PrintStream(new FileOutputStream("/Users/NathanBreitsch/Desktop/GoogleOut/StoreCreditOut", true)));
			
			
			

			int N = in.nextInt();
			int S = in.nextInt();
			int P = in.nextInt();
			
			int P1 = Math.max(0, P-1);
			int P2 = Math.max(0, P-2);
			
			
			PriorityQueue<Integer> t= new PriorityQueue<Integer>(20, new Comparator<Integer>(){
	            public int compare(Integer o1, Integer o2){
	                return o2 - o1;
	            }
	        });
			
			
			
			for (int i = 0; i < N; i++){
				t.add(in.nextInt());
			}
			
			int sup = 0;
			int max = 0;
			while((sup < S) && (!t.isEmpty())){

				
				
				if (P + 2*(P1) <= t.peek()){
					max++;
				}
				else if(P + 2*(P2) <= t.peek()){
					max ++;
					sup ++;
				}
				
				t.poll();
			}
			
			
			while(! t.isEmpty()){

				
				
				if (P + 2*(P1) <= t.peek()){
					max++;
				}
				
				t.poll();
			}
			
			
			//In Europe, the first floor is numbered zero.
			//But this is America!  Hence the +1
			System.out.print("Case #" + (CasesDone+1) + ": ");
			
			System.out.print(max);
			
			System.out.println();
			
			
		}
	}
}
