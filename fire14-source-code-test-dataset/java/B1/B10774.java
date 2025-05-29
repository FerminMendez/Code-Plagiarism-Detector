import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class RecycledNumbers {

	public RecycledNumbers() {
		solve();
	}

	/**
	 * Solves Problem A. Speaking in Tongues
	 */
	private void solve() {
		try {
			File f = new File("./C-small-attempt0.in.txt");
			File output = new File("./output2.out");

			if (output.exists())
				output.delete();

			output.createNewFile();

			PrintWriter pw = new PrintWriter(output);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			linea = br.readLine();

			int i = 1;
			while (linea != null) {
				int a = Integer.parseInt(linea.split(" ")[0]);
				int b = Integer.parseInt(linea.split(" ")[1]);

				pw.println("Case #" + i + ": " + getRecycledAmmount(a, b));
				linea = br.readLine();
				i++;
			}

			pw.close();
			br.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int getRecycledAmmount(int start, int end) {
		int ammount = 0;

		for (int n = start; n <= end; n++) {
			for (int m = start; m <= end; m++) {
				if (n < m && isRecycled("" + n, "" + m))
					ammount++;
			}
		}

		return ammount;
	}

	private boolean isRecycled(String n, String m) {

		for (int i = m.length()-1; i > 0; i--) {
			
			String prefix = m.substring(0, i);			
			String suffix = m.substring(i);
			
			String recycled = suffix + prefix;
			if(recycled.equals(n))
				return true;

		}

		return false;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RecycledNumbers();
	}

}
