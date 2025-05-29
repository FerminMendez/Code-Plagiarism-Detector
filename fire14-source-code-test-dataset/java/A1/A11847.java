import java.io.BufferedWriter;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigInteger;

class CombinationGenerator {

  private int[] a;
  private int n;
  private int r;
  private BigInteger numLeft;
  private BigInteger total;

 
  public CombinationGenerator (int n, int r) {
    if (r > n) {
      throw new IllegalArgumentException ();
    }
    if (n < 1) {
      throw new IllegalArgumentException ();
    }
    this.n = n;
    this.r = r;
    a = new int[r];
    BigInteger nFact = getFactorial (n);
    BigInteger rFact = getFactorial (r);
    BigInteger nminusrFact = getFactorial (n - r);
    total = nFact.divide (rFact.multiply (nminusrFact));
    reset ();
  }

  //------
  // Reset
  //------

  public void reset () {
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
    numLeft = new BigInteger (total.toString ());
  }

  //------------------------------------------------
  // Return number of combinations not yet generated
  //------------------------------------------------

  public BigInteger getNumLeft () {
    return numLeft;
  }

  //-----------------------------
  // Are there more combinations?
  //-----------------------------

  public boolean hasMore () {
    return numLeft.compareTo (BigInteger.ZERO) == 1;
  }

  //------------------------------------
  // Return total number of combinations
  //------------------------------------

  public BigInteger getTotal () {
    return total;
  }

  //------------------
  // Compute factorial
  //------------------

  private static BigInteger getFactorial (int n) {
    BigInteger fact = BigInteger.ONE;
    for (int i = n; i > 1; i--) {
      fact = fact.multiply (new BigInteger (Integer.toString (i)));
    }
    return fact;
  }

  //--------------------------------------------------------
  // Generate next combination (algorithm from Rosen p. 286)
  //--------------------------------------------------------

  public int[] getNext () {

    if (numLeft.equals (total)) {
      numLeft = numLeft.subtract (BigInteger.ONE);
      return a;
    }

    int i = r - 1;
    while (a[i] == n - r + i) {
      i--;
    }
    a[i] = a[i] + 1;
    for (int j = i + 1; j < r; j++) {
      a[j] = a[i] + j - i;
    }

    numLeft = numLeft.subtract (BigInteger.ONE);
    return a;

  }
}

public class One
{
	public static void main(String args[])
	{
		String filename = args[0];
		int i=0,j=0;
		int testcase=0 ;
		String out="";
		BufferedWriter bufferedWriter = null;
		try { BufferedReader in = new BufferedReader(new FileReader(filename));
		String str;
		boolean output;
		str = in.readLine();
		testcase = Integer.parseInt(str);
		
		//Construct the BufferedWriter object
		bufferedWriter = new BufferedWriter(new FileWriter("oneoutput.wpd"));
		for (i=0;i <testcase; i++)
		{
			int N=0,S=0,P=0;
			int[] t=new int[10000000];
			str = in.readLine();
/*		StringTokenizer st2 = new StringTokenizer(str, ",");
 
		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
		}
*/
			StringTokenizer st = new StringTokenizer(str," ");
			System.out.println(st);
			N = Integer.parseInt((String)st.nextElement());
			S = Integer.parseInt((String)st.nextElement());
			P = Integer.parseInt((String)st.nextElement());

			System.out.println("N="+N+" S="+S);
			for (j=0;j<N;j++)
				t[j] = Integer.parseInt((String)st.nextElement());
			
		//declare data structures here
					
			// initialize with non surprizes end
			
		int[] indices;
	    CombinationGenerator gen = new CombinationGenerator (N, S);//3C2
	     BigInteger numCombinations = gen.getTotal ();
  	System.out.println ("Num combinations to test " + numCombinations.toString ());
  	
  	int maxwinner=-1;
// for each case
  	while (gen.hasMore ()) {
  		int nowinner=0; 
	      indices = gen.getNext ();
			int[][] score= new int[N][3]; 	    
			   // initialize with non surprizes
				for ( j=0;j<N;j++)
				{
					
				if(t[j]%3 ==0 )
				{
					score[j][0]=t[j]/3;
					score[j][1]=t[j]/3;
					score[j][2]=t[j]/3;
				}
				if(t[j]%3 ==1 )
				{
					score[j][0]=t[j]/3;
					score[j][1]=t[j]/3;
					score[j][2]=(t[j]/3)+1;
				}
				if(t[j]%3 ==2 )
				{
					score[j][0]=t[j]/3;
					score[j][1]=(t[j]/3)+1;
					score[j][2]=(t[j]/3)+1;
				}
				
				}
		      
	    for (int i1 = 0; i1 < indices.length; i1++)
	    {	
	    	System.out.println ("indices["+i1+"]="+indices[i1]);
	    	// over write with surprises
	    	if (t[indices[i1]] >0)
	    	{
	    	if(t[indices[i1]]%3 ==0 )
			{
				score[indices[i1]][0]=t[indices[i1]]/3-1;
				score[indices[i1]][1]=(t[indices[i1]]/3);
				score[indices[i1]][2]=(t[indices[i1]]/3)+1;
			}
			if(t[indices[i1]]%3 ==1 )
			{
				score[indices[i1]][0]=(t[indices[i1]]-4)/3;
				score[indices[i1]][1]=((t[indices[i1]]-4)/3)+2;
				score[indices[i1]][2]=((t[indices[i1]]-4)/3)+2;
			}
			if(t[indices[i1]]%3 ==2 )
			{
				score[indices[i1]][0]=t[indices[i1]]/3;
				score[indices[i1]][1]=(t[indices[i1]]/3);
				score[indices[i1]][2]=(t[indices[i1]]/3)+2;
			}
	    	}
	    }
	    // compute largest.
	      for (int l=0;l<N;l++)
	      {
	    	  System.out.println ("score["+l+"]="+score[l][0]+","+score[l][1]+","+score[l][2]);
	 	     
	    	  if(score[l][2]>=P)
	    		  nowinner++;
	    	  System.out.println ("nowwinner="+nowinner+"l="+l);
	      }
	      if(maxwinner<nowinner)
	    	  maxwinner=nowinner;
	    
  	}
       
          
			
	
			out="Case #"+(i+1)+": ";
			
				out += maxwinner+"\n";
				
				System.out.println ("out ="+out);
				
			bufferedWriter.write(out);
			
		}
		in.close(); } 
		catch (IOException ex) {               ex.printStackTrace();} 
		finally {
			//Close the BufferedWriter
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

public static StringBuffer[] rotateAndDrop(String grid[], int N,int K)
{
	int m,o;
	StringBuffer reverseStr[] = new StringBuffer[N];
	for (m=0;m<N;m++)
	{
		reverseStr[m]= (new StringBuffer(grid[m])).reverse();
		System.out.println ("reverseStr["+m+"]="+reverseStr[m]);
		for (o=0;o<N;o++)
		{
			/*if(reverseStr[m].charAt(o)=='.')
			{	
				StringBuffer tmp=new StringBuffer(reverseStr[m].substring(o+1,N));
				System.out.println ("After reverseStr["+m+"]="+reverseStr[m]);
				System.out.println ("tmp="+tmp);
				reverseStr[m]= tmp.append(".");
				System.out.println ("After reverseStr["+m+"]="+reverseStr[m]);
				
			}*/
			 
		}
	}
	return reverseStr;
	
}

public static String results(StringBuffer grid[], int N,int K)
{
	char[][] ch=new char[N][N];
	StringBuffer out=new StringBuffer();
	boolean Blue=false,Red=false; 
	int m,o,i;
	for (m=0;m<N;m++)
	{
		for (o=0;o<N;o++)
		{
			ch[m][o]=grid[m].charAt(o);
		}
	}
	for (m=0;m<N;m++)
	{
		for (o=0;o<N;o++)
		{
			if (ch[m][o] != '.' )
			{
				try{
			 //check horizontally
			   int j=0;
			   for(i=0;i<K;i++)
			   {
				   if( ch[m][o] == ch[m][o+i] )
				    j++;
				   else
					  break; 
			   }
			  if (j==K)
			  {
				  out.append(ch[m][o]); 
			  }
				 //check vertically
			   j=0;
			   for(i=0;i<K;i++)
			   {
				   if( ch[m][o] == ch[m+i][o] )
				    j++;
				   else
					  break; 
			   }
			  if (j==K)
			  {
				  out.append(ch[m][o]); 
			  }		  
				 //check diagonally
			   j=0;
			   for(i=0;i<K;i++)
			   {
				   if( ch[m][o] == ch[m+i][o+i] )
				    j++;
				   else
					  break; 
			   }
			  if (j==K)
			  {
				  out.append(ch[m][o]); 
			  }		  
				 //check diagonally
			   j=0;
			   for(i=0;i<K;i++)
			   {
				   
				   if( ch[m][o] == ch[m-i][o-i] )
				    j++;
				   else
					  break;
				   
			   }
			  if (j==K)
			  {
				  out.append(ch[m][o]); 
			  }	
				}
				   catch(Exception r)
				   {
					  
				   }
			}
			
		}
		
	}
	if (out != null)
	{
		if (out.indexOf("B")>0 )
			Blue =true;
		if (out.indexOf("R")>0 )
			Red =true;
	}
	
	if (Blue && Red)
		
	  return "BOTH";
	if (Blue)
		return "Blue";
	if (Red)
		return "Red";
	return "Neither";
}
}
