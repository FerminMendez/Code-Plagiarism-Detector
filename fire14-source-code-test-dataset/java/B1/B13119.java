/**
 * 
 */

/**
 * @author Mostafa
 *
 */
public class RecycledNumbers {
	
	public static String traverse(String x) {
		char[] m = x.toCharArray();
		m[0] = x.charAt(1);
		m[1] = x.charAt(0);
		String t = new String(m);
		return t;
	}
	
	public static String traverse1(String x) {
		char[] m = x.toCharArray();
		m[0] = x.charAt(2);
		m[1] = x.charAt(0);
		m[2] = x.charAt(1);
		String t = new String(m);
		return t;
	}
	public static String traverse2(String x) {
		char[] m = x.toCharArray();
		m[0] = x.charAt(1);
		m[1] = x.charAt(2);
		m[2] = x.charAt(0);
		String t = new String(m);
		return t;
	}
	
	public static int renumber(int first, int last) {
		String[] test = new String[last-first+1];
		int i, j;
		int testc = 0;
		int count = 0;
		for (i = first; i<=last; i++) {
			String x = Integer.toString(i);
			test[testc] = x;
			testc++;
		}
		if (test[0].length() == 1) {
			count = 0;
		}
		else if (test[0].length() == 2) {
			for (i=0; i<test.length; i++) {
				for (j = i+1; j<test.length; j++) {
					if (test[i].compareTo(traverse(test[j])) == 0) {
						count++;
					}
				}
			}
		}
		else if (test[0].length() == 3) {
			for (i=0; i<test.length; i++) {
				for (j = i+1; j<test.length; j++) {
					if (test[i].compareTo(traverse1(test[j])) == 0) {
						count++;
					}
					if ((test[i].compareTo(traverse2(test[j])) == 0)) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
