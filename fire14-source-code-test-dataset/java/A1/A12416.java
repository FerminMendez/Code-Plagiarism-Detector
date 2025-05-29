import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader input =
			new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(input.readLine());
		for (int i = 1; i <= a; i++) {
			String[] b = input.readLine().split(" ");
			int s = Integer.parseInt(b[1]);
			int p = Integer.parseInt(b[2]);
			int[] gs = new int[Integer.parseInt(b[0])];
			for (int j = 0; j < gs.length; j++) {
				gs[j] = Integer.parseInt(b[j+3]);
            }
			Arrays.sort(gs);
			int hasil = 0;
			for (int j = gs.length - 1; j >= 0; j--) {
				if (gs[j]/3 >= p) {
					hasil++;
					//System.out.println("1 " + gs[j]);
                }
				else {
					if (gs[j] % 3 == 2) {
						if (gs[j]/3 + 1 >= p) {
							hasil++;
							//System.out.println("2 " + gs[j]);
                        }
						else if (gs[j]/3 + 2 >= p && s > 0) {
							s--;
							hasil++;
							//System.out.println("3 " + gs[j]);
						}
                    }
					else if (gs[j] % 3 == 1) {
						if (gs[j]/3 + 1 >= p) {
							hasil++;
							//System.out.println("4 " + gs[j]);
                        }
					}
					else {
						if (gs[j]/3 + 1 >= p && s > 0 && gs[j]/3 > 1) {
							s--;
							hasil++;
							//System.out.println("5 " + gs[j]);
						}
					}
				}
            }
			System.out.println("Case #" + i + ": " + hasil);
        }
	}
}
