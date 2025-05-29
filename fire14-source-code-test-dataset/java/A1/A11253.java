import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Dance {
	
public static int[][] JudgedScores(int a){
	
	int div=a/3;
	int[][] Demo=new int[1][3];
	
	
	if(a==0) { Demo[0][0]=0; Demo[0][1]=0; Demo[0][2]=0;
	
	}
	else {Demo[0][0]=div; Demo[0][1]=div; Demo[0][2]=div;
	
	if(Demo[0][0]+Demo[0][1]+Demo[0][2]==a){} else {Demo[0][0]=Demo[0][0]+1;}
	if(Demo[0][0]+Demo[0][1]+Demo[0][2]==a){} else {Demo[0][1]=Demo[0][1]+1;}
	}
	
	
	return Demo;
}

public static int[][] SurpriseCheck(int a,int b,int[][] c){
	
	int surprisesAllowed=a;
	int bestNo=b;
	int [][] googlerScores=c;
	
	if(surprisesAllowed==0 || bestNo==0 || bestNo==1) return googlerScores;
	else{
		int surprisesDone=0;
		
		for(int i=0;i<googlerScores.length;i++){
			int[][] Demo=new int[1][3];
			Demo[0][0]=googlerScores[i][0];
			Demo[0][1]=googlerScores[i][1];
			Demo[0][2]=googlerScores[i][2];
			
			int flag=0;
			
			if(Demo[0][0]>=bestNo) {flag=1;}
			else if(Demo[0][1]>=bestNo) {flag=1;}
			else if(Demo[0][2]>=bestNo) {flag=1;}
			
			else if(flag==0){
				
				Demo[0][0]=Demo[0][0]+1; Demo[0][1]=Demo[0][1]-1;
				if(Demo[0][0]-Demo[0][1]>2 || Demo[0][0]-Demo[0][1]<-2 || Demo[0][0]-Demo[0][2]>2 || Demo[0][0]-Demo[0][2]<-2){
					
					Demo[0][0]=Demo[0][0]-1; Demo[0][1]=Demo[0][1]+1;
				}
				else{
					
					if(Demo[0][0]==bestNo)
					{flag=1;}
					
					else {Demo[0][0]=Demo[0][0]-1;  Demo[0][1]=Demo[0][1]+1;  }
					
				}
				
	if(flag==0){
					
		Demo[0][0]=Demo[0][0]+1; Demo[0][1]=Demo[0][2]-1;
		if(Demo[0][0]-Demo[0][1]>2 || Demo[0][0]-Demo[0][1]<-2 || Demo[0][0]-Demo[0][2]>2 || Demo[0][0]-Demo[0][2]<-2){
			
			Demo[0][0]=Demo[0][0]-1;  Demo[0][2]=Demo[0][2]+1;
		}
		else{
			
			if(Demo[0][0]==bestNo)
			flag=1;
			
			else {Demo[0][0]=Demo[0][0]-1; Demo[0][2]=Demo[0][2]+1;}
			
		}
					}
				
				
				if(flag==0){
					
					Demo[0][0]=Demo[0][0]+2; Demo[0][1]=Demo[0][1]-1; Demo[0][2]=Demo[0][2]-1;
					if(Demo[0][0]-Demo[0][1]>2 || Demo[0][0]-Demo[0][1]<-2 || Demo[0][0]-Demo[0][2]>2 || Demo[0][0]-Demo[0][2]<-2){
						
						Demo[0][0]=Demo[0][0]-2;Demo[0][1]=Demo[0][1]+1; Demo[0][2]=Demo[0][2]+1;
					}
					else{
						
						if(Demo[0][0]==bestNo)
						flag=1;
					
						else{ Demo[0][0]=Demo[0][0]-2; Demo[0][1]=Demo[0][1]+1; Demo[0][2]=Demo[0][2]+1;}
						
					}
					}
			
				
if(flag==0){
					
					Demo[0][1]=Demo[0][1]+1; Demo[0][0]=Demo[0][0]-1;
					if(Demo[0][1]-Demo[0][0]>2 || Demo[0][1]-Demo[0][0]<-2 || Demo[0][1]-Demo[0][2]>2 || Demo[0][1]-Demo[0][2]<-2){
						
						Demo[0][1]=Demo[0][1]-1;Demo[0][0]=Demo[0][0]+1;
					}
					else{
						
						if(Demo[0][1]==bestNo)
						flag=1;
						
						else {Demo[0][1]=Demo[0][1]-1;Demo[0][0]=Demo[0][0]+1;}
						
					}
					}

if(flag==0){
	
	Demo[0][1]=Demo[0][1]+1; Demo[0][2]=Demo[0][2]-1;
	if(Demo[0][1]-Demo[0][0]>2 || Demo[0][1]-Demo[0][0]<-2 || Demo[0][1]-Demo[0][2]>2 || Demo[0][1]-Demo[0][2]<-2){
		
		Demo[0][1]=Demo[0][1]-1;Demo[0][2]=Demo[0][2]+1;
	}
	else{
		
		if(Demo[0][1]==bestNo)
		flag=1;
		
		else {Demo[0][1]=Demo[0][1]-1;Demo[0][2]=Demo[0][2]+1;}
		
	}
	}

if(flag==0){
	
	Demo[0][1]=Demo[0][1]+2; Demo[0][0]=Demo[0][0]-1;Demo[0][2]=Demo[0][2]-1;
	if(Demo[0][1]-Demo[0][0]>2 || Demo[0][1]-Demo[0][0]<-2 || Demo[0][1]-Demo[0][2]>2 || Demo[0][1]-Demo[0][2]<-2){
		
		Demo[0][1]=Demo[0][1]-2; Demo[0][0]=Demo[0][0]+1;Demo[0][2]=Demo[0][2]+1;
	}
	else{
		
		if(Demo[0][1]==bestNo)
		flag=1;
		
		else {Demo[0][1]=Demo[0][1]-2;Demo[0][0]=Demo[0][0]+1;Demo[0][2]=Demo[0][2]+1;}
		
	}
	}
if(flag==0){
	
	Demo[0][2]=Demo[0][2]+1; Demo[0][0]=Demo[0][0]-1;
	if(Demo[0][2]-Demo[0][0]>2 || Demo[0][2]-Demo[0][0]<-2 || Demo[0][1]-Demo[0][2]>2 || Demo[0][1]-Demo[0][2]<-2){
		
		Demo[0][2]=Demo[0][2]-1;Demo[0][0]=Demo[0][0]+1;
	}
	else{
		
		if(Demo[0][2]==bestNo)
		flag=1;
		
		else {Demo[0][2]=Demo[0][2]-1;Demo[0][0]=Demo[0][0]+1;}
		
		}
	}

if(flag==0){
	
	Demo[0][2]=Demo[0][2]+1; Demo[0][1]=Demo[0][1]-1;
	if(Demo[0][2]-Demo[0][0]>2 || Demo[0][2]-Demo[0][0]<-2 || Demo[0][1]-Demo[0][2]>2 || Demo[0][1]-Demo[0][2]<-2){
		
		Demo[0][2]=Demo[0][2]-1;Demo[0][1]=Demo[0][1]+1;
	}
	else{
		
		if(Demo[0][2]==bestNo)
		flag=1;
		
		else {Demo[0][2]=Demo[0][2]-1;Demo[0][1]=Demo[0][1]+1;}
		
		}
	}

if(flag==0){
	
	Demo[0][2]=Demo[0][2]+1;Demo[0][0]=Demo[0][0]-1;Demo[0][1]=Demo[0][1]-1;
	if(Demo[0][2]-Demo[0][0]>2 || Demo[0][2]-Demo[0][0]<-2 || Demo[0][1]-Demo[0][2]>2 || Demo[0][1]-Demo[0][2]<-2){
		
		Demo[0][2]=Demo[0][2]-1;Demo[0][0]=Demo[0][0]+1;Demo[0][1]=Demo[0][1]+1;
	}
	else{
		
		if(Demo[0][2]==bestNo)
		flag=1;
		
		else {Demo[0][2]=Demo[0][2]-1;Demo[0][0]=Demo[0][0]+1;Demo[0][1]=Demo[0][1]+1;}
		
	}
	}


if(flag==1) surprisesDone=surprisesDone+1;
				
			}	
			
			googlerScores[i][0]=Demo[0][0];
			googlerScores[i][1]=Demo[0][1];
			googlerScores[i][2]=Demo[0][2];
			
			if(surprisesDone==surprisesAllowed){return googlerScores;}
			}
		
	
		
	}
	
	return googlerScores;
}
	

public static int checkResult(){
	
	return 0;

}
	public static void main(String args[]) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Faisal/Downloads/B-small-attempt0.in")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("B-small-attempt0.in")));
		String line = reader.readLine();
		int k = Integer.parseInt(line);
		int count=1;
		for(int i = 0 ; i < k ; i ++){
			line = reader.readLine();
		
		String[] newLine=line.split(" ");
			
			
			
			
			System.out.println(count);
			count++;
			int noOfGooglers=Integer.parseInt(newLine[0]); System.out.println("noOfGooglers "+noOfGooglers);
			int surprises=Integer.parseInt(newLine[1]);
			int bestNo=Integer.parseInt(newLine[2]);
			int[] totalScores=new int[noOfGooglers]; 
			
			for(int j=3,n=0;j<newLine.length;j++,n++){
				totalScores[n]=Integer.parseInt(newLine[j]);
				System.out.println("totalScores "+totalScores[n]);
				
		    }
			
			int [][] googlerScores=new int[noOfGooglers][3];
			
			for(int j=0;j<totalScores.length;j++){
				
				int[][] Demo=JudgedScores(totalScores[j]);
				googlerScores[j][0]=Demo[0][0];
				googlerScores[j][1]=Demo[0][1];
				googlerScores[j][2]=Demo[0][2];
				
			}
			
			googlerScores=SurpriseCheck(surprises,bestNo,googlerScores);
			int result=0;
			for(int h=0;h<googlerScores.length;h++){
				if(googlerScores[h][0]>=bestNo || googlerScores[h][0]>=bestNo || googlerScores[h][0]>=bestNo ){
					
					result++;
					
				}
			}
			
			
	       
			int Case=i+1;
	        writer.write("Case #" + Case + ": ");
		    writer.write(Integer.toString(result)); 
	       if(Case==k){} else{writer.write("\n"); }
   
			
		}
		reader.close();
		writer.close();
	}

}

