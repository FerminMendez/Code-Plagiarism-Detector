import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class DancingWiththeGooglers 
{
	int maxWiner =0;
	LinkedList<Integer> x = new LinkedList<Integer>();
	ArrayList<Integer> answer = new ArrayList<Integer>();
	
	public DancingWiththeGooglers()
	{
		
	}
	
	public void solve(int[] given)
	{
		int maxNumberOfSur = given[1];
		for(int i=3;i<given.length;i++)
		{
			int min= given[i]/3;
			int rest = given[i] %3;
			if(min>= given[2])
			{
				maxWiner++;
			}
			else if(rest ==1)
			{
				if(min+rest>=given[2])
				{
					maxWiner++;
				}
			}
			else if(rest ==2)
			{
				x.add(min);
			}
		}
		int use = 1;
		if(maxNumberOfSur!=0)
		{
			for(int i=0;i<x.size();i++)
			{	
				if(x.get(i)+2>=given[2] && use<=maxNumberOfSur)
				{
					maxWiner++;
					use++;
				}
			}
		}
		else
		{
			for(int i=0;i<x.size();i++)
			{
				if(x.get(i)+1>=given[2])
				{
					maxWiner++;
				}
			}
		}
		answer.add(maxWiner);
		x=new LinkedList<Integer>();
		maxWiner=0;
	}

	
	public void write()
	{
		try{
	    	  // Create file 
	    	  FileWriter fstream = new FileWriter("out.txt");
	    	  BufferedWriter out = new BufferedWriter(fstream);
	    	  int m=0;
	    	  for(int i=0;i<answer.size();i++)
	    	  {
	    		  m=i;
	    		  out.write("Case #"+(m+1)+": "+answer.get(i));
	    		  if(i!=answer.size()-1)
	    		  out.newLine();
	    	  }
	    		  
	    	  //Close the output stream
	    	  out.close();
	    	  }catch (Exception e){//Catch exception if any
	    	  System.err.println("Error: " + e.getMessage());
	    	  }  
	}
	
	public void answer()
	{
		
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("input.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = br.readLine();
			  //Read File Line By Line
			  
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				  
				 String[] k = strLine.split(" ");
				 int[]u = new int[k.length];
				 for(int i=0;i<k.length;i++)
				 {
					 if(k[i]!=""||k[i]!=" ")
					 u[i]=Integer.parseInt(k[i]);
				 }
				 solve(u);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if
			  System.err.println("Error: " + e.getMessage());
			  }
			  write();
	}

    public static void main(String[] args) {
		DancingWiththeGooglers p=new DancingWiththeGooglers();
		p.answer();
		
	}


}
