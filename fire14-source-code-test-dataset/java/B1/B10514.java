import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class GCIFileWriter {
	
	public GCIFileWriter (File file) throws IOException {
		mBufferedWriter = new BufferedWriter(new FileWriter(file));
		mFile = file;
	}
	
	public void writeResult(GCIResult res) throws IOException
	{
		Iterator<String> it = res.iterator();
		while(it.hasNext())
		{
			mBufferedWriter.write(it.next() + "\n");
			mBufferedWriter.flush();
		}
	}
	
	public void reset() throws IOException
	{
		mBufferedWriter.close();
		mBufferedWriter = new BufferedWriter(new FileWriter(mFile));
	}
	
	public void close() throws IOException
	{
		mBufferedWriter.flush();
		mBufferedWriter.close();
	}

	private BufferedWriter mBufferedWriter;
	private File           mFile;

}
