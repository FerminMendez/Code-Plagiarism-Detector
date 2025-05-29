import java.util.*;
import java.io.*;

public class DancingGooglers {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int count = in.nextInt(); 
		//in.nextLine();
		for(int i=0;i<count;i++){
			int N=in.nextInt();
			int s=in.nextInt();
			int p=in.nextInt();
			int scores[]=new int[N];
			for(int j=0;j<N;j++){
				scores[j]=in.nextInt();
			}
			int max=processOneCase(N,s,p,scores);
			System.out.println("Case #"+(i+1)+": "+max);
		}
		
		
	}
	public static int processOneCase(int N,int s,int p,int[] scores){
		int max=0;
		for(int i=0;i<N;i++){
			int score=scores[i];
			double avg=(double)score/3.0;			
			if(avg>p-1){
				//System.out.println("case 1");
				max++;
			}
			else if(score/3 == p-1 && s!=0){
				if(!(score==0 && p==1))
				{					
				s--;
				max++;
				//System.out.println("case 2");
				}
			}
			else if(avg>p-2 && avg <p-1 && s!=0){
				if(score-3*(score/3) == 2)
				{
					s--;
					max++;
					//System.out.println("case 3");
				}
			}
		}
		
		return max;
	}
	
}
