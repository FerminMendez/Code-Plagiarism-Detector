package GCJ2012QR2012;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.Math;
import java.util.LinkedList;

import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

import template.Template;

public class B {
	public static void main(String[] args)  throws Exception{
		Template tpl = new Template('B', false, true, 0);
		String line = tpl.read(0);
		int T = Integer.parseInt(line);
		for(int i=1; i<tpl.getSize(); i++){
			String[] str = tpl.read(i).split(" ");
			int N = Integer.parseInt(str[0]);
			int S = Integer.parseInt(str[1]);
			int p = Integer.parseInt(str[2]);
			int[] t = new int[str.length-3];
			for(int j=0; j<N; j++){
				t[j] = Integer.parseInt(str[j+3]);
			}
			int confirmed = 0;
			int possible = 0;
			int never = 0;
			
			int cnf_sup = 0;
			int psb_sup = 0;
			if(p>=2){
				cnf_sup = p+(p-1)+(p-1);
				psb_sup = p+(p-2)+(p-2);
			}
			else if(p>=1){
				cnf_sup = p+(p-1)+(p-1);
				psb_sup = p+(p-1)+(p-1);
			}
			else{
				cnf_sup = p*3;
				psb_sup = p*3;
			}
					
			for(int j=0; j<t.length; j++){
				if(t[j]>=cnf_sup) confirmed++;
				else if(t[j]>=psb_sup) possible++;
				else never++;
			}
			int result = confirmed+Math.min(possible, S);
			String rst = "Case #"+i+": "+ result;
			tpl.addLine(rst);
		}
		tpl.write();
		
	}
}
