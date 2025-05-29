import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class dancer {
	public static Scanner setFileIn(){
		try{
			Scanner input = new Scanner(new FileInputStream(new File ("test.txt")));
			return input;
		}catch(Exception e){
			return null;
		}
	}
	public static Scanner setSysIn(){
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		return input;
	}
	
	
	public static int dancer(int n, int s, int p,Scanner input){
		int ans = 0;
		int noSur = 3*p-2;
		int sur = 3*p-4;
		if (p==1){
			noSur = 1;
			sur = 1;
			
		}
		
		if(p==0){
			noSur = 0;
			sur = 0;
			
		}
		//
		//System.out.println(" "+s+" "+p);
		//System.out.println(" "+noSur+" "+sur);
		while(n>0){
			int score = input.nextInt();
			//System.out.print(" "+ score+" ");
			if (score>=noSur){
				ans++;
			}else{
				if ((score >= sur)&&(s>0)){
					s--;
					ans++;
				}
			}
			n--;
		}
		return ans;
	}

	public static void main(String args[]){
		Scanner input = setFileIn();
		long counter = input.nextInt();
		int ans = 0;
		int count = 1;
		while(count<=counter){
			System.out.print("Case #"+count+": ");
			 int n = input.nextInt();
			 int s = input.nextInt();
			 int p = input.nextInt();
			 ans = dancer(n,s,p,input); 
			System.out.println(ans);
			count++;
		}

	}
}
