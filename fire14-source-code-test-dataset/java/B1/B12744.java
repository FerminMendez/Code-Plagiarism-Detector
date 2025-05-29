import java.io.*;
import java.util.*;
public class q3
{
	public static void main(String []args) throws IOException
	{
		
		
		 PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
	   BufferedReader br=new BufferedReader(new FileReader("input.txt"));
		int arr[]=new int[2];
		int limit=Integer.parseInt(br.readLine());
		String x2;
		int count=0;
		for(int li=1;li<=limit;li++)
	   {count=0;
	   	   x2=br.readLine();
	   	      int j=0;
	   	   StringTokenizer st =new StringTokenizer(x2);
	   	   while (st.hasMoreElements()) {

              String token = st.nextElement().toString();
               arr[j]=Integer.parseInt(token);
                 j++;
           }
           
           for(int a1=arr[0];a1<=arr[1];a1++)
           { 
           	  String x1=String.valueOf(a1);
           	  int l=x1.length();
           	  String final1="";
           	  for(int x=1;x<=(l-1);x++)
		     	{
			
			      final1=x1.substring(l-x,l)+x1.substring(0,l-x);
			          int check=Integer.parseInt(final1);
			      if(a1<check&&check<=arr[1])
			      {
			      	      count++;
			        
			          }
			    }
           	  final1="";
           }    
            
	        pw.println("Case #"+li+": "+count);
	   
	   }
	    pw.close();
	}
}