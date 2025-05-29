import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class code_jam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("C:\\test.in");
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    DataInputStream dis = null;
	    
	    try {
		    fis = new FileInputStream(file);
		    bis = new BufferedInputStream(fis);
		    dis = new DataInputStream(bis);
		    
		    int cc = Integer.parseInt(dis.readLine());
		    int i;
		    for (i=0;i<cc;i++) {
		    	String range = dis.readLine();
		    	int from = Integer.parseInt(range.substring(0, range.indexOf(' ')));
		    	int to = Integer.parseInt(range.substring(range.indexOf(' ')+1, range.length()));
		    	int count = 0;
		    	int x,y;
		    	for (x=from; x < to; x++){		    		
		    		int length = String.valueOf(x).length();
		    		for (y = 0; y < length-1; y++){
		    			int head = (int) (x / Math.pow(10, y+1));
		    			int tail = (int) (x % Math.pow(10, y+1));
		    			int new_num = (int) (tail * Math.pow(10, length-y-1) + head);
		    			if ((new_num <= to) && (new_num > x))
		    				count++;
		    		}
		    	}
		    	System.out.println("Case #" + (i+1) + ": " + count);
		    }
	      fis.close();
	      bis.close();
	      dis.close();

	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
		
	}

}
