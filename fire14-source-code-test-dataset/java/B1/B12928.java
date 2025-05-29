package main;

import java.util.Vector;
import java.io.*;

public class RecycledNumbers {
	
	static int numberOfElementForEachTest = 2;
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
			
			s = Reader.readLine();
			String s1 = s.substring(0, s.indexOf(" "));
			s=s.substring(s.indexOf(" ")+1);
			
			int numberOfDigits = s1.length();
			int[] digits = new int[numberOfDigits];
			int firstNumber = Integer.parseInt(s1);
			int secondNumber = Integer.parseInt(s);
			
			int result = 0;
			switch (numberOfDigits)
			{
			case 1:
				break;
			case 2:
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10 + n1%10*10;
					if (n2>n1 && n2<=secondNumber) result++;
				}
				break;
			case 3:
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100 + n1%100*10;
					if (n2>n1 && n2<=secondNumber) result++;
					
					n2 = n1/10 + n1%10*100;
					if (n2>n1 && n2<=secondNumber) result++;
				}
				break;
			case 4:
//				System.out.println(System.currentTimeMillis());
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/1000 + n1%1000*10;
					if (n2>secondNumber) n1 = (n1/1000 + 1) *1000; 
					else if (n2>n1) {
						result++;
					}
				}

				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100 + n1%100*100;
					if (n2>secondNumber) n1 = (n1/100 + 1) *100; 
					else if (n2>n1) {
						result++;
					}
				}
				
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10 + n1%10*1000;
					if (n2>secondNumber) n1 = (n1/10 + 1) *10; 
					else if (n2>n1) {
						result++;
						if (n1/1000 == n1%100/10 && n1%1000/100 == n1%10) result--;
					}
				}
//				System.out.println(System.currentTimeMillis());
				break;
			case 5:
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10000 + n1%10000*10;
					if (n2>secondNumber) n1 = (n1/10000 + 1) *10000; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/1000 + n1%1000*100;
					if (n2>secondNumber) n1 = (n1/1000 + 1) *1000; 
					else if (n2>n1) {
						result++;
					}
				}

				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100 + n1%100*1000;
					if (n2>secondNumber) n1 = (n1/100 + 1) *100; 
					else if (n2>n1) {
						result++;
					}
				}
				
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10 + n1%10*10000;
					if (n2>secondNumber) n1 = (n1/10 + 1) *10; 
					else if (n2>n1) {
						result++;
					}
				}
				break;
			case 6:
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100000 + n1%100000*10;
					if (n2>secondNumber) n1 = (n1/100000 + 1) *100000; 
					else if (n2>n1) {
						result++;
					}
//					if (n2>n1 && n2<=secondNumber) result++;
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10000 + n1%10000*100;
					if (n2>secondNumber) n1 = (n1/10000 + 1) *10000; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/1000 + n1%1000*1000;
					if (n2>secondNumber) n1 = (n1/1000 + 1) *1000; 
					else if (n2>n1) {
						result++;
						if (n1/100000 == n1%10000/1000 &&
								n1%10000/1000 == n1%100/10 &&
								n1%100000/10000 == n1%1000/100 &&
								n1%1000/100 == n1%10) result-=2;
					}
				}

				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100 + n1%100*10000;
					if (n2>secondNumber) n1 = (n1/100 + 1) *100; 
					else if (n2>n1) {
						result++;
					}
				}
				
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10 + n1%10*100000;
					if (n2>secondNumber) n1 = (n1/10 + 1) *10; 
					else if (n2>n1) {
						result++;
					}
				}
				break;
			case 7:
//				System.out.println(System.currentTimeMillis());
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/1000000 + n1%1000000*10;
					if (n2>secondNumber) n1 = (n1/1000000 + 1) *1000000; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100000 + n1%100000*100;
					if (n2>secondNumber) n1 = (n1/100000 + 1) *100000; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10000 + n1%10000*1000;
					if (n2>secondNumber) n1 = (n1/10000 + 1) *10000; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/1000 + n1%1000*10000;
					if (n2>secondNumber) n1 = (n1/1000 + 1) *1000; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/100 + n1%100*100000;
					if (n2>secondNumber) n1 = (n1/100 + 1) *100; 
					else if (n2>n1) {
						result++;
					}
				}
				for (int n1=firstNumber; n1<secondNumber; n1++)
				{
					int n2 = n1/10 + n1%10*1000000;
					if (n2>n1 && n2<secondNumber) {
						result++;
					}
				}
//				System.out.println(System.currentTimeMillis());
				break;
				
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
