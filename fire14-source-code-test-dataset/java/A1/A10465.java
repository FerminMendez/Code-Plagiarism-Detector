package codejam.suraj.quals2012.googlerese;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import codejam.suraj.quals2012.CodeJamSkeleton;

public class Googlerese extends CodeJamSkeleton {

	public static Map<Character, Character> map = 
			new HashMap<Character, Character>(52);
	
	public static void initializeCharMap(){
		map.put('e','o');
		map.put('j','u');
		map.put('p','r');
		map.put('m','l');
		map.put('y','a');
		map.put('s','n');
		map.put('l','g');
		map.put('j','u');
		map.put('y','a');
		map.put('l','g');
		map.put('c','e');
		map.put('k','i');
		map.put('d','s');
		map.put('k','i');
		map.put('x','m');
		map.put('v','p');
		map.put('e','o');
		map.put('d','s');
		map.put('d','s');
		map.put('k','i');
		map.put('n','b');
		map.put('m','l');
		map.put('c','e');
		map.put('r','t');
		map.put('e','o');
		map.put('j','u');
		map.put('s','n');
		map.put('i','d');
		map.put('c','e');
		map.put('p','r');
		map.put('d','s');
		map.put('r','t');
		map.put('y','a');
		map.put('s','n');
		map.put('i','d');
		map.put('r','t');
		map.put('b','h');
		map.put('c','e');
		map.put('p','r');
		map.put('c','e');
		map.put('y','a');
		map.put('p','r');
		map.put('c','e');
		map.put('r','t');
		map.put('t','w');
		map.put('c','e');
		map.put('s','n');
		map.put('r','t');
		map.put('a','y');
		map.put('d','s');
		map.put('k','i');
		map.put('h','x');
		map.put('w','f');
		map.put('y','a');
		map.put('f','c');
		map.put('r','t');
		map.put('e','o');
		map.put('p','r');
		map.put('k','i');
		map.put('y','a');
		map.put('m','l');
		map.put('v','p');
		map.put('e','o');
		map.put('d','s');
		map.put('d','s');
		map.put('k','i');
		map.put('n','b');
		map.put('k','i');
		map.put('m','l');
		map.put('k','i');
		map.put('r','t');
		map.put('k','i');
		map.put('c','e');
		map.put('d','s');
		map.put('d','s');
		map.put('e','o');
		map.put('k','i');
		map.put('r','t');
		map.put('k','i');
		map.put('d','s');
		map.put('e','o');
		map.put('o','k');
		map.put('y','a');
		map.put('a','y');
		map.put('k','i');
		map.put('w','f');
		map.put('a','y');
		map.put('e','o');
		map.put('j','u');
		map.put('t','w');
		map.put('y','a');
		map.put('s','n');
		map.put('r','t');
		map.put('r','t');
		map.put('e','o');
		map.put('u','j');
		map.put('j','u');
		map.put('d','s');
		map.put('r','t');
		map.put('l','g');
		map.put('k','i');
		map.put('g','v');
		map.put('c','e');
		map.put('j','u');
		map.put('v','p');
		map.put('z','q');
		map.put('q','z');
		map.put(' ',' ');
	}
	
	
	
	@Override
	protected void handleTestCase(int testCaseNumber) throws IOException {
		
		String line = readLine();
		StringBuffer text = new StringBuffer(line.length());
		for(int i = 0; i < line.length(); ++i)
		{
			text.append(map.get(line.charAt(i)));
		}
		System.out.println(text);
		addOutput(testCaseNumber, text.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeCharMap();
		CodeJamSkeleton testCase = new Googlerese();
		testCase.handleAllTestCases(args[0], args[1]);
		
	}

}
