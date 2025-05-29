package main;

import java.util.Vector;
import java.io.*;

public class Googlers {

	/**
	 * 2012 Qualif B
	 */
	static int numberOfElementForEachTest = 0;
	static int numberOfLinesPerTest = 0;
	
	public static void main(String[] args) {
		Vector<Integer> elements = new Vector<Integer>();
		numberOfElementForEachTest = 0;
		
		Reader.setFile("input.txt");
		Writer.setFile("output.txt");
		
		String s = Reader.readLine();
		int numberTest = Integer.parseInt(s);
		
		for (int i=0; i<numberTest; i++) {
			numberOfElementForEachTest = 0;
			elements = new Vector<Integer>();
			
			String s1 = "";
			
			s = Reader.readLine();
			s1 = s.substring(0, s.indexOf(" "));
			s=s.substring(s.indexOf(" ")+1);
			numberOfElementForEachTest =  Integer.parseInt(s1);
			
			s1 = s.substring(0, s.indexOf(" "));
			s=s.substring(s.indexOf(" ")+1);
			int numberOfSurprises =  Integer.parseInt(s1);
			
			s1 = s.substring(0, s.indexOf(" "));
			s=s.substring(s.indexOf(" ")+1);
			int bestToReach =  Integer.parseInt(s1);
			
			for (int j=0; j<numberOfElementForEachTest-1; j++) {
				s1 = s.substring(0, s.indexOf(" "));
				s=s.substring(s.indexOf(" ")+1);
				elements.add(Integer.parseInt(s1));
			}
			elements.add(Integer.parseInt(s));
			
			int result = 0;
			for (int id=0; id<elements.size(); id++)
			{
				int bestNoSurprise = 0;
				int bestWithSurprise = 0;
				int n = elements.get(id);
				if (n%3==0)
				{
					bestNoSurprise = n/3;
					if (n!=30 && n!=0) bestWithSurprise = bestNoSurprise+1;
					else bestWithSurprise = bestNoSurprise;
				}
				else if (n%3==1)
				{
					bestNoSurprise = n/3+1;
					bestWithSurprise = bestNoSurprise;
				}
				else if (n%3==2)
				{
					bestNoSurprise = n/3+1;
					if (n!=29) bestWithSurprise = bestNoSurprise+1;
					else bestWithSurprise = bestNoSurprise;
				}
				System.out.println(n + ", " + bestNoSurprise + ", " + bestWithSurprise );
				
				if (bestNoSurprise >= bestToReach) result++;
				else if (bestWithSurprise >= bestToReach &&
						numberOfSurprises > 0)
				{
					result ++;
					numberOfSurprises --;
				}
			}
			
			
			Writer.writeln("Case #" + (i+1) + ": " + result);
			 
		}
		Writer.close();

	}
	
	public static final class Reader 
	{
		static BufferedReader in;
		
		public static void setFile(String fichier) {
			File file = new File(fichier);
			try {
				in =  new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
			}
		}

		public static String readLine() {
			String line = null;
			try {
				line =  in.readLine();
			}
			catch (IOException e) {}
			
			return line;
		}
		
		public static String readAll() {
			String text = "";
			String line = "";
			while (line != null) {
				try {
					line = in.readLine();
				} 
				catch (IOException e) {
				}
				if (line != null) text += line + "\n";
			}
			return text;
		}
	}
	
	public static final class Writer 
	{
		static BufferedWriter out;
		
		public static void setFile(String file) {
			try{
				FileWriter fstream = new FileWriter(file);
				out = new BufferedWriter(fstream);
			}
			catch (Exception e){}
		}
		
		public static void write(String ligne) {
			try {
				out.write(ligne);
			}
			catch (Exception e){}
		}
		public static void writeln(String ligne) {
			try {
				out.write(ligne);
				out.write("\n");
			}
			catch (Exception e){}
		}

		public static void close() {
			try {
				out.close();
			}
			catch (Exception e){}
		}
	}
		
}
