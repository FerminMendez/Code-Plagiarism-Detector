import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number {
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(s.readLine());
		for (int i = 1; i <= t; i++){
			String[] a = s.readLine().split(" ");
			int A = Integer.parseInt(a[0]);
			int B = Integer.parseInt(a[1]);
			int temp = 0;
			int result = 0;
			
			for (int j = A; j < B; j++) {
				String str = "" + j ;
				int n = str.length();
				for (int k = 1; k < n; k++) {
					str = "" + str.charAt(n-1) + str.substring(0, n-1);
					temp = Integer.parseInt(str);
					if (temp > j && temp <= B)
						result++;
				}
			}
			System.out.println("Case #"+ i + ": "+ result);
		}
	}
}