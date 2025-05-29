import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;


public class B implements Runnable{

	public static void main(String[] args) {
		new Thread(new B()).start();
	}

	private BufferedReader in;
	private PrintWriter out;
	
	public B() {
		try {
			System.setIn(new FileInputStream("C:/Users/Admin/AppData/Local/Temp/b-small.in"));
			System.setOut(new PrintStream(new FileOutputStream("b-small.out")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.err.println("hello");
		String Scases = null;
		try {
			Scases = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cases = Integer.parseInt(Scases);
		System.err.println(cases + " tests found.");
		for(int testNo = 1; testNo <= cases; testNo++) {
			out.print("Case #" + testNo + ": ");
			
			try {
				String line1 = in.readLine();
				
				String[] strings = line1.split(" ");
				int participants = Integer.parseInt(strings[0]);
				int surprises = Integer.parseInt(strings[1]);
				int neededScore = Integer.parseInt(strings[2]);
				
				System.err.printf("%d participants, %d surprises, %d min. score.\n", participants, surprises, neededScore);
				
				Vector<Integer> scores = new Vector<Integer>();
				for (int i=3; i < strings.length; i++) {
					scores.add(Integer.parseInt(strings[i]) );
				}
				System.err.printf("scores: %s \n", scores.toString());
				
				int possible = 0;
				int possibleWithSurprise = 0;
				int impossible = 0;
				
				for(int score : scores) {
					float f = score / 3.0f;
					float diff = neededScore - f;
					
					if ( (2*(Math.max(neededScore-2,0)) + 1*neededScore) > score) {
						impossible++;
					} else {
						if (diff >= 0.7 && diff < 1.4) {
							possibleWithSurprise++;
						} else if (diff < 0.7) {
							possible++;
						} else {
							impossible++;
						}
					}
					
					System.err.println("score/3: " + f + "nf:" + (neededScore - f) );
					}
				System.err.printf("%d possible %d possibleWithSurprise %d impossible\n\n", possible, possibleWithSurprise, impossible);					
				
				int total = Math.min(possibleWithSurprise, surprises) + possible;
				out.print(total);
				
				
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			out.print("\n");
		}
		out.close();
	}

}
