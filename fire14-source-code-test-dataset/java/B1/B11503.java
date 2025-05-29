package com.prob1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ClassB {
	public static void main(String args[]){
		   try{
		      BufferedReader in = new BufferedReader(new FileReader("D://NewFolder2//C-small-attempt0.in")); 
		      //BufferedReader in = new BufferedReader(new FileReader("D://NewFolder2//C-large.in")); 
		      PrintWriter out = new PrintWriter(new FileWriter("D://NewFolder2//test1.txt")); 
		      int c =1;
		      //int x =0;
		      while (in.ready()){
		    	  String text = in.readLine();
		    	  
		    	  if(c != 1){
		    		  StringTokenizer tokenizer = new StringTokenizer(text," "); 
			    	  String[] allText = new String[2]; 
			    	  int pos = 0; 
			    	  while (tokenizer.hasMoreTokens()) 
			    	        allText[pos++] = tokenizer.nextToken();
			    	long lower_limit = Long.parseLong(allText[0]);
					long upper_limit = Long.parseLong(allText[1]);
					long result = countRecycledNums(lower_limit,upper_limit);
    	    		  String text1 = "Case #"+(c-1)+": "+result;
			          out.println(text1);
			          c++;
		    	  }
		    	  else{
		    		 // x = Integer.parseInt(text); 
		    		  c++;
		    	  }
		      }
		      out.close();
		      in.close();
		   }catch(IOException e){
		      System.out.print("Exception");
		   }	
	 } //end of main

	
  private static int countNumDigits( long number)
	{
		int count = 1;
		count = 1 + (int)Math.floor(Math.log10(number));
		return count;
	}
  
  
//Rotate a number by specified positioon
  private static long cyclicRotate( long num, int numLen, int pos )
  {
  	long new_num, suffix,prefix;
  	long compute_by = (long)(Math.pow((double)10,(numLen - pos )));
  	suffix =  num / compute_by ;
  	prefix =  num % compute_by ;

  	new_num = prefix *  (long)Math.pow((double)10, pos ) + suffix;

  	return new_num;
  }
  
  
  static long countRecycledNums(long lower_limit, long upper_limit)
  {
  	long uniq_recycle_pair_count = 0;
  	int num_digits =  countNumDigits ( lower_limit);
  	if ( num_digits == 1 ){ 
  		return 0;
  		}

  	for ( int counter = (int)lower_limit ; counter < upper_limit ; counter++)
  	{
  		Set set = new HashSet();

  		for ( int pos = 1 ; pos < num_digits ; pos++ ) 
  		{
  			long recycled_num = cyclicRotate(counter,num_digits,pos);
  			if ( recycled_num <= counter)
  			{
  				continue;
  			}
  			if ( lower_limit <= recycled_num && upper_limit >= recycled_num )  
  			{
  				uniq_recycle_pair_count++;
  				set.add(recycled_num);
  				
  			}
  		}
  	}
  	return uniq_recycle_pair_count;
  }
}