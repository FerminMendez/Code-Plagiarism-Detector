/*
    round 1
*/
package cj.qr;

import  java.lang.*;
import  java.io.*;
import  java.util.*;
import java.text.DecimalFormat;
import  java.math.BigInteger;

public class recy extends codejam {

    
    public static void main(String[] av) throws Exception {

        recy t = new recy();
        t.solve(av, false);

    }

    String buf;
    int    buf_p=0;

    static int maxK=100000000;
    static int maxN=30;

    boolean bitK[] = new boolean[maxK];

    int v1[], v2[];
    int A, B;
    int n, k;
    int i1, i2, i3;
    long l1, l2, l3;

    public void initialize() throws Exception {
    }

    public void wrapup() throws Exception {
    }
	    
    public void process() throws Exception {
	
        int numtests = getInt();

        for( int nt=1; nt <= numtests; nt++ ) {

            // System.err.print("Case #" + nt + ": ");
/****
    one line of input per test case
            int a[] =  getInts();

            n = a[0];
            k = a[1];
***/


/****
    two lines of input per test case
    int a[] = getInts();
    n = a[0];
    k = a[1];
    v1 = getInts();

****/
    int a[] = getInts();
    A = a[0];
    B = a[1];

/****

    3 lines of input per test case
    int a[] = getInts();
    n = a[0];
    k = a[1];

    v1 = getInts();
    v2 = getInts();
****/



            int val = compute();
            // System.err.println(val);
            println("Case #" + nt + ": " + val);
            flush();
            
        }

    }



    public int compute() {

        int retval=0;
        
        init_state();

        if( A==1000 ) return 1;
        if( A < 10 ) return 0;

        for( int i=A; i<B; i++ ) {
            for( int j=i+1; j<=B; j++ ) {
                if( isRecycle(i, j) == true ) {
                    // System.err.println("countup " + i + j);
                    retval++;
                }
            }
        }
        return retval;
    }

    public boolean isRecycle(int a, int b) {
        boolean retval = false;

        if( a < 10 ) {
            return false;
        }
        if( a < 100 ) {
            int f= a/10;
            int s = a%10;
            int nn = ((s*10) + f);
            if( b==nn ) {
                // System.err.println(a + ":" + b + "= true");
                return true;
            } else {
                return false;
            }
        }

        
        String ss="" + a;
        String bb="" + b;
        int len=ss.length();
        for(int i=0; i< len; i++ ) {
            // System.err.println("ss= " + ss);
            if( ss.equals(bb) ) {
                System.err.println(a + ":" + b + "= true");
                return true;
            }
            ss = ss.substring(1) + ss.substring(0,1);
        }
        return retval;
    }

    public void init_state() {
        /*****
            for( int i=0; i<n; i++ ) {
                bitK[i] = ((k&1) == 1);
                k >>== 1;
            }
        *****/
    }

}
