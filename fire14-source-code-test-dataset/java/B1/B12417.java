import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class abc {
	public static void main(String args[]) 
	{
		int x ,y,j,k,ans=0;
		int tcount =0;
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter("C-small-attempt4.out");
			  BufferedWriter out = new BufferedWriter(fstream);
			 
		
      
		
		 Scanner myfile;
		try {
			myfile = new Scanner(new FileReader("C-small-attempt4.in"));
				 int testcases = myfile.nextInt();
         while (testcases != 0 || myfile.hasNextInt())  
         {          // Read file content using a while loop
        	 ans =0; 
        	 x = myfile.nextInt();
        	 y = myfile.nextInt();
        	 
        // System.out.println(x + y);
		
		int divby = 1;
		for(k = x;k>=10;k/=10)
		{
			divby = divby *10;
		}
		
		int divdivby = 1;
		for(j=x;j<=y;j++)
		{
			int[] ar = new int[20];
			int itr = 0;
			for(divdivby = divby ; divdivby != 1; divdivby/=10)
		  	
			{
			int m = j % divdivby;
			int n = j /divdivby;
			m  = m *(divby /divdivby)*10;
			m = m+n;
			for(int l=0;l<=itr;l++)
			{
				if(ar[l] == m)
				{	m=0;break;}
				
			}
			if(m!=0)
			{
				ar[itr] = m;
				itr++;
			}
			if(m > j && m <= y && m >= x)
				{
				ans++;
				//System.out.println(m +"-- "+j);
				}
			
			}
		}
		
		
		out.write("Case #"+ ++tcount+": "+ans+"\n");
		
		System.out.println(ans);
		testcases--;
	}

		  
         
         myfile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Reading file using Scanner

		out.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
		
	}

	
}
