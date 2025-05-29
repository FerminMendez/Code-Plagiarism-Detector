package cj;

import static cj.Utils.*;

public class Recycle {
    
    public static int count(int a, int b) {
	int ret = 0;
	for (int i=a; i<=b; i++) {
	    for (int j=i+1; j<=b; j++) {
		if (recycled(i, j)) ret++;
	    }
	}
	return ret;
    }
    
    public static boolean recycled(int a, int b) {
	if (a==b) return true;
	String A = a+"";
	String B = b+"";
	for (int i=0; i<(int)Math.log10(a)+1; i++) {
	    if (A.equals(B)) return true;
	    B = B.charAt(B.length()-1) + B.substring(0, B.length()-1);
	}
	return false;
     }

    public static void main(String[] args) {
	String[] lines = readLines("in/"+args[0]);
	int num = new Integer(lines[0]) + 1;
	String[] print = new String[num-1];
	for (int i=1; i<num; i++) {
	    int[] nums = toInts(lines[i]," ");
	    int max = count(nums[0], nums[1]);
	    print[i-1] = "Case #"+i+": "+max;
	}
	writeLines(print, "out/"+args[1]);
    }

}