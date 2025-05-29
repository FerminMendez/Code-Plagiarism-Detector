import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int T= in.nextInt(); int n,t,s,answer=0;
		for (int i = 0; i < T; i++) {
			n=in.nextInt();  t=in.nextInt(); s=in.nextInt();
			for (int j = 0; j < n; j++) {
				int x=in.nextInt(); int nashti=x%3;
				if(x==0 && s!=0) continue;
				if(x/3>=s){ answer++; continue;}
				if(x/3==(s-1)){
					if(nashti>0){answer++; continue;}
					if(t>0){t--; answer++; continue;}
				}
				if(x/3==(s-2)){
					if(nashti>=2 && t>0){t--; answer++; continue;}
				}
			}
			System.out.println("Case #"+(i+1)+": "+answer);
			answer=0;
		}
	}
}
