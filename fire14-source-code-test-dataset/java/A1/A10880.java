package com.nigel.codejam;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class GoogleDance {
	
public static int[][] gudjedScores(int a){
	
	int div=a/3;
	int[][] tempArray=new int[1][3];
	
	
	if(a==0) { tempArray[0][0]=0; tempArray[0][1]=0; tempArray[0][2]=0;
	
	}
	else {tempArray[0][0]=div; tempArray[0][1]=div; tempArray[0][2]=div;
	
	if(tempArray[0][0]+tempArray[0][1]+tempArray[0][2]==a){} else {tempArray[0][0]=tempArray[0][0]+1;}
	if(tempArray[0][0]+tempArray[0][1]+tempArray[0][2]==a){} else {tempArray[0][1]=tempArray[0][1]+1;}
	}
	
	
	return tempArray;
}

public static int[][] supriseArray(int a,int b,int[][] c){
	
	int surprisesAllowed=a;
	int bestNo=b;
	int [][] googlerScores=c;
	
	if(surprisesAllowed==0 || bestNo==0 || bestNo==1) return googlerScores;
	else{
		int surprisesDone=0;
		
		for(int i=0;i<googlerScores.length;i++){
			int[][] tempArray=new int[1][3];
			tempArray[0][0]=googlerScores[i][0];
			tempArray[0][1]=googlerScores[i][1];
			tempArray[0][2]=googlerScores[i][2];
			
			int flag=0;
			
			if(tempArray[0][0]>=bestNo) {flag=1;}
			else if(tempArray[0][1]>=bestNo) {flag=1;}
			else if(tempArray[0][2]>=bestNo) {flag=1;}
			
			else if(flag==0){
				
				tempArray[0][0]=tempArray[0][0]+1; tempArray[0][1]=tempArray[0][1]-1;
				if(tempArray[0][0]-tempArray[0][1]>2 || tempArray[0][0]-tempArray[0][1]<-2 || tempArray[0][0]-tempArray[0][2]>2 || tempArray[0][0]-tempArray[0][2]<-2){
					
					tempArray[0][0]=tempArray[0][0]-1; tempArray[0][1]=tempArray[0][1]+1;
				}
				else{
					
					if(tempArray[0][0]==bestNo)
					{flag=1;}
					
					else {tempArray[0][0]=tempArray[0][0]-1;  tempArray[0][1]=tempArray[0][1]+1;  }
					
				}
				
	if(flag==0){
					
		tempArray[0][0]=tempArray[0][0]+1; tempArray[0][1]=tempArray[0][2]-1;
		if(tempArray[0][0]-tempArray[0][1]>2 || tempArray[0][0]-tempArray[0][1]<-2 || tempArray[0][0]-tempArray[0][2]>2 || tempArray[0][0]-tempArray[0][2]<-2){
			
			tempArray[0][0]=tempArray[0][0]-1;  tempArray[0][2]=tempArray[0][2]+1;
		}
		else{
			
			if(tempArray[0][0]==bestNo)
			flag=1;
			
			else {tempArray[0][0]=tempArray[0][0]-1; tempArray[0][2]=tempArray[0][2]+1;}
			
		}
					}
				
				
				if(flag==0){
					
					tempArray[0][0]=tempArray[0][0]+2; tempArray[0][1]=tempArray[0][1]-1; tempArray[0][2]=tempArray[0][2]-1;
					if(tempArray[0][0]-tempArray[0][1]>2 || tempArray[0][0]-tempArray[0][1]<-2 || tempArray[0][0]-tempArray[0][2]>2 || tempArray[0][0]-tempArray[0][2]<-2){
						
						tempArray[0][0]=tempArray[0][0]-2;tempArray[0][1]=tempArray[0][1]+1; tempArray[0][2]=tempArray[0][2]+1;
					}
					else{
						
						if(tempArray[0][0]==bestNo)
						flag=1;
					
						else{ tempArray[0][0]=tempArray[0][0]-2; tempArray[0][1]=tempArray[0][1]+1; tempArray[0][2]=tempArray[0][2]+1;}
						
					}
					}
				//----------------------------------
				
if(flag==0){
					
					tempArray[0][1]=tempArray[0][1]+1; tempArray[0][0]=tempArray[0][0]-1;
					if(tempArray[0][1]-tempArray[0][0]>2 || tempArray[0][1]-tempArray[0][0]<-2 || tempArray[0][1]-tempArray[0][2]>2 || tempArray[0][1]-tempArray[0][2]<-2){
						
						tempArray[0][1]=tempArray[0][1]-1;tempArray[0][0]=tempArray[0][0]+1;
					}
					else{
						
						if(tempArray[0][1]==bestNo)
						flag=1;
						
						else {tempArray[0][1]=tempArray[0][1]-1;tempArray[0][0]=tempArray[0][0]+1;}
						
					}
					}

if(flag==0){
	
	tempArray[0][1]=tempArray[0][1]+1; tempArray[0][2]=tempArray[0][2]-1;
	if(tempArray[0][1]-tempArray[0][0]>2 || tempArray[0][1]-tempArray[0][0]<-2 || tempArray[0][1]-tempArray[0][2]>2 || tempArray[0][1]-tempArray[0][2]<-2){
		
		tempArray[0][1]=tempArray[0][1]-1;tempArray[0][2]=tempArray[0][2]+1;
	}
	else{
		
		if(tempArray[0][1]==bestNo)
		flag=1;
		
		else {tempArray[0][1]=tempArray[0][1]-1;tempArray[0][2]=tempArray[0][2]+1;}
		
	}
	}

if(flag==0){
	
	tempArray[0][1]=tempArray[0][1]+2; tempArray[0][0]=tempArray[0][0]-1;tempArray[0][2]=tempArray[0][2]-1;
	if(tempArray[0][1]-tempArray[0][0]>2 || tempArray[0][1]-tempArray[0][0]<-2 || tempArray[0][1]-tempArray[0][2]>2 || tempArray[0][1]-tempArray[0][2]<-2){
		
		tempArray[0][1]=tempArray[0][1]-2; tempArray[0][0]=tempArray[0][0]+1;tempArray[0][2]=tempArray[0][2]+1;
	}
	else{
		
		if(tempArray[0][1]==bestNo)
		flag=1;
		
		else {tempArray[0][1]=tempArray[0][1]-2;tempArray[0][0]=tempArray[0][0]+1;tempArray[0][2]=tempArray[0][2]+1;}
		
	}
	}
//----------------------------------
if(flag==0){
	
	tempArray[0][2]=tempArray[0][2]+1; tempArray[0][0]=tempArray[0][0]-1;
	if(tempArray[0][2]-tempArray[0][0]>2 || tempArray[0][2]-tempArray[0][0]<-2 || tempArray[0][1]-tempArray[0][2]>2 || tempArray[0][1]-tempArray[0][2]<-2){
		
		tempArray[0][2]=tempArray[0][2]-1;tempArray[0][0]=tempArray[0][0]+1;
	}
	else{
		
		if(tempArray[0][2]==bestNo)
		flag=1;
		
		else {tempArray[0][2]=tempArray[0][2]-1;tempArray[0][0]=tempArray[0][0]+1;}
		
		}
	}

if(flag==0){
	
	tempArray[0][2]=tempArray[0][2]+1; tempArray[0][1]=tempArray[0][1]-1;
	if(tempArray[0][2]-tempArray[0][0]>2 || tempArray[0][2]-tempArray[0][0]<-2 || tempArray[0][1]-tempArray[0][2]>2 || tempArray[0][1]-tempArray[0][2]<-2){
		
		tempArray[0][2]=tempArray[0][2]-1;tempArray[0][1]=tempArray[0][1]+1;
	}
	else{
		
		if(tempArray[0][2]==bestNo)
		flag=1;
		
		else {tempArray[0][2]=tempArray[0][2]-1;tempArray[0][1]=tempArray[0][1]+1;}
		
		}
	}

if(flag==0){
	
	tempArray[0][2]=tempArray[0][2]+1;tempArray[0][0]=tempArray[0][0]-1;tempArray[0][1]=tempArray[0][1]-1;
	if(tempArray[0][2]-tempArray[0][0]>2 || tempArray[0][2]-tempArray[0][0]<-2 || tempArray[0][1]-tempArray[0][2]>2 || tempArray[0][1]-tempArray[0][2]<-2){
		
		tempArray[0][2]=tempArray[0][2]-1;tempArray[0][0]=tempArray[0][0]+1;tempArray[0][1]=tempArray[0][1]+1;
	}
	else{
		
		if(tempArray[0][2]==bestNo)
		flag=1;
		
		else {tempArray[0][2]=tempArray[0][2]-1;tempArray[0][0]=tempArray[0][0]+1;tempArray[0][1]=tempArray[0][1]+1;}
		
	}
	}


if(flag==1) surprisesDone=surprisesDone+1;
				
			}	
			
			googlerScores[i][0]=tempArray[0][0];
			googlerScores[i][1]=tempArray[0][1];
			googlerScores[i][2]=tempArray[0][2];
			
			if(surprisesDone==surprisesAllowed){return googlerScores;}
			}
		
	
		
	}
	
	return googlerScores;
}
	

public static int checkResult(){
	
	return 0;

}
	public static void main(String args[]) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(new File("E:/DOWNLOADS/B-small-attempt3.in")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("E:/DOWNLOADS/B-small-attempt3.out")));
		String line = reader.readLine();
		int k = Integer.parseInt(line);
		int count=1;
		for(int i = 0 ; i < k ; i ++){
			line = reader.readLine();
		//	System.out.println("11");
		//line=line.replaceAll(" ","");
		String[] newLine=line.split(" ");
			//char[] cArray = line.toCharArray();
			
			
			
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
				
				int[][] tempArray=gudjedScores(totalScores[j]);
				googlerScores[j][0]=tempArray[0][0];
				googlerScores[j][1]=tempArray[0][1];
				googlerScores[j][2]=tempArray[0][2];
				
				System.out.println(googlerScores[j][0]+""+googlerScores[j][1]+""+googlerScores[j][2]);
			}
			
			googlerScores=supriseArray(surprises,bestNo,googlerScores);
			int result=0;
			for(int h=0;h<googlerScores.length;h++){
				System.out.println(googlerScores[h][0]+""+googlerScores[h][1]+""+googlerScores[h][2]);
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

