import java.util.*;
import java.io.*;

public class recycled {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("input"));
		int size = sc.nextInt();

		for (int x = 0; x < size; x++) {
			TreeSet<String> set = new TreeSet<String>();
			TreeSet<String> set1 = new TreeSet<String>();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int comb = 0;
			
			for (int w = A; w <= B; w++) {
				String str = w + "";

				if (str.length() >= 2 && good(str)) {
					//System.out.println(str);
					for (int y = 1; y < str.length(); y++) {
						int cons = Integer.parseInt(str.substring(y, str
								.length())
								+ str.substring(0, y));

						if (cons <= B && cons>=w) {
				
							comb++;
							set.add(str + " " + str.substring(y, str
									.length())
									+ str.substring(0, y));
						}
					}
				}
			}
			
			int comp = 0;
		
			for (int y = A; y <= B; y++)
				for (int z = y + 1; z <= B; z++) {
					boolean good = false;
					String yy = y + "";
					String zz = z + "";
					for (int k = 1; k < zz.length(); k++) {
						String cons = (zz
								.substring(k, zz.length())
								+ zz.substring(0, k));
						if ((cons + "").equals(yy)) {
							comp++;
							set1.add(yy + " " + zz);
							break;
						}
					}
				}
//			System.out.println(set);
//			set1.removeAll(set);
//			System.out.println(set1);
//			System.out.println(comb);
			System.out.println("Case #"+(x+1)+": "+comp);
		}

	}

	public static boolean good(String str) {
		int temp=str.charAt(0);
		for (int x = 1; x < str.length() - 1; x++)
			if (str.charAt(x)=='0')temp=0;
			else if(str.charAt(x)<temp)return false;
			else temp=str.charAt(x);
			
		if(str.length()==2 && str.charAt(0)==str.charAt(1))return false;
		return true;
	}
}
