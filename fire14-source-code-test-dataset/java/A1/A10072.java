/**
 * @(#)Text1.java
 *
 *
 * @author
 * @version 1.00 2012/4/14
 */

import java.util.*;
import java.io.*;

public class B {

	public static int diff(int a, int b, int c) {
		int max = 0;
		if(Math.abs(a-b) > max) max = Math.abs(a-b);
		if(Math.abs(b-c) > max) max = Math.abs(b-c);
		if(Math.abs(c-a) > max) max = Math.abs(c-a);
		return max;
	}

	public static int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	public static int combo(int score, int best) {
		double avg = score/3.0;
		int min = 3;
		for(int i = 0; i <= 11; i++) {
			for(int j = 0; j <= 11; j++) {
				for(int k = 0; k <= 11; k++) {
					if(i + j + k == score && max(i, j, k) >= best) {
						int s = diff(i, j, k);
						//System.out.println("	S: " + score + " B: " + best + " ("+i+", "+j+", "+k+")" + " " + s);

						if(s < min) min = s;
						if(min == 0 || min == 1) return min;
					}
				}
			}
		}
		//System.out.println("		MIN: " + min);
		return min;

	}


    public static void main(String [] argz) throws IOException {
    	Scanner reader = new Scanner(new File("B-small-attempt1.in"));
    	int numCases = reader.nextInt();
    	reader.nextLine();

		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);


    	for(int i = 0; i < numCases; i++) {
    		ArrayList<Integer> scores = new ArrayList<Integer>();
    		Scanner lineReader = new Scanner(reader.nextLine());
    		while(lineReader.hasNext()) scores.add(lineReader.nextInt());
			int googlers = scores.remove(0);
			int surprising = scores.remove(0);
			int best = scores.remove(0);
			int amount = 0;

			//System.out.println("\n\n\nCase #" + (i+1) + " best: " + best);
			for(int j = 0; j < scores.size(); j++) {
				int current = combo(scores.get(j), best);
				if(current == 2 && surprising > 0) {
					amount++;
					surprising--;
				}
				if(current == 1 || current == 0) amount++;
				//System.out.println("AMT: " + amount + "	SUR: " + surprising);
			}
			//System.out.println();
    		out.write("Case #" + (i+1) + ": " + amount + "\n");

    	}
		out.close();
    }
}