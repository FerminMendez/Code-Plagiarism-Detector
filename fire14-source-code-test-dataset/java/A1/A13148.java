package codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ProblemB {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new File("ProblemB.txt.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("ProblemB.txt.out")));
		
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++){
			
			int n = sc.nextInt();
			int s= sc.nextInt();
			int p = sc.nextInt();
			
			int count =0;
			
			for(int j=0;j<n;j++){
				int x = sc.nextInt();
				int max, diff=0;
				
				if(x%3==0)max = x / 3;
				else max = x/3 + 1;
				
				if(x%3==1) diff=-1;
				
				if (max >=p) count++;
				else if ((max+1) == p && s>0 && diff!=-1 && max>0){
					s--;
					count++;
				}
					
			}
				
			bw.write("Case #" + (i+1) +": "+ count +"\n");
			System.out.println("Case #" + (i+1) +": "+ count);
			}
		
			bw.close();
			sc.close();
				
			
		}
		
	}


