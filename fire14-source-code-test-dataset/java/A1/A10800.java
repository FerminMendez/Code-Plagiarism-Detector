import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Fattom2012B {
	private final String _PROBLEM_NO = "201201B";
	private final String _FILE_DIRECTORY = "K:/Dropbox/workspace/codejam/" + _PROBLEM_NO + "/";
	private final String _FILE_PATH = _FILE_DIRECTORY + "B-small-attempt7";
	
	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		new Fattom2012B().execute();
	}

	public void execute() {
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			br = new BufferedReader(new FileReader(_FILE_PATH + ".in"));
			pw = new PrintWriter(_FILE_PATH + ".out");
			 
			//main
			int caseno = Integer.parseInt(br.readLine());
			
			for (int count = 1; count <= caseno; count++) {
				pw.print("Case #" + count + ": ");
				System.out.print("Case #" + count + ": ");
				
				String line = br.readLine();
				
					String[] splits = line.split(" ");
					int N = Integer.parseInt(splits[0]); 
					int S = Integer.parseInt(splits[1]); 
					int P = Integer.parseInt(splits[2]); 
					int r = 0;
					for(int j=0;j<N;j++) {
						int tt = Integer.parseInt(splits[3 +j]);
						if(tt==0) {
							if(P==0) 
								r++;
							continue;
						}
						int t = tt - P*3;
						if(t >= -2) {
							r++;
						}
						else if(S > 0 && ((t == -3) || (t == -4))) {
							r++;S--;
						}
					}
					pw.print(r);
					System.out.print(r);
				
				
				pw.print("\n");
				System.out.print("\n");
			}
			
			//end
	
	
			br.close();
			pw.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pw != null) pw.close();
			} catch(Exception e) {}
			try {
				if(br != null) br.close();
			} catch(Exception e) {}
		}
	}

}
