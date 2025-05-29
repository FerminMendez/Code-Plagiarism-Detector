import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class numberproblem
{	public static void main(String args[])
	{
	
	
	 try
	  {
	  FileInputStream in = new FileInputStream("/Users/nanz/Downloads/C-small-attempt0.in");
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  int line=0;
	  int ln;
	  while((strLine = br.readLine())!= null)
	  {
	   if(line==0)
		   {
		   		ln = Integer.parseInt(strLine);
		   }
	   else
	   
	   	   {
		        //System.out.println(strLine);
		   
		   		String nums[]=strLine.split(" ");
		   		//System.out.println(nums);
		   		int num_A= Integer.parseInt(nums[0]);
		   		int num_B= Integer.parseInt(nums[1]);
		   		RotateNumber(num_A,num_B,line);

			   
		   }
	    line++;

	   }
	   
	   }
	catch(Exception e){
		   System.out.println(e);
		  }
		  	 
    
}

private static void RotateNumber(int A, int B, int line)
{
      int num = A;
      double pairs_2=0;
      double pairs_3=0;
      double pairs;
      while(num<=B)
      {
      int numdigits = (int) Math.log10((double)num)+1; // would return numdigits - 1
      int ones, tens, hundrds;
      
      if(numdigits==2)
      {
    	  //System.out.println("2 digit number");
    	  ones = num%10;
    	  int temp=num/10;
    	  tens=temp%10;
    	  //System.out.println(ones+" "+tens);
    	  if((tens!=ones)&&(tens!=0)&&(ones!=0))
    	  {
    		  int num_pair = ones*10+tens;
    		  if((num_pair>=A)&&(num_pair<=B))
    		  {
    			  pairs_2=pairs_2+1;
    			  //System.out.println(num_pair);
    		  }
    		  
    	  }

    		 
      }
      else if(numdigits==3)
      {
    	  int pair_a, pair_b, pair_c;
    	  //System.out.println("3 digit number !");
    	  ones = num%10;
    	  int temp1=num/10;
    	  tens=temp1%10;
    	  int temp2=temp1/10;
    	  hundrds=temp2%10;
    	  //System.out.println(hundrds+" "+tens+" "+ones);
    	  if((tens==hundrds)&&(hundrds==ones))	// Working
    	  {
        	  //System.out.println("No pairs here");

    	  }
    	  else
    	  {
    		  pair_a=num;
    		  pair_b= tens*100+ ones*10+ hundrds;
    		  pair_c= ones*100 + hundrds*10 + tens;
    		  int nod_a=3;
    		  int nod_b = (int) Math.log10((double)pair_b)+1;
    		  int nod_c=  (int) Math.log10((double)pair_c)+1;
    		  if((nod_b==3)&&(nod_c==3))
    		  {
            	  //System.out.println("All have three digits");
            	  if((pair_b>=A)&&(pair_b<=B)&&(pair_c>=A)&&(pair_c<=B))
            	  {
                	  //System.out.println("Inside the case where all 3 pairs lie in the range");

                	  //System.out.println("pair a"+pair_a+" ");
					  //System.out.println("Incremented");

                	  pairs_3= pairs_3+1;    // As each pair will add 1 thus 3 will be added anyways

            	  }
            	  
            	  else if(((pair_b>=A) && (pair_b<=B)) || (pair_c>=A) && (pair_c<=B))
            	  {
                	  //System.out.println("Inside the case where only 2 pairs lie in the range");
					  //System.out.println("pair a"+ pair_a+"pair b"+ pair_b+"pair c"+ pair_c);
					  //System.out.println("Incremented");

            		  pairs_3= pairs_3+0.5;
            	  }
            	   
    		  }
    		  
    		  else if((nod_b==3)||(nod_c==3))
    		  {
				  //System.out.println("Inside case where only 2 numbers have 3 digits");

    			  if(nod_b==3)
    			  {
    				  if((pair_b>=A) && (pair_b<=B))
    				  {
    					  //System.out.println("pair a"+ pair_a+"pair b"+ pair_b+"pair c"+ pair_c);
    					  //System.out.println("Incremented");
    					  pairs_3= pairs_3+0.5;
    				  }
    				  
    			  }
    			  else if(nod_c==3)
    			  {
    				  if((pair_c>=A) && (pair_c<=B))
    				  {
    					  //System.out.println("pair a"+ pair_a+"pair b"+ pair_b+"pair c"+ pair_c);
    					  //System.out.println("Incremented");
    					  pairs_3= pairs_3+0.5;
    				  }
    			  }
    		  }
    		  
    	  }

      }
      
	  num++;
      }
	  
      
      pairs= pairs_2/2+pairs_3;
      
	  //System.out.println("Number of 2 digit pairs "+ pairs_2/2);
	  //System.out.println("Number of 3 digit pairs "+ pairs_3);
	  //System.out.println("Total number pairs "+ pairs);
      int ans = (int)pairs;
	  System.out.println("Case #"+line+": "+ans);

	  

}
	
}



	

