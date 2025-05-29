import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C {
	private static Map<Long, Long> map = new HashMap<Long, Long>();

	public static void main(String args[]) {
		try {
			String fileName = "C:\\Users\\Lenovo Z370\\Desktop\\gcj\\comp-2012\\C-small-attempt1.in";
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<t; i++) {
				map.clear();
				String[] abs = br.readLine().split("\\s+");
				long a = Long.parseLong(abs[0]);
				long b = Long.parseLong(abs[1]);
				
				long count = 0;
				
				for(long j=a; j<=b; j++) {
					long n=j;
					String s = String.valueOf(n);
					int l = s.length()-1;
					for(int k=0; k<l; k++) {
						int r = (int)(n%10);
						long m = (long)(r*Math.pow(10, l)) + n/10;

						if(m > j && m >= a && m <= b) {
							Long val = map.get(j);
							if(val == null || val != m) {
								map.put(j, m);
								count++;
							}
						}
						n=m;
					}
				}
				
				System.out.println("Case #" + (i+1) + ": " + count);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
