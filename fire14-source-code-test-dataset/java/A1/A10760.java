import java.util.Scanner;
public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int zz = 1; zz <= T;zz++){
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int x = 0;
			for(int i = 0; i < N;i++){
				int score = in.nextInt();
				int best = score/3;
				int mod = score%3;
				int diff = p-best;
				if(diff<1){
					x++;
				}else if(diff<2){
					if(mod==0 && score !=0){
						if(S!=0){
							S--;x++;
						}
					}else if(score!=0){
						x++;
					}
				}else if(diff<3){
					if(mod==2){
						if(S!=0){
							S--;x++;
						}
					}
				}
			}
			System.out.format("Case #%d: %d\n", zz, x);
		}
	}
}
