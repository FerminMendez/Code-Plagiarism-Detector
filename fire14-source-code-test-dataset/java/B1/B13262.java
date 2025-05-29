import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int T = 0;
	public static BufferedReader bufReader;
	public static BufferedWriter bufWriter;
	public static File wFile, rFile;

	private static int tMinLimit = 1;
	private static int tMaxLimit = 50;
	private static String rFilename = "C-small-attempt0.in";
	private static String wFilename = "OUTPUT0.txt";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		rFile = new File(rFilename);
		bufReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(rFile), "utf8"));

		wFile = new File(wFilename);// 建立檔案，準備寫檔
		bufWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(wFile, false), "utf8"));

		T = Integer.valueOf(bufReader.readLine().trim());
		if (tMinLimit <= T && T <= tMaxLimit) {
			for (int i = 1; i <= T; i++) {
				String[] AB = bufReader.readLine().split(" ");
				new Round1C(i, Integer.parseInt(AB[0]), Integer.parseInt(AB[1]));
			}
		}
		bufWriter.close();
	}

}