package codejam;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class QualificationB {
	public static void main(String[] args){
		try{
			Scanner sc=new Scanner(new File("B.in"));
			PrintStream ps=new PrintStream("B.out");
			int t=sc.nextInt();
			for(int i=0;i<t;i++){
				int n=sc.nextInt();
				int s=sc.nextInt();
				int p=sc.nextInt();
				int count=0;
				for(int j=0;j<n;j++){
					int x=sc.nextInt();
					if(x>(p-1)*3)count++;
					else if(x>1&&x>(p-1)*3-2&&s>0){
						count++;
						s--;
					}
				}
				ps.println("Case #"+(i+1)+": "+count);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
