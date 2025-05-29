import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
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
		    int i, j;
		    for (i=0;i<cc;i++) {
		    	String range = dis.readLine();
		    	
		    	StringTokenizer st = new StringTokenizer(range);
		    	int googler_count = Integer.parseInt(st.nextToken());
		    	int surprising = Integer.parseInt(st.nextToken());
		    	int index = Integer.parseInt(st.nextToken());
		    	int count = 0;
		    	int can_surprise = 0;
		    	
		    	for (j=0;j<googler_count; j++) {
		    		int googler_score = Integer.parseInt(st.nextToken());
		    		if (googler_score >= (index * 3 - 2)) {
		    			count += 1;
		    		} else if ((googler_score >= (index * 3 - 5)) && (googler_score > 1)){
		    			can_surprise += 1;
		    		}
		    	}
		    	if (can_surprise > surprising)
		    		count += surprising;
		    	else 
		    		count += can_surprise;

		    	System.out.println("Case #" + (i+1) + ": " + count);
		    	
		    	/*int from = Integer.parseInt(range.substring(0, range.indexOf(' ')));
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
		    	*/
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
