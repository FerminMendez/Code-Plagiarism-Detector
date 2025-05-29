package codejam.suraj.quals2012.googlerese;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class GooglereseTrain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lines = "ejp mysljylc kd kxveddknmc re jsicpdrysi rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd de kr kd eoya kw aej tysr re ujdr lkgc jv";
		String oplines = "our language is impossible to understand there are twenty six factorial possibilities so it is okay if you want to just give up";
		char[] lineArr = lines.toCharArray();
		char[] oplinesArr = oplines.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0; i < lineArr.length; ++i){
			if(lineArr[i] == ' ')
				continue;
			System.out.println("map.put('" + lineArr[i] + "','" + oplinesArr[i] + "');");
			map.put(lineArr[i], oplinesArr[i]);
		}
		
		
		System.out.println(map.keySet().size());
		System.out.println(new TreeSet<Character>(map.keySet()));
		System.out.println(new TreeSet<Character>(map.values()));
		
	}

}
