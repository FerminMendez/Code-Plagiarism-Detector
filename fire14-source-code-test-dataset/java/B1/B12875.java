package qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recycled {
	public static void main(String[] args) throws FileNotFoundException {
		List<Pair> list = new ArrayList<Pair>();
		Scanner s = new Scanner(new File("C-small-attempt1.in"));
		s.nextLine();

		int count = 1;
		while (s.hasNext()) {
			int a = s.nextInt();
			int b = s.nextInt();
			int result = 0;
			list.clear();

			for (int i = a; i < b; i++) {
				String as = i + "";

				int l = as.length();
				for (int j = 1; j < as.length(); j++) {
					String back = as.substring(l - j, l);
					String front = as.substring(0, l - j);
					String ts = back + front;

					if (back.charAt(0) == '0' || as.length() != ts.length() || as.equals(ts))
						continue;
					int tsInt = Integer.parseInt(ts);
					
					if (tsInt <= b && i <= tsInt){
						boolean hasPair = false;
						for(int k=0; k<list.size(); k++){
							Pair p = list.get(k);
							if(p.a.equals(String.valueOf(i)) && p.b.equals(ts)){
								hasPair = true;
								break;
							}
						}
						if(!hasPair){
							list.add(new Pair(i+"", ts));
							result++;
						}
					}

				}
			}

			System.out.print("Case #" + count + ": " + result);

			if (s.hasNext()) {
				count++;
				System.out.println();
			}
		}
	}
}

class Pair{
	String a;
	String b;

	Pair(String a, String b){
		this.a = a;
		this.b = b;
	}
}