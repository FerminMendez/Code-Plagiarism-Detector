/**
 * 
 */
package kr.javanese.gcj2012.qr.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @author javanese
 *
 */
public class DancingWithTheGooglers {

	private int findMax(int s, int p, int[] t) {
		int n = t.length;
		int[] tremaining = new int[t.length];
		int bmin[] = new int[t.length]; // min of possible best scores
		int bmax[] = new int[t.length]; // max of possible best scores
		boolean[] shouldBeSuprising = new boolean[n];
		
		int count = 0;
		int shouldBeSuprisingCount = 0;
		for (int i=0; i<n; i++) {
			tremaining[i] = t[i] % 3;
			switch(tremaining[i])
			{
			case 0:
				if (t[i]==0) {
					bmin[i] = 0;
					bmax[i] = 0;
				} else {
					bmin[i] = t[i]/3;
					bmax[i] = t[i]/3+1;
				}
				if (bmin[i]>=p) {
					count++;
				} else if (bmax[i]==p) {
					shouldBeSuprising[i] = true;
					shouldBeSuprisingCount++;
				}
				break;
			case 1:
				bmin[i] = t[i]/3+1;
				bmax[i] = t[i]/3+1;
				if (bmin[i]>=p) {
					count++;
				}
				break;
			case 2:
				bmin[i] = t[i]/3+1;
				bmax[i] = t[i]/3+2;
				if (bmin[i]>=p) {
					count++;
				} else if (bmax[i]==p) {
					shouldBeSuprising[i] = true;
					shouldBeSuprisingCount++;
				}
				break;
			}
			System.err.println(">> "+i+": "+bmin[i]+", "+bmax[i]+", "+count+"["+shouldBeSuprisingCount+"]");
		}
		
		if (shouldBeSuprisingCount>=s) {
			count += s;
		} else {
			count += shouldBeSuprisingCount;
		}
		return count;
	}

	public static void main(String[] args) {
		try {
			DancingWithTheGooglers instance = new DancingWithTheGooglers();

			BufferedReader reader;
			if (args.length > 0) {
				reader = new BufferedReader(new FileReader(args[0]));
			} else {
				reader = new BufferedReader(new InputStreamReader(System.in));
			}
			String line = null;
			line = reader.readLine();
			int caseCount = Integer.parseInt(line);

			long startTime = System.currentTimeMillis();

			for (int i = 0; i < caseCount; i++) {
				line = reader.readLine();
				String[] tokens = line.split(" ");
				int n = Integer.parseInt(tokens[0]);
				int s = Integer.parseInt(tokens[1]);
				int p = Integer.parseInt(tokens[2]);
				int t[] = new int[n];
				for (int j=0; j<n; j++) {
					t[j] = Integer.parseInt(tokens[j+3]);
				}
				
				System.out.print("Case #");
				System.out.print(i + 1);
				System.out.print(": ");
				System.out.println(instance.findMax(s, p, t));
			}

			System.err.println("Elasped Time : "
					+ (System.currentTimeMillis() - startTime));
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
