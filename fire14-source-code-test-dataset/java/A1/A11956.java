import java.util.Scanner;

public class cj1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 1; i<=T; i++) {
			int N = s.nextInt();
			int S = s.nextInt();
			int p = s.nextInt();
			int nc=0;
			int nawt=0;
			int nbwt=0;
			int naw=0;
			int nbw=0;
			int delta=0;
			for (int j = 1; j<=N; j++) {
				int ti = s.nextInt();
				if (ti==0) {
					if(ti==p) {
						nbw++;
						nbwt++;
					}
					continue;
				}
				if((ti-1)%3==0) {
					if ((ti+2)/3>=p) nc++;
				}
				if(ti%3==0){
					if(ti/3>=p) {
						nbw++;
						nbwt++;
					}
					else if((ti+3)/3>=p) nbw++;
				}
				if((ti+1)%3==0) {
					if ((ti+1)/3>=p) {
						naw++;
						nawt++;
					}
					else if ((ti+4)/3>=p) naw++;
				}
			}
			if(S<=(naw+nbw-nawt-nbwt)) delta=S;
			else delta=naw+nbw-nawt-nbwt;
			int max = nc + nawt + nbwt + delta;
			System.out.println("Case #" + i + ": "+ max);
		}
	}
}
