import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class C {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("c.txt"));
		String line = reader.readLine();
		int count = 1;
		while ((line = reader.readLine()) != null) {
			String [] split = line.split("\\s+");
			int A = Integer.parseInt(split[0]);
			int B = Integer.parseInt(split[1]);
			int ans = 0;
			for (int i = A; i <= B; i++) {
				String num = i+"";
				String tmp = num;
				HashSet<String> set = new HashSet<String> ();
				for (int j = 1; j < num.length(); j++) {
					char t = tmp.charAt(0);
					tmp = tmp.substring(1);
					tmp = tmp + t;
					if((Integer.parseInt(tmp)+"").length() == num.length() && Integer.parseInt(num) < Integer.parseInt(tmp) && Integer.parseInt(tmp) <= B) {
						if(!set.contains(tmp+" "+num))
							ans++;
						set.add(tmp+" "+num);
					}
				}
			}
			System.out.println("Case #"+(count++)+": "+ans);
		}
		reader.close();
	}

}
