import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File in = new File("b.in");
		File out = new File("b.out");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));
		Scanner sc = new Scanner(in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		
		for(int i=0;i<T;i++){
			
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			
			
			int surp = 0;
			int count = 0;
			
			
			for(int j=0;j<N;j++){
				int m = sc.nextInt();
				
				
				if(m==0){
					
					if(p==0){
						count++;
					}
										
				}else if(m == 30){
					
					if(p<=10){
						count++;
					}
					
					
				}else if(m%3==0){					
					if(m/3 >= p){
						count++;
					}else if((m/3+1)>=p){
						count++;
						surp++;
					}
					
				}else if(m%3==1){
					
					if((m/3 + 1)>=p){
						count++;
					}					
					
				}else{
					
					if((m/3+1)>=p){
						count++;
					}else if((m/3+2)>=p){
						count++;
						surp++;
					}	
				}				
			}
			
			count = surp<=S ?count:count-(surp-S);
			
			
			bw.write("Case #"+(i+1)+": "+count+"\n");

			
		}
		bw.close();
	}

}
