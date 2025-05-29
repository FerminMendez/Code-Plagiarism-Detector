package cl.rodrigo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.lang.StringBuffer;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream fstream;
		
		int count;
		try {
			fstream = new FileInputStream("/home/rodrigo/Descargas/C-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			count = Integer.parseInt(br.readLine());
			
			
			FileWriter outFile = new FileWriter("/home/rodrigo/GoogleCodeJam/C-small.out");
            PrintWriter out = new PrintWriter(outFile);
			
			for (int z=1;z<=count;z++) {
				HashMap hm = new HashMap();
				Integer contador = 0;
				String[] linea = br.readLine().split(" ");
				String lineakeypad = new String();
				
				Integer min = Integer.parseInt(linea[0]);
				Integer max = Integer.parseInt(linea[1]);
				
				System.out.println(min+"-"+max);
				
				for(int i=min;i<=max;i++) {
					
					for(int j=1;j<= String.valueOf(max).length()-1;j++) {
						
						String num = new String();
						String num_pre = new String();
						String num_post = new String();
				        String num_final = new String();
				        Integer num_int ;
						num = String.valueOf(i);
						
						num_pre = num.substring(j);
						num_post = num.substring(0, j);
						
						
						
						
						
						num_final = num_pre + num_post; 
						num_int = Integer.parseInt(num_final);
						
						
						
						
						if (min <= i && i < num_int && num_int <= max && min <= num_int && i <= max) {
							System.out.println(num+"-"+num_int);
						
							
							hm.put(num+"-"+num_int, 1);
							
							
						}
							
						
					}
				}
					
				Iterator<?> it = hm.entrySet().iterator();
				while (it.hasNext()) {
					contador++;
					it.next();
				}
				
				out.print("Case #"+z+": ");
				out.print(contador);
				out.println("");
				
			}
			
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
