import java.awt.datatransfer.StringSelection;
import java.util.*;
public class q3 {

	public static void main(String[] args) {
		new q3().run();
	}
	Scanner input = new Scanner(System.in);
	void run(){
		int c = input.nextInt();
		for(int i=1;i<=c;i++){
			System.out.print("Case #"+i+": ");
			solve();
		}
	}
	void solve(){
		int a = input.nextInt();
		int b = input.nextInt();
		boolean [] used = new boolean [b+1];
		int ans = 0;
		String x;
		int i,j,k,y;
		for(i=a;i<=b;i++){
			x = Integer.toString(i);;
			for(j=1;j<=x.length()-1;j++){
				y = recycled(x,j);
				//System.out.println(y);
				if(y >= a && y <= b && !used[y] && i!=y){
					//System.out.println(i +" "+y);
					ans++;
				}
			}
			used[i] = true;
		}	
		System.out.println(ans);
	}
	int recycled(String x,int n){
		String f = x.substring(x.length()-n,x.length());
		int i;
		for(i=0;i<f.length() && f.charAt(i) == '0';i++)
		f = f.substring(i+1,f.length());
		String l = x.substring(0,x.length()-n);
		f = f.concat(l);
		return Integer.parseInt(f);
	}

}
