/**
 * Program : Test for google code jam
 * Author  : jenogg
 * Since   : 2012.04.14
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Subject0102 {

	/** Mapping map */
	private Map<String, String> mapper;
	
	/**
	 * Construct
	 */
	public Subject0102() {
		init();
	}
	
	/**
	 * Initialize.
	 */
	private void init() {
		/*
			Input
			3
			ejp mysljylc kd kxveddknmc re jsicpdrysi
			rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd
			de kr kd eoya kw aej tysr re ujdr lkgc jv
	
			Output
			Case #1: our language is impossible to understand
			Case #2: there are twenty six factorial possibilities
			Case #3: so it is okay if you want to just give up
		*/
		String input  = " abcdefghijklmnopqrstuvwxyz";
		String output = " yhesocvxduiglbkrztnwjpfmaq";
		mapper = new HashMap<String, String>();
		for (int letter=0; letter < input.length(); letter++) {
			mapper.put(input.substring(letter,letter+1), output.substring(letter,letter+1));
		}
	}

	/**
	 * Test
	 */
	public void test() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String systemIn;
		int sentenceSize = 0;
		String[] sentence = new String[]{};
		try {
			//println("Input");
			systemIn = nvl(in.readLine());
			sentenceSize = getSentenceSize(systemIn);
			if (sentenceSize > 0) {
				sentence = new String[sentenceSize];
				for (int index = 0; index < sentenceSize; index++) {
					systemIn = in.readLine();
					sentence[index] = nvl(systemIn);
				}
				//println("\n-------------------------------------------\n");
				in.close();
				
				//println("Output");
				for (int index = 0; index < sentenceSize; index++) {
					print("Case #" + (index+1) + ": ");
					printSentence(sentence[index]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets size of sentences
	 * @param sentenceSize Sentence size
	 * @return Size of sentences
	 * @throws Exception
	 */
	private int getSentenceSize(String sentenceSize) throws Exception {
		return Integer.parseInt(nvl(sentenceSize, "0"));
	}

	/**
	 * Print mapping sentence
	 * @param sentence Source sentence
	 */
	private void printSentence(String sentence) {
		int success = 0;
		
		String[] data = sentence.split(" ");
		int dancers = Integer.parseInt(data[0]);
		int suprise = Integer.parseInt(data[1]);
		int cutline = Integer.parseInt(data[2]);
		
		if (cutline == 0) {
			success = dancers;
		} else {
			for (int index=0; index < dancers; index++) {
				int totalPoint = Integer.parseInt(data[3+index]);
				if (totalPoint == 0) {
					continue;
				}
				int basePoint = totalPoint / 3;
				int rest = totalPoint % 3;
				int canPoint  = basePoint;
				
				if (rest != 0) {
					canPoint++;
				}
				if (canPoint >= cutline) {
					success++;
					continue;
				}
				
				if (suprise > 0) {
					if (rest != 1) {
						canPoint++;
						if (canPoint >= cutline) {
							success++;
							suprise--;
							continue;
						}
					}
				}
			}
		}
		println(success);
	}
	
	/**
	 * Replace null to empty string
	 * @param string Input value of string
	 * @return If input string is null then empty string, otherwise trimmed input string
	 */
	private String nvl(String string) {
		return nvl(string, "");
	}

	/**
	 * Replace null to replace string
	 * @param string Input value of string
	 * @param replace Replace value of string
	 * @return If input string is null then empty string, otherwise trimmed input string
	 */
	private String nvl(String string, String replace) {
		return string == null ? "" : string.trim();
	}

	/**
	 * Print out
	 * @param obj Value of object
	 */
	private void print(Object obj) {
		System.out.print(obj);
	}
	
	/**
	 * Print line out
	 */
	private void println() {
		println("");
	}
	
	/**
	 * Print line out
	 * @param obj Value of object
	 */
	private void println(Object obj) {
		System.out.println(obj);
	}

	/**
	 * main
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		Subject0102 subject = new Subject0102();
		subject.test();
	}
}
