import java.io.File;
 import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
 public class C { 

	static String inner = "input.in";
	static Scanner scan;
	public static void main (String[]args) throws IOException
	{ 
		File f = new File (inner);
		File out = new File("output.out");
		FileWriter wr; 
		wr = new FileWriter(out); 
		scan = new Scanner(f); 
		int test = scan.nextInt();
		scan.nextLine();
		for(int i = 0 ;i < test ; i++)
			wr.write( "Case #"+ (i+1)+": "+testcase(  new BigInteger(""+scan.nextInt()) , new BigInteger(""+scan.nextInt()) )   + "\n");
	 	 wr.flush();
	}
	
	public static int testcase (BigInteger A , BigInteger B)
	{ 
		int ret = 0;
		int len = A.toString().length(); 
		for(BigInteger b = A ; b.compareTo(B) < 1 ;b= b.add(BigInteger.ONE) )
		{
			String []ff = new String [len-1];  
			String s =b.toString(); 
			for(int i = 1 ;i <len ; i++)
			{
				BigInteger dum = new BigInteger(s.substring (i) + s.substring(0,i));
				ff[i-1] = dum.toString();	
				if(dum.compareTo(B)!=1 && dum.compareTo(b)==1)
				{
					boolean skip=false;  
					for(int j =0 ; j < i-1 ; j++)
						if(ff[j].equals(ff[i-1])) 
							skip = true;  
					if(skip) continue;
					ret++;
				 
				} 
			}
		}
		return ret;
	}
}
