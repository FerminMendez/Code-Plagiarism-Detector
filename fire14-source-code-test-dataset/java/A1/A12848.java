package prob2;

import java.util.Scanner;

public class Prob2{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=Integer.parseInt(scan.nextLine());
		for(int i=0;i<n;i++){
			System.out.print("Case #");
			System.out.print(i+1);
			System.out.print(": ");
			System.out.println(processLine(scan.nextLine()));
		}
	}
	public static int processLine(String line){
		String[] x=line.split("\\s+");
		int n=Integer.parseInt(x[0]);
		int s=Integer.parseInt(x[1]);
		int p=Integer.parseInt(x[2]);
		int needSpec=0;
		int count=0;
		for(int i=0;i<n;i++){
			int j=Integer.parseInt(x[i+3]);
			if(maxReg(j)>=p) {
				count++;
			} else if(specPoss(j)&&maxSpecial(j)>=p) {
				needSpec++;
			}
		}
		return count+Math.min(needSpec,s);
	}
	public static int maxSpecial(int sum){
		return ((sum-2)/3)+2;
	}
	public static boolean specPoss(int sum){
		return 2<=sum&&sum<=28;
	}
	public static int maxReg(int sum){
		return (sum+2)/3;
	}
}