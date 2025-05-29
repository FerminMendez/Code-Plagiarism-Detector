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
import java.util.HashMap;
import java.util.HashSet;

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
		setContents(new File("C-small-attempt.out"),getContents(new File("C-small-attempt0.in")));
		
		/*System.out.println(getContents(new File("in")));
		setContents(new File("out"),getContents(new File("in")));*/
		// File("A-small-attempt2.in"));
		// System.out.println(isSurprising(8,10,8));
		//digitsReplacement("1114");
	}

	public static int recycledNumber(String str) {
		int counter=0;
		String[] input = str.split(" ");
		int A = Integer.parseInt(input[0]); // lower bound
		int B = Integer.parseInt(input[1]); // upper bound
		HashMap<String,Integer> tHashMap = new HashMap<String,Integer>();
		HashSet<String> tHashSet = new HashSet<String>();
		for (int i=A; i<=B;i++){
			//tHashSet.add(i);
			tHashMap.put(Integer.toString(i),0);
		}
		for (int i=A; i<=B;i++){
			String numberStr = Integer.toString(i);
			String newNumberStr = null;
			int sizeNumberStr = numberStr.length();
			for (int j=1; j<sizeNumberStr;j++){
				newNumberStr = numberStr.substring(j) + numberStr.substring(0,j);
				if (newNumberStr.compareTo(numberStr)!=0) {
					if (tHashMap.containsKey(newNumberStr)){// && !tHashSet.contains(newNumberStr)){
							tHashSet.add(numberStr+newNumberStr);
							//System.out.println(numberStr + " "+newNumberStr);
							//counter++;
							//tHashSet.add(newNumberStr);
							//tHashSet.add(newNumberStr);
							//tHashSet.add(numberStr);
					}
				}
			}
			tHashMap.remove(numberStr);
		}
		return tHashSet.size();
	}
	public static String digitsReplacement(String str){
		String newStr = null;
		int size = str.length();
		for (int i= 1; i<size;i++){
			newStr = str.substring(i) + str.substring(0,i);
			if (newStr.compareTo(str)!=0)
				System.out.println(newStr);
		}
		return "";
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
					contents.append("Case #" + i + ": " + recycledNumber(line));
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
