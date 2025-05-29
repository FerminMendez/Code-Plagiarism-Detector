import java.util.Scanner;
import java.io.File;
import java.util.HashSet;

public class RecycledNumberFinder
 {
 	
 	
 	public void analyzeInputFile(String fileName) throws Exception
 	 {
 	   Scanner fileScanner = new Scanner (new File (fileName) ); 	
 	   
 	   String line;
 	   
 	   line = fileScanner.nextLine();
 	   
 	   int numberOfTestCases = Integer.parseInt(line.trim());
 	   
 	   
 	   
 	   for(int i = 1; i<= numberOfTestCases ; i++)
 	    { 
 	       line = fileScanner.nextLine();	
 	       
 	       Scanner lineScanner = new Scanner(line);
 	       
 	       int A;
 	       int B;
 	       
 	       A = Integer.parseInt(lineScanner.next().trim());
 	       B = Integer.parseInt(lineScanner.next().trim());
 	       
 	      // System.out.println("\n\nA = "+A+" B = "+B);
 	       
 	       HashSet<String> set = new HashSet<String>();
 	       
 	       int num;
 	       
 	       for(num = A; num<=B ; num ++)
 	        {
 	           int powerOfTenForNum;
 	           
 	           powerOfTenForNum = getPowerOfTenForNumber(num);
 	           
 	           int P = powerOfTenForNum+1;
 	           
 	           for(int power=1; power<= powerOfTenForNum; power++)
 	            {
 	               int Q;
 	               int R;
 	               int n,m;
 	               
 	               Q = num / (int) (Math.pow(10,power));
 	               R = num % (int) (Math.pow(10,power));
 	               P--;
 	               
 	               int newNumberFormed = (int) (Math.pow(10,P)) * R + Q;
 	              
 	               
 	               if(newNumberFormed < A || newNumberFormed >B)
 	                {
 	                   // it is bad.
 	                   continue;	
 	                }	
 	               
 	               if(newNumberFormed == num)
 	                {
 	                   // no use 	
 	                   continue;	
 	                } 
 	               
 	               if(newNumberFormed < num)
 	                {
 	                   n = newNumberFormed;
 	                   m = num;	
 	                }  
 	               else
 	                {
 	                   n = num;
 	                   m = newNumberFormed; 	
 	                } 
 	               
 	               String entryIntoSet = new String("("+n+","+m+")");
 	                
 	               //System.out.printf("(%d,%d) ",num,newNumberFormed); 
 	              // System.out.print(entryIntoSet+" ");
 	               set.add(entryIntoSet);
 	            }
 	           
 	        }
 	       
 	      // System.out.println("\nNo = "+set.size()+"\n");
 	       System.out.println("Case #"+i+": "+set.size());
 	    }	 	
 	 }
 	
 	private int getPowerOfTenForNumber(int num)
 	 {
 	   	int powerOfTenForNum;
 	           
 	    int Q=-1;
 	    int power = -1;
 	           
 	    while(Q!=0)
 	     {
 	       power++;
 	       Q = num / (int) (Math.pow(10,power));	
 	     }	
 	           
 	     
 	    powerOfTenForNum = power-1;
 	     
 	    return powerOfTenForNum;      
 	 }
 	
 	
    public static void main(String[] args) throws Exception
     {
     	RecycledNumberFinder RNF = new RecycledNumberFinder(); 
     	String inputFile = "C-small-attempt0.in";
     	
     	RNF.analyzeInputFile(inputFile);
     }	
 	
 }