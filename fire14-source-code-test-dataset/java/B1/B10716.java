import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class Recycled {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String line;
		Integer i = 1;
		Integer licz = 0;
		boolean first = true; 
		try {
			while ((line = bufferRead.readLine()) != null && line.length()!= 0)
			{
				if (first)
				{
					licz = Integer.parseInt(line);
					first = false;
				}
				else
				{
					System.out.print("Case #" + i +": ");
					// tu wlasciwe obliczenie
					String[] split = line.split(" ");
					policzRececled(split[0], split[1]);
					System.out.println();
					i++;
					licz--;
				}
				if (licz < 0)
					break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int policzRececled(String A, String B) {
		if (A.length() == 1)
		{
			System.out.print("0");
			return 0;
		}
		Map<String,Integer> map = new HashMap<String, Integer>();
		Integer licznikPar = 0;
		Integer min = Integer.parseInt(A);
		Integer max = Integer.parseInt(B);
		for (Integer X = min; X <= max; ++X)
		{
			String S = X.toString();
			for (int i = 1; i < A.length(); ++i)
			{
				String subS = S.substring(0, i);
				String subE = S.substring(i);
				String sNew = subE + subS;
				Integer iNew = Integer.parseInt(sNew);
				if (X < iNew && iNew >= min && iNew <= max)
				{
					String ss = "" + X + iNew;
					if (map.containsKey(ss))
					{
						Integer j = map.get(ss);
						j++;
						map.put(ss, j);
					}
					else
					{
						map.put(ss, 1);
					}
					//System.out.println(licznikPar + ": " + X + " -> " + iNew);
					//licznikPar++;
				}
			}
		}
		System.out.print(map.size());
		/*
		System.out.println();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		int ii = 1;
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(ii + ": " + entry.getKey() + " -> " + entry.getValue());
			ii++;
		}
		*/
		return 0;
	}

}
