
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class B {

	int INF = 1 << 28;

	void run() {
		Scanner sc;
		FileOutputStream fw;
		try {
			sc = new Scanner(new File("B.in"));
			fw = new FileOutputStream(new File("B.out"));
			PrintWriter pw = new PrintWriter(fw);
//			sc.useDelimiter("\\n");
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				int t = sc.nextInt();
				int s = sc.nextInt();
				int p = sc.nextInt();
				int[] total = new int[t];
				for(int j=0;j<t;j++) {
					total[j] = sc.nextInt();
				}
				sort(total);
				int[][] score = new int[t][3];
				for(int j=0;j<t;j++) {
					int ave = total[j]/3;
					if(total[j]%3 == 0) {
						score[j][0] = score[j][1] = score[j][2] = ave;
					}
					else if(total[j]%3 == 1) {
						score[j][0] = score[j][1] = ave;
						score[j][2] = ave+1;
					}
					else {
						score[j][0] = ave;
						score[j][1] = score[j][2] = ave+1;
					}
				}
				int cnt = 0;
				for(int j=0;j<t;j++) {
//					debug(score[j]);
					if( score[j][2] >= p ) cnt++;
					else if( s > 0 ){
						if( score[j][2] == score[j][1] && score[j][2] + 1 >= p &&
							total[j] != 0 && score[j][2] != 10) {
							s--;
							cnt++;
						}
					}
				}
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
		new B().run();
	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}
}
