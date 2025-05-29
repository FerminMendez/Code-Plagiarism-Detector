import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class B_Small {
    static int[][] table = { {0}, {1}, {1,2}, {1,2}, {2}, {2,3}, {2,3}, {3}, {3,4}, {3,4}, {4}, {4,5}, {4,5}, {5}, {5,6}, {5,6}, {6}, {6,7}, {6,7}, {7}, {7,8}, {7,8}, {8}, {8,9}, {8,9}, {9}, {9,10}, {9,10}, {10}, {10}, {10}};
    public static void main(String[] args) {
	try {
	    FileWriter writer = new FileWriter("B-small-attempt.out");
	    BufferedWriter out = new BufferedWriter(writer);
	    String current, result;
	    result = "";
	    Scanner sc = new Scanner(new File("B-small-attempt1.in"));
	    int x = Integer.parseInt(sc.nextLine());
	    for (int k = 0; k < x; k++) {
		result = "Case #" + (k+1) + ": ";
		current = sc.nextLine();
		int count = 0;
		String[] cur = current.split(" ");
		int z = Integer.parseInt(cur[0]);
		int s = Integer.parseInt(cur[1]);
		int p = Integer.parseInt(cur[2]);
		for (int t = 3; t < cur.length; t++) {
		    int score = Integer.parseInt(cur[t]);
		    int[] special = table[score];
		    if (special[0] >= p) {
			count++;
		    } else if (s > 0 && special.length > 1) {
			if (special[1] >=p) {
			    count++;
			    s--;
			}
		    }
		}
		result += count;
		out.write(result);
		out.newLine();
	    }
	    out.close();
	} catch (Exception e) {
	    System.out.println("error");
	}
    }

}
