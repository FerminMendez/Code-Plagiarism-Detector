package Googlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import exoD.Ray;

public class googlers {

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

    static int maxWinners(int N, int S, int P, int[] T) {
	int res = 0;
	int used = 0;
	if (P == 0)
	{
	    return N;
	}
	else
	{
	    for (int i = 0; i < N; i++)
	    {
		if (T[i] >= 3 * P - 2)
		{
		    res += 1;
		}
		else if (T[i] >= 3 * P - 4 && used < S && P >= 2)
		{
		    used += 1;
		    res += 1;
		}
	    }
	}
	return res;
    }
    static void run(int N, int S, int P, int[] T, int turn) {
	System.out.println("Case #" + turn + ": " + maxWinners(N, S, P, T));
    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
	Scanner f = new Scanner(
	        new File(
	                "C:\\Users\\Jean-Baptiste\\Desktop\\Info2A\\GoogleJam\\src\\Googlers.in"));
	int nbCases = f.nextInt();
	int[] T = { 0 };
	int N = 1;
	int S = 1;
	int P = 1;

	for (int i = 0; i < nbCases; i++)
	{
	    N = f.nextInt();
	    S = f.nextInt();
	    P = f.nextInt();
	    T = new int[N];
	    for (int j = 0; j < N; j++)
	    {
		T[j] = f.nextInt();
	    }
	    run(N, S, P, T, i + 1);
	}

	f.close();
    }

}
