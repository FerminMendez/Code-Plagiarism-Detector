import java.io.*;
import java.util.*;
import java.lang.*;


public class Googlers {
	
	
	private BufferedReader br;
	private int numCases;
	
	public Googlers(String input){
		try{
		FileInputStream fstream = new FileInputStream(input);
		DataInputStream in = new DataInputStream(fstream);
		 br = new BufferedReader(new InputStreamReader(in));
		
		 numCases = Integer.parseInt(br.readLine());
		 
		 for(int i=0;i<numCases;i++){
			 System.out.print("Case #"+(i+1)+": ");
			 this.Calculate(br.readLine());
			 
		 }
				 
		 in.close();
		}
	catch (Exception e){
		  System.err.println("Error: " + e.getMessage());
		  }
	}
	
	public void Calculate(String c){
		StringTokenizer st = new StringTokenizer(c);
		int numDancers = Integer.parseInt(st.nextToken());
		int numSurprising = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[][]scores= new int[numDancers][3];
		int[]totals = new int[numDancers];
		int[]rem= new int[numDancers];
		for(int i=0;i<numDancers;i++)totals[i]=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<numDancers;i++){
			int avg=totals[i]/3;
			rem[i]=totals[i]-(avg*3);
			for(int j=0;j<3;j++)scores[i][j]=avg;
		}
		
		
		for(int i=0;i<numDancers;i++){
			if(rem[i]>0 && totals[i]<30){
				int temp=rem[i];
				if(temp==2){
					if(numSurprising >0){
						if(scores[i][0]+2<=10 && scores[i][0]+2>=p){
						scores[i][0]=scores[i][0]+2;
						numSurprising--;
						
						}
						else{
							scores[i][0]=scores[i][0]+1;
							scores[i][1]=scores[i][1]+1;
							
						}
					}
					else{
						scores[i][0]=scores[i][0]+1;
						scores[i][1]=scores[i][1]+1;
					}
					rem[i]=-1;
				}
				else if(temp==1){
					scores[i][0]=scores[i][0]+1;
					rem[i]=-1;
				}
			}
		}
		
		if(numSurprising >0){
			for(int i=0;i<numDancers;i++){
				if(rem[i]==0 && (scores[i][0]+1)>=p){
					scores[i][0]=scores[i][0]+1;
					scores[i][1]=scores[i][1]-1;
					numSurprising--;
					rem[i]=-1;
					if(numSurprising==0)break;
				}
			}
		}
		
		if(numSurprising >0){
			for(int i=0;i<numDancers;i++){
				if(rem[i]==0){
					scores[i][0]=scores[i][0]+1;
					scores[i][1]=scores[i][1]-1;
					numSurprising--;
					if(numSurprising==0)break;
				}
			}
		}
		
		int count=0;
		for (int i=0;i<numDancers;i++){
			for(int j=0;j<3;j++){
				if(scores[i][j]>=p){
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	
	public static void main(String[] args) {
		
		 Googlers g= new Googlers("input.txt");
			

	}

}
