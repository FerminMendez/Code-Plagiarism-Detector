/**
 * 
 */
package asem.core.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

/**
 * @author A.Alathwari
 * 
 * InputReader 
 *
 */
public class InputReader extends BufferedReader {

	/**
	 * @param in
	 */
	public InputReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param in
	 * @param sz
	 */
	public InputReader(Reader in, int sz) {
		super(in, sz);
		// TODO Auto-generated constructor stub
	}

	public InputReader(String fileName) throws java.io.FileNotFoundException {
		// TODO Auto-generated constructor stub
		this(new FileReader(fileName));
	}
	
	public String readLine(boolean skipEmptyLines) throws IOException {

		String str = this.readLine();
		
		if (skipEmptyLines)
			while (str.length() == 0)
				str = this.readLine();
			
		return str; 
	}
	
	private String readIntegral() throws IOException {
		
		int c = this.read();
		
		while (c == ' ' || c == '\n' || c == '\t' || c == '\r')
			c = this.read();
		
		boolean sign = false;
		
		while (c == '-') {
			c = this.read();
			sign = !sign;
		}
		
		StringBuffer buf = new StringBuffer();
		while (Character.isDigit(c)) {
			buf.append((char) c);
			this.mark(1);
			c = this.read();
		}

		this.reset();
		
		return (sign) ? "-" + buf.toString() : buf.toString();
	}
	
	private String readFlat() throws IOException {
		
		int c = this.read();
		
		while (c == ' ' || c == '\n' || c == '\t' || c == '\r')
			c = this.read();
		
		boolean sign = false;
		
		while (c == '-') {
			c = this.read();
			sign = !sign;
		}
		
		StringBuffer buf = new StringBuffer();
		while (Character.isDigit(c) || c == '.') {
			buf.append((char) c);
			this.mark(1);
			c = this.read();
		}
		
		this.reset();
		
		return (sign) ? "-" + buf.toString() : buf.toString();
	}
	
	public int readInt() throws IOException {
		return Integer.parseInt(readIntegral());
	}
	
	public long readLong() throws IOException {
		return Long.parseLong(readIntegral());
	}
	
	public double readDouble() throws IOException {
		return Double.parseDouble(readFlat());
	}
	
	public BigInteger readBigInteger() throws IOException {
		
		try {
			return new BigInteger(readWord());
		} catch (NumberFormatException e) {
			throw new java.util.InputMismatchException();
		}
	}
	
	@SuppressWarnings("deprecation")
	public String readWord() throws IOException {
		
		int c = this.read();
		
		while (Character.isSpace((char)c))
			c = this.read();
		
		StringBuffer res = new StringBuffer();
		do {
			res.appendCodePoint(c);
			c = this.read();
		} while (!Character.isSpace((char)c) && Character.isDefined(c));
		
		return res.toString();
	}
	
	@SuppressWarnings("deprecation")
	public String readString() throws IOException {
		
		int c = this.read();
		
		while (Character.isSpace((char) c))
			c = this.read();
		
		StringBuffer buf = new StringBuffer();
		while (Character.isDefined(c)) {
			buf.append((char) c);
			this.mark(1);
			c = this.read();
		}
		
		this.reset();
		
		return buf.toString();
	}
	
	@SuppressWarnings("deprecation")
	public char readCharacter() throws IOException {
		
		char c = (char) this.read();
		
		while (Character.isSpace(c))
			c = (char) this.read();
		
		return c;
	}
}
