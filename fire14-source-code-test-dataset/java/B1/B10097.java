package se.round1.problem3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.round1.util.JamUtil;

public class Problem3 {

	Map<Character, Character> trans = new HashMap<Character, Character>();
	
	public static void main(String[] args) throws IOException{
		new Problem3();
	}
	
	public Problem3() throws IOException{
		BufferedReader reader = JamUtil.getReader("problem3/C-small-attempt0.in");
		int currCase = 0;
		int nrOfCases = Integer.parseInt(reader.readLine());
		String s = "";
		System.out.println(">>>>>>>>"+nrOfCases);
		BufferedWriter writer = JamUtil.getWriter("problem3/output.txt");
		while((s = reader.readLine()) != null){
			currCase++;
			
			int res = solveLine(s);
			String sol = "Case #"+currCase+": "+res+"\n";
			System.out.println(res);
			writer.write(sol);
		}
		writer.close();
		System.out.println("done.");
	}
	
	
	private int solveLine(String line){
		int start = Integer.parseInt(line.split(" ")[0]);
		int stop = Integer.parseInt(line.split(" ")[1]);
		Map<Integer, List<String>> map = buildMap(start, stop);
		int sum = 0;
		int rotCount = 0;
		for(int i=start;i<=stop;++i){
			String curr = Integer.toString(i);
			sum = 0;
			char[] charArray = curr.toCharArray();
			for(char c : charArray)
				sum += c;
			if(map.get(sum).size() > 1)
				rotCount += rotTryArr(curr, map.get(sum));
		}
		
		return rotCount/2;
	}
	
	private int rotTryArr(String target, List<String> list){
		int count = 0;
		for(String s : list){
			if(isSameString(s, target)){
				count++;
			}
			
		}
		return count;
	}
	
	private boolean isSameString(String s1, String s2){
		if(s1.equals(s2))
			return false;
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		if(cs1.length != cs2.length)
			return false;
		
		for(int i=0;i<cs1.length;++i){
			if(isSame(cs1, cs2, i))
				return true;
		}
		
		return false;
	}
	
	private boolean isSame(char[] cs1, char[] cs2, int index){
		for(int i=0;i<cs1.length;++i){
			if(cs1[i] != cs2[ (i+index) % cs1.length])
				return false;
		}
		return true;
	}
	
	
	
	private Map<Integer, List<String>> buildMap(int start, int stop){
		HashMap<Integer, List<String>> m = new HashMap<Integer, List<String>>();
		for(int i=start;i<=stop;++i){
			String curr = Integer.toString(i);
			int sum = 0;
			char[] charArray = curr.toCharArray();
			for(char c : charArray)
				sum += c;
			if(m.containsKey(sum)){
				m.get(sum).add(curr);
			}
			else{
				List<String> s = new ArrayList<String>();
				s.add(curr);
				m.put(sum, s);
			}
		}
		return m;
	}
	
}
