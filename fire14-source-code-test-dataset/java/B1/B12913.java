import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainApp {

	public static void main(String[] args) {
		String input = "";

		try {
			FileInputStream fstream = new FileInputStream("C-small-attempt2.in");

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				input += strLine + "\n";
			}
			in.close();
		} catch (Exception e) {
		}

		String[] inputs = input.split("\n");
		
		int len = inputs.length;
	
		for (int p = 1; p < len; ++p) {
			int count = 0;
			
			String[] split = inputs[p].split(" ");
			
			int A = Integer.parseInt(split[0]);
			int B = Integer.parseInt(split[1]);

			int n = A;
			
			while (n < B - 1) {
				for (int m = (n + 1); m <= B; ++m) {
					String strN = String.valueOf(n);
					
					for (int k = strN.length(); k > 1; --k) {
						String str = strN.substring(k - 1, strN.length()) + strN.substring(0, k - 1);

						int a = Integer.parseInt(str);
						
						if (a == m) {
							count++;
							break;
						}
					}
				}
				
				n++;
			}

			System.out.println("Case #" + p + ": " + count);
		}
	}
}
