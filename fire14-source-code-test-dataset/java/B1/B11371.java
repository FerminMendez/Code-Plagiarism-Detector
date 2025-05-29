import java.util.Scanner;


public class C {
	
	
	int A = 0;
	int B = 0;
	int cnt = 0;
	
	public int getDig(int x){
		int temp = x;
		int dig = 0;
		while(temp>0){
			dig++;
			temp/=10;		
		}
		return dig;
		
	}
	
	public int flip(int x, int time){
		int temp = x;
		int base = 1;
		for(int i = 1; i<=time;i++) base*=10; 
		int last = temp %base;
		
		
		for(int i = 1; i<=time; i++) temp/=10;		
		for(int i = 1; i<=getDig(x)-time; i++) last*=10;
		
		int ans = last + temp;	
		return ans;
	}
	
	public void getPair(int x){
		if (x<10) return;
		
		
		int dig = getDig(x);
		
		for (int i = 1; i<=dig-1;i++){
			int next = flip(x,i);
			if (dig!=getDig(A)) continue;
			if (next<x) continue;
			if (next==x) break;
			if (next>B||next<A) continue;
//			System.out.println(x+","+next);
			cnt++;
		}		
		return;
	}
	
	public C(Scanner input){
		int T = input.nextInt();
		for(int tt= 1; tt<=T;tt++){
			
			A =input.nextInt();
			B =input.nextInt();
				
			cnt = 0;

			for(int i = A; i<=B; i++){
				getPair(i);				
			}
			System.out.println("Case #"+tt+": "+cnt);
		}
		
	}
	
	public static void main(String args[]){
		new C(new Scanner(System.in));
	}
}
/*
4
1 9
10 40
100 500
1111 2222


*/