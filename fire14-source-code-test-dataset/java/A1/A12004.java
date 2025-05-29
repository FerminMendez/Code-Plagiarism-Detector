package dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DancingTestCase {

	private final int noOfDancers;
	private final int noOfSurprising;
	private final int minScore;
	private final List<Integer> scores;
	private final int result;

	DancingTestCase(int noOfDancers, int noOfSurprising, int minScore, List<Integer> scores) {
		if (scores.size() != noOfDancers)
			throw new IllegalArgumentException("Data mismatch");
		if (noOfSurprising> noOfDancers)
			throw new IllegalArgumentException("too many surprises");
		this.noOfDancers = noOfDancers;
		this.noOfSurprising = noOfSurprising;
		this.minScore = minScore;
		this.scores = scores;
		this.result = calculateResult();
		
	}
	
	private int calculateResult() {
		int total=0;
		int grandTotal=0;
		int remainingSuprises = noOfSurprising;
		
		//needs to try all permutation of each dancer having the suprising flag
		//then return the bes
		
		for(int score : scores) {
			
			int div = score / 3;
			int next = score - div;
			int secondDiv = next /2;
			int remainder = next - secondDiv;
		//System.out.println("input "+score+" first:"+div+" second: "+secondDiv+" third:"+remainder);
			//assume these won't be more than 1 apart
			//remainder should be highest, div lowest
			//could decrement second div and increment reminder if we have a suprise left and smallest value only 1 less
			
			if (remainder<div)
				System.out.println("alarm1");
			if (remainder<secondDiv)
				System.out.println("alarm2");
			if (remainder== minScore -1 //missed by just 1 
					&&  remainingSuprises > 0 //could make this a suprising result
					&& remainder < 10 //isn't already 10 (unlikly)
					&& secondDiv > 0 //the second smallest isn't already at zero
					&& ((remainder == div +1 && remainder==secondDiv)//we are currently only one apart from smallest //the second value is same as largest so could drop
					 || (remainder == div && remainder ==secondDiv) ))   //all values same
					{
				remainder++;
				remainingSuprises--;
			}
				
			
			int max = remainder;
			if (max >= minScore)
				total++;
			
		}
		
		if (total>grandTotal)
			grandTotal=total;
		
		
		return grandTotal;
		
	}
	
	
	
	public static void main(String[] args) {
	
		DancingTestCase dt = new DancingTestCase(3,1,5,new ArrayList<Integer>(Arrays.asList(15,13,11)));
		System.out.println("Result"+dt.getResult());

		dt = new DancingTestCase(3,0,8,new ArrayList<Integer>(Arrays.asList(23,22,21)));
		System.out.println("Result"+dt.getResult());
		
		dt = new DancingTestCase(2,1,1,new ArrayList<Integer>(Arrays.asList(8,0)));
		System.out.println("Result"+dt.getResult());
		
		dt = new DancingTestCase(6,2,8,new ArrayList<Integer>(Arrays.asList(29,20,8,18,18,21)));
		System.out.println("Result"+dt.getResult());
		
		
		if (args.length != 2)
			throw new IllegalArgumentException("No file specified");

		List<String> data = new ArrayList<String>();
		List<String> results = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				data.add(strLine);
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		if (data.size() == 0)
			throw new IllegalArgumentException("No data in file");

		int noTestCases = Integer.parseInt(data.get(0));
		if (data.size() != noTestCases + 1)
			throw new IllegalArgumentException("Number of test cases is not "
					+ noTestCases);

		for (int i = 1; i <= noTestCases; i++) {
			results.add("Case #" + i + ": " + parse(data.get(i)));
		}

		try {
			FileWriter fostream = new FileWriter(args[1]);
			BufferedWriter out = new BufferedWriter(fostream);
			for (int i =0;i<results.size();i++) {
				String s = results.get(i);
				out.write(s);
				if (i<results.size()-1)
					out.newLine();
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static int parse(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		if (st.countTokens() <1)
			throw new IllegalArgumentException("No values found");
		int noOfDancers = Integer.parseInt(st.nextToken());
		if (st.countTokens() != 2 + noOfDancers)
			throw new IllegalArgumentException("Wrong no of values");
		int noSuprises = Integer.parseInt(st.nextToken());
		int minValue = Integer.parseInt(st.nextToken());
		
		List<Integer> scores = new ArrayList<Integer>();
		while (st.hasMoreTokens())
			scores.add(Integer.parseInt(st.nextToken()));
		DancingTestCase dt = new DancingTestCase(noOfDancers,noSuprises,minValue,scores);
	//	System.out.println("Result"+dt.getResult());
		return dt.getResult();
	}

	public int getResult() {
		return result;
	}
	
}
