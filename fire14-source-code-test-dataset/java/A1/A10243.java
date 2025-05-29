import java.util.*;

public class Main{
    public static void main(String[] args) {
	Scanner console = new Scanner(System.in);
	int t = console.nextInt();
	for (int i = 0; i < t; i++) {
	    System.out.print("Case #" + (i + 1) + ": ");
	    int n = console.nextInt();
	    int s = console.nextInt();
	    int p = console.nextInt();
	    int k = 0;
	    int m = 0;
	    for (int j = 0; j < n; j++) {
		int score = console.nextInt();
		if (score % 3 == 0) {
		    if (score / 3 >= p) {
			m++;
		    } else if (score != 0 && score / 3 + 1 >= p) {
			k++;
		    }
		} else if (score % 3 == 1) {
		    if (score / 3 >= p - 1) {
			m++;
		    }
		} else {
		    if (score / 3 >= p) {
			m++;
		    } else if (score / 3 + 1 >= p) {
			m++;
		    } else if (score / 3 + 2 >= p) {
			k++;
		    }
		}
	    }
	    if (k <= s) {
		m += k;
	    } else {
		m += s;
	    }
	    System.out.println(m);
	}
    }
}