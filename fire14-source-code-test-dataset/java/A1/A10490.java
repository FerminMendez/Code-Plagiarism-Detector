import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GCIFileReader {

	public GCIFileReader(File file) throws FileNotFoundException {
		mBufferedReader = new BufferedReader(new FileReader(file));
		mFile = file;
	}
	
	public String getLine() {
		try {
			String s = mBufferedReader.readLine();
			if (s == null)
			{
				mBufferedReader.close();
			}
			return s;	
		} catch (IOException e) {
			return null;
		}
	}
	
	public void reset () throws IOException
	{
		mBufferedReader.close();
		mBufferedReader = new BufferedReader(new FileReader(mFile));
	}
	
	private BufferedReader mBufferedReader;
	private File           mFile;

}