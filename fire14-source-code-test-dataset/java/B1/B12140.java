package Recycled;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class recycled {

    static void print(int nbCases, int N, int S, int P, int[] T) {
	System.out.print(N + " ");
	System.out.print(S + " ");
	System.out.print(P);
	for (int j = 0; j < N; j++)
	{
	    System.out.print(" " + T[j]);
	}
	System.out.println();
    }

    static int RecycledNumbers(int A, int B) {
	int res = 0;
	double d = Math.log10(A);
	int n = (int) Math.floor(Math.log10(A)) + 1;
	// System.out.println(" A = " + A + "B = " + B);
	// System.out.println(" N = " + n + " pour d = " + d);
	int flag = 0;
	HashSet<Couple> l = new HashSet<Couple>();
	for (int i = A; i <= B; i++)
	{
	    for (int j = 1; j < n; j++)
	    {
		int p = (int) (((int) Math.pow(10, n - j)) *
		               (i % (int) Math.pow(10, j)) + i /
		                                             Math.pow(10, j));
		if (i < p && p >= A && p <= B && p / Math.pow(10, n) != 0 && !l.contains(new Couple(i, p)))
		{
		    flag += 1;
		    res += 1;
		    l.add(new Couple(i,p));
		    //if (flag >1)
		    //	System.out.println("FLAG");
		    //System.out.println(" Couple : (" + i + ", " + p + ")");
		}
		
	    }
	    flag = 0;
	}
	return res;
    }
    static void run(int A, int B, int turn) {
	System.out.println("Case #" + turn + ": " + RecycledNumbers(A, B));
    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
	Scanner f = new Scanner(
	        new File(
	                "C:\\Users\\Jean-Baptiste\\Desktop\\Info2A\\GoogleJam\\src\\Recycled.in"));
	int nbCases = f.nextInt();
	int A = 1;
	int B = 1;

	for (int i = 0; i < nbCases; i++)
	{
	    A = f.nextInt();
	    B = f.nextInt();

	    run(A, B, i + 1);
	}

	int n = 6;
	int i = 123456;
	int j = 4;
	int p = (int) (((int) Math.pow(10, n - j)) *
	               (i % (int) Math.pow(10, j)) + i / Math.pow(10, j));
	//System.out.println(" Pour i = 123456 et j = 3 : " + p);
	f.close();
    }

}
