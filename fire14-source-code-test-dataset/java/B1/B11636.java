package contest;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Set; 
import java.util.HashSet;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int T = Integer.parseInt(in.readLine());
			for (int tc = 0; tc<T; tc++) { 
				String testCase = in.readLine();
				StringTokenizer st = new StringTokenizer(testCase); 
				
				int A = Integer.parseInt(st.nextToken()); 
				int B = Integer.parseInt(st.nextToken());
				
				Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
				
				int count = 0;
				for (int n=A; n<=B; n++) { 
					List<Integer> list = getRecList(n);
					for (int m: list) { 
						if (m<=B && n<m) { 
							if (map.containsKey(n)) {
								if (map.get(n).contains(m)) { 
									//this pair already exists, skip
								}
								else { 
									map.get(n).add(m);
									count++;
								}
								
							} else { 
								Set<Integer> s = new HashSet<Integer>(); 
								s.add(m);
								map.put(n, s);
								count++;
							}
//							System.out.println("(" +n+ "," + m + ")");//testing
						}
					}
				}
				System.out.println("Case #" + (tc+1) + ": " + count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static List<Integer> getRecList(int n) { 
		List<Integer> ret = new ArrayList<Integer>(); 

		String str = Integer.toString(n);
		
//		System.out.println("processing " + n); //testing
		for (int i = str.length()-1; i>0;i--) { 
			ret.add(Integer.parseInt(str.substring(i, str.length()) + str.substring(0, i)));
//			System.out.println("adding: " + Integer.parseInt(str.substring(i, str.length()) + str.substring(0, i)));//testing
		}
		
		return ret;
	}
	
	

}
