import java.util.*;
public class q2 {

	public static void main(String args[]){
		new q2().run();
	}
	Scanner input = new Scanner(System.in);
	
	
	
	void run(){
		int N = input.nextInt();
		for(int i=1;i<=N;i++){
			System.out.print("Case #"+i+": ");
			solve();
		}
	}
	void solve(){
		int i,j,k;
		int T = input.nextInt();
		int s = input.nextInt();
		int p = input.nextInt();
		int x,m,ans = 0;
		double y;
		Integer [] a = new Integer [T];
		boolean [] used = new boolean[T];
		for(i=0;i<T;i++)
			a[i] = input.nextInt();
		
		for(i=0;i<T;i++){
			x = a[i]/3;
			if(a[i]%3==0){
				if(x >= p)ans++;
				else if(s > 0 && x > 0 && x + 1 >= p){
					ans++;
					s--;
				}
			}
			else if(a[i]%3==1){
				if(x>=p || x+1>=p)
					ans++;
				else if (s > 0 && x + 1 >= p){
					ans++;
					s--;
				}
			}
			else if(a[i]%3==2){
				if(x+1 >= p || x>= p)
					ans++;
				else if(s>0 && x+2 >= p){
					ans++;
					s--;
				}
			}
		}
		System.out.println(ans);
	}
	
	
}
