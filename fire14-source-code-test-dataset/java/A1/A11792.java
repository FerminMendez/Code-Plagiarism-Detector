import java.util.Scanner;


public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] result= new int[T];
		for(int i=0;i<T;i++){
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p= scan.nextInt();
			
			int count=0;
			
			int max = 3*p-2;
			if(p==0)
				max=0;
			
			int min = 3*p-4;
			if(p==1)
				min=1;
			
			for(int j=0;j<N;j++){
				int t = scan.nextInt();
				if(t>=max)
					count++;
				else{
					if(S>0 && t>=min){
						count++;
						S--;
					}
					
				}
			}
			result[i]=count;			
		}
		for(int i=0;i<T;i++){
			System.out.println("Case #"+(i+1)+": "+result[i]);
		}
	}
}
