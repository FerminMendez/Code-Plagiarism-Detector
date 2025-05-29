import java.util.Scanner;

public class ProbB1 {
	
	public static void main(String arg[]){
		
		Scanner in = new Scanner (System.in);
		
		int T= in.nextInt();
		
		for(int i=1;i<=T;i++){
			int N = in.nextInt();
			int S=in.nextInt();
			int p=in.nextInt();
			
			int count = 0;
			int minN = p*3-4;
			
			for(int j=0;j<N;j++){
				int n = in.nextInt();
				if(minN>=0){
				if(n>=minN+2)
					count++;
				else if((n>=minN)&&(S>0)){
					S--;
					count++;
				}
				}
				else{
					if((n>0)||((n==0)&&(p==0))) count ++ ;
				}
					
					}
			System.out.println("Case #"+i+": "+count);
					
			}
		}
	}


