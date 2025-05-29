import java.io.*;
import java.text.Format;
import java.util.Formatter;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.math.*;




public class Dancing {



	
	  static public String getContents(File aFile) {
		    //...checks on aFile are elided
		    StringBuilder contents = new StringBuilder();
		    
		    try {
		      //use buffering, reading one line at a time
		      //FileReader always assumes default encoding is OK!
		      BufferedReader input =  new BufferedReader(new FileReader(aFile));
		      try {
		        String line = null; //not declared within while loop
		        /*
		        * readLine is a bit quirky :
		        * it returns the content of a line MINUS the newline.
		        * it returns null only for the END of the stream.
		        * it returns an empty String if two newlines appear in a row.
		        */
		        while (( line = input.readLine()) != null){
		          contents.append(line);
		          contents.append(System.getProperty("line.separator"));
		        }
		      }
		      finally {
		        input.close();
		      }
		    }
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		     
		    return contents.toString();
		  }	
	  
	  static public void setContents(File aFile, String aContents)
      throws FileNotFoundException, IOException {
			if (aFile == null) {
			throw new IllegalArgumentException("File should not be null.");
			}
			if (!aFile.exists()) {
			throw new FileNotFoundException ("File does not exist: " + aFile);
			}
			if (!aFile.isFile()) {
			throw new IllegalArgumentException("Should not be a directory: " + aFile);
			}
			if (!aFile.canWrite()) {
			throw new IllegalArgumentException("File cannot be written: " + aFile);
		}
		
		//use buffering
		Writer output = new BufferedWriter(new FileWriter(aFile));
		try {
		//FileWriter always assumes default encoding is OK!
		output.write( aContents );
		}
		finally {
		output.close();
		}
	}

	/** Simple test harness.   */
	public static void main (String... aArguments) throws IOException {
		File testFile = new File("/Users/MatFuck/Dropbox/Projects/Code Jam Qualification 2009/src/A-small-practice-1.in");
		//System.out.println("Original file contents: " + getContents(testFile));
		
		String[] in = getContents(testFile).split(System.getProperty("line.separator")), params= in[0].split(" ");
		

	    long ans[] = new long[2000];
	
		
		
		int NC=Integer.parseInt(params[0].trim());
		
		for(int ci=0;ci<NC;ci++)
		{
			String[] req = in[ci+1].split(" ");
			long googlersN = Long.parseLong(req[0].trim()), surprising = Long.parseLong(req[1].trim()), criteria = Long.parseLong(req[2].trim()) ;
			
			ans[ci + 1] = 0;
			
			for(long i=0;i<googlersN;i++){
				long score = Long.parseLong(req[(int) (i+3)].trim());
				score -= criteria;
				if (score >= 0) {
					score /= 2;
					if (((criteria - score) == 2) && (surprising > 0)) {
						ans[ci + 1]++;
						surprising--;
					}
					else {
						if ((criteria - score) < 2) {
							ans[ci + 1]++;
						}					
					}
				}
					
			}
			
	}
		
	
		
		
		String out ="";
		
		StringBuilder contents = new StringBuilder();

		for (int i=0;i<NC;i++){
		    try {
		       
		          contents.append( "Case #" + (i+1)+ ": " + ans[i+1] );
		          contents.append(System.getProperty("line.separator"));
		    }
		    catch (Exception ex){
		      ex.printStackTrace();
		    }
		}
	     
	    out = contents.toString();
		
		
		
		
		File outFile = new File("/Users/MatFuck/Dropbox/Projects/Code Jam Qualification 2009/src/A-small-practice-1.txt");
		outFile.createNewFile();
		setContents(outFile, out);
		
		System.out.println(getContents(outFile));
	}


} 	  


