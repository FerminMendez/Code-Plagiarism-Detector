package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Googler3 {

	
	public static void main(String[] args) {
		try
		{
			//BufferedReader br = new BufferedReader(new FileReader("/Users/Sush/Documents/workspace1/CJ/src/files/Input.txt"));
			BufferedReader br = new BufferedReader(new FileReader("/Users/Sush/Downloads/B-small-attempt0.in.txt"));
			String line;
			StringBuffer sb = new StringBuffer();
			while((line= br.readLine())!= null)
			{
				sb = sb.append(line + "\n");
			}
			String[] cases = sb.toString().split("\n");
			String data = "";
			for(int i= 1;i<cases.length;i++)
			{
				
				int count = 0;
				String[] num = cases[i].split(" ");
				int surp = Integer.parseInt(num[1]);
				int p = Integer.parseInt(num[2]);
				int track = surp;
				for (int j = 3; j< num.length; j++)
				{
					int n = Integer.parseInt(num[j]);
					
					if (surp == 0)
					{
						int min = p + (p-1) + (p-1);
						if (n>=min)
						{
							count = count +1;
						}
						
					}
					else
					{
						int upper = p + (p-1) + (p-1);
						int lower = p + (p-2) + (p-2);
						if (p==1)
						{
							lower = 1;
						}
						if (n >= upper)
						{
							count = count +1;
						}
						else if(n>=lower && n < upper && track >0)
						{
							count = count + 1;
							track = track - 1;
						}
								
					}
					
					
				}
				
				data = data + "Case #"+i+": "+count+"\n";
				System.out.print("Case #"+i+": "+count+"\n");
				
			}
			File ff = new File("Output3.txt");
			if (ff.exists())
			{
				ff.delete();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(ff, true));
			bw.write(data);
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
