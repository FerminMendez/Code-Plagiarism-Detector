import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class G2 
{
	 private Scanner reader;
	 private FileWriter fstream;
	 private BufferedWriter out;
	 String nextline;
	 int noLines;
	 int intA;
	 int intB;
	 int lineIndex=1;
	 int value=0;
	 
	 
	 public boolean isValid(int n,int m)
	 {
		 return (!(n==m)&&(intA<=n)&&(n<m)&&(m<=intB));
		 	
	 }
	 public void initiateFiles()
	{
			try 
			{
				
				reader = new Scanner(new File("src/resources/inb.in"));
				String nextline = reader.nextLine();
				noLines = new Integer(nextline);
				System.out.println(noLines);
				fstream = new FileWriter("out.txt");
				out = new BufferedWriter(fstream);
				
				process();
				out.close();
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
	}
	 public void process() throws IOException
	 {
		 while (reader.hasNext()) 
		{
			 	value=0;
			 	nextline = reader.nextLine();
			 	System.out.println("Case #"+(lineIndex)+": ");
	            out.write("Case #"+(lineIndex++)+": ");
	            StringTokenizer allwords = new StringTokenizer(nextline);
	            intA= new Integer(allwords.nextToken());
	            intB= new Integer(allwords.nextToken());
	            System.out.println(intA+"    "+intB);
	            
	            int n,m=0;
	            for(n=intA;n<=intB;n++)
	            {
	            	System.out.println(n+"    "+m);
	            	String ns=""+n;
	            	
	            	for(int i=1;i<=ns.length();i++)
	            	{
	            		//System.out.println(i);
	            		String S2=ns.substring(ns.length()-i);
	            		
	            		if(S2.charAt(0)=='0')
	            			continue;
	            		String S1=ns.substring(0,ns.length()-i);
	            		
	            		String ms=S2+S1;
	            		m=new Integer(ms);
	            		//System.out.println(isValid(n, m));
	            		if(isValid(n, m))
	            		{
	            			value++;
	            		}
	            		
	            	}
	            }
	            out.write(value+"\n");
	            

	       }
	 }
	 
	public static void main(String []args)
	{
		G2 obj=new G2();
		obj.initiateFiles();
		
		
		
	}

}
