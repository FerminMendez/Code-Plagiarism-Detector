import java.io.*;
import java.util.*;

public class C implements Runnable{

	public void run(){
		try{
			Scanner in = new Scanner(new File("C-small.in"));
			PrintWriter out = new PrintWriter("C-small.out");
			int a, b, t = in.nextInt(), ans, x, l;
			String min, buf, max;
			Set<String> set = new HashSet<String>();
			for (int k = 1; k <= t; k++){
				ans = 0;
				a = in.nextInt();
				b = in.nextInt();
				max = Integer.toString(b);
				for (int i = a; i < b; i++){
					set.clear();
					x = i;
					min = buf = Integer.toString(x);
					l = min.length();
					for (int j = 0; j < l-1; j++){
						buf = min.substring(l - j - 1) + min.substring(0, Math.max(0, l - j - 1));
						if ((buf.length() == l) && (min.compareTo(buf) < 0) && (buf.compareTo(max) <= 0)) {
							if (!set.contains(buf)){
								set.add(buf);
								ans++;
							}
						}
					}
				}
				out.println("Case #" + k + ": " + ans);
			}
			out.close();
		}
		catch(Exception e){
		}                                         
	}

	public static void main(String[] args){
		(new Thread(new C())).start();
	}
}                       