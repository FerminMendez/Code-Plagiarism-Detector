import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class RecycledNumbersSolver {
	public static void main(String[] args) {
		try {
			FileInputStream fIS = new FileInputStream(args[0]);
			BufferedReader r = new BufferedReader(new InputStreamReader(fIS));
			
			int t = Integer.parseInt(r.readLine());
			for (int i=0;i<t;++i) {
				System.out.print("Case #" + (i+1) + ": ");
				if (i < t-1)
					System.out.println(solveTest(r.readLine()));
				else
					System.out.print(solveTest(r.readLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

	private static int solveTest(String line) {
		Map<Integer, List<Integer>> matches = new HashMap<Integer, List<Integer>>();
		
		String[] nums = line.split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		Integer bInt = b;
		
		int result = 0;
		
		for (int i=a;i<b;++i) {
			result += solveTest(i, bInt, matches);
		}
		
		return result;
	}

	private static int solveTest(Integer n, Integer max, Map<Integer, List<Integer>> matches) {
		String txt = n.toString();
		int digits = txt.length();
		
		int counter = 0;
		
		for (int i=1;i<digits;++i) {
			Integer nNum = getRecycled(txt, i);
			if (nNum.compareTo(n) > 0 && nNum.compareTo(max) <= 0) {
				if (matches.get(n) == null)
					matches.put(n, new LinkedList<Integer>());
				
				List<Integer> list = matches.get(n);
				if (!list.contains(nNum)) {
					list.add(nNum);
					++counter;
				}
			}
		}
		
		return counter;
	}

	private static Integer getRecycled(String txt, int shift) {
		StringBuilder bld = new StringBuilder();
		
		for (int i=txt.length()-shift;i<txt.length();++i)
			bld.append(txt.substring(i, i+1));
		
		for (int i=0;i<txt.length()-shift;++i)
			bld.append(txt.substring(i, i+1));
		
		return Integer.parseInt(bld.toString());
	}
}
