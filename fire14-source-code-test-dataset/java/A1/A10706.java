package test;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
public class A {
	
	public static  int getDiff(int x , int y , int z , int l){
	    if(y>=l && z>=l)
	        return 0;
	  ArrayList<Integer> arr = new ArrayList<>();
	 
	
	 arr.add(Math.abs(x-y));
	 arr.add(Math.abs(x-z));
	 arr.add(Math.abs(y-z));
	 
	 return Collections.max(arr);
	     
	     
	 }
	
	 public static void main(String[] args) throws Exception  {
		 
		 Scanner in = new Scanner(new File("B-small-attempt3.in"));
		 PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("bout.txt")));
		 int repeats=0;
			int numTests;
			int t;
			int limit,ex,k;
			repeats = in.nextInt();
			for(int j=1;j<=repeats;j++)
			{
		//	System.out.print("Case #"+j+":");
			out.print("Case #" + (j) + ": ");
			numTests = in.nextInt();
			ex = in.nextInt();
			limit = in.nextInt();
			int res=0;
			for(int i=0;i<numTests;i++){
				t = in.nextInt();
		           if(t>=limit){
		             if(limit != 0 && t/limit==3)
		               res++;
		             else{
		                  int rMain =t-limit;
		                  int r1 = rMain/2;
		                  int r2 = t-limit-r1;
		                  int fin = getDiff(limit,r1,r2,limit);
		                  if(fin<2)
		                    res++;
		                  else if(fin==2 && ex>0){
		                    res++;
		                    ex--;
		                    }
		                  
		                  }
		             }
		       
		           
		          
		          
		             
		    }
		   
			//System.out.println(" "+res);
			 System.out.println("Case #" + (j) + ": " + res);
		}
		 
		/*
	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("B-small-attempt0.in")));
	          //  int t = Integer.parseInt(in.readLine());
	            int repeats = Integer.parseInt(in.readLine());
	            
	            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("bout.txt")));
	            for (int i = 1; i <= repeats; i++) {
	                //String res = "";
	            	int numTests = (in.read());
	            	int ex = in.read();
	            	int limit = in.read();
	            	int res=0;
	               // String input = in.readLine();
	                for(int j=0;j<numTests;j++){
	                	int t = in.read();
	                	if(t>limit){
	                        if(t%limit==0)
	                          res++;
	                        else{
	                             int rMain =t-limit;
	                             int r1 = rMain/2;
	                             int r2 = t-limit-r1;
	                    
	                             int fin = getDiff(limit,r1,r2,limit);
	                             if(fin<2)
	                               res++;
	                             else if(fin==2 && ex>0){
	                               res++;
	                               ex--;
	                               }
	                             }
	                      }
	                	}
	                out.println("Case #" + (i) + ": " + res);
	            }
	            out.close();
	        }catch(Exception e){
	        	e.printStackTrace();
	        }*/
	 }
}


