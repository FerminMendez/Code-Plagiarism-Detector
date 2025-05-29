/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jam_b;

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
public class Jam_B {

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
				
				System.out.println("Case #"+counter+":" + res);

				counter++;
			}
	}

	public static int findMax(List<String> lines)
	{
		int max = 0;
		
		int peaopleNum = Integer.parseInt(lines.get(0));
		int surprising = Integer.parseInt(lines.get(1));
		int find = Integer.parseInt(lines.get(2));
		
		//System.out.println(find);

		int counter = 0;
		for(String score : lines)
		{
			if(counter > 2)
			{
				//find potential
				Double  scoreD = Double.parseDouble(score); 
				if(scoreD/3 >= (find-0.75))
				{
					max++;
					//System.out.println("1: " + scoreD/3);
				}
				else if (surprising>=1 && (scoreD/3 > (find-1.5)) && (find-1.5) > 0 )
				{
					max++;
					surprising--;
					//System.out.println("2: " + scoreD/3);
				}
			}
			counter++;
			//System.out.println(max);
		}
		return max;
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
				Logger.getLogger(Jam_B.class.getName()).log(Level.SEVERE, null, ex);
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Usage: java ReadFile filename\n");			
			}catch (IOException e){
				System.out.println(e.getMessage());
			} finally {
				try {
					input.close();
				} catch (IOException ex) {
					Logger.getLogger(Jam_B.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return casesList;
	}
}