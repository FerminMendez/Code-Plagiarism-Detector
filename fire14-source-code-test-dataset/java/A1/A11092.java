package problemB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DancingWithTheGooglers {
	final static String DIRECTORY = "ioFile";
	
	final static String FNAME = "B-small-attempt2";

	public BufferedReader in;

	public PrintWriter out;

	void open() throws IOException {
		in = new BufferedReader( new FileReader( new File( DIRECTORY + "/" + FNAME + ".in" ) ) );
		out = new PrintWriter( new File( DIRECTORY + "/" +  FNAME + ".out" ) );
	}

	void close() throws IOException {
		out.close();
	}
	
	void run() throws IOException {
		String nac = in.readLine();		
		for (int i=0; i<Integer.parseInt(nac); i++){
			int count = 0;
			String line = in.readLine();
			String [] sa = line.split(" ");
			int n = Integer.parseInt(sa[0]);
			int s = Integer.parseInt(sa[1]);
			int p = Integer.parseInt(sa[2]);
			List<Integer> list = new ArrayList<Integer>();
			for ( int j = 3; j < sa.length; j++) {
				list.add(Integer.parseInt(sa[j]));				
			}
			for ( int j =0; j<n && s>=0; j++) {
				int num = list.get(j);
				if ( num % 3 == 0) {
					if ( num/3 >= p)
						count ++;
					else if (num > 0 && s>0 &&  num/3+1 >=p) {
						s--;
						count++;
					}
				}
				else if ( num % 3 == 1 && num/3 +1 >=p	) {
					count ++;
				}
				else if ( num % 3 == 2 ) {
					if ( num/3 +1 >= p) 
						count ++;
					else if (s>0 &&  num/3 + 2 >=p ) {
						s--;
						count ++;
					}						
				}
//				if ( (num/3 ) >= p) 
//					count ++;
//				else if (num > 0 && s>0 && (num/3 + 2) >=p ) {
//					s--;
//					count++;
//				}
			}
			out.println("Case #" + (i+1) + ": " + count);
		}		
	}
	
	int count(String sNumber, char ch){
		int count=0;
		for(int i=0;i<sNumber.length();i++){
			if(sNumber.charAt(i)==ch)
				count++;
		}
		return count;
	}
	
	public static void main( String[] args ) throws IOException {
		new Thread() {

			public void run() {
				try {
					DancingWithTheGooglers solution = new DancingWithTheGooglers();
					solution.open();
					solution.run();
					solution.close();
				} catch ( Exception e ) {
					throw new RuntimeException( e );
				}
			}
		}.start();
	}
}
