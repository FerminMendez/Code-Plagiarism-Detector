import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public abstract class FileWrapper {

	protected static final String CASE = "Case #";
	protected static final String OUTPUT = "result.out";
	protected int caseNum = 0;
	protected String output[] = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private FileWriter fw = null;
	private BufferedWriter bw = null;

	protected void openReadFile(String fileName) throws Exception {
		this.fr = new FileReader(fileName);
		this.br = new BufferedReader(this.fr);
	}

	protected void closeReadFile() throws Exception {
		this.br.close();
		this.fr.close();
	}

	protected String readLine() throws Exception {
		return this.br.readLine();
	}
	
	protected boolean isFileReady() throws Exception {
		return this.br.ready();
	}
	
	protected abstract void processInput(String fileName);
	
	private void openWriteFile(String fileName) throws Exception {
		this.fw = new FileWriter(fileName);
		this.bw = new BufferedWriter(this.fw);
	}

	private void closeWriteFile() throws Exception {
		this.bw.close();
		this.fw.close();
	}

	private void writeLine(String line) throws Exception {
		this.bw.write(line);
		this.bw.newLine();
	}
	
	protected void processOutput(String fileName) {
		try{
			this.openWriteFile(fileName);
			for (int i=0; i<this.caseNum; i++) {
				this.writeLine(this.output[i]);
			}
			this.closeWriteFile();
		}catch(Exception e){}
	}
	
	protected abstract void calculate();

}