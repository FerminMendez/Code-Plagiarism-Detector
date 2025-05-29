package hk.polyu.cslhu.codejam.solution.impl.qualificationround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hk.polyu.cslhu.codejam.solution.Solution;

import org.apache.log4j.Logger;

public class SpeakingInTongues extends Solution {
	private Map<String, String> codeMap;
	private String oriText;
	
	private void setCodeMap() {
		this.codeMap = new HashMap<String, String>();
		codeMap.put("y", "a");
		codeMap.put("e", "o");
		codeMap.put("q", "z");
		codeMap.put("z", "q");
		
		List<String> oriTextList = new ArrayList<String>();
		oriTextList.add("ejp mysljylc kd kxveddknmc re jsicpdrysi");
		oriTextList.add("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd");
		oriTextList.add("de kr kd eoya kw aej tysr re ujdr lkgc jv");
		
		List<String> encodedTextList = new ArrayList<String>();
		encodedTextList.add("our language is impossible to understand");
		encodedTextList.add("there are twenty six factorial possibilities");
		encodedTextList.add("so it is okay if you want to just give up");
		
		for (int i = 0; i < oriTextList.size(); i++) {
			String oriText = oriTextList.get(i);
			String encodedText = encodedTextList.get(i);
			
			for (int j = 0; j < oriText.length(); j++) {
				String ori = oriText.substring(j, j + 1);
				String encoded = encodedText.substring(j, j + 1);
				
				if (ori.equals(" "))
					continue;
				
				if (! codeMap.containsKey(ori))
					codeMap.put(ori, encoded);
				else if (! codeMap.get(ori).equals(encoded))
					logger.error("Found duplicate encoded string for input " + ori);
			}
		}
		
		logger.info("The size of code map is " + this.codeMap.size());
	}
	
	@Override
	public void setProblem(List<String> problemDesc) {
		// TODO Auto-generated method stub
		this.oriText = problemDesc.get(0);
	}

	@Override
	public void solve() {
		// TODO Auto-generated method stub
		this.setCodeMap();
		
		this.result = "";
		
		for (int i = 0; i < this.oriText.length(); i++) {
			String ori = this.oriText.substring(i, i + 1);
			
			if (ori.equals(" "))
				this.result += ori;
			else if (this.codeMap.containsKey(ori))
				this.result += this.codeMap.get(ori);
			else
				logger.error("Failure to find the encoded string for " + ori);
		}
	}
}
