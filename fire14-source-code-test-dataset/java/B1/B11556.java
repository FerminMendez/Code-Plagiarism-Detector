
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class C {

	int INF = 1 << 28;

	void run() {
		Scanner sc;
		FileOutputStream fw;
		try {
			sc = new Scanner(new File("C.in"));
			fw = new FileOutputStream(new File("C.out"));
			PrintWriter pw = new PrintWriter(fw);
//			sc.useDelimiter("\\n");
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int cnt = 0;
				for(int j=a;j<=b;j++) {
					String num = String.valueOf(j);
//					debug(num);
					HashSet<Integer> visited = new HashSet<Integer>();
					for(int k=1;k<num.length();k++) {
						String rot_s = num.substring(k) + num.substring(0,k);
						int rot = Integer.parseInt( rot_s );
						if(rot > j && a <= rot &&  rot <= b) visited.add(rot);
					}
					cnt += visited.size();
				}
//				debug(cnt);
				pw.println("Case #" + i + ": " + cnt);
			}
			pw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new C().run();
	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}
}
