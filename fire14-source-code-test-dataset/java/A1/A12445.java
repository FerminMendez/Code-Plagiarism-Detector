import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Dancing_Googlers {
	public static void main(String args[]) throws Exception
	{
		FileWriter ofstream = new FileWriter("outp.out");
		  BufferedWriter out = new BufferedWriter(ofstream);
			  FileInputStream fstream = new FileInputStream("inp.in");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 long n,sur,p,ng,rem;
			int i,ans=0;
			 int countn=1;
			  String strLine;
			  long[] li = new long[250];
				String[] ls = new String[250];
			  strLine = br.readLine();
			  n = Long.parseLong(strLine);
			  while ((strLine = br.readLine()) != null)   {
				  ans=0;
				  ls =   strLine.split(" ");
				  for (i=0;i<ls.length;++i)
					{
						li[i] = Long.parseLong(ls[i]);
					}
				  i=0;
				  ng =li[i] ;
				  ++i;
				  sur = li[i];
				  ++i;
				  p = li[i];
				  ++i;
				  //System.out.println ("n=" +n);
				  //System.out.println ("ng="+ng);
				  //System.out.println ("Sur="+sur);
				  //System.out.println ("p="+p);
				  for(;i<=(ng+2);i++)
				  {
					  //System.out.println (li[i]);
					  if(li[i]<p)  //Eliminating lower values
						  continue;
					  if((li[i]/3)>=p)   //Finalizing stage 1
					  {
						  //System.out.println ("Hello thier " + (li[i]/3));
						  ++ans;	
						  continue;
					  }
					  //Without Surprise
					  rem = li[i]-(2*p);
				      if(((rem)+1) == p || ((rem)-1) == p || ((rem)+2) == p || ((rem)-2) == p)
				      {
				    	  ++ans;
				    	  continue;
				      }
				    //With SUrprise	
				      rem = (li[i]-p)/2;
				      if(sur>0)
				      {
				    	  if((rem==p) || ((rem+2)==p) || ((rem-2)==p))
				    			  {
				    		         --sur;
				    		         ++ans;
				    			  }
				      }
				  }
				  System.out.println (ans);
				  out.write("Case #" +countn + ": " +ans + "\n");
				  ++countn;
			  }
			  in.close();	
			  out.close();
	}
}
