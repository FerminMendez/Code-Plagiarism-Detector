import java.io.*;
import java.util.*;

public class GoogleCount{
	
	public GoogleCount(String line, int i, BufferedWriter out){
		int count=0;
		try {
//			ArrayList<Goods> gooda = new ArrayList();
//			TreeSet<Integer> goods = new TreeSet();
			StringTokenizer token = new StringTokenizer(line);
			out.write("Case #"+Integer.toString(i)+": ");
			String str = null;
			Goods cur;
			int countS=0, countG=0;
	  		while (token.hasMoreTokens()){
				str = token.nextToken();
				int totG=Integer.parseInt(str);

				str = token.nextToken();
				int totS=Integer.parseInt(str);

				str = token.nextToken();
				int best=Integer.parseInt(str);

				int curr,temp;
				while (token.hasMoreTokens() && count<totG){
					str = token.nextToken();
					curr=Integer.parseInt(str);
					
					if(curr>=best){
						if (curr-best>=((best-1)*2)){

							countG++;
						}
						else if(curr-best>=((best-2)*2) && countS<totS){

							countS++;
							countG++;
						}
					}
					count++;
				}
			}
			out.write(Integer.toString(countG));
			System.out.print("\n");
			out.write("\n");
		}
		catch (IOException ex){
		      ex.printStackTrace();	    		
		}	
	}		
}
