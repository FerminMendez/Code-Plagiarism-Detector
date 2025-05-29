import java.io.*;
import java.util.*;
public class b{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++){
			int n = sc.nextInt(), s = sc.nextInt(), p = sc.nextInt(), r = 0;
			int mn = p + (Math.max(0,p-1)<<1), ms = p + (Math.max(0,p-2)<<1);
			for(int i = 0; i < n; i++){
				int tp = sc.nextInt();
				if(tp >= mn) r++;
				else if(s > 0 && tp >= ms) { r++; s--; } 
			}
			System.out.println("Case #" + tc + ": " + r);
		}
	}
}

//n** {{4 3 1 5 15 13 11 3 0 8 23 22 21 2 1 1 8 0 6 2 8 29 20 8 18 18 21}}
