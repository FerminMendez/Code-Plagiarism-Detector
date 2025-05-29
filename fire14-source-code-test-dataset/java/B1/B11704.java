/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jam_c;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkozyrev
 */
public class Jam_C {

	/**
	 * @param args the command line arguments
	 */
	
	public static void main(String[] args) {

			List<Map> cases = readFile("C:\\tmp\\testA.txt");

			int counter = 1;
			String delimiter = " ";
			
			for (Map<String, String> caseItem : cases)
			{
				List<String> lines = Arrays.asList(caseItem.get("str").split(delimiter));
				int res = findMax(lines);
				System.out.println("Case #"+counter+": " + res);

				counter++;
			}
	}

	public static int findMax(List<String> lines)
	{
		int max = 0;
		
		//10
		//40
		//10 ? n < m ? 40
		// A ? n < m ? B
		int A = Integer.parseInt(lines.get(0));
		int B = Integer.parseInt(lines.get(1));
		
		//System.out.println(isRecycled(123405, 340512)); if (true) return 1;
		
//		ArrayList <String> distinct = new ArrayList<String>();
		
		for(int m=A+1 ; m <= B ; m++)
		{
			//A ? n < m ? B
			for(int n=A ; n < m ; n++)
			{
//				if(n >=m)
//				{
//					continue;
//				}
//				if(distinct.contains(m+""+n))
//				{
//					continue;
//				}				
				if (isRecycled(n,m) )
				{
					//System.out.println("compare n and m: " + n + " " + m);	
					max++;
//					distinct.add(m+""+n);
				}
			}
		}
				
		return max;
	}
	
	public static boolean isRecycled(int n, int m)
	{
		//120345
		String compareStr = "";
		String replaceStr = "";
		String nInput = n+"";
		
		String mInput = m+"";
		
		boolean isRecycled = false;
		
		int counter = nInput.length()-1;
		while (n > 0) {
			
			replaceStr = (n % 10) + replaceStr;
			n = n / 10;
						
			//System.out.println(replaceStr);
			if(counter == 0)
			{
				break;
			}
			compareStr = replaceStr + nInput.substring(0, counter);
			//System.out.println(compareStr);
			counter--;
			
			if(compareStr.equals(mInput))
			{
				//System.out.println(mInput);
				return true;
			}
		}

		return isRecycled;
	}
	
	public static List<Map> readFile(String fname)  {
			List<Map> casesList = new ArrayList<Map>();
		{
			FileReader input = null;
			try {
				input = new FileReader(fname);
				BufferedReader bufRead = new BufferedReader(input);
				String line;
				int count = 0;
				line = bufRead.readLine();
				Integer cases = Integer.parseInt(line);
				count++;
				while (line != null)
				{
					if  (count == 1)
					{
						line = bufRead.readLine();
						count++;
						continue;
					}
					
					Map<String, String> params = new HashMap<String, String>();
					params.put("str", line);
					line = bufRead.readLine();
					
					casesList.add(params);
					count++;
				}
				bufRead.close();
			} catch (FileNotFoundException ex) {
				Logger.getLogger(Jam_C.class.getName()).log(Level.SEVERE, null, ex);
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Usage: java ReadFile filename\n");			
			}catch (IOException e){
				System.out.println(e.getMessage());
			} finally {
				try {
					input.close();
				} catch (IOException ex) {
					Logger.getLogger(Jam_C.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return casesList;
	}
}