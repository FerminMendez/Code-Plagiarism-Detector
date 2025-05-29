/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

/**
 * @(#)codejam2.java
 *
 * codejam2 application
 *
 * @author 
 * @version 1.00 2012/4/14
 */
 import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
public class codejam2012B {
    
    public static void main(String[] args) throws IOException {
    	Scanner scan = new Scanner(new File("C:\\Users\\Eren\\Desktop\\input.txt"));
    //	System.out.println(scan.nextLine());
    	int N = Integer.parseInt(scan.nextLine());
    	String line;
    	int count;
    	int result;
    	int surprise;
    	int p;
    	int temp;
    	int temp1;
    	StringTokenizer tokenizer;
    	
    	for ( int i = 0 ; i < N ; i ++)	{
    		result = 0;
    		line = scan.nextLine();
    		tokenizer = new StringTokenizer(line);
    		count = Integer.parseInt(tokenizer.nextToken());
    		surprise = Integer.parseInt(tokenizer.nextToken());
    		p = Integer.parseInt(tokenizer.nextToken());
    		
    		for ( int j = 0; j < count; j++)
    		{
    			temp = Integer.parseInt(tokenizer.nextToken());
    			temp1 = temp;
    			temp = 3*p -temp;
    			if (temp1 == 0 )  
                        {
                            if ( p == 0)
    				result++;   
                        }
    			else if ( temp1 == 1 )
                        {
                                if(p == 0 || p == 1)
                                    result++;
                        }
    			else if ( temp <= 2 )
    				result++;
    			else if ( (temp == 4 || temp == 3) && surprise > 0 )
    				{
    				result++;
    				surprise--;
    				}
    				
    		}		
    		System.out.println("Case #" + (i+1) + ": " + result);			
    	}
    }
}
