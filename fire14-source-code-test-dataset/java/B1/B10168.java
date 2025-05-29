import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class RecycledNumbers {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: java RecycledNumbers <input-file> <output-file>");
			System.exit(0);
		}
		
		try {
			
			RecycledCounter counter = 
					new RecycledCounter(new FileReader(args[0]), new FileWriter(args[1]));
			counter.count();
			
		} catch (Exception e) {
			
			System.out.println("Sorry, there was a fatal error:");
			e.printStackTrace();
			System.exit(0);
		}
	}
}

class RecycledCounter {
	
	private final BufferedReader reader;
	private final PrintWriter writer;
	
	public RecycledCounter(Reader in, Writer out) throws IOException {
		
		reader = new BufferedReader(in);
		writer = new PrintWriter(out);
	}
	
	public void count() throws IOException {
		
		String line = reader.readLine();
		int numTests = Integer.parseInt(line);
		
		for (int i = 0; i < numTests; i++) {
			
			line = reader.readLine();
			writer.printf("Case #%d: %s", i + 1, countNumberOfRecycledPairs(line));
			writer.println();
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public int countNumberOfRecycledPairs(String line) {
		
		String[] tokens = line.split(" ");
		int a = Integer.parseInt(tokens[0]);
		int b = Integer.parseInt(tokens[1]);
		
		int y = 0;
		Set<String> distinct = new HashSet<String>();
		
		for (; a <= b; a++) {
			
			if (a < 10) {
				continue;
			}
			
			String num = String.valueOf(a);
			for (int i = num.length() - 1; i > 0; i--) {
				String recycledNum = num.substring(i) + num.substring(0, i);
				if (recycledNum.startsWith("0")) {
					continue;
				}
				int recycled = Integer.valueOf(recycledNum);
				if (recycled >= a && recycled <= b && a < recycled && !distinct.contains(num + recycledNum)) {
					distinct.add(num + recycledNum);
					y++;
				}
			}
		}
		
		return y;
	}
}
