package mgg.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CorrespondenceUtils {

	public static String getT9Correspondence(char c) {

		/** Generating code:
		for(int i = 0; i<=25; i++){
			System.out.println("case '"+((char)(i+((int)'a')))+"':");
			System.out.println("return \"\";");
		}
		 */
		switch (c){
		case 'a':	return "2";
		case 'b':	return "22";
		case 'c':	return "222";

		case 'd':	return "3";
		case 'e':	return "33";
		case 'f':	return "333";

		case 'g':	return "4";
		case 'h':	return "44";
		case 'i':	return "444";

		case 'j':	return "5";
		case 'k':	return "55";
		case 'l':	return "555";

		case 'm':	return "6";
		case 'n':	return "66";
		case 'o':	return "666";

		case 'p':	return "7";
		case 'q':	return "77";
		case 'r':	return "777";
		case 's':	return "7777";

		case 't':	return "8";
		case 'u':	return "88";
		case 'v':	return "888";

		case 'w':	return "9";
		case 'x':	return "99";
		case 'y':	return "999";
		case 'z':	return "9999";

		case ' ':	return "0";

		default:
			throw new RuntimeException("Not valid character: '" + c + "'");
		}
	}

	public static char getGooglereseCorrespondence(char c) {

		/** Generating code:
		String strG = "ejp mysljylc kd kxveddknmc re jsicpdrysi rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd de kr kd eoya kw aej tysr re ujdr lkgc jv";
		String strE = "our language is impossible to understand there are twenty six factorial possibilities so it is okay if you want to just give up";
		
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i< strE.length(); i++){
			
			set.add("case '" + strG.charAt(i) + "':\treturn '" + strE.charAt(i) + "';");
			//System.out.println("case '" + strG.charAt(i) + "':\treturn '" + strE.charAt(i) + "';");
		}
				
		ArrayList<String> list = new ArrayList<String>(set);
		
		Collections.sort(list);
		
		for(String s : list){
			System.out.println(s);
		}
		 **/
		switch (c){
		case 'a':	return 'y';
		case 'b':	return 'h';
		case 'c':	return 'e';
		case 'd':	return 's';
		case 'e':	return 'o';
		case 'f':	return 'c';
		case 'g':	return 'v';
		case 'h':	return 'x';
		case 'i':	return 'd';
		case 'j':	return 'u';
		case 'k':	return 'i';
		case 'l':	return 'g';
		case 'm':	return 'l';
		case 'n':	return 'b';
		case 'o':	return 'k';
		case 'p':	return 'r';
		case 'q':	return 'z';
		case 'r':	return 't';
		case 's':	return 'n';
		case 't':	return 'w';
		case 'u':	return 'j';
		case 'v':	return 'p';
		case 'w':	return 'f';
		case 'x':	return 'm';
		case 'y':	return 'a';
		case 'z':	return 'q';
		case ' ':	return ' ';

		default:
			throw new RuntimeException("Not valid character: '" + c + "'");
		}
	}

}
