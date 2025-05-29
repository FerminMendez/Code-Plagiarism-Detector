import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	public Case[] read() {
		
		BufferedReader bf;
		Case[] cases = null;
		
		try {
			bf = new BufferedReader(new FileReader("in"));
			
			int numTestCase = Integer.parseInt(bf.readLine());
			cases = new Case[numTestCase];
			
			for(int case_index = 0;case_index < numTestCase;case_index++){
				cases[case_index] = new Case();
				cases[case_index].ind = case_index + 1;
				
				/////////
				String linea = bf.readLine();
				String[] nums = linea.split(" ");
				cases[case_index].a = Double.parseDouble(nums[0]);
				cases[case_index].b = Double.parseDouble(nums[1]);
				////////
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cases;
	}

}
