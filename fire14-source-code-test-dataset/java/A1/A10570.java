import java.io.*;
import java.util.*;

/**
 *
 * @author posv
 */

public class GoogleDance{
	public static void main(String[] args){
		int cs = 0;
		int n,s,p,ln,count,counts,total,temp;
		count = 0; counts = 0; total = 0;
		//List<Integer> scores = new ArrayList<Integer>();
		try{
			File file = new File("lines1.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null){
				String[] tokens = line.split(" ");
				//System.out.println("Length : #" +tokens.length);
				ln = tokens.length;
				if(cs==0){
					cs++;
					continue;
				} else {
					n = Integer.parseInt(tokens[0]);
					s = Integer.parseInt(tokens[1]);
					p = Integer.parseInt(tokens[2]);
					for(int i=3;i<ln;i++){
						temp = Integer.parseInt(tokens[i]);
						if(temp == 0 && p!= 0){
							continue;
						} else if(temp >= (p*3-2)) {
							count++;
						}else if(temp >= (p*3-4) && temp < (p*3-2)){
							counts++;
						}
					}
					if(counts >= s){
						total = count + s;
					} else{
						total = count + counts;
					}
					System.out.println("Case #" +cs+": " +total);
				}
				cs++;
				count = 0; counts = 0; total = 0;
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
