import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;


public class Dancing implements Runnable {

	private BufferedReader in;
	private BufferedWriter out;
	private static String inputFile = "";
	private static String outputFile = "";
	static{
		inputFile = "B-small-attempt0.in";
		outputFile = "B-small-attempt0.out";
	}
	
	private String count( String inputString ) {
		if( inputString == null || inputString.length() <= 1 ) {
			return null;
		}
		
		String[] inputToken = inputString.split(" ");
		
		int scoreCount = Integer.parseInt(inputToken[0]);
		int surprise = Integer.parseInt(inputToken[1]);
		int highScore = Integer.parseInt(inputToken[2]);
		
		List<String> scores = new LinkedList<String>();
		for( int i = 3; i < inputToken.length; i++ ) {
			scores.add(i-3, inputToken[i]);
		}

		int count = find( surprise, highScore, scores );
		
		return count+"\n";
	}
	
	private int find( int surprise, int highScore, List<String> scores ) {
		for( int i = 0; i < scores.size(); i++ ) {
			int score = Integer.parseInt(scores.get(i));
			
			int remainder = score % 3;
			switch( remainder ) {
				case 0:
					if( score/3 >= highScore ) break;
					
					if( score/3 <= 0 ) {
						scores.remove(i);
						i--;
						break;
					}
					
					if( surprise <= 0 ) {
						scores.remove(i);
						i--;
					} else {
						if( score/3 < highScore-1 ) {
							scores.remove(i);
							i--;
						} else {
							surprise--;
						}
					}
					break;
				case 1:
					if( score/3 >= highScore - 1 ) break;
					scores.remove(i);
					i--;
					break;
				case 2:
					if( score/3 >= highScore - 1 ) break;
					if( score/3 >= highScore - 2 && surprise > 0 ) {
						surprise--;
						break;
					}
					
					scores.remove(i);
					i--;
					break;
			}
		}
		return scores.size();
	}
	
	private void solve() throws Exception {
		String inputString = in.readLine();
		
		int roop = Integer.parseInt(inputString);
		for( int i = 1; i <= roop; i++ ) {
			inputString = in.readLine();
			if(inputString == null || inputString.length() <= 0) {
				i--;
				continue;
			} else {
				out.write( "Case #"+i+": " + count(inputString) );
			}
		}
	}
	
	@Override
	public void run() {
		try {
			in = new BufferedReader( new FileReader(inputFile) );
			out = new BufferedWriter( new FileWriter(outputFile) );
		//	in = new BufferedReader( new InputStreamReader(System.in) );
		//	out = new BufferedWriter( new OutputStreamWriter(System.out) );
			
			solve();
			
			out.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Dancing()).start();
	}
}
