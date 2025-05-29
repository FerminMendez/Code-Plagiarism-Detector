package fixjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Iterator that iterates over the lines of the file and then closes it after the last line has been read.
 * 
 * e.g.
 * 
 * <code>
 * 
 * for (String line : new FileLineIterator("in.txt"))
 *     System.out.println(line);
 * 
 * for (NumberedLine nl : new FileLineIterator("in.txt").withLineNumbers())
 *     System.out.println(nl.getLineNum() + " " + nl.getLine());
 *     
 * </code>
 */
public class FileLineIterator implements Iterable<String>, Iterator<String> {

	private BufferedReader reader;
	String nextLine = null;
	boolean nextLineAlreadyFetched = false;
	private int lineNum = -1;

	// ------------------------------------------------------------------------------------------

	/**
	 * Construct an iterator that iterates over the lines of the file and then closes it after the last line has been read.
	 * 
	 * e.g. for (String line : new FileLineIterator("in.txt")) System.out.println(line);
	 * 
	 * @throws IllegalArgumentException
	 *             on any I/O exception, so you can use this directly in foreach loops.
	 */
	public FileLineIterator(String filename) {
		this(new File(filename));
	}

	/**
	 * Construct an iterator that iterates over the lines of the file and then closes it after the last line has been read.
	 * 
	 * e.g. for (String line : new FileLineIterator(file)) System.out.println(line);
	 * 
	 * @throws IllegalArgumentException
	 *             on any I/O exception, so you can use this directly in foreach loops.
	 */
	public FileLineIterator(File file) {
		try {
			reader = new BufferedReader(new FileReader(file), 1024 * 1024);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public Iterator<String> iterator() {
		return this;
	}

	// ------------------------------------------------------------------------------------------

	private String getNextLine(boolean consume) {
		if (!nextLineAlreadyFetched) {
			try {
				nextLine = reader.readLine();
				lineNum++;
				nextLineAlreadyFetched = true;
				if (nextLine == null)
					// Close reader after last line has been read
					reader.close();
			} catch (IOException e) {
				if (reader != null)
					try {
						reader.close();
					} catch (Exception e2) {
					}
				throw new IllegalArgumentException(e);
			}
		}
		String retVal = nextLine;
		if (consume) {
			nextLine = null;
			nextLineAlreadyFetched = false;
		}
		return retVal;
	}

	/** Return the current zero-indexed line number -- only returns the correct line number after a call to hasNext() or next() */
	public int getLineNum() {
		return lineNum;
	}

	@Override
	public boolean hasNext() {
		return getNextLine(false) != null;
	}

	@Override
	public String next() {
		return getNextLine(true);
	}

	@Override
	public void remove() {
		getNextLine(true);
	}

	// ------------------------------------------------------------------------------------------

	public class NumberedLine {
		String line;
		int lineNum;

		public NumberedLine(String line, int lineNum) {
			this.line = line;
			this.lineNum = lineNum;
		}

		public String getLine() {
			return line;
		}

		public int getLineNum() {
			return lineNum;
		}
	}

	/** Return an Iterable<NumberedLine> that includes the line number with each line */
	public Iterable<NumberedLine> withLineNumbers() {
		final FileLineIterator fileLineIter = this;
		return new Iterable<NumberedLine>() {
			@Override
			public Iterator<NumberedLine> iterator() {
				return new Iterator<NumberedLine>() {
					@Override
					public void remove() {
						fileLineIter.remove();
					}

					@Override
					public NumberedLine next() {
						String line = fileLineIter.next();
						int lineNum = fileLineIter.getLineNum();
						return new NumberedLine(line, lineNum);
					}

					@Override
					public boolean hasNext() {
						return fileLineIter.hasNext();
					}
				};
			}
		};
	}
}
