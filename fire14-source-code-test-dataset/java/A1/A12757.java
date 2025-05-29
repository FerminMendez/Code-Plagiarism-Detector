import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SolutionB_2 {

    public static void main(String[] args) throws IOException {

	String curDir = "DancingWithGooglers/";

	Scanner sc = new Scanner(new FileReader(curDir + "B-small-attempt11.in"));
	PrintWriter pw = new PrintWriter(new FileWriter(curDir + "B-small-attempt0.out"));

	int totalTestCase = Integer.parseInt(sc.nextLine());

	for (int testCase = 1; testCase <= totalTestCase; testCase++) {
	    Integer nGoogler = sc.nextInt();
	    Integer nSurprising = sc.nextInt();
	    Integer bestNum = sc.nextInt();

	    Integer maxNum = 0;
	    Integer nCheck = 0;

	    List<Integer> g = new ArrayList<Integer>();
	    List<Integer> g1 = new ArrayList<Integer>();

	    for (int i = 0; i < nGoogler; i++) {
		Integer a = sc.nextInt();
		g.add(a);
		g1.add(a);
	    }

	    if (nSurprising == 0) {
		for (Integer t : g) {
		    int y = t / 3;
		    int z = t % 3;

		    if (t == 0 || t == 1) {
			if (t >= bestNum) {
			    maxNum++;
			}
		    } else if (z == 0) {
			if (y >= bestNum) {
			    maxNum++;
			}
		    } else if (z == 1) {
			if (y + 1 >= bestNum) {
			    maxNum++;
			}
		    } else if (z == 2) {
			if (y + 1 >= bestNum) {
			    maxNum++;
			}
		    }
		}
	    } else {
		java.util.Collections.sort(g, new Comparator<Integer>() {
		    public int compare(Integer a, Integer b) {
			if (a > b) {
			    return 1;
			} else if (a < b) {
			    return -1;

			} else {
			    return 0;
			}
		    }
		});

		for (Iterator<Integer> it = g.iterator(); it.hasNext();) {
		    Integer t = it.next();

		    int y = t / 3;
		    int z = t % 3;

		    if (t == 0 || t == 1) {
			continue;
		    } else if (z == 0) {
			if (y + 1 >= bestNum && nCheck < nSurprising) {
			    maxNum++;
			    nCheck++;
			    it.remove();
			}
		    } else if (z == 1) {
			if (y + 1 >= bestNum && nCheck < nSurprising) {
			    maxNum++;
			    nCheck++;
			    it.remove();
			}
		    } else if (z == 2) {
			if (y + 2 >= bestNum && nCheck < nSurprising) {
			    maxNum++;
			    nCheck++;
			    it.remove();
			} else if (y + 1 >= bestNum && nCheck < nSurprising) {
			    maxNum++;
			    nCheck++;
			    it.remove();
			}
		    }
		}

		if (nCheck >= nSurprising) {
		    for (Integer t : g) {
			int y = t / 3;
			int z = t % 3;

			if (t == 0 || t == 1) {
			    if (t >= bestNum) {
				maxNum++;
			    }
			} else if (z == 0) {
			    if (y >= bestNum) {
				maxNum++;
			    }
			} else if (z == 1) {
			    if (y + 1 >= bestNum) {
				maxNum++;
			    }
			} else if (z == 2) {
			    if (y + 1 >= bestNum) {
				maxNum++;
			    }
			}
		    }
		}

	    }

	    pw.println(String.format("Case #%d: %d", testCase, maxNum));
	    System.out.println(String.format("Case #%d: %d, %d, %s => %d", testCase, nSurprising, bestNum, g1.toString(), maxNum));
	}

	pw.flush();
	pw.close();
	sc.close();
    }
}
