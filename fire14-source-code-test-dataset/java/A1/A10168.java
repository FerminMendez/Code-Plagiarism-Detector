import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DancingWithTheGooglers {

	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("Usage: java DancingWithTheGooglers <input-file> <output-file>");
			System.exit(0);
		}
		
		try {
			
			DancingGooglerScoreProcessor processor = 
					new DancingGooglerScoreProcessor(new FileReader(args[0]), new FileWriter(args[1]));
			processor.process();
			
		} catch (Exception e) {
			
			System.out.println("Sorry, there was a fatal error:");
			e.printStackTrace();
			System.exit(0);
		}
	}
}

class DancingGooglerScoreProcessor {
	
	private final BufferedReader reader;
	private final PrintWriter writer;
	
	public DancingGooglerScoreProcessor(Reader in, Writer out) throws IOException {
		
		reader = new BufferedReader(in);
		writer = new PrintWriter(out);
	}
	
	public void process() throws IOException {
		
		String line = reader.readLine();
		int numTests = Integer.parseInt(line);
		
		for (int i = 0; i < numTests; i++) {
			
			line = reader.readLine();
			writer.printf("Case #%d: %d", i + 1, processLine(line));
			writer.println();
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	private int processLine(String line) {
		
		String[] tokens = line.split(" ");
		int[] scores = new int[Integer.parseInt(tokens[0])];
		int S = Integer.parseInt(tokens[1]);
		int p = Integer.parseInt(tokens[2]);
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(tokens[3+i]);
		}
		
		int numSurprises = 0;
		int n = 0;
		
		for (int score : scores) {
			
			Set<Triplet> triplets = getPossibleTriplets(score);
			removeTripletsThatWillNeverHappen(triplets);
			if (hasBestResultOrBetterNoSurprise(p, triplets)) {
				n++;
			} else {
				if (numSurprises < S && hasBestResultOrBetterSurprising(p, triplets)) {
					n++;
					numSurprises++;
				}
			}
		}
		
		return n;
	}
	
	private void removeTripletsThatWillNeverHappen(Set<Triplet> triplets) {
		
		for (Iterator<Triplet> itr = triplets.iterator(); itr.hasNext();) {
			Triplet t = itr.next();
			if (t.willNeverHappen()) {
				itr.remove();
			}
		}
	}
	
	private boolean hasBestResultOrBetterNoSurprise(int bestResult, Set<Triplet> triplets) {
		
		return hasBestResultOrBetter(bestResult, triplets, false);
	}
	
	private boolean hasBestResultOrBetterSurprising(int bestResult, Set<Triplet> triplets) {
		
		return hasBestResultOrBetter(bestResult, triplets, true);
	}
	
	private boolean hasBestResultOrBetter(int bestResult, Set<Triplet> triplets, boolean surprisingAllowed) {
		
		for (Triplet t : triplets) {
			if (t.getBestResult() >= bestResult) {
				if (t.isSurprising() && !surprisingAllowed) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
	
	private Set<Triplet> getPossibleTriplets(int totalScore) {
		
		Set<Triplet> possibleTriplets = new HashSet<Triplet>();
		
		for (int a = 0; a <= 10; a++) {
			for (int b = 0; b <= 10; b++) {
				for (int c = 0; c <= 10; c++) {
					if ((a + b + c) == totalScore) {
						possibleTriplets.add(new Triplet(a, b, c));
					}
				}
			}
		}
		
		return possibleTriplets;
	}
}

class Triplet {
	
	private int[] scores = new int[3];
	private boolean surprising = false;
	private boolean neverHappen = false;
	
	public Triplet(int a, int b, int c) {
		
		scores[0] = a;
		scores[1] = b;
		scores[2] = c;
		Arrays.sort(scores);
		
		int diff1 = scores[2] - scores[0];
		int diff2 = scores[2] - scores[1];
		int diff3 = scores[1] - scores[0];
		surprising =  (diff1 > 1) || (diff2 > 1) || (diff3 > 1);
		neverHappen = (diff1 > 2) || (diff2 > 2) || (diff3 > 2);
	}
	
	public int getBestResult() {
		return scores[2]; //since the array is sorted in ascending order
	}
	
	public boolean isSurprising() {
		return surprising;
	}
	
	public boolean willNeverHappen() {
		return neverHappen;
	}
	
	public boolean equals(Object t) {
		
		if (t == null) {
			return false;
		}
		
		if (!(t instanceof Triplet)) {
			return false;
		}
		
		Triplet that = (Triplet)t;
		return Arrays.equals(scores, that.scores);
	}
	
	public int hashCode() {
		
		return Arrays.hashCode(scores);
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer("[");
		sb.append(scores[0]);
		sb.append(",");
		sb.append(scores[1]);
		sb.append(",");
		sb.append(scores[2]);
		sb.append("]");
		if (isSurprising()) {
			sb.append("*");
		}
		return sb.toString();
	}
}
