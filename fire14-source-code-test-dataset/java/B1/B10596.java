import java.io.*;
import java.util.*;

/**
 *
 * @author posv
 */

public class Recycle{
	public static void main(String[] args){
		int cs = 0;
		int a,b,n,m;
		int temp1, temp2,total,len;
		double temp;
		total = 0;
		try{
			File file = new File("lines2.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null){
				String[] tokens = line.split(" ");
				Set<Double> ints = new HashSet<Double>();
				if(cs==0){
					cs++;
					continue;
				} else {
					a = Integer.parseInt(tokens[0]);
					b = Integer.parseInt(tokens[1]);
					len = tokens[0].length();
					if(len == 1){
						System.out.println("Case #" +cs+": " + 0);
					}else{
						for(int i=a;i<=b;i++){
							int k = len;
							int j=10;
							temp1 = i;
							while(j<=(Math.pow(10,len-1))){
								temp2 = (int)(temp1%(j)*(Math.pow(10,k-1))) + (int)(temp1/j);
								if(temp1>= i && temp1 <= b && temp2<=b && temp1 < temp2){
									total++;
									temp = temp1*(Math.pow(10,len)) + temp2;
									ints.add(temp);
								}
								k--;
								j=j*10;
							}
						}
					System.out.println("Case #" +cs+": " + ints.size());
					}
				}
				cs++;
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
