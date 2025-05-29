import java.util.*;
import java.math.*;

public class C{

	public static int func(int x, int M){
		int tmp,d=0,i;
		
		int a[] = new int[10];
		d = 0;
		tmp = x;
		while(tmp > 0){
			a[d] = tmp % 10;
			tmp /= 10;
			d++;
		}
		
		int ten = 1;
		for(i=0;i<d-1;i++) ten *= 10;
		
		int y[] = new int[d];
		tmp = x;
		for(i=0;i<d;i++){
			y[i] = tmp;
			tmp = tmp / 10 + ten * a[i];
		}
		
		Arrays.sort(y);
		
		int ans = 0;
		for(i=0;i<d;i++) if(y[i] > x && y[i] <= M && (i == 0 || y[i] != y[i-1])) ans++;
		return ans;
	}

	public static void main(String args[]){
		int T,t,A,B,i;
		
		Scanner scan = new Scanner(System.in);
		
		T = scan.nextInt();
		
		for(t=0;t<T;t++){
			A = scan.nextInt();
			B = scan.nextInt();
			
			int ans = 0;
			for(i=A;i<=B;i++) ans += func(i,B);
			
			System.out.printf("Case #%d: %d\n", t+1, ans);
		}
	}

}
