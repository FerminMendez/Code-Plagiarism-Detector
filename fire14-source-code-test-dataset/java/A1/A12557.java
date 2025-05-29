import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.Charset;


public class Main {
	public static void main(String arg[])
	{
		try {
			FileInputStream fIn = new FileInputStream("input.txt");
			Charset cs = Charset.forName("UTF-8");
			InputStreamReader iRd = new InputStreamReader(fIn,cs);
			BufferedReader bRd = new BufferedReader(iRd);
			
			
			String str = bRd.readLine();
			
			Integer line = Integer.parseInt(str);
						
			Writer output = null;
			File file = new File("output.txt");
			output = new BufferedWriter(new FileWriter(file));
			
			
			for(int i = 0 ; i < line; ++i)
			{
				String inLine = bRd.readLine();
				
			//	System.out.println(inLine);
				
				String[] nums = inLine.split(" ");
				
				int n = Integer.parseInt(nums[0]);
				int surprise = Integer.parseInt(nums[1]);
				int point = Integer.parseInt(nums[2]);
				int goal = point*3;
				
				int pass = 0;
				int sPass = 0;
				
				for(int j = 0 ; j < n; ++j)
				{
					int num = Integer.parseInt(nums[j+3]);
					int dif = goal - num;
					
					if(dif <=2 ) ++pass;
					else if( (dif ==3 || dif == 4) && goal > 3) ++sPass;
					
				}
				
				if( surprise >= sPass) pass += sPass;
				else pass += surprise;
				output.write("Case #" + (i+1) + ": " + pass + "\n");
				
			}
			
			
			
			output.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
