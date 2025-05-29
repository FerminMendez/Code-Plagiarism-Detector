import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class RecycledNumber {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		FileInputStream fstream = new FileInputStream("C:\\input.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		int cases = Integer.parseInt(br.readLine());
		String mainOutput = "";

		for (int c = 0; c < cases; c++) {

			StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());
			
			int finalCount = 0;

			int arr[] = new int[b * 2];
			int arr2[] = new int[b * 2];

			for (int n = a; n < b; n++) {

				int TEN = 10;
				int count = Integer.toString(n).length();
				for (int i = 1; i < count; i++) {
					int m = (int) ((n % Math.pow(TEN, i)) * Math.pow(TEN, count
							- i))
							+ (int) (n / Math.pow(TEN, i));
					if (a <= n && n < m && m <= b) {
						// System.out.println(n + " " + m);
						arr[finalCount] = m;
						arr2[finalCount++] = n;
					}
				}
			}
			int count = 0;
			for (int i = 1; i < finalCount; i++) {
				if ((arr2[i] == arr2[i + 1] && arr[i] == arr[i + 1])
						|| (arr2[i - 1] == arr2[i] && arr[i - 1] == arr[i])) {
					count++;
				}
			}
			mainOutput = mainOutput + "Case #"+(c+1)+": "+(finalCount - (count / 2))+"\n";			
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
        "C:\\output.txt"), true));
		
		bw.write(mainOutput);
		bw.close();
		
		
		in.close();
	}

}
