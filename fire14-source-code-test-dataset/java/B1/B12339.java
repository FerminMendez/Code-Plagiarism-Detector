package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class testapp {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		 StringBuilder contents = new StringBuilder();
		 int totalCase=0;
		 int aVar[]=null,bVar[]=null;
		 int loop=-1;
		 
		    
		    try {
		    String aFile="c:\\testapp.txt";
		      BufferedReader input =  new BufferedReader(new FileReader(aFile));
		      try {
		        String line = null; 
		        while (( line = input.readLine()) != null){
		          if(loop==-1)
		          {
		        	  System.out.println(line.trim());
		        	totalCase =Integer.parseInt(line);
		        	aVar =new int[totalCase];
		        	bVar =new int[totalCase];
		        	loop++;
		        	continue;
		          }
		          String[] result = line.split("\\s");
		          aVar[loop]=Integer.parseInt(result[0]);
		          bVar[loop]=Integer.parseInt(result[1]);
		          loop++;
		        }
		      }
		      finally {
		        input.close();
		      }
		    }
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		
		
		for(int caseid=0;caseid<totalCase;caseid++)
		{
			int a=aVar[caseid];
			int b=bVar[caseid];
			int num=a;
		
		ArrayList<String> matchlist=new ArrayList<String>();
	
		while(num<=b)
		{
			
		checkpairs(num,a,b,matchlist);
		num++;
			
		}
		
		System.out.println("Case #"+(caseid+1)+": "+matchlist.size());
		}

	}
	
	public static int checkpairs(int num,int a, int b,ArrayList<String> matchlist)
	{
		int count=0;
		int rnd=1;
		int m;
		double div;
		int size=String.valueOf(num).trim().length();
		while(rnd<size)
		{
			
			div=num/Math.pow(10, rnd);
			m=(int)(num%Math.pow(10, rnd)*Math.pow(10, size-rnd))+(int)(Math.floor(div));
	
			if(m>=a && m<=b && m!=num )
			{
				if(!(matchlist.contains(num+"-"+m)|| matchlist.contains(m+"-"+num)))
					matchlist.add(num+"-"+m);
			}
			
			rnd++;
		}
	
		return count;
	}

}
