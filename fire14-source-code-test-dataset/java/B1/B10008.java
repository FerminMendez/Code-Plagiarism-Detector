import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class C {

	Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();

	public C() {
		for (int i=1; i<=2000000; i++) {
			char ch[] = (""+i).toCharArray();
			Arrays.sort(ch);
			String key = new String (ch);

			Set<Integer> val = map.containsKey(key)?map.get(key): new HashSet<Integer>();
			val.add(i);
			map.put(key, val);
		}

		System.out.println("Done..\n");
	}

	boolean rot (int a, int b) {
		String A = ""+a;
		String B = ""+b;
		for (int i=1; i<A.length(); i++) {
			String r = B.substring(i) + B.substring(0, i);
			//System.out.println(r);
			if (r.equals(A))
				return true;
		}
		return false;
	}
	
	int answer (int A, int B) {
		int total = 0;
		HashSet<String> stopList = new HashSet<String>();
		for (int i=A; i<=B; i++) {
			char ch[] = (""+i).toCharArray();
			Arrays.sort(ch);
			String key = new String (ch);

			if (stopList.contains(key))
				continue;
			Object values[] = map.get(key).toArray();
			for (int j=0; j<values.length; j++) {
				int valJ = (Integer)values[j];
				if (valJ>=A && valJ<=B) {
					for (int k=j+1; k<values.length; k++) {
						int valK = (Integer)values[k];
						if (valK>=A && valK<=B) {
							if (rot(valJ, valK)) {
								total++;
								//System.out.println(valJ+", "+valK);
							}
						}
					}

				}
			}
			stopList.add(key);


		}
		return total;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C c = new C();
		
		//System.out.println(c.rot(12345, 45123));
		int T = sc.nextInt();

		for (int i=0; i<T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			System.out.println("Case #"+(i+1)+": "+c.answer(A, B));
		}
	}
}
