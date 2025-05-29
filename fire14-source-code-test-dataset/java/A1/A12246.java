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
 * Problem B : 
 *
 */
public class ProblemB implements Runnable {
	
	asem.core.util.InputReader fin;
	java.io.PrintWriter fout;

	/**
	 * @param fin
	 * @param fout
	 */
	public ProblemB(asem.core.util.InputReader fin, PrintWriter fout) {
		this.fin = fin;
		this.fout = fout;
	}
	
	/**
	 * @param fin
	 * @param fout
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ProblemB(String fin, String fout) throws FileNotFoundException, IOException {
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
				
				int N = fin.readInt();
				int S = fin.readInt();
				int P = fin.readInt();
				
				int [] googlers = new int [N];
				int y = 0;
				
				for (int i = 0; i < N; i++) {
					googlers[i] = fin.readInt();
					
					if (googlers[i] == 0) {
						if (P == 0)
							y++;
						continue;
					}

					if ((Math.ceil((double)googlers[i] / 3) >= P)) {
						y++;
						continue;
					}
					
					if (S > 0 && (Math.ceil((double)(googlers[i]-1) / 3) >= (P-1))) {
						y++;
						S--;
					}
				}

				System.out.println("Case #" + tNum + ": " + y);
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