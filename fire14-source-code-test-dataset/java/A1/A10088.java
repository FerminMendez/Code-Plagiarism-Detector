import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;



class roundtwo {
    public static void main(String[] args) {
    	String text = "";
    	if( args.length > 0) {
    		text = args[0];
    	} else {
	    	try {
				FileInputStream fos = new FileInputStream( "text2.txt");
			    Scanner scanner = new Scanner(new FileInputStream("text2.txt"));
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
        	
        	int number = Integer.parseInt(st2.nextToken());
        	int suprise = Integer.parseInt(st2.nextToken());
        	int score_target = Integer.parseInt(st2.nextToken());
        	int[] data = new int[30];
        	for( int i = 0; i < 30; i++){
        		data[i] = 0;
        	}
        	int for_sure = 0;
        	int mabey = 0;
        	for( int i = 0; i < number; i++){
        		int current = Integer.parseInt(st2.nextToken());
        		int base = current / 3;
        		if( base >= score_target) {
        			for_sure++;
        		}
        		if( base == (score_target - 1)) {
        			int remainder = current % 3;
        			if( remainder > 0) {for_sure++;}
        			else if( base != 0){mabey++;}
        		} 
        		if( base == (score_target - 2)) {
        			int remainder = current % 3;
        			if( remainder == 2) {mabey++;}
        		}
        	}
        	int number_possible = for_sure; 
        	if( suprise >= mabey) {
        		number_possible += mabey;
        	} else {
        		number_possible += suprise;
        	}
            System.out.println( "Case #" + x + ": " + number_possible);
        }
    }
}