import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

public class crazysolution {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		// Scanner sc = new Scanner(System.in);
		// int N = Integer.parseInt(sc.nextLine());

		//System.out.println(getContents(new File("B-small-attempt1.in")));
		setContents(new File("B-small-attempt2.out"),getContents(new File("B-small-attempt2.in")));
		/*System.out.println(getContents(new File("in")));
		setContents(new File("out"),getContents(new File("in")));*/
		// File("A-small-attempt2.in"));
		// System.out.println(isSurprising(8,10,8));
	}

	public static int dancinggoogler(String str) {
		String[] input = str.split(" ");
		int counter = 0;
		int N = Integer.parseInt(input[0]); // number of dancers
		int S = Integer.parseInt(input[1]); // surprising score
		int p = Integer.parseInt(input[2]); // best score
		ArrayList<Integer> tLst = new ArrayList<Integer>();

		// StringBuffer result = new StringBuffer();
		int size = input.length;
		for (int i = 3; i < size; i++) {
				tLst.add(Integer.parseInt(input[i]));
		}
		// sort tLst by increased order
		// those numbers in the list can generate surprising triplet
		Collections.sort(tLst);
		int tLstSize = tLst.size();
		for (int i = 0; i < tLstSize; i++) {
			int ti = tLst.get(i);
			if (ti / 3 >= p) {
				counter = counter + tLstSize - i; break;
			} else { 
				if (ti-p < 0) continue;
				int res = (ti - p) / 2;
				//res must be < than p
				if (S ==0){
					if (isLegal(p,res,ti-p-res) && (!isSurprising(p, res, ti-p-res))) counter++;
					continue;
				}
				if (isLegal(p, res, ti-p-res)){
					if (isSurprising(p, res, ti-p-res)){
						S--;
						/*if (S == 0) {
							counter = counter + tLstSize -i; break;
						}*/
					}
					counter++;
				}
				
			}
		}

		return counter;
	}

	public static boolean isLegal(int a, int b, int c) {
		if ((Math.abs(a - b) <= 2) && (Math.abs(b - c) <= 2)
				&& (Math.abs(a - c) <= 2))
			return true;
		else
			return false;
	}

	// assumed that (a,b,c) is a legal triplet
	public static boolean isSurprising(int a, int b, int c) {
		if ((Math.abs(a - b) == 2) || (Math.abs(b - c) == 2)
				|| (Math.abs(a - c) == 2))
			return true;
		return false;
	}

	public static boolean isLegalSurprising(int a, int b, int c) {
		boolean result = false;
		if ((Math.abs(a - b) <= 2) && (Math.abs(b - c) <= 2)
				&& (Math.abs(a - c) <= 2)) {
			if ((Math.abs(a - b) == 2) || (Math.abs(b - c) == 2)
					|| (Math.abs(a - c) == 2))
				result = true;
			else
				result = false;
		} else
			result = false;
		return result;
	}

	static public String getContents(File aFile) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();

		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				line = input.readLine();
				int T = Integer.parseInt(line);
				int i = 1;
				while ((line = input.readLine()) != null) {
					// contents.append(line);
					contents.append("Case #" + i + ": " + dancinggoogler(line));
					if (i < T)
						contents.append(System.getProperty("line.separator"));
					i++;

				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return contents.toString();
	}

	static public void setContents(File aFile, String aContents)
			throws FileNotFoundException, IOException {
		if (aFile == null) {
			throw new IllegalArgumentException("File should not be null.");
		}
		if (!aFile.exists()) {
			throw new FileNotFoundException("File does not exist: " + aFile);
		}
		if (!aFile.isFile()) {
			throw new IllegalArgumentException("Should not be a directory: "
					+ aFile);
		}
		if (!aFile.canWrite()) {
			throw new IllegalArgumentException("File cannot be written: "
					+ aFile);
		}

		// use buffering
		Writer output = new BufferedWriter(new FileWriter(aFile));
		try {
			// FileWriter always assumes default encoding is OK!
			output.write(aContents);
		} finally {
			output.close();
		}
	}

}
