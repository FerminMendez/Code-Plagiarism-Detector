import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Scanner sc = new Scanner(br.readLine());
		int T = sc.nextInt();
		int caseNumber = 1;
		
		
		for(int i=0; i<T; i++){
			sc = new Scanner(br.readLine());
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int n = A;
			int m = A;
			int count = 0;
			
			
			for(int j=A; j<B; j++){
				n = j;
				
				for(int k=j; k<B; k++){
					m = k+1;
					
					String sn = ""+n;
					String sm = ""+m;
					if(n<m && !sn.equals(sm)){
						for(int l=1; l<sn.length(); l++){
							String smt = sm.substring(l) + sm.substring(0, l);
							if(Integer.parseInt(smt) == n){
								//System.out.println("sn="+sn + "    sm="+ sm);
								count++;
							}
						}
					}
				}
			}
			
			
			
			System.out.println("Case #"+caseNumber+": "+ count);
			caseNumber++;
		}
		
	}
}