package _2012._0.b_dancers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class DancingWithGooglers
{
	public static int countMaxMinScores (int[] totalScores, int i, int numSurprises, int minDesiredPoints, int cabeSurprise)
	{
		if (i >= totalScores.length) {
			if (numSurprises > cabeSurprise) {
				return cabeSurprise - numSurprises;
			} else {
				return 0;
			}
		}
		
		int newCount = 0;
		
System.out.print (totalScores[i] + " (" + minDesiredPoints + "): ");
		if (((minDesiredPoints * 3) - 0) <= totalScores[i]) {
System.out.println("a");
			newCount = 1;
//			if ((((minDesiredPoints * 3) - 4) > 0) || (totalScores[i] <= 8)) {
			if ((totalScores[i] >= 2) && (totalScores[i] <= 28)) {
				cabeSurprise++;
			}
			
		} else if ((((minDesiredPoints * 3) - 2) <= totalScores[i]) && (minDesiredPoints >= 1)) {
System.out.println("b");
			newCount = 1;
			if ((totalScores[i] >= 2) && (totalScores[i] <= 28)) {
			//if ((((minDesiredPoints * 3) - 4) > 0) || (totalScores[i] <= 8)) {
				cabeSurprise++;
			}
			
		} else if ((((minDesiredPoints * 3) - 4) <= totalScores[i]) && (numSurprises > 0) && (minDesiredPoints >= 2)) {
System.out.println("c");
			newCount = 1;
			numSurprises = numSurprises - 1;
		} else {
			if (totalScores[i] >= 2)  cabeSurprise++;
System.out.println("NO");
		}
		
		return newCount + countMaxMinScores (totalScores, i+1, numSurprises, minDesiredPoints, cabeSurprise);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
			throws Exception
	{
		long t0 = System.currentTimeMillis();
		String sIn = "src/_2012/_0/b_dancers/B-small-attempt1.in";
		if (args.length > 0)  sIn = args[0];
		String sOut = sIn;
		if (sOut.endsWith (".in")) sOut = sOut.substring (0, sOut.length() - 3);
		sOut = sOut + ".out";
		
		LineNumberReader in = new LineNumberReader (new FileReader (sIn));
		PrintWriter out = new PrintWriter (new FileWriter (sOut));
	
		String linea0 = in.readLine();
		int numCasos = Integer.parseInt (linea0);
		
		for (int i=0; i<numCasos; i++) {
			System.out.println ("Case #" + (i+1));
			String s = in.readLine();
			
			String[] trozos = s.split (" ");
			int numDancers = Integer.parseInt(trozos[0]);
			int maxSurprising = Integer.parseInt(trozos[1]);
			int minDesiredPoints = Integer.parseInt(trozos[2]);
			
			int[] totalScores = new int[numDancers];
			for (int j=0; j<numDancers; j++) {
				totalScores[j] = Integer.parseInt(trozos[3 + j]);
			}
			
			int res = countMaxMinScores (totalScores, 0, maxSurprising, minDesiredPoints, 0);
			
			out.println ("Case #" + (i+1) + ": " + res);
		}
		
		
		out.close();
		
		long t1 = System.currentTimeMillis();
		long seg = ((t1 - t0) / 1000);
		double mins = seg / 60d;
		
		System.out.println ("OK - " + mins + " minutos");
	}


}
