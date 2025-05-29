package GoogleCodeJam.ed2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class QualificationB2012 {

	private String inputFile;
	private String outputFile;

	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		QualificationB2012 qualificationB2012 = new QualificationB2012("QualificationB2012.in", "QualificationB2012.out");
		qualificationB2012.run();
	}

	private void run() throws Exception {
		openFiles();
		solve();
		closeFiles();
	}


	private void solve() throws Exception {
		int tests = Integer.valueOf(reader.readLine());
		for (int test=1; test<=tests; test++) {
			String[] line = reader.readLine().split(" ");
			int n = Integer.valueOf(line[0]);
			int s = Integer.valueOf(line[1]);
			int p = Integer.valueOf(line[2]);
			int maxNoteContestants = 0;
			for (int i=0; i<n; i++) {
				int points = Integer.valueOf(line[3+i]);
				if (haveNormalNoteOverP(points,p)) {
					maxNoteContestants++;
				}
				else if ((s>0) && haveSurprisingNoteOverP(points,p)) {
					s--;
					maxNoteContestants++;
				}
			}
			writer.write("Case #"+test+": "+maxNoteContestants+"\n");
		}
	}

	private boolean haveSurprisingNoteOverP(int points, int p) {
		int note = points / 3;
		int modulo = points % 3;
		if ((modulo == 0) && (note+1<=10) && (note-1>=0) && (note+1>=p)) {
			return true;
		}
		else if ((modulo == 2) && (note+2 <= 10) && ( note+2>=p)) {
			return true;
		}
		return false;
	}

	private boolean haveNormalNoteOverP(int points, int p) {
		int note = points / 3;
		int modulo = points % 3;
		if (((modulo == 0) && (note>=p)) || ((modulo>0) && (note+1>=p))) {
			return true;
		}
		return false;
	}

	public QualificationB2012(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}
	
	private void closeFiles() {
		try {
			reader.close();
			writer.close();
		}
		catch (Exception e) {
			throw new RuntimeException();
		}

	}
	
	private void openFiles() {
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(outputFile));
		}
		catch (Exception e) {
			throw new RuntimeException("File initialization failed");
		}
	}
}
