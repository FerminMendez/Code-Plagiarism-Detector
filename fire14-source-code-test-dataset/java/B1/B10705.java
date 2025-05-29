package test.googlejam.year2012.jam;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import test.googlejam.base.ProblemProcessor;
import test.googlejam.base.ValueReader;

public class RecycledNumbers extends ProblemProcessor
{

	static java.util.Map<Integer, Integer> mapping = new java.util.TreeMap<Integer, Integer>();
	public static void main(String[] args) throws java.io.IOException
	{
		RecycledNumbers processor;
		String fileName = "c:/temp/googlejam/RecycledNumbers";

		processor = new RecycledNumbers();
		processor.setInputFileName(fileName + args[0] + ".in");
		processor.setOutputFileName(fileName + args[0] + ".out");
		processor.start();
	}

	@Override
	public String processCase(int caseNumber) throws IOException
	{
		java.util.List<String> values;
		
		values = this.readValues(" ", new ValueReader<String>() {
			@Override
			public String readValue(String token) {
				return token;
			}
		});
		
		String stringA;
		int valueA, valueB;
		stringA = values.get(0);
		valueA = Integer.valueOf(values.get(0));
		valueB = Integer.valueOf(values.get(1));
		java.util.SortedSet<Integer> permutations = new java.util.TreeSet<Integer>();

		for ( int currentValue = valueA; currentValue <= valueB; currentValue++ )
		{
			String currentString = Integer.toString(currentValue);
			for ( int i = 1; i < currentString.length(); i++ )
			{
				String newString = StringUtils.right(currentString, i) + StringUtils.left(currentString, currentString.length() - i);
				if ( '0' == newString.charAt(0) ) continue;
				int newValue = Integer.valueOf(newString);
				if ( (valueA <= newValue) && (newValue <= valueB) )
					permutations.add(newValue);
			}
		}

		System.out.println(valueA);
		System.out.println(valueB);
		System.out.println(permutations);
		java.util.Set<String> foundCases = new java.util.HashSet<String>();
		for ( int currentValue : permutations )
		{
			String currentString = Integer.toString(currentValue);
			for ( int i = 1; i < currentString.length(); i++ )
			{
				String newString = StringUtils.right(currentString, i) + StringUtils.left(currentString, currentString.length() - i);
				if ( '0' == newString.charAt(0) ) continue;
				int newValue = Integer.valueOf(newString);
				if ( (currentValue < newValue) && (permutations.contains(newValue)))
				{
					String foundCase = valueA + " <= " + currentValue + " < " + newValue + " <= " + valueB;
					//System.out.println(foundCase);
					foundCases.add(foundCase);
				}
			}
		}
		//System.out.println(foundCases);
		return Integer.toString(foundCases.size());
	}
}
