import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class QuestionA extends Question{

	private static Map<Character, Character> translationMap;
	private static boolean isInit;
	private StringBuilder sb;
	
	public QuestionA(Result result, Counter counter)
	{
		super(result, counter);
		if (!isInit) {
			init();
			isInit=true;
		}
	}
	
	private void init() {
		translationMap = new HashMap<Character, Character>();
		String text = "zyeq"+"ejp mysljylc kd kxveddknmc re jsicpdrysi"+"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd"+"de kr kd eoya kw aej tysr re ujdr lkgc jv";
		String translation = "qaoz"+"our language is impossible to understand"+"there are twenty six factorial possibilities"+"so it is okay if you want to just give up";
		for (int i = 0; i < text.length(); i++) {
			if (!translationMap.containsKey(text.charAt(i)))
				translationMap.put(text.charAt(i), translation.charAt(i));
		}
	}

	@Override
	public void readInput(Scanner scanner) {
		sb = new StringBuilder();
		sb.append(scanner.nextLine());
	}
	
	@Override
	public String solution() {
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, translationMap.get(sb.charAt(i)));
		}
		return sb.toString();
	}


}
