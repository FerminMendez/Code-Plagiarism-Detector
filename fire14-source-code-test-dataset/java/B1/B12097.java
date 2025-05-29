import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class cycle {
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

	
	public static int[] move(int i){
		String s = ""+i;
		int[] ans = new int[s.length()-1];
		int counter = 0;
		int temp = i;
		int weishu = 1;
		while(temp>9){
			temp = temp/10;
			weishu = weishu*10;
		}
		temp = i;
		while(counter<s.length()-1){
			int last = temp%10;
			int rest = temp/10;
			temp = rest+last*weishu;
			ans[counter] = temp;
			counter++;
		}
		
		return ans;
	}
	public static void main(String args[]){
		Scanner input = setFileIn();
		long counter = input.nextInt();
		int ans = 0;
		int count = 1;
		while(count<=counter){
			ans = 0;
			System.out.print("Case #"+count+": ");
			 int a = input.nextInt();
			 int b = input.nextInt();
			 int[] test = new int[20000000];
			 for(int i = a;i<=b;i++){
				 int[] pos = move(i);
				 for(int j = 0;j<pos.length;j++){
					 if ((pos[j]>i)&&(pos[j]<=b)&&(test[pos[j]]==0)){
						 ans++;
						 test[pos[j]]=1;
						// System.out.println(" "+ans+" "+i+" "+pos[j]+" ");
					 }
				 }
				 for(int j = 0;j<pos.length;j++){
						 test[pos[j]]=0;
				 }
			 }
			System.out.println(ans);
			count++;
		}

	}
}
