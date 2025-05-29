import java.util.Scanner;


public class C_RecycledNumbers {

	static int[] bases = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
	static int digits(int value) {
		int i = 0;
		for (; i < bases.length && value >= bases[i]; i++);
		return i;
	}
	
	static int shift(int value, int len) {
		int last = value % 10;
		return (int)(Math.pow(10, len - 1)) * last + (value / 10);
	}
	
	
	static int countRecycled(int value, int B) {
		int shifted = value;
		int len = digits(value);
		int[] cache = new int[len];
		int ck = 0;
out:	for (int i = 0; i < len - 1; i++) {
			shifted = shift(shifted, len);
			
			if (shifted > value && shifted <= B) {
				for (int j = 0; cache[j] != 0; j++)
					if (cache[j] == shifted)
						continue out;	
				//System.out.println("n=" + value + ", m=" + shifted);
				cache[ck++] = shifted;
			}
		}
		return ck;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int A = 1;
		int B = 500;
		int count = 0;
		for (int val = A; val <= B; val++) {
			count += countRecycled(val, B);
		}
		System.out.println(count);*/
		
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		for (int t = 1; t <= test; t++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			int count = 0;
			for (int val = A; val <= B; val++) {
				count += countRecycled(val, B);
			}
			System.out.println("Case #" + t + ": " + count);
		}
	}
}
