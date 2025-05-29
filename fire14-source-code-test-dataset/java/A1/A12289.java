import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class problem2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fstream = new FileInputStream("C:\\Profiles\\sys4qa\\Desktop\\in.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;	
		  Integer T= 0;
		 
		  int N=0;
			int S=0;
		int 	p=0;
		ArrayList score=new ArrayList();
			
		ArrayList inputList =new ArrayList();
		ArrayList input =new ArrayList();
		  while ((strLine = br.readLine()) != null)   {
			  
			 
			  if (T==0)
			  {
				  T= Integer.parseInt(strLine);
			  }
			  else
			  {
				  String s[]=strLine.split(" ");
				   inputList =new ArrayList();
				  for(int i=0;i<s.length;i++)
					  inputList.add(Integer.parseInt(s[i]));
				  input.add(inputList);
				
			  }
			  
			  }
			  //Close the input stream
			  in.close();
		
			  FileWriter fstream1 = new FileWriter("C:\\Profiles\\sys4qa\\Desktop\\out.txt");
			  BufferedWriter out = new BufferedWriter(fstream1);
			 
			  
		
int id=0;
		Iterator iter=input.iterator();
		while (iter.hasNext()) {
			ArrayList ip= (ArrayList) iter.next();
			N = (Integer)ip.get(0);
			S= (Integer) ip.get(1);
			p=(Integer) ip.get(2);
			score=new ArrayList();
			Iterator iter1= ip.subList(3, N+3).iterator();
			while (iter1.hasNext()) {
				score.add(iter1.next());
			}
			int output= execute(score,N,S,p);
			id++; 
			
			 out.write("Case #"+id+": "+output+"\n");
		}
		//Close the output stream
		  out.close();

	
		
		
		}

	

	static int execute(ArrayList score,int N,int S, int p) {

		int count=0;
		int min=0;
		if (p>=2)
		min =(p-1)*3+1;
		else
			min=p*3;
		
		int surpiseMin = min-2;
	
		for (int i=0;i<N;i++)
		{
			if ((Integer)score.get(i)>=min)
			count++;
			else if (((Integer)score.get(i)>=surpiseMin) && S>0)
				{
				S--;
				count++;
				}				
		}
		return count;
		
	}
	}

	
