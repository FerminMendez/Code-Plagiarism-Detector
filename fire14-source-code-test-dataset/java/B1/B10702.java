import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Recycle {

	private static HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
	private static HashSet<Integer> toSkip = new HashSet<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			long before = System.currentTimeMillis();
			int res = doit(a, b);
			System.out.printf("Case #%d: %d\n", tc, res);
			long after = System.currentTimeMillis();
//			System.out.println("time taken: " + (after - before));
		}
	}

	private static int doit(int a, int b) {
		int count = 0;
		HashSet<Integer> skip = new HashSet<Integer>(toSkip);
		for (int i = a; i <= b; i++) {
			if (skip.contains(i))
				continue;
			HashSet<Integer> arr = generate(i);
//			if(arr.size() > 1) {
//				map.put(i, arr);
//			}
			// System.out.println(i + " --> " +
			// Arrays.deepToString(arr.toArray()));
			int temp = 0;
			if (arr.size() > 1) {
				for (int x : arr) {
					if (x >= a && x <= b) {
						temp++;
						skip.add(x);
					}
				}
				count += temp * (temp - 1) / 2;
			}
//			System.out.println("not skipping " + i + " gen: " + arr.size()+ " " + (temp * (temp - 1) / 2));
		}
		return count;
	}

	private static HashSet<Integer> generate(int num) {
		if(map.containsKey(num)) {
			HashSet<Integer> list = map.get(num);
			return list;
		}
		HashSet<Integer> list = new HashSet<Integer>();
		String s = "" + num;
		list.add(num);
		int len = s.length();
		for (int i = 1; i < len; i++) {
			String temp = s.substring(i) + s.substring(0, i);
			// System.out.println("temp: " + temp);
			if (temp.charAt(0) == '0')
				continue;
			int x = Integer.parseInt(temp);
			if( x <= 2000000) {
				list.add(x);
			}
		}
		if(list.size() > 1) {
			map.put(num, list);
		} else {
			toSkip.add(num);
		}
		return list;
	}

}
