import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int x = 1;
		while (t > 0) {
			int y = 0;
			String[] g = bf.readLine().trim().split("\\s+");
			int a = Integer.parseInt(g[0]);
			int b = Integer.parseInt(g[1]);
			for (int i = a; i < b; i++) {
				boolean[] flag = new boolean [b-a+1];
				String s= Integer.toString(i); 
				for (int j = 0; j < g[0].length()-1; j++) {
					int ss = Integer.parseInt(s.substring(j+1)+s.substring(0,j+1));
					if (ss>i&&ss<=b&&!flag[ss-a]) {
						y++;
						flag[ss-a]=true;
					}
				}
			}

			System.out.println("Case #" + x + ": " + y);
			x++;
			t--;
		}

	}

}
