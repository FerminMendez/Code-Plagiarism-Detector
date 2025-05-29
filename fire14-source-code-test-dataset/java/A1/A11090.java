package DancingWithTheGooglers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class DancingWithTheGooglers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream("input.txt"));
		PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
		
		int lines = in.nextInt();
		in.nextLine();
		int counter = 0;
		
		for (;counter<lines;counter++) {
			out.write("Case #" + (counter+1) + ": ");
			
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int finalCount = 0;
			ArrayList<Integer> scores = new ArrayList<Integer>();
			for (int i = 0; i<n; i++) {
				scores.add(in.nextInt());
			}
			Collections.sort(scores);
			for (int i: scores) {
				if (i<p)
					continue;
				else if ((((i-2)/3)+2)<p)
					continue;
				else if ((((i-1)/3)+1)>=p)
					finalCount++;
				else if (s>0) {
					s--;
					finalCount++;
				}
			}
			out.write(finalCount + "\n");
		}
		
		in.close();
		out.close();
	}
}
