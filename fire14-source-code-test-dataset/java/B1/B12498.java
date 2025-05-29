import java.io.*;import java.util.*;
public class Solution3
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("input.txt"));
	    PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
	    int lines=Integer.parseInt(br.readLine());
	    for(int q=1;q<=lines;q++)
	    {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int A=Integer.parseInt(st.nextToken());
		    int B=Integer.parseInt(st.nextToken());
		    int ctr=0;
		    for(int n=A;n<=B;n++)
		    {
		    	for(int m=n+1;m<=B;m++)
		    	{
		    			String s1=String.valueOf(n);
			    		String s2=String.valueOf(m);
			    		int x1,x2,i;
			    		for(i=0;i<s1.length();i++)
			    		{
			    			if(s1.charAt(0)==s2.charAt(i))
			    			{
			    			String chk1=s1.substring(0,s2.length()-i);
				    		String chk2=s1.substring(s2.length()-i);
				    		String chk3=s2.substring(0,i);
				    		String chk4=s2.substring(i);
				    		if(chk1.equals(chk4)&&chk2.equals(chk3))
				    		  { ctr++;}
			    			}
			    		}        
		        }    
		    }
		    pw.println("Case #"+q+": "+ctr);
	    }
	    pw.close();
	    
	    
    }
    
}