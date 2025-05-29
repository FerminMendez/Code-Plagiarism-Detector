import java.util.*;
import java.io.*;

public class Qual2012 {
	
	public static void lame() {
		try {
			FileReader fr = new FileReader("input.txt");
			BufferedReader reader = new BufferedReader(fr);
			PrintWriter writer = new PrintWriter("output.txt");
			
			HashMap<String,String> dictionary = new HashMap<String,String>();
			dictionary.put("a", "y");
			dictionary.put("b", "h");
			dictionary.put("c", "e");
			dictionary.put("d", "s");
			dictionary.put("e", "o");
			dictionary.put("f", "c");
			dictionary.put("g", "v");
			dictionary.put("h", "x");
			dictionary.put("i", "d");
			dictionary.put("j", "u");
			dictionary.put("k", "i");
			dictionary.put("l", "g");
			dictionary.put("m", "l");
			dictionary.put("n", "b");
			dictionary.put("o", "k");
			dictionary.put("p", "r");
			dictionary.put("q", "z");
			dictionary.put("r", "t");
			dictionary.put("s", "n");
			dictionary.put("t", "w");
			dictionary.put("u", "j");
			dictionary.put("v", "p");
			dictionary.put("w", "f");
			dictionary.put("x", "m");
			dictionary.put("y", "a");
			dictionary.put("z", "q");
			dictionary.put (" ", " ");
			int numCases = Integer.parseInt(reader.readLine());
			
			for (int i = 1; i <= numCases; i++) {
				String sentence = reader.readLine();
				String newSentence = "";
				for (char c: sentence.toCharArray()) {
					char[] temp = new char[1];
					temp[0] = c;
					newSentence += dictionary.get(new String(temp));
				}
				writer.println("Case #" + i + ": " + newSentence);
			}
			
			writer.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean canMatch(int score, int target) {
		if (score == 0)
			return target <= 0;
		if (score == 1 || score == 2)
			return target <= 1;
		if (score % 3 == 0){
			return score/3 >= target;
		} 
		return ((score/3) + 1 >= target);
	}
	
	public static boolean canMatchSpecial(int score, int target) {
		if (score == 0)
			return target <= 0;
		if (score == 1)
			return target <= 1;
		if (score == 2)
			return target <= 2;
		if (score % 3 == 1)
			return (score /3 + 1) >= target;
		return (score /3 + 2) >= target;
	}
	
	public static void dance() {
		try {
			FileReader fr = new FileReader("input.txt");
			BufferedReader reader = new BufferedReader(fr);
			PrintWriter writer = new PrintWriter("output.txt");
			
			int numCases = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= numCases; i++) {
				StringTokenizer line = new StringTokenizer(reader.readLine(), " ");
				int numDancers = Integer.parseInt(line.nextToken());
				int numSurprising = Integer.parseInt(line.nextToken());
				int bestScore = Integer.parseInt(line.nextToken());
				List<Integer> scores = new LinkedList<Integer>();
				for (int j = 0; j < numDancers; j++)
					scores.add(Integer.parseInt(line.nextToken()));
				int count = 0;
				for (Integer score: scores) {
					if (canMatch(score, bestScore))
						count++;
					else if (canMatchSpecial(score, bestScore) && numSurprising > 0) {
						numSurprising--;
						count++;
					}
				}
				writer.println("Case #" + i + ": " + count);
			}
			
			writer.close();
			fr.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		//lame();
		dance();
	}
}