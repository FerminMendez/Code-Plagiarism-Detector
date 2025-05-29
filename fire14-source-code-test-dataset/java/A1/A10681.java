import java.io.*;

class Dancing 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader in=new BufferedReader(new FileReader("in.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("out.txt"));
		int tests=Integer.parseInt(in.readLine());
		for(int i=0;i<tests;i++)
		{
			String data[]=in.readLine().split("\\s+");
			int people=Integer.parseInt(data[0]);
	        int surprise=Integer.parseInt(data[1]);
	        int min_score=Integer.parseInt(data[2]);	   
	        int count=0;
	    
	        for(int j=3;j<data.length;j++)
	        {
	        	int quot=Integer.parseInt(data[j])/3;
	        	switch (Integer.parseInt(data[j]) % 3)
	        	{
	        		case 0:
	        			if (quot>=min_score)
	        			{
	        				count++;
	        			}
	        			else
	        			{
	        				if (surprise>0 && quot>0 && quot+1>=min_score)
	        				{            
	        					count++;
	        					surprise--;
	        				}            
	        			}         
	        			break;

	        		case 1:
	        			if (quot>=min_score || quot+1>=min_score)
	        			{
	        				count++;
	        			}
	        			else
	        			{
	        				if (surprise>0 && quot+1>=min_score)
	        				{
	        					count++;
	        					surprise--;
	        				}
	        			}

	        			break;
	        
	        		case 2:
	       				if (quot+1>=min_score || quot>=min_score)
	       				{
	       					count++;
	       				}
	       				else
	       				{
	       					if (surprise>0 && quot+2>=min_score)
	       					{
	       						count++;
	       						surprise--;
	       					}
	       				}
	        			break;
        		}
	        	
	        }
	        out.println("Case #"+(i+1)+": "+count);
	        out.flush();
		}
	}
}
