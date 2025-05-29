package zid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Cycle {

	
	HashSet<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
		Cycle c = new Cycle();
		c.start(args[0]);
	}


	
private void start(String filename) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(filename));

			int N = Integer.parseInt(br.readLine());
			int n = 1;
			while (n <= N) {
			
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int COUNT = 0;
				set.clear();
				for (int i = A; i <= B; i++) {
					String iNum = "" + i;
					int iDigitCount = iNum.length();
					for (int j = 0; j < iDigitCount; j++) {
						iNum = getRecycled(iNum);
						int recycled = Integer.parseInt(iNum);
						int recycledDigitCount = iNum.length();
						
						if ( (i < recycled) &&
								(A <= i && recycled <= B) &&
								(recycledDigitCount == iDigitCount)
								)
							{
							String entry = String.format("%d|%d", i, recycled);
							if (!set.contains(entry)) {
								set.add(entry);
								COUNT++;
								//System.out.println(String.format("%d | %d", i,
								//		recycled));
							}
							//else
							//	System.out.println(entry);
						}
					}

				}
				
				System.out.println(String.format("Case #%d: %s", n,COUNT));
				
				n++;
				}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



private String getRecycled(String i) {
	String s = new String(i + "");
	
	String s2 = s.substring(s.length() - 1);
	s = s.substring(0, s.length()-1);
	s = s2 + s;
	
	
	return s;
}

	
	
}
