package com.google.codejam;

public class RecycledNumbers {
	public int solve(int[] n){
		int res = 0;
		int len = getLen(n[0]);
		int[] sh = new int[len-1];
		for (int i = n[0]; i <= n[1]; i++) {
			for (int j = 1; j < len; j++) {
				int ni = shift(i, j, len);
				sh[j-1] = ni; 
				if(ni > i && ni <= n[1]) {
					boolean dup = false;
					for (int k = 0; k < j-1; k++) {
						if(sh[k] == ni) dup = true;
					}
					if(!dup) res++; 
				}
			}
		}
		return res;
	}

	private int shift(int i, int j, int len) {
		int ex = i % ((int)Math.pow(10, j));
		int div = i / (int)Math.pow(10, j);
		return ex * (int)Math.pow(10, len-j) + div;
	}

	private int getLen(int n) {
		int c = 0;
		while(n > 0){
			n /= 10;
			c++;
		}
		return c;
	}
}
