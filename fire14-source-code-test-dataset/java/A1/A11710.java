import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Googlers_Dance {
	
	FileWriter fstream;
	BufferedWriter out;
	
	Googlers_Dance()
	{
		try 
		{
		fstream = new FileWriter("E:\\Yoxos\\EclipseNew\\workspace\\TestProject\\Dance_op.txt");
		out = new BufferedWriter(fstream);
		
		}catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Googlers_Dance obj = new Googlers_Dance();
		obj.getInput();
		
		 //Close the output stream
		  //out.close();
	}
	
	void printFile(String strLine)
	{
		try{
			  // Create file 
			  
			  out.write(strLine);
			 
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	
	void getInput()
	{
	try{
	    // Open the file that is the first 
	    // command line parameter
		int iNumberOfLines = 0 ;
	    FileInputStream fstream = new FileInputStream("E:\\Yoxos\\EclipseNew\\workspace\\TestProject\\src\\B-small-attempt0.in");
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    
	    String strLine;
	    //Read File Line By Line
	    if ((strLine = br.readLine()) != null)   {
	      // Print the content on the console
	      //System.out.println (""+strLine);
	      iNumberOfLines = Integer.parseInt(strLine);
	    }
	    int j=1;
	    while(iNumberOfLines-- > 0 && ((strLine = br.readLine())!=null))
	    {
   	
	    	int iTempCount = getGooglersBestNumber(strLine);
	    	String strTemp= "Case #"+j+": "+iTempCount;
	    	
	    	System.out.println(strTemp);
	    	j++;
	    }
	    //Close the input stream
	    in.close();
	    }catch (Exception e){//Catch exception if any
	    	e.printStackTrace();
	    }  
	}
	
	int getGooglersBestNumber(String strLine)
	{
		int iGooglersBestCount=0;
    	String strWords[] = strLine.split(" ");
    	int iN = Integer.parseInt(strWords[0]);
    	int iSurprising = Integer.parseInt(strWords[1]);
    	int iP = Integer.parseInt(strWords[2]);
    	
    	int  l=3,k=0;
    	
    	while(l < strWords.length) {
    		k=iP;
    		int iT = Integer.parseInt(strWords[l++]);
    		
    		while(k>=0 && k<=10)
    		{
    			int iTempMaxVal = (k*3);
    			if(iT >= iTempMaxVal) {
    				
    				if((iT==iTempMaxVal) || (iT == iTempMaxVal+1) || (iT == iTempMaxVal+2)) {
						
    					iGooglersBestCount++;
    					break;
    				}   
                  
    				if(iSurprising>0) {
    					
    					if((iT == iTempMaxVal+3)  || (iT == iTempMaxVal+4)) {
    						iSurprising--;
    						iGooglersBestCount++;
    						break;
    					}
    				}
    				
    				 				
    				k++;
    			}
    			else {
    				
    				if(iT <= iTempMaxVal) {
    					
    					if((iT==iTempMaxVal) || (iT == iTempMaxVal-1) || (iT == iTempMaxVal-2)) {
        					iGooglersBestCount++;
        					break;        			
        				}
    	                  
        				if(iSurprising>0) {
        					
        					if(iT!=0 && (iT == iTempMaxVal-3) || (iT == iTempMaxVal-4)) {
        						iGooglersBestCount++;
        						iSurprising--;
        						break;
        					}
        				}
        				
        				break;
        			}    			
    				
    			}
    		}
    	}
    	
		return iGooglersBestCount;
	}
}
