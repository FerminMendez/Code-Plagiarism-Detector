package qualification;

import java.io.*;

public class Csmall {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("./src/qualification/C-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/qualification/C-small-attempt0.out"));
		int[][] inputs = new int[50][2];
		int casenumber = 0;
		String input = null;
		int total = 0;
		while((input=br.readLine()) != null)
		{
			if(casenumber==0)
			{
				total = Integer.parseInt(input);
			}else{
				String[] array = input.split(" ");
				inputs[casenumber-1][0] = Integer.parseInt(array[0]);
				inputs[casenumber-1][1] = Integer.parseInt(array[1]);
			}
			casenumber++;
		}
		casenumber=1;
		while(casenumber <= total)
		{
			System.out.println("Case #" + casenumber + ": " + String.valueOf(recycledNumbers(inputs[casenumber-1][0], inputs[casenumber-1][1])));
			bw.write("Case #" + casenumber + ": " + String.valueOf(recycledNumbers(inputs[casenumber-1][0], inputs[casenumber-1][1])));
			bw.newLine();
			casenumber++;
		}
		bw.close();
	}
	
	public static int recycledNumbers(int a, int b) throws IOException
	{
		int[] storage = new int[2000000];
		int count=0;
		for(int i=a;i<b+1;i++)
		{
			for(int j=a+1;j<b+1;j++)
			{
				if(i!=j && storage[j]==0)
				{
					String icopy = String.valueOf(i);
					String jcopy = String.valueOf(j);
					for(int k=0;k<icopy.length();k++)
					{
						icopy = shiftString(icopy).toString();
						if(icopy.compareTo(jcopy)==0)
						{
							storage[i]=1;
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
	public static StringBuffer shiftString(String input)
	{
		StringBuffer output = new StringBuffer();
		output.append(input.charAt(input.length()-1));
		for(int i=0;i<input.length()-1;i++)
		{
			output.append(input.charAt(i));
		}
		return output;
	}
}