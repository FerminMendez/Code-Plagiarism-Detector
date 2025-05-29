import java.util.*;
import java.io.*;
import java.math.*;

public class Prac2 {
	public static void main(String[] arg){
		try{
			Scanner in=new Scanner(new File("sample"));
			//BufferedReader br=new BufferedReader(new FileReader("sample"));
			//int numCases=in.nextInt();//br.readLine();br.readLine();
		//	BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
			int numCases=in.nextInt();
			int counter=1;
			//in.nextLine();
			counter=1;
			while (counter!=numCases+1){
				int N=in.nextInt();
				int S=in.nextInt();
				int p=in.nextInt();
				int count=0;
				while (N!=0){
					int cur=in.nextInt();
					if (cur/3>p){
						int third=cur/3;
						int pair=cur-cur/3;
						if (Math.abs(third-pair/2)<=1){
							count++;
						}else{
							if (Math.abs(third-pair/2)==2 && S>0){
								S=S-1;
								count++;
							}
						}
					}else{
						int pair=cur-p;
						if (cur>=p && Math.abs(p-pair/2)<=1){
							count++;
						}else{
							if (Math.abs(p-pair/2)==2 && S>0){
								S=S-1;
								count++;
							}
						}
					}
					N=N-1;	
				}
				
				System.out.println("Case #"+counter+": "+count);
				
				counter++;
			}
		
		}catch (FileNotFoundException e){
			
		}catch (IOException e){
		}
	}
}