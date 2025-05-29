package google.contest.A;

import google.loader.Challenge;
import google.problems.AbstractChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AChallenge extends AbstractChallenge implements Challenge {

	private String text;
	private static Map<String, String> map;

	public AChallenge(int number, String line) {
		super(number);
		text = line;
		initTranslationMap();
		setResult(translate());
	}

	private String translate() {
		String res="";
		for(int i=0;i<text.length();i++){
			res=res+map.get(String.valueOf(text.charAt(i)));
		}
		return res;
	}

	private void initTranslationMap() {
		if(map==null){
			map = new HashMap<String, String>();

			String  input="ejp mysljylc kd kxveddknmc re jsicpdrysirbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcdde kr kd eoya kw aej tysr re ujdr lkgc jv";
			String output="our language is impossible to understandthere are twenty six factorial possibilitiesso it is okay if you want to just give up";

			for(int i=0;i<input.length();i++){
				map.put(String.valueOf(input.charAt(i)),String.valueOf(output.charAt(i)));
			}
			map.put("q","z");
			map.put("z","q");
		}
	}


}
