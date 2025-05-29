import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.StringTokenizer;


public class one {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("input.txt");
		FileInputStream instream = new FileInputStream(f);
		BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
				
		File f2 = new File("output.txt");
		FileOutputStream outstream = new FileOutputStream(f2);
		BufferedOutputStream of = new BufferedOutputStream(outstream);
		DataOutputStream writer = new DataOutputStream(of);
		
		int cases = Integer.parseInt(reader.readLine());
		for (int casenum = 1; casenum <= cases; casenum++) {
			String s = reader.readLine();
			StringTokenizer ts = new StringTokenizer(s);
			int x = Integer.parseInt(ts.nextToken());
			int y = Integer.parseInt(ts.nextToken());
			String s_out = "Case #"+casenum+": ";
			int count = 0;
			for (int i = x; i < y; i++) {
				for (int j = i+1; j <= y; j++) {
					if(isRecycled(i, j)){
						count++;
					}
				}
			}
			s_out += count;
			s_out += '\n';
			writer.write(s_out.getBytes());
			System.out.println(count);
		}
		
		writer.flush();
		writer.close();
	}
	static boolean isRecycled(int x_, int y_){
		String x = Integer.toString(x_);
		String y = Integer.toString(y_);
		String temp = "";
		String test = "";
		for (int i = 0; i < x.length()-1; i++) {
			temp += x.charAt(i);
			test = x.substring(i+1) + temp ;
			if(test.equalsIgnoreCase(y))
				return true;
		}
		return false;
	}

}
