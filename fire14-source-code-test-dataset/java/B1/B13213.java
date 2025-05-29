import java.io.*;
import java.util.*;

public class C {
	HashMap map = new HashMap<Character, Character>();

	public static void main(String args[]) {
		try {
			InputStreamReader isr = null;
			try {
				isr = new InputStreamReader(System.in, "UTF-8");
				BufferedReader br = null;
				try {
					br = new BufferedReader(isr);
					new C().solve(br);
				} finally {
					if (br != null) br.close();
				}
			} finally {
				if (isr != null) isr.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public void solve(BufferedReader br) throws IOException {
		String line = null;
		int T = Integer.parseInt(br.readLine());
		for (int count = 1; count <= T; count++) {
			doOne(count, br.readLine());
		}
	}

	public void doOne(int count, String line) {
		TreeMap<String, List<String>> map =
			new TreeMap<String, List<String>>();
		List<String> list = null;
		List<String> keys = null;
		String key = null;
		String nstr = null;
		String sstr = null;
		String lines[] = line.split(" ");
		int startNum = Integer.parseInt(lines[0]);
		int endNum = Integer.parseInt(lines[1]);
		for (int n = startNum; n <= endNum; n++) {
			nstr = Integer.toString(n);
			keys = makeKeys(nstr);
			key = null;;
			for (int i = 0; i < keys.size(); i++) {
				key = keys.get(i);
				list = map.get(key);
				if (list != null)
					break;
			}
			if (list == null) {
				key = nstr;
				list = new ArrayList<String>();
			}
			list.add(nstr);
			map.put(key, list);
		}

		Set <String>keySet = map.keySet();  
		Iterator <String>keyIte = keySet.iterator();  
		int total = 0;
		while(keyIte.hasNext()) {
			String mapKey = keyIte.next();  
			List<String> data = map.get(mapKey);  
			// System.out.println(mapKey + ":" + data);

			if (data.size() > 1)
				total += data.size() * (data.size() - 1) / 2;
		}

		System.out.println("Case #" + count + ": " + total);
	}

	public List<String> makeKeys(String nstr) {
		List<String>list = new ArrayList<String>();
		char nchar[] = new char[nstr.length()];
		for (int i = 0; i < nchar.length; i++)
			nchar[i] = nstr.charAt(i);
		char kchar[] = new char[nstr.length()];
		for (int startc = 0; startc < nchar.length; startc++) {
			for (int c = 0; c < nchar.length; c++)
				kchar[c] = nchar[(startc + c) % nchar.length];
			list.add(new String(kchar));
		}
		return list;
	}
}
