package com.blah;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class Triplet {
	int  numbers[] = new int[3];
	
	public Triplet(int number) {
		numbers[0] = numbers[1] = numbers[2] = number;
		// TODO Auto-generated constructor stub
	}
	
	boolean hasBestResultOrMore(int p){ 
		return numbers[0]>=p || numbers[1]>=p || numbers[2]>=p; 
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + numbers[0] +"," + numbers[1] +"," + numbers[2] +"]";
	}
}


class ComponentNumber {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Number "+total+" : "+primary+","+secondary+" (*)" ;
	}
	int total;
	boolean marked = false;
	Triplet primary,secondary = null;//secondary is a surprising result always
	
	boolean hasBestResultOrMore(int p){
		return primary.hasBestResultOrMore(p);
	}
	
	boolean hasSurprisingBestResultOrMore(int p){
		return secondary!=null &&  secondary.hasBestResultOrMore(p);
	}
	
	public ComponentNumber(int totalPoints) {
		total = totalPoints;
		int base = totalPoints/3;
		primary = new Triplet(base);
		if(totalPoints==0){
			//do nothing, 0 = 0 + 0 + 0
		}
		else if(totalPoints==1){
			primary.numbers[2] = 1;
			//1 = 0 + 0 + 1 or any other permutation
		}
		else {
			switch(totalPoints%3){
			case 2:
				primary.numbers[1] = primary.numbers[2] = base + 1;
				secondary = new Triplet(base);
				secondary.numbers[2] =  base + 2;
				break;
			case 1:
				primary.numbers[2] = base + 1;
				secondary = new Triplet(base);
				secondary.numbers[0] =  base - 1;
				secondary.numbers[1] = secondary.numbers[2] =  base + 1;
				break;
			case 0:
				secondary = new Triplet(base);
				secondary.numbers[0] =  base - 1;
				secondary.numbers[2] =  base + 1;
				break;
			}
		}
	}
	
}

class Case {
	int googlers;
	int surprising;
	int bestResult;
	ArrayList<Integer> results;
	int components[][] = new int[3][2];
	
	Case(String g,String s,String p){
		googlers = Integer.parseInt(g);
		surprising = Integer.parseInt(s);
		bestResult = Integer.parseInt(p);
		results = new ArrayList<Integer>();
	}
	
	void addResult(String result){
		results.add(Integer.parseInt(result));
	}
}

public class MainProblem3 {
	public static void main(String[] args) {

		ArrayList<Case> cases = new ArrayList<Case>();
		try {
			System.setOut(new PrintStream("data.out"));
			BufferedReader br = new BufferedReader(new FileReader("data.in"));
			int numCases = Integer.parseInt(br.readLine());
			StringTokenizer st;
			Case aCase;
			for (int i = 0; i < numCases; i++) {
				st = new StringTokenizer(br.readLine());
				aCase = new Case(st.nextToken(), st.nextToken(), st.nextToken());
				for (int j = 0; j < aCase.googlers; j++) {
					aCase.addResult(st.nextToken());
				}
				cases.add(aCase);
			}
			resolver(cases);
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	private static void resolver(ArrayList<Case> cases) {
		Case aCase;
		for (int j = 0; j < cases.size(); j++) {
			aCase = cases.get(j);
			int p = aCase.bestResult;
			int s = aCase.surprising;
			ArrayList<ComponentNumber> theBest = new ArrayList<ComponentNumber>();
			ArrayList<ComponentNumber> theSurprises = new ArrayList<ComponentNumber>();
			ComponentNumber aCandidate;
			for (int k = 0; k < aCase.googlers; k++) {
				aCandidate = new ComponentNumber(aCase.results.get(k));
				//System.out.println(aCandidate);
				if(aCandidate.hasBestResultOrMore(p)){
					theBest.add(aCandidate);
				}
				else if(aCandidate.hasSurprisingBestResultOrMore(p)){
					theSurprises.add(aCandidate);
				}
			}
			int totalBest = theBest.size() + Math.min(theSurprises.size(), s);
			System.out.println("Case #"+(j+1)+": "+totalBest);
		}
	}

}