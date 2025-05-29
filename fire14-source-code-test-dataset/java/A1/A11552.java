import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Scanner sc = new Scanner(br.readLine());
		int T = sc.nextInt();
		int caseNumber = 1;
		
		
		
		for(int i=0; i<T; i++){
			
			
			sc = new Scanner(br.readLine());
			
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			
			int count = 0;
			//int countS = 0;
			//int countCanBeS = 0;
			
			//ArrayList<Integer> ta = new ArrayList<Integer>();
			//ArrayList<Integer> tb = new ArrayList<Integer>();
			
			
			for(int j=0; j<N; j++){
				int tr = sc.nextInt();
				
				if(tr>0){
					if(tr/3 >= p){
						count++;
					}else if((tr + 2)/3 >= p){
						count++;
						//countCanBeS++;
					}else if(tr/3<p){
						if(S>0){
							if((tr+3)/3 >= p){
								count++;
								S--;
							}else if((tr+4)/3 >= p){
								//System.out.println("Hello" + count);
								count++;
								S--;
							}
						}
					}
						
				}else if(tr==0 && p==0){
					count++;
				}
		
			}
			
			
			System.out.println("Case #"+ caseNumber +": "+count);
			caseNumber++;
		
		}
		
		
	}
}