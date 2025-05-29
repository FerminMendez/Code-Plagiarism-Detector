
	import java.io.*;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.Scanner;
import java.util.regex.Pattern;

	/** Parse the movie database.
	 *
	 * The format of this database is one movie per line, with movie fields
	 * separated by a ",".  The format is:
	 *
	 *      title,category
	 *
	 * Note that there is no space before or after the ",".
	 */
	public class Round2
	{
		private String[] Google;
		private FileReader x;

	    public static void main(String[] argv)
	                  throws FileNotFoundException
	    {
	        FileReader fr = new FileReader("test1.txt");

	        Round2 x = new Round2(fr);

	        String[] g = x.getStrings();
	        for (int i = 0; i < g.length; i ++){
	        	System.out.println("Case #"+(i+1)+": "+g[i]);
	        }
	    }

	    /** Parse all lines from the database.
	     *
	     * @param fr    The FileReader object from which to read the database.
	     */
	    public Round2(FileReader fr)
	    {	try {
			if (fr.ready()){
						Scanner g_reader = new Scanner(fr);
						int y = 0;
						if (g_reader.hasNextLine()){
							y = new Integer(g_reader.nextLine());  
						}
						Google = new String[y];
						parseAll(g_reader);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

	    /** Return a copy of the array of movies
	     */
	    public String[] getStrings()
	    {	return Arrays.copyOf(Google, Google.length);
	    }

	    /** Parse all lines from the database.
	     *
	     * @param scn   The Scanner object from which to read the database.
	     */
	    private void parseAll(Scanner scn)
	    { int i = 0;
	    	while (scn.hasNextLine()){
	    		Google[i] = parseOne(scn.nextLine());
	    		i++;
	    	}
	    }

	    /** Parse one line from the database.
	     *
	     * @param line  One line from the movie database, without the newline
	     *              character.
	     * @throws ParseError 
	     */
	    private String parseOne(String line)
	    {	String[] x = line.split(" ");
	    	int[] y = new int[x.length];
	    		for (int i = 0; i < x.length; i++){
	    			y[i] = Integer.parseInt(x[i]);
	    		}
				return ""+Translate(y);
	    }
	    


	    
	    private int Translate(int[] x){
	    	
	    	int numG = x[0];  
	    	int numS = x[1];
	    	int P = x[2];
	    	int w = 0;
	    	Arrays.sort(x, 3, x.length);
	    	for (int i = 3; i < x.length; i++){
	    		if (P*3 -2 <= x[i] && P <= x[i]){
	    			w++;
	    		}
    			else if(P*3 -4 <= x[i] && numS > 0 && P <= x[i]){
	    			w++;
	    			numS --;
    			}
	    	}
	    	return w;
	}
}
