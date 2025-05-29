import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) {
		int n = 0;
		int[] a = null;
		int[] b = null;
		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);
			n = sc.nextInt();
			a = new int[n];
			b = new int[n];
			for (int i=0;i<n;i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i=0;i<n;i++) {
			int ret = 0;
			for (int j=a[i];j<=b[i];j++) {
				String s = String.valueOf(j);
				List<Integer> list = new ArrayList<Integer>();
				for (int k=1;k<s.length();k++) {
					String front = s.substring(0, k);
					String end = s.substring(k, s.length());
					int x = Integer.parseInt(end+front);
					boolean existCheck = false;
					for (int l=0;l<list.size();l++) {
						if (list.get(l) == x) {
							existCheck = true;
						}
					}
					if (existCheck) { continue; }
					list.add(x);
					if(j<x && x<=b[i]){
						ret++;
					}
				}
			}
			System.out.println("Case #" + (i+1) + ": " + ret);
		}
	}
}
