import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class main {
	 
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		//Scanner res = new Scanner( new File("/home/loic/INF422/workspace/CodeJam1/bin/Result.txt"));
		int T = sc.nextInt();
		int N; int S; int p; int[] participants; int results;
		for (int i = 0; i<T; i++){
			N = sc.nextInt(); S = sc.nextInt(); p =sc.nextInt();results=0; participants = new int[N];
			for (int j =0; j<participants.length;j++){
				participants[j]=sc.nextInt();
			}
				for (int k =0; k<participants.length; k++){
					if(participants[k]>=1){
					if(participants[k]>=3*p-2)
						results++;
					else if(participants[k]>=3*p-4){
						if(S!=0){
							results++;
							S--;
						}	
					}
					}
			}
				if(p==0)
					results=N;
			System.out.println("Case #"+(i+1)+": "+results);
		}
	}
}
