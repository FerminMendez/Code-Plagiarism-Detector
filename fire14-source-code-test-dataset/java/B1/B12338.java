package com.example;

import java.io.IOException;
import java.util.List;

public class ProblemC {

    static int[] data = new int[2000001];

    public static void main(String[] a) throws IOException {
	
//	if(true) {
//	    precalc();
//
////	    System.out.println("min = "+ findMinimum(3210));
//	    
//	    return;
//	}
	
	List<String> lines = FileUtil.getLines("/C-small-attempt0.in");
	
	for(int i=1; i<data.length; i++) {
	    data[i] = findMinimum(i);
	}
	
	int cases = Integer.valueOf(lines.get(0));
	
	for(int i=0; i<cases; i++) {

	    String[] tokens = lines.get(i+1).split(" ");
	    
	    Integer start = Integer.valueOf(tokens[0]);
	    Integer stop = Integer.valueOf(tokens[1]);
	    
	    System.out.println("Case #"+ (i+1) +": "+ test(start, stop));
	}
    }
    
    static int test(int a, int b) {
	int found = 0;
	
	for(int n=a; n<b; n++) {
	    for(int m=n+1; m<=b; m++) {
		
		boolean equals = (data[n] == data[m]);
		
		if(equals) {
		    found++;
		}
	    }
	}
	
	return found;
    }
    
    static int findMinimum(int i) {
	int numDigits = (int) (1+Math.log10(i));
	
	int min = i;
	
	for(int r=0; r<numDigits-1; r++) {
	    int rotated = rotateInt(i, r);
	    int numDigitRotated = (int) (1+Math.log10(rotated));
	    
	    if(numDigits == numDigitRotated && rotated < min) {
		min = rotated;
	    }
	}

	return min;
    }
    
    static int rotateInt(int i, int r) {
	int tailPow = pow(10, 1+r);
	int tail = i % tailPow;
	
	return (i/tailPow) + tail * pow(10, (int) Math.log10(i) - r);
    }
    
    static int pow(int a, int b) {
	int r = 1;
	
	for(int i=0; i<b; i++) {
	    r *= a;
	}
	
	return r;
    }
}
