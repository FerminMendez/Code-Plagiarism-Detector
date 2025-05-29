import java.util.*;
import java.io.*;
import java.math.*;



public class Solver
{
	private String key = "yhesocvxduiglbkrztnwjpfmaq";
	
	public int[] convert(String[] s) {
		int[] res = new int[s.length];
		for(int i = 0;i < s.length; i++) {
			res[i] = Integer.parseInt(s[i]);
		}
		return res;
	}
	
	private String decode(String str, String res) {
		if (str.length() == 0) {return res;}
		String nextchar = "";
		if (str.charAt(0) == ' ') {nextchar = " ";}
		else {nextchar = key.substring(str.charAt(0) - 'a',str.charAt(0) - 'a' + 1);}
		return decode(str.substring(1),res + nextchar);
	}
	
	public String solve(BufferedReader reader) {
		try {
			String word = reader.readLine();
			return decode(word,"");
		}
		catch(Exception e) {e.printStackTrace(); return "";}
	}
	
	public String solve2(BufferedReader reader) {
		try {
			int[] dims = convert(reader.readLine().split(" "));
			int num = dims[0];
			int sups = dims[1];
			int target = dims[2];
			int total = 0;
			for(int i = 0; i < num; i++) {
				if(dims[3+i] > (target -1)*3) {total++;}
				else if(dims[3+i] < Math.max((target-1)*3 - 1,1)) {}
				else {
					if(sups > 0) {total++; sups--;}
				}
			}
			return ""+total;
		}
		catch(Exception e) {e.printStackTrace(); return "";}
	}
	
	public static void main(String[] args)
	{	
		try
		{			
			FileReader flrdr = new FileReader(new File("test.in"));
			BufferedReader br = new BufferedReader(flrdr);
			FileWriter writer = new FileWriter("output.txt");
			int n = Integer.parseInt(br.readLine());
			Solver s = new Solver();
			for(int i = 1; i < n+1; i++)
			{
				//System.out.println("Case #" + i + ": " + s.solve4(br) + "\n");
				writer.write("Case #" + i + ": " + s.solve2(br) + "\n");
			}
			writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void checkFiles(String f1, String f2) {
		try {
			FileReader flrd1 = new FileReader(new File(f1));
			FileReader flrd2 = new FileReader(new File(f2));
			BufferedReader br1 = new BufferedReader(flrd1);
			BufferedReader br2 = new BufferedReader(flrd2);
			int count = 1;
			while(br1.readLine().equals(br2.readLine())) {
				count++;
			}
			System.out.println(count);
		}
		catch(Exception e) {e.printStackTrace();}
	}
}