import java.util.Scanner;


public class Dancing {

	public static void main(String[] args) {

		int t, n, s, p, y;
		int[] ti;
		
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		
		for(int i=1; i<=t; i++){
			
			y = 0;
			int surprised = 0;
			
			n = scan.nextInt();
			s = scan.nextInt();
			p = scan.nextInt();
			
			ti = new int[n];
			
			for(int j=0; j<n; j++){
				ti[j] = scan.nextInt();
			}
			
			int limiteInf;
			
			if(p <= 1)
				limiteInf = p;
			else
				limiteInf = p + 2 * (p - 2);
			
			for(int j=0; j<ti.length; j++){
				
				if(limiteInf == 0){
					y++;
				}else if(ti[j] >= (limiteInf + 2)){
					y++;
					//System.out.println("Entrou 1: " + ti[j]);
				}else if(ti[j] >= limiteInf && ti[j] < (limiteInf + 2) && surprised < s){
					y++;
					surprised++;
					//System.out.println("Entrou 2: " + ti[j]);
				}
			}
			
			
			
			System.out.println("Case #" + i + ": " + y);
		}
	}

}
