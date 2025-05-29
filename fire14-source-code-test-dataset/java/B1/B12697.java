import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class SpeakingInTongues {

	static int caseNumber;
	static int totalCases;
	static HashMap<Character, Character> map = new HashMap(36); 
	//Uses 36 so the map doesn't rebuild to keep the load factor below .75 with 26 maps

	public static void main(String[] args) throws Exception {

		caseNumber = 1;
	

		File fileIn = new File("C:\\GCJ\\SpeakingInTongues\\A-small-attempt1.in");
		FileInputStream fileInputStream = null;
		BufferedInputStream inputStream = null;
		BufferedReader reader = null;
		Writer out;

		String newLine = System.getProperty("line.separator");

		String fileOutPath = "C:\\GCJ\\SpeakingInTongues\\outputSmall2.txt";
		File fileOut = new File(fileOutPath);
		if (!fileOut.createNewFile()) {
			fileOut.delete();
			fileOut.createNewFile();
		}

		out = new OutputStreamWriter(new FileOutputStream(fileOutPath), "US-ASCII");
		StringBuilder builder = new StringBuilder();

		map.put('a', 'y');
		map.put('b', 'h');
		map.put('c', 'e');
		map.put('d', 's');
		map.put('e', 'o');
		map.put('f', 'c');
		map.put('g', 'v');
		map.put('h', 'x');
		map.put('i', 'd');
		map.put('j', 'u');
		map.put('k', 'i');
		map.put('l', 'g');
		map.put('m', 'l');
		map.put('n', 'b');
		map.put('o', 'k');
		map.put('p', 'r');
		map.put('q', 'z'); //Not given to us in the sample. Either Q or Z, the other not given
		map.put('r', 't');
		map.put('s', 'n');
		map.put('t', 'w');
		map.put('u', 'j');
		map.put('v', 'p');
		map.put('w', 'f');
		map.put('x', 'm');
		map.put('y', 'a');
		map.put('z', 'q'); //Not given to us in the sample. Either Z or Q, the other not given
		map.put(' ', ' ');
		
		try {
			fileInputStream = new FileInputStream(fileIn);

			// Here BufferedInputStream is added for fast reading.
			inputStream = new BufferedInputStream(fileInputStream);
			reader = new BufferedReader(new InputStreamReader(inputStream));

			totalCases = Integer.parseInt(reader.readLine());
			while (caseNumber <= totalCases) {
				builder.append(handleTestCase(reader));
				builder.append(newLine);
				caseNumber++;
			}

			// dispose all the resources after using them.
			fileInputStream.close();
			inputStream.close();
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(builder.toString());
		out.write(builder.toString());
		out.close();
	}

	public static String handleTestCase(BufferedReader reader) throws Exception {
		String line = reader.readLine();
		char[] chars = line.toCharArray();
		for (int i = 0; i < chars.length; i++){
			chars[i] = map.get(chars[i]);
		}
		return "Case #"+caseNumber+": "+String.valueOf(chars);
	}
}
