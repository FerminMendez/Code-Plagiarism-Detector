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
 * Problem A : 
 *
 */
public class ProblemA implements Runnable {
	
	asem.core.util.InputReader fin;
	java.io.PrintWriter fout;

	/**
	 * @param fin
	 * @param fout
	 */
	public ProblemA(asem.core.util.InputReader fin, PrintWriter fout) {
		this.fin = fin;
		this.fout = fout;
	}
	
	/**
	 * @param fin
	 * @param fout
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ProblemA(String fin, String fout) throws FileNotFoundException, IOException {
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
			
			String ciphertext1 = new String("ejp mysljylc kd kxveddknmc re jsicpdrysi");
			String ciphertext2 = new String("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd");
			String ciphertext3 = new String("de kr kd eoya kw aej tysr re ujdr lkgc jv qz");
			String plaintext1 = new String("our language is impossible to understand");
			String plaintext2 = new String("there are twenty six factorial possibilities");
			String plaintext3 = new String("so it is okay if you want to just give up zq");
			
			String code = new String("abcdefghijklmnopqrstuvwxyz");
			String code2 = new String();
			
			char ch = ' ';
			for (int i = 0; i < 26; i++) {
				ch = code.charAt(i);
				
				if (plaintext1.indexOf(ch) >= 0)
					code2 += ciphertext1.charAt(plaintext1.indexOf(ch));
				else if (plaintext2.indexOf(ch) >= 0)
					code2 += ciphertext2.charAt(plaintext2.indexOf(ch));
				else if (plaintext3.indexOf(ch) >= 0)
					code2 += ciphertext3.charAt(plaintext3.indexOf(ch));
				else
					code2 += ch;
			}
			
			
			for (int tNum = 1, inT = fin.readInt(); tNum <= inT; tNum++) {
				
				String ciphertext = fin.readLine(true);
				String plaintext = new String();
				
				for (int i = 0; i < ciphertext.length(); i++)
					if (code2.indexOf(ciphertext.charAt(i)) >= 0)
						plaintext += code.charAt(code2.indexOf(ciphertext.charAt(i)));
					else if (ciphertext.charAt(i) == ' ')
						plaintext += ciphertext.charAt(i);
				
				System.out.println("Case #" + tNum + ": " + plaintext);
				
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