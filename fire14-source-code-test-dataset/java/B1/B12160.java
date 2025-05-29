import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class Main {

	/**
	 * @param args
	 */
	public static  void main(String[] args) 
	{
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("C-small-attempt7.in");
//			  FileInputStream fstream = new FileInputStream("in.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  FileWriter foutstream = new FileWriter("output.out");
			  BufferedWriter out = new BufferedWriter(foutstream);
			  System.out.println (br.readLine());
			  int Case = 0;
			  while ((strLine = br.readLine()) != null)   
			  {
				  Case+=1;
				  out.write("Case #" + Case + ": ");
				  System.out.println (strLine);
				  String str[] = strLine.split(" ");
				  int A = Integer.parseInt(str[0]);
				  int B = Integer.parseInt(str[1]);
				  char a[] = str[0].toCharArray();
				  char b[] = str[1].toCharArray();
				  int recs = 0;
				  List<String> check3 = new ArrayList<String>();
				  for (int i=A;i<=B;i++)
				  {
					 int prev =0;
					 char[] curr = String.valueOf(i).toCharArray();
					 if (curr.length==b.length)
					 {
					  for (int j=0;j<curr.length;j++)
						  if ((curr[curr.length-1-j]<b[0])&&(curr[curr.length-j-1]!='0'))
						  {
							 int number = makerec(curr,j);
							 boolean bool = false;
							 bool = checkexistence(check3,i,number);
							 if ((bool)&&(number>=A)&&(number<=B)&&(i<number))
							 {
								 recs+=1;
								 check3.add(number+ " " + i);
								 System.out.println(i + " , " + number);
							 }
						  }
						  else if (curr[curr.length-j-1]==b[prev])
						  {
							  
							  int number = makerec(curr,j);
							  boolean bool = false;
							  bool = checkexistence(check3,i,number);
							  if ((bool)&&(number>=A)&&(number<=B)&&(i<number))
								 {
									 recs+=1;
									 check3.add(number+ " " + i);
									 System.out.println(i + " , " + number);
								 }
						  }
						  else 
						  { 
							  int number = makerec(curr,j);
							  boolean bool = false;
							  bool = checkexistence(check3,i,number);
							  if ((bool)&&(number>=A)&&(number<=B)&&(i<number))
								 {
									 recs+=1;
									 check3.add(number + " " + i);
									 System.out.println(i + " , " + number);
								 }
							 
						  }	  
					 }	
					 else 
					 {
						 for (int j=0;j<curr.length-1;j++)
							  if ((curr[curr.length-j-1]!='0'))
							  {
								 int number = makerec(curr,j);
								 boolean bool = false;
								 bool = checkexistence(check3,i,number);
								 if ((bool)&&(number>=A)&&(number<=B)&&(i<number))
								 {
									 recs+=1;
									 check3.add(number+ " " + i);
									 System.out.println(i + " , " + number);
								 }
								// else System.out.println("NOT :" + number + ", cause " + bool);
							  }

					 }

				  }
				  System.out.println("Case #" + Case + ": " +String.valueOf(recs));
				  out.append(String.valueOf(recs));
				  out.newLine();
				  
				  
			  }
			  out.close();
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage() + " " + e.getCause());
			  }
		System.exit(-1);
		
		

	}
	
	public static int makerec(char[] c,int fromback)
	{
		int num=0;
		char[] rec = new char[c.length];
		int f = fromback;
		for (int i=0;i<c.length;i++)
		{
			if (fromback>=0)
			{
			rec[i] = c[c.length-1-fromback];
			fromback--;
			}
			else
				rec[i] = c[i-f-1];
		}
		return i(rec);
	}
	
	public static int i(char c)
	{
		return Integer.parseInt(Character.toString(c));
	}
	
	public static int i(char[] c)
	{
		return Integer.parseInt(String.valueOf(c));
	}
	
	public static boolean checkexistence(List<String> a,int c,int d)
	{
		 boolean bool = false;
			if ((a.indexOf(c + " " + d)==-1)&&(a.indexOf(d + " " + c)==-1))
				bool=true;
			else
				bool=false;				
		 return bool;
		
	}
	

}
