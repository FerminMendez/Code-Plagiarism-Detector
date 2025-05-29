package com.gcj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HallOfMirrors {

	public static Integer mirrors(String A, String B) {
		int lowerB = Integer.parseInt(A);
		int upperB = Integer.parseInt(B);
		int mirror = 0;
		int mirrorAdvised = 0;
		Map<Integer,List<Integer>> uniq = new HashMap<Integer,List<Integer>>();
		for (int i = lowerB; i <= upperB; i++) {
			String num = Integer.toString(i);
			// System.out.println(num + " " + num.length());
			for (int j = 1; j <= num.length(); j++) {
				String numA = num.substring(j, num.length())
						+ num.substring(0, j);
//				String numB = new StringBuffer(numA).reverse().toString();
				// mirror += (lowerB <= Integer.parseInt(numA) &&
				// Integer.parseInt(numB)<= upperB ) ? 1 : 0;
//				mirror += (lowerB <= Integer.parseInt(numA) && Integer.parseInt(numA)< Integer.parseInt(numB) 
//						&& Integer.parseInt(numB) <= upperB) ? 1 : 0;

				if(lowerB <= Integer.parseInt(num) && Integer.parseInt(num) < Integer.parseInt(numA) && Integer.parseInt(numA) <= upperB)
				{
//					System.out.println(numA + " " + num);
					if(uniq.containsKey(Integer.parseInt(num)))
							{
								List<Integer> some  = uniq.get(Integer.parseInt(num));
								if(some.contains(Integer.parseInt(numA)))
								{
//									System.out.println("GOTnum=" + num);
//									System.out.println("GOT YOU" + numA);
									mirrorAdvised--;
								}
								some.add(Integer.parseInt(numA));
								mirrorAdvised++;
							}
					else
					{
						List<Integer> x = new ArrayList<Integer>();
						x.add(Integer.parseInt(numA));
						uniq.put(Integer.parseInt(num), x);
						mirrorAdvised++;
					}
					mirror++;

				}
			}
		}
//		Set xa = new TreeSet();
//		for(Map.Entry<Integer, List<Integer>> a : uniq.entrySet())
//		{
//			if(a.getValue().size()>0)
//			{
////				System.out.println(a.getKey()-a.getValue().get(0));
//				xa.add(a.getKey());
//				System.out.println(a.getKey() + " " + a.getValue());
//			}
//		}
//		System.out.println(xa.size());
		return mirrorAdvised;
	}

	public static void readFile() {

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"C://dev//gcj//C-small-attempt0.in"));
			String str;
			boolean first = true;
			int num = 0;
			int k = 0;
			List<String> testCases = new ArrayList<String>();
			while ((str = in.readLine()) != null) {
				if (first) {
					num = Integer.parseInt(str);
					first = false;
				} else {
					String[] input = str.split(" ");
					String A = input[0];
					String B = input[1];

					Integer result = mirrors(A, B);

					System.out.println("Case #" + (++k) + ": " + result);
				}

			}
			in.close();
		} catch (IOException e) {
		}

	}

	public static void main(String args[]) {
		readFile();
	}

}
