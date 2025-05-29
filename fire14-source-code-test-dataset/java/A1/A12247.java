/**
 * 
 */
package asem.googe.codejam.qround;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author A.Alathwari
 * 
 * Problem C : 
 *
 */
public class ProblemC implements Runnable {
	
	asem.core.util.InputReader fin;
	java.io.PrintWriter fout;

	/**
	 * @param fin
	 * @param fout
	 */
	public ProblemC(asem.core.util.InputReader fin, PrintWriter fout) {
		this.fin = fin;
		this.fout = fout;
	}
	
	/**
	 * @param fin
	 * @param fout
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ProblemC(String fin, String fout) throws FileNotFoundException, IOException {
		this.fin  = new asem.core.util.InputReader(new FileReader(fin));
		this.fout = new PrintWriter(System.out);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			for (int tNum = 1, inT = fin.readInt(); tNum <= inT; tNum++) {
				
				System.out.println("Case #" + tNum + ": " + "");
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}