import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class C {
	public static void main(String[] args) {
		try {
			int num;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = null;
			str = br.readLine();
			num = Integer.parseInt(str);
			for (int i = 0; i < num; i++) {
				String s = br.readLine();
				String arr[] = s.split("\\s+");
				int num1 = Integer.parseInt(arr[0]);
				int num2 = Integer.parseInt(arr[1]);
				int count = 0;
				for (int j = num1; j <= num2; j++) {
					String originalStr = "" + j;
					String numStr = originalStr;
					do {
						numStr = numStr.substring(1) + numStr.charAt(0);
						if (numStr.compareTo(originalStr) > 0) {
							if (Integer.parseInt(numStr) <= num2)
							count++;
						}
					} while (!numStr.equals(originalStr));
				}
				System.out.println("Case #" + (i+1) + ": " + count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	