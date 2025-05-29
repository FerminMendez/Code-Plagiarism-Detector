package com.google.codejam;

import java.util.HashSet;
import java.util.Set;

import com.google.codejam.util.CodeJamInputFile;
import com.google.codejam.util.CodeJamOutputFile;

public class Recycle {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer count;
		CodeJamInputFile f = new CodeJamInputFile("in/C-small-attempt0.in");
		CodeJamOutputFile fo = new CodeJamOutputFile("out/C-small.out");

		for(int c = 0; c < f.getCases(); c++){
			count = 0;
			Set<String> tested = new HashSet<String>();
			String[] range = f.getLine().split(" ");
			Integer a = Integer.valueOf(range[0]);
			Integer b = Integer.valueOf(range[1]);
			
			for(Integer i = a; i < (b + 1); i++){
				String str = i.toString();
				tested.add(str.concat(str));
				for(int j = 1; j<str.length(); j++){
					String newstr = str.substring(j).concat(str.substring(0, j));
					if(tested.contains(str.concat(newstr)) || tested.contains(newstr.concat(str))){
						continue;
					}
					tested.add(str.concat(newstr));
					Integer testval = Integer.valueOf(newstr);
					if(testval >= a && testval <= b){
						//System.out.println(str + " - " + newstr);
						count++;
					}
				}
			}
			
			fo.writeCase(c, count.toString());
		}
		f.close();
		fo.close();
	}

}
