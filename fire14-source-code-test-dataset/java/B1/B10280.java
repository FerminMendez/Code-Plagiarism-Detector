package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Hashtable;

public class Recycle2 {
	public static void main(String[] args)
	{
		try
		{
			String line;
			String data="";
			 File ff = new File("Output.txt");
		     if (ff.exists())
		     {
		    	 ff.delete();
			 }
		     //BufferedReader br = new BufferedReader(new FileReader("/Users/Sush/Documents/workspace1/CJ/src/files/Input.txt"));
		     BufferedReader br = new BufferedReader(new FileReader("/Users/Sush/Downloads/C-small-attempt2.in.txt"));
			 
			 StringBuffer sb = new StringBuffer();
				 while((line = br.readLine())!= null)
				 {
					 sb = sb.append(line +"\n");
				 }
			 String[] nos = sb.toString().split("\n");
			 for (int i = 1; i< nos.length; i++)
			 {
		     Hashtable<Integer, Integer> counts = new Hashtable<Integer, Integer>();
		     //System.out.println("Str "+nos[i]);
			 String[] num = nos[i].split(" ");
			 int count=0;
		     int begin=Integer.parseInt(num[0]);
		     int end = Integer.parseInt(num[1]);
		     while(begin < end)
		     {
		    	 int a = begin;
		    	 int d = (int)Math.floor(Math.log10(a));
		    	 
		    	 if (d!= 0)
		    	 {
		    	 int f = a/(int)(Math.pow(10, d));
		    	 int n = a/(int)(Math.pow(10, d-1));
		    	 if (f>n)
		    	 {
		    		 a = f * (int)Math.pow(10, d) + n * (int)Math.pow(10, d-1); 
		    	 }
		    	 }
		    	 int check = a;
		    	 int x = 0; 
		     if (!counts.containsKey(a))
		     {
		    	 counts.put(a, 0);
			     while(x != a)
			     {
			    	 x = (check%10)*(int)(Math.pow(10.0, d)) + (check/10);
			    	 check = x;
			    	 if (x > a && x <= end)
			    	 {
			    		 //counts.put(x, 0);
			    		 count = count +1; 
			    		 counts.put(a, count);
			    	 }
			     }
		     }
		     begin = begin + 1;
		     }
		     data = data + "Case #"+i+": "+count+"\n";
		     System.out.print("Case #"+i+": ");
		     System.out.println(count);
		     
		}

	     BufferedWriter bw = new BufferedWriter(new FileWriter(ff, true));
	     bw.write(data);
	     bw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
