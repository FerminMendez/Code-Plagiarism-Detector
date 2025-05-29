import java.util.Scanner;
public class RecycledNumbers {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		for (int i = 0; i < x; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int count = 0;
			for (int j = a; j < b; j++) {
				for (int k = j; k <= b; k++) {
					String one = new Integer(j).toString();
					String two = new Integer(k).toString();
					if (j < k && one.length() == two.length()) {
						for (int l = 0; l < one.length(); l++) {
							one = one.charAt(one.length()-1) + one.substring(0, one.length()-1);
							if (one.equals(two)) {
								count++;
								break;
							}
						}
					}
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
}
