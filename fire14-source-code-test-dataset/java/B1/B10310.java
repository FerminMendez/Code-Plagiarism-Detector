import java.io.BufferedReader;
import java.io.FileReader;


public class C {

	private static final String head = "Case #";

	public static void main(String[] args) {
        try{
            FileReader f = new FileReader(args[0]);
            BufferedReader b = new BufferedReader(f);
            String s;
            boolean ff = false;
            int c = 0;
            while((s = b.readLine())!=null){
            	if (!ff){ff=true;continue;}
            	else {
            		c++;
            		System.out.println(head + c + ": " + C.getI(s));
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
        	
        }
	}
	
	private static int getI(final String line) {
		//System.out.print("TEST:"+line);
		int r = 0;
		int a,b;
		String[] sp = line.split(" ");
		a = Integer.valueOf(sp[0]);
		b = Integer.valueOf(sp[1]);
		//if (b < 10) return 0;
		//else if (a == b) return 0;
		//else {
			//if (a <= 10) {a = 11;}
			for (int x = a; x <= b; x++) {
				for (int y = 0; y < String.valueOf(x).length(); y++) {
					if (y != 0) {
						int re = C.getRR(x, y);
						if (re <= 11 || re >= x) {continue;}
						else {
							if (re >= a && re <= b) {
								//System.out.println("X:"+x+"T"+re);
								r++;		
							}
						}
					}
				}
			}
		//}
		return r;
	}
	private static Integer getRR(final int v, final int o) {
		StringBuilder sb = new StringBuilder();
		String str = String.valueOf(v);
		sb.append(str.substring(o));
		sb.append(str.substring(0, o));
		return Integer.valueOf(sb.toString());
	}
}
