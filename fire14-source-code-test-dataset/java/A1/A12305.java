package com.example;

import java.io.IOException;
import java.util.List;

public class ProblemB {
    
    enum Result {
	INSUFFICIENT,
	SUFFICIENT,
	SUFFICIENT_WHEN_SURPRISING
    }

    public static void main(String[] a) throws IOException {

	List<String> lines = FileUtil.getLines("/B-small-attempt0.in");
	
	int cases = Integer.valueOf(lines.get(0));
	
	for(int c=0; c<cases; c++) {
	    String[] tokens = lines.get(c+1).split(" ");
	    
	    int n = Integer.valueOf(tokens[0]); // N = number of Googlers
	    int s = Integer.valueOf(tokens[1]); // S = number of surprising triplets
	    int p = Integer.valueOf(tokens[2]); // P = __at least__ a score of P
	    
	    int sumSufficient = 0;
	    int sumSufficientSurprising = 0;
	    
	    for(int i=0; i<n; i++) {
		int points = Integer.valueOf(tokens[3+i]);
		
		switch(test(points, p)) {
		case SUFFICIENT:
		    sumSufficient++;
		    break;
		    
		case SUFFICIENT_WHEN_SURPRISING:
		    sumSufficientSurprising++;
		    break;
		}
		
//		uSystem.out.println("points "+ points +" ? "+ p +" => "+ result);
	    }
	    
	    System.out.println("Case #"+ (c+1) +": "+ (sumSufficient + Math.min(s, sumSufficientSurprising)));
	    
//	    System.out.println();
//	    System.out.println("N="+ n +", S="+ s +", P="+ p);
//	    System.out.println();
	}
    }

    private static Result test(int n, int p) {
	int fac = n / 3;
	int rem = n % 3;
	
	if(rem == 0) {
	    
//	    int triplet0[] = { fac, fac, fac };
//	    print(n, triplet0);
	    
	    if(fac >= p) {
		return Result.SUFFICIENT;
	    }
	    
	    if(fac > 0 && fac < 10) {
		
		if(fac+1 >= p) {
		    return Result.SUFFICIENT_WHEN_SURPRISING;
		}
		
//		int triplet1[] = { fac+1, fac, fac-1 }; // surprising 
//		print(n, triplet1);
	    }
	    
	    
	} else if(rem == 1) {
	    
//	    int triplet0[] = { fac+1, fac, fac };
//	    print(n, triplet0);
	    
	    if(fac+1 >= p) {
		return Result.SUFFICIENT;
	    }
	    
//	    if(fac > 0 && fac < 10) {
//		int triplet1[] = { fac+1, fac+1, fac-1 };
//		print(n, triplet1);
//	    }
	    
	} else if(rem == 2) {
	    
//	    int triplet0[] = { fac+1, fac+1, fac };
//	    print(n, triplet0);
	    
	    if(fac+1 >= p) {
		return Result.SUFFICIENT;
	    }
	    
	    if(fac < 9) {
//		int triplet1[] = { fac+2, fac, fac }; // surprising
//		print(n, triplet1);

		if(fac+2 >= p) {
		    return Result.SUFFICIENT_WHEN_SURPRISING;
		}
	    }
	    
	} else {
	    throw new RuntimeException("error");
	}
	
	return Result.INSUFFICIENT;
//	System.out.println();
//	System.out.println(n +" => "+ div3 +" ("+ rem +")");
    }
    
//    private static void print(int n, int[] triplet) {
//	System.out.println("n="+ n +" ("+ (n/3) +","+ (n%3) +") => ["+ triplet[0] +","+ triplet[1] +","+ triplet[2] +"]" + (triplet[0]-triplet[2] > 1 ? " *" : ""));
//    }
    
}
