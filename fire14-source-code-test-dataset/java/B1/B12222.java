import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	public static void main(String[] args) {
		List<String> lines = getline("C:\\Users\\Ami\\Downloads\\C-small-attempt1.in");
		System.out.println("number of TestCases-->>" + lines.remove(0));
		Process(lines);
	}

	private static void Process(List<String> lines) {
		int i = 1;
		for (String line : lines) {
			int k = 0;
			String[] nums = line.split(" ");
			int A = Integer.valueOf(nums[0]);
			int B = Integer.valueOf(nums[1]);
			for (int j = A; j < B; j++) {
				String j2 = "" + j;
				for (int x = 1; x <=j2.length(); x++) {
					int num = Integer.parseInt(j2.substring(x)
							+ j2.substring(0, x));
					if (num > j && num <= B){
						k++;
						//System.out.println(j2+" : "+num);
					}
						
				}
			}
			System.out.println("Case #" + i + ": " + k);
			i++;
		}

	}

	private static List<String> getline(String path) {
		List<String> ls = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				ls.add(strLine);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return ls;
	}
}
