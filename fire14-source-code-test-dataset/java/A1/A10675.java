import java.util.Arrays;
import java.util.Scanner;


public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		for(int tc = 1 ; tc <= T ; tc++ ) {
			int N = reader.nextInt();
			int S = reader.nextInt();
			int p = reader.nextInt();
			int [] arr = new int[N];
			for(int i = 0 ; i < N ; i ++) {
				arr[i] = reader.nextInt();
			}
			int res = doit(arr, S, p);
			System.out.printf("Case #%d: %d\n", tc, res);
		}
	}

	private static int doit(int[] arr, int s, int p) {
		int n = arr.length;
		Triplet[] ts = new Triplet[n];
		for(int i = 0 ; i < n ; i ++) {
			ts[i] = new Triplet(arr[i]);
		}
		Arrays.sort(ts);
		int count = 0;
		for(int i = 0 ; i < arr.length; i ++) {
			if ( ts[i].max >= p) {
				count ++;
//				System.out.println(ts[i].total + " used");
				continue;
			}
			if( s > 0 && ts[i].surprisingMax >= p) {
				s--;
				count ++;
//				System.out.println(ts[i].total + " used");
				continue;
			}
//			System.out.println(ts[i].total + "  " + s + p);
		}
		return count;
	}
}

class Triplet implements Comparable<Triplet> {
	int total;
	int max;
	int surprisingMax;
	public Triplet(int total) {
		this.total = total;
		initialize();
	}
	private void initialize() {
		int avg = total / 3;
		int remaining = total % 3;
		int a[] = new int[3];
		a[0] = avg;
		a[1] = avg;
		a[2] = avg;
		if(remaining > 0) {
			a[0]++;
		}
		if(remaining > 1) {
			a[1]++;
		}
		this.max = a[0];
		switch(remaining) {
		case 0:
		case 2:
			this.surprisingMax = a[0] + (a[1] > 0 ? 1 : 0);
			break;
		case 1:
			this.surprisingMax = -1;
			break;
		}
//		System.out.println("total: " + total + " max: " + max + " remaining: " + remaining + " surp max: " + surprisingMax);
	}
	@Override
	public int compareTo(Triplet o) {
		if(o.total != total) {
			return o.total - total;
		}
		if(o.max != max) {
			return o.max - max;
		}
		return o.surprisingMax - surprisingMax;
	}
}
