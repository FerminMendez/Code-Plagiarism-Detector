import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



class roundThree {
    public static void main(String[] args) {
    	String text = "";
    	if( args.length > 0) {
    		text = args[0];
    	} else {
	    	try {
				FileInputStream fos = new FileInputStream( "text3.txt");
			    Scanner scanner = new Scanner(new FileInputStream("text3.txt"));
			    try {
			      while (scanner.hasNextLine()){
			        text += scanner.nextLine() + "\n";
			      }
			    }
			    finally{
			      scanner.close();
			    }
				try {
					fos.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    
    	StringTokenizer st = new StringTokenizer(text, "[\r\n]+", false);
    	int cases = Integer.parseInt(st.nextToken());
    	
        for (int x=1; x<= cases; x++) {
        	
        	StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[ ]+", false);
        	
        	int small = Integer.parseInt(st2.nextToken());
        	int large = Integer.parseInt(st2.nextToken());
        	ArrayList keep_track = new ArrayList<Integer>();
        	String small_int = "" + small;
        	int count = 0;
        	int small_length = small_int.length();
        	for( int i = small; i < large; i++) {
        		String number1 = "" + i;
        		keep_track.clear();
        		for( int j = 1; j < small_length; j++) {
        			String sub_2 = number1.substring(0,j);
        			String sub_1 = number1.substring(j,small_length);
        			int variation = Integer.parseInt( sub_1 + sub_2 );
        			if( variation > i && variation <= large && !keep_track.contains(variation)) {
        				keep_track.add(variation);
        				count++;
        			}
        		}
        	}
            System.out.println( "Case #" + x + ": " + count);
        }
    }
}