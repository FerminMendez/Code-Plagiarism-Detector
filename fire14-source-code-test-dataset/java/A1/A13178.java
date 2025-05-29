import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;

public class B {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int t = parseInt(br.readLine());
		for(int z=1;z<=t;z++) {
			String ss[] = br.readLine().trim().split("\\s+");
			int T = parseInt(ss[0]);
			int S = parseInt(ss[1]);
			int p = parseInt(ss[2]);
			int[] arr = new int[T];
			for(int i=0;i<T;i++) {
				arr[i] = parseInt(ss[i+3]);
			}
			Arrays.sort(arr);
			int[][] div = new int[T][3];
			for(int i=0;i<T;i++) {
				div[i][0] = arr[i]/3;
				div[i][1] = (arr[i]-div[i][0])/2;
				div[i][2] = arr[i] - div[i][0] - div[i][1];
			}
			while(S-->0) {
				boolean ok = false;
				for(int i=0;i<T;i++) {
					if(div[i][2] < p) {
						switch(arr[i]%3) {
							case 0:
								if(div[i][2] == p-1 && div[i][0] > 0) {
									div[i][2]++;
									div[i][0]--;
									ok = true;
								}
								break;
							case 1:
								break;
							case 2:
								if(div[i][2] == p-1 && div[i][1] > 0) {
									div[i][2]++;
									div[i][1]--;
									ok = true;
								}
								break;
						}
					}
					if(ok) {
						// out.println(Arrays.toString(div[i]));
						break;
					}
				}
				// if(!ok) {
					// for(int i=0;i<T;i++) {
						// if(!isSup(div[i]) && canBeSup(div[i])) {
							// div[i] = sup(div[i]);
							// ok = true;
						// }
						// if(ok) break;
					// }
				// }
			}
			int count = 0;
			for(int i=0;i<T;i++) {
				if(div[i][2] >= p) count++;
				// out.println(div[i][0]+" "+div[i][1]+" "+div[i][2]);
			}
			out.println("Case #"+z+": "+count);
		}
	}
	
	static boolean isSup(int[] div) {
		return (div[2] - div[0] == 2);
	}
	
	static boolean canBeSup(int[] div) {
		return div[0] != 0;
	}	
	
	static int[] sup(int[] div) {
		if(div[0] == div[2]) return new int[]{div[0]-1,div[1],div[2]+1};
		else if(div[1] == div[2]) return new int[]{div[0],div[1]-1,div[2]+1};
		else return new int[]{div[0]-1,div[1]+1,div[2]};
	}
}