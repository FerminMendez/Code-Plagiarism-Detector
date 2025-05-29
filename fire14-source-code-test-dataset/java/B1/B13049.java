
package googleCodeJam;

import java.io.*;
import java.util.*;

public class firstExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FileInputStream fstream = new FileInputStream("C-small-attempt3.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			FileWriter fstream2 = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream2);
			
			String strLine;
			int j=0;
		
			strLine = br.readLine();
			
			while ((strLine = br.readLine()) != null)   {
				ArrayList<String> line = new ArrayList<String>();
				String[] s = strLine.split(" ");
				int i =0;
				for(;i<s.length;){
					line.add(s[i++]);
				}  
				
				int n1 = Integer.parseInt(line.get(0));
				int n2 = Integer.parseInt(line.get(1));
				int nr = 0;
				
				for(int k = n1; k<=n2; k++)
				{ 
					int temp1=k,temp2,nr_temp=0;
					int nr_sh = (int)Math.log10(k);
					do{
						if((temp1>=n1) && (temp1<=n2)) 
							nr_temp++;
						temp2=temp1%10;
						temp1/=10;
						temp1+=temp2*Math.pow(10,nr_sh);
					}while(temp1!=k);
					if(nr_temp>1) 
						nr=nr+nr_temp-1;
				}
				
				
					
					
				//shkrimi i rezultatit	
					
				out.write("Case #"+(++j)+": "+nr/2+" \n");
				
				
				//System.out.println(strLine);
								
				
			}
			//System.out.println(vec.size()+vec.toString());
		    in.close();
		    out.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}	
}
