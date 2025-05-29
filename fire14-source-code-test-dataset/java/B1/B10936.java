import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class qc {

	public static void main(String [] args)
	{
		String fileName = "C-small-attempt0.in";
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String line="";
			int count = 0;
			int solution = 0;
			while((line=br.readLine())!=null)
			{					
				if(count == 0)
				{
					count++;
					continue;
				}
				
				String [] sp = line.split(" ");
				int [] range = new int[sp.length];
				for(int i =0; i<range.length; i++)
				{
					range[i] = Integer.parseInt(sp[i]);
				}
								
				for(int i =range[0]; i<=range[1]; i++)
				{
					String temp="" + i;
					int [] numArr = makeDigit(temp);
					for(int j =0; j<numArr.length; j++)
					{						
						if((range[0]<=i) && (i < numArr[j]) && (numArr[j] <= range[1]))
							solution++;
					}
				}
				
				bw.write("Case #"+count+": "+solution+"\n");
				
				solution = 0;
				count++;
			}
			bw.close();
			fw.close();
			br.close();
			fr.close();
			
		}catch(Exception EE){
			EE.printStackTrace();
		}
	}
	
	public static int [] makeDigit(String str)
	{		
		int [] returnArr = new int[str.length()];
		for(int i=0; i<str.length()-1; i++)
		{
			char temp = str.charAt(str.length()-1);
			str = str.substring(0, str.length()-1);
			
			String tempS = "" + temp+str;
			str = tempS;
			returnArr[i] = Integer.parseInt(str);
		}
		
		return returnArr;
	}
}
