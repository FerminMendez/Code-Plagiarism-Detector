import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Googlers {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		for (int i = 1; i <= t; i++){
			String[] a = read.readLine().split(" ");
			int n = Integer.parseInt(a[0]);
			int s = Integer.parseInt(a[1]);
			int p = Integer.parseInt(a[2]);
			int result = 0;
			int temp = 0;
			for (int j = 0; j < n; j++){
				temp = Integer.parseInt(a[3+j]);
                                if (temp == 0 && p > 0);
                                else if (temp < p);
                                else if (temp >= 3*p)
					result++;
				else {
					temp = temp - p;
					double d = temp/2.0;
					double e = p;
					if (e - d<= 1.0) {
						result++;
					}
					else if (e - d <= 2.0 && s > 0) {
						result++;
						s--;
					}
				}
			}
			System.out.println("Case #"+ i + ": "+ result);
		}
	}
}