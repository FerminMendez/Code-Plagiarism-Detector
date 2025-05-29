import java.util.*;
import java.io.*;


public class probC {
	public static void main (String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("C:\\downloads\\c-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\downloads\\c-small-output.in"));
		int t = Integer.parseInt(in.readLine());
		int i,j,k,l;
		int A,B;
		int len;
		int count;
	    for (i=1;i<=t;i++)
		{ StringTokenizer st = new StringTokenizer(in.readLine());
		  A = Integer.parseInt(st.nextToken());
		  B = Integer.parseInt(st.nextToken());
		  count=0;
		  len = String.valueOf(A).length();
		  int[] temp =  new int[len];
		  for (j=A;j<=B;j++)
		  { String n;
		    n = String.valueOf(j);
		    
		    for (k=0;k<len-1;k++)
		    { int flag=0;
		      temp[k] = Integer.parseInt(n);
		      StringBuilder sb = new StringBuilder();
		    	for (l=1;l<len;l++)		         
		          sb.append(n.charAt(l));
		    	sb.append(n.charAt(0));
		    	int y = Integer.parseInt(sb.toString());
		    	for (int x : temp)
		    		if (x==y)
		    		{ flag=1;
		    		  break;
		    		}
		    	if ((flag==0) && (y>j) && (y<=B))
		    			count++;
		    	n = sb.toString();
		  }
		    }
		out.write("Case #"+i+": "+count);
		out.newLine();
		  
		}
		  out.close();
	}

}
