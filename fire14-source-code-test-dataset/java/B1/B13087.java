package recycle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class EnvironmentallyFriendly {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
		BufferedWriter wr = new BufferedWriter(new FileWriter(new File("output.txt")));
		int count = Integer.parseInt(br.readLine());
		int min,max;
		int total;
		String[] vals;
		for(int i=1; i<=count; i++)
		{
			total=0;
			String line = br.readLine();
			vals = line.split(" ");
			min = Integer.parseInt(vals[0]);
			max = Integer.parseInt(vals[1]);
			for(int k =min; k<max; k++)
			{
				total+=numRecyclable(k+"",max);
			}
			wr.write("Case #"+i+": "+total);
			wr.newLine();
			
		}
		wr.close();
	}

	private static int numRecyclable(String num, int max) {
		String newnum;
			
		int total =0,newval,oldval;
		ArrayList<Integer> duplicatecheck = new ArrayList<Integer>();
		for(int i=1; i<num.length(); i++)
		{
			newnum = num.substring(i)+num.substring(0, i);
			newval = Integer.parseInt(newnum);
			oldval = Integer.parseInt(num);
			if(newnum.charAt(0)!='0' && newval<=max
				&& newval > oldval && !duplicatecheck.contains(newval))
			{
				duplicatecheck.add(newval);
				total++;
			}
		}
		return total;
	}
}
