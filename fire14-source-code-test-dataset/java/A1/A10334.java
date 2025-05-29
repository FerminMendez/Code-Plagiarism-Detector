import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class problemB {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int[] tab = new int[100];

		String outputFile = "C:\\Users\\mejdi\\Documents\\A-small1.out";
		String inputFile = "C:\\Users\\mejdi\\Documents\\B-small-attempt0.in";

		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
		DataInputStream in = new DataInputStream(new FileInputStream(inputFile));

		int T = Integer.valueOf(in.readLine());

		for (int o = 0; o < T; o++) {

			String list = in.readLine();
			int k = Integer.valueOf(list.substring(0, list.indexOf(" ")));
			list = list.substring(list.indexOf(" ") + 1);
			int s = Integer.valueOf(list.substring(0, list.indexOf(" ")));
			list = list.substring(list.indexOf(" ") + 1);
			int p = Integer.valueOf(list.substring(0, list.indexOf(" ")));
			list = list.substring(list.indexOf(" ") + 1);
			for (int j = 0; j < (k-1); j++) {
				tab[j] = Integer.valueOf(list.substring(0, list.indexOf(" ")));
				list = list.substring(list.indexOf(" ") + 1);
			}
			tab[k-1] = Integer.valueOf(list.substring(0));
		

			int i = 0;
			int r = 0;
			while (i < k)

			{
				if (tab[i]==0 )
					{if (p==0)
						{i=i+1;
						r=r+1;
						}
					else
						i=i+1;}
						
						
						
				else if ((tab[i] / 3) + 2 - p < 0)
					i = i + 1;

				else if ((tab[i] / 3) + 2 - p == 0) {
					if (tab[i] % 3 == 2) {
						if (s > 0) {
							s = s - 1;
							r = r + 1;
							i = i + 1;
						}

						else {
							i = i + 1;
						}
					} else {
						i = i + 1;
					}
				} else if ((tab[i] / 3) + 1 - p == 0) {
					
					if (tab[i] % 3 == 0) {
						if (s > 0) {
							s = s - 1;
							r = r + 1;
							i = i + 1;
						}

						else {
							i = i + 1;
						}
					} else {
						i = i + 1;
						r = r + 1;
					}
				} else {
					i = i + 1;
					r = r + 1;
				}

			}

			int x = o + 1;
			out.write("Case #" + x + ": " + r);
			out.newLine();
		}
		in.close();
		out.close();
	}
}
