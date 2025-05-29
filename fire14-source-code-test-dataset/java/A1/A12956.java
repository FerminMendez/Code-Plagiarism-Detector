import java.io.*;
import java.util.*;

public class b {

	public static void main(String[] args) {

		Scanner fin = new Scanner(System.in);

		int numCases = fin.nextInt();

		for (int loop=1; loop<=numCases; loop++) {

			int numPeople = fin.nextInt();
			int numSurprise = fin.nextInt();
			int threshold = fin.nextInt();

			int safe = 0;
			int surprise = 0;
			int lost = 0;
			int either = 0;

			for (int i=0; i<numPeople; i++) {

				int next = fin.nextInt();
				if (threshold >= 2) {

					if (next >= 3*threshold - 2)
						safe++;
					else if (next >=  3*threshold - 4)
						surprise++;
					else
						lost++;
				}
				else {
					if (threshold == 0)
						safe++;
					else {
						if (next >= 1)
							safe++;
						else
							lost++;
					}

				}
			}

			System.out.println("Case #"+loop+": "+(safe+Math.min(surprise, numSurprise)));
		}
	}
}