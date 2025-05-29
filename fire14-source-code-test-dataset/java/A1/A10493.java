import java.util.*;
import java.io.*;


 class dancing{

	public static void main(String args[])throws FileNotFoundException
	{
		File myFile = new File("B-small-attempt0.in");
		PrintWriter resultFile = new PrintWriter("B-small-attempt0.out");
		Scanner fileRead = new Scanner(myFile);
		int times = fileRead.nextInt();
		fileRead.nextLine();
		int guys;
		int p;
		int s;
		int surp;
		int me;
		int data;
		for(int i = 0; i < times; i++){
			guys = fileRead.nextInt();
			s = fileRead.nextInt();	
			p = fileRead.nextInt();
			surp = 0;
			for(int j = 0; j < guys; j++){
				data = fileRead.nextInt();
				me = data/3;
				if(me >= p){
					surp++;
				}
				else if((me+1) >= p && (3*me + 1) <= data && data >= 1){
					surp++;
				}
				else if(s > 0){
					if((me+1) >= p && data > 1){
						s--;
						surp++;
					}
					else if((me+2) >= p && (3*me + 2) <= data && data >= 2){
						s--;
						surp++;
					}
				
				}
				
			
			}//end for loop
			resultFile.println("Case #" + (i+1) + ": " + surp);
		}//end for loop
		resultFile.close();
	}//end main


}//end class googlerese