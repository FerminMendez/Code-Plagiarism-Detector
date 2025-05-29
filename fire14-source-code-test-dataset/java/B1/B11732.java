import java.util.*;
import java.io.*;


public class RecycledNums 
{
    
    static LinkedList<String[]> output = new LinkedList<String[]>();
    
    
    static int numberOfLines;

    //Main Method
    public static void main (String[] args)
	{
                 
		//Read in the file
        parseFile( output );
        
        
        int[] ans = new int[ numberOfLines ];
        
        //Calculate recycled numbers
        ListIterator itr = output.listIterator();
            
        int count = 0;
       
        
        //Iterate through all cases, input to calcNums     
        while( itr.hasNext() )
        {
           int result = calcNums( (String[])itr.next() );
           
           //Store result of that case in ans array
           ans[count] = result; 
           count++;
        }
                
        //printFile(output);
        
        //Write out file
        writeFile( ans );
 
    }//End of Main
      
    static int calcNums(String[] input )
    {
        
        //Let A = first element, let B = the second element 
        String a = input[0];
        String b = input[1];
        String n = null;
        String m = null;
        
        //If length of A and B == 1
        if (a.length() == 1 && b.length() == 1)
        {
          return 0;
        }
        
        //initialize the array ranges with numbers starting from A ending at B
        int count = 0;
        HashSet<String> set = new HashSet<String>();
        
        ArrayList<String> range = new ArrayList<String>(); 
        
        int int_a = Integer.parseInt(a);
        int int_b = Integer.parseInt(b); 
        int temp = int_a;
        
        while( temp <= int_b )
        {    
            range.add( Integer.toString( temp ) );
            temp++;     
        }
        
        //loop from i = 0 till i < ranges.size()
        for (int i = 0; i < range.size(); i++)
        {
          n = range.get(i);
          m = range.get(i);
          int int_n = Integer.parseInt(n);
          

            //let length be the length of string in ranges[i] 
          int length = range.get(i).length();
          
          //loop from j = 0 till j < ranges[i].length
          for (int j = 0; j < length; j++)
          {
            //get the last char from current_m 
            //get the string from 0 to 2nd last char
            //concatenate both strings together
            
            m = m.substring(length -1) + m.substring(0, length - 1);
            
            
            int int_m = Integer.parseInt(m);

            // A ≤ n < m ≤ B
            if (int_m <= int_b && int_m > int_n && int_m >= int_a)
            {
                //If a valid pair, add pair to HashSet, no duplicates.
                String key = n + m;
                set.add(key);
            }
          }
        }
    
        return set.size(); 
    }
    
  
    static void parseFile(LinkedList<String[]> output)
	{
        
  		try
		{
				BufferedReader in = new BufferedReader(new FileReader( "input.in" ));

				numberOfLines = Integer.parseInt( in.readLine() );
				
				int count = 0;
				String line;
				
				
				    while (count < numberOfLines )	//file reading line by line
				    {
				        line = in.readLine();
				        
				        //Split each line into array of 2 numbers
					    String[] lines = line.split(" ");
						
						//int[] temp = new int[lines.length]; 
						//temp[0] = Integer.parseInt( lines[0] );
						//temp[1] = Integer.parseInt( lines[1] );
						
						//output.add(temp);
						
						output.add(lines);
						
						count++;
		        	    
				    }
				    
	        	    in.close();

	            }catch( IOException ioException ) {}
    
    }//End of parseFile()
    
    static void writeFile( int[] ans)
    {
        //Write out lines to a file
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.in"), false));
            
            
            for(int i = 0 ; i < ans.length; i++)
            {
                int num = i + 1;
                bw.write("Case #" + num + ": ");
                bw.write( Integer.toString(ans[i]));
                bw.newLine();
            }
            
            bw.close();
        } 
        catch (Exception e) 
        {}
   
    }//End of writeFile() 
  
} //End of RecyclesNums Class   
