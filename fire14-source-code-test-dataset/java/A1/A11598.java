import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Googlerese {
	
	static Scanner in;
	static PrintWriter out;
	        
	public static void fillDictionary(Map<Character,Character> dic){
		dic.put(new Character('a'), new Character('y'));
		dic.put(new Character('b'), new Character('n'));
		dic.put(new Character('c'), new Character('f'));
		dic.put(new Character('d'), new Character('i'));
		dic.put(new Character('e'), new Character('c'));
		dic.put(new Character('f'), new Character('w'));
		dic.put(new Character('g'), new Character('l'));
		dic.put(new Character('h'), new Character('b'));
		dic.put(new Character('i'), new Character('k'));
		dic.put(new Character('j'), new Character('u'));
		dic.put(new Character('k'), new Character('o'));
		dic.put(new Character('l'), new Character('m'));
		dic.put(new Character('m'), new Character('x'));
		dic.put(new Character('n'), new Character('s'));
		dic.put(new Character('o'), new Character('e'));
		dic.put(new Character('p'), new Character('r'));
		dic.put(new Character('q'), new Character('z'));
		dic.put(new Character('r'), new Character('p'));
		dic.put(new Character('s'), new Character('d'));
		dic.put(new Character('t'), new Character('r'));
		dic.put(new Character('u'), new Character('j'));
		dic.put(new Character('v'), new Character('g'));
		dic.put(new Character('w'), new Character('t'));
		dic.put(new Character('x'), new Character('h'));
		dic.put(new Character('y'), new Character('a'));
		dic.put(new Character('z'), new Character('q'));
	}
	
	public static String translate(String originalWord, Map<Character,Character> dic){
		String translatedWord="";
		for(int i = 0; i < originalWord.length(); i++){
			translatedWord += dic.get(originalWord.charAt(i));
		}
		
		return translatedWord;
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(new File("A-small.txt"));
		out = new PrintWriter(new File("output.txt"));

		Map<Character,Character> dic = new HashMap<Character, Character>();
		fillDictionary(dic);
		//Read file
		String Y = null;
		String[] originalWords;
		int T = in.nextInt();
		//for each case do
		for (int i = 0; i < T; i++){
			//get first O and first B buttons
			Y = in.nextLine();
			originalWords = Y.split(" ");
			System.out.print("Case " + i + ":");
			for(int j = 0; j < originalWords.length; j++){
				System.out.print(				translate(originalWords[j],dic))
			}
			
		}
		
	    out.print(Y);
	    //printf("Case #%d: %s%n", cas, ans);

		out.close();	
	}
}