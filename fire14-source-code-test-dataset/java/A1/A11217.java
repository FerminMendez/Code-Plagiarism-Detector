package com.google.codejam;

public class DancingGoogler {
	public int solve(String str){
		String[] arr = str.split(" ");
		int n = Integer.valueOf(arr[0]);
		int s = Integer.valueOf(arr[1]);
		int p = Integer.valueOf(arr[2]);
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = Integer.valueOf(arr[3+i]);
		}
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			if(p == 0){
				res++;
			}else if(p == 1){
				if(c[i] > 0) res++;
			}else{
				if(c[i] >= 3*p - 2) res++;
				else if(c[i] >= 3*p - 4 && s > 0){
					res++; s--;
				}
			}
		}
		return res;
	}
}
