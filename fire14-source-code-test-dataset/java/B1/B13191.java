import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;


public class RecyclePair {
	
	public static void main(String[] args) {
		runTestCase();
	}
	public static void runTestCase() {
		String fileName = "C-small-attempt0.in";// input file
		String outFileName = "outputFile.txt";// output file

		try {
			FileInputStream fStream = new FileInputStream(fileName);
			FileOutputStream fOutStream = new FileOutputStream(outFileName);

			BufferedReader bf = new BufferedReader(new InputStreamReader(
					fStream));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					fOutStream));
			int i = 0;
			int testSize = Integer.parseInt(bf.readLine());
			while (i < testSize) {
				String in = bf.readLine();
				bw.write(checkForMatchingPairs(in, ++i));
				bw.newLine();
			}
			// close the two files.
			bf.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String checkForMatchingPairs (String inputData , int testCase)
	{
		StringBuffer temp = new StringBuffer();
		temp.append("Case #" + testCase + ": ");
		String[] split = inputData.split(" ");
		int lowerLimit = Integer.parseInt(split[0]);
		int upperLimit = Integer.parseInt(split[1]);
		int noOfMatches =0;
		for(int count=lowerLimit;count<upperLimit;count++)
		{
			int numberPairs = findPairs(count, upperLimit, lowerLimit);
			noOfMatches+=numberPairs;
		}
		temp.append(noOfMatches);
		return temp.toString();
	}
	
	public static int findPairs(int number,int upperLimit , int lowerLimit)
	{
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		int divisor = number;
		int noOfMatches = 0;
		while(divisor>0)
		{		
			int remainder = divisor%10;
			divisor = divisor/10;
			stack.push(remainder);
		}
		
		while(!stack.isEmpty())
		{
			queue.add(stack.pop());
		}
		
		Integer count = 0;
		while(count<queue.size())
		{
			StringBuffer newNumber = new StringBuffer();
			for(Integer integer :queue)
			{
				newNumber.append(integer);
			}
			
			int matchingPair = Integer.parseInt(newNumber.toString());
			if(matchingPair > number && matchingPair >= lowerLimit &&  matchingPair <=upperLimit)
			{
				noOfMatches++;
				System.out.println(number +":"+ matchingPair  );
			}
			count++;
			Integer head = queue.poll();
			queue.add(head);
		}
		return noOfMatches;
	}
}
