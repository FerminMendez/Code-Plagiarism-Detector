/**
 * 
 */
package asem.google.codejam;

//import asem.google.codejam.pract.y2010.qround.ProblemC;


/**
 * @author A.Alathwari
 * 
 * MainClass 
 *
 */
public class MainClass {
	
	public static String INPUT_FILE_PATH  = "input.txt";
	public static String OUTPUT_FILE_PATH = "output.txt";
	
	/**
	 * 
	 */
	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setOut(new java.io.PrintStream(
					new java.io.FileOutputStream(MainClass.OUTPUT_FILE_PATH)));
			
			new Thread(new asem.googe.codejam.qround.ProblemB(
					MainClass.INPUT_FILE_PATH, MainClass.OUTPUT_FILE_PATH)).start();
			
		} catch (java.io.FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
