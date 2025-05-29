import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class QR2 {
	private String[][] in;
	private int numCases;
	private String[] out;
	
	public QR2() {
		String inFilename = "B-small-attempt2.in";
		readFile(inFilename);
		numCases = new Integer(in[0][0]);
		out = new String[numCases];
		calculateResult();
		String outFilename = "B-small-attempt2.out";
		writeOut(outFilename);
	}
	
	public void calculateResult() {
		int arp = 1;
		for(int c = 0; c < numCases; c++) {
			int N = new Integer(in[arp][0]);
			int S = new Integer(in[arp][1]);
			int p = new Integer(in[arp][2]);
			int[] t = new int[N];
			for(int i = 0; i < N; i++) {
				t[i] = new Integer(in[arp][3+i]);
			}
			
			int nsupo = 0;
			int supo = 0;
			
			for(int ct : t) {
				if(((ct+2)/3) >= p) {
					nsupo++;
				} else if((ct > 0) && (((ct+4)/3) >= p)) {
					supo++;
				}
			}
			
			if(supo >= S) {
				out[c] = (new Integer(nsupo + S)).toString();
			} else {
				out[c] = (new Integer(nsupo + supo)).toString();
			}
			
			arp++;
		}
	}
	
	public void readFile(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String cl;
			ArrayList<String[]> inal = new ArrayList<String[]>();
			while((cl = br.readLine()) != null) {
				String[] cle = cl.split("\\s");
				inal.add(cle);
			}
			in = inal.toArray(new String[0][]);
			br.close();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void writeOut(String filename) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for(int i = 0; i < out.length; i++) {
				int caseNum = i + 1;
				String caseTxt = "Case #" + caseNum + ": ";
				if(i > 0) {
					bw.newLine();
				}
				bw.write(caseTxt);
				bw.write(out[i]);
			}
			bw.close();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void printInArray() {
		for(int i = 0; i < in.length; i++) {
			for(int j = 0; j < in[i].length; j++) {
				System.out.print(in[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new QR2();
	}

}
