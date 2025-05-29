public class recycled {
    public static void main(String args[]) {
	java.util.Scanner s = new java.util.Scanner(System.in);
	int T = s.nextInt();
	for (int n = 1; n <= T; n++) 
	    System.out.println("Case #" + n + ": " + f(s.nextInt(), s.nextInt()));
    }

    public static int f(int a, int b) {
	String A = "" + a;
	String B = "" + b;
	java.util.HashSet<String> s = new java.util.HashSet<String>();

	for (int i = a; i <= b; i++) {
	    String I = "" + i;
	    for (int j = 1; j < I.length(); j++) {
		String x = I.substring(j) + I.substring(0, j);
		if (A.compareTo(x) <= 0 && B.compareTo(x) >= 0 && !I.equals(x))
		    if (x.compareTo(I) > 0) 
			s.add(x+":"+I);
		    else
			s.add(I+":"+x);
	    }
	}

	return s.size();
    }
}