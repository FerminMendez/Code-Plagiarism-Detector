import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class B_Small {
	
	static int[] resu;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File input=new File("D:\\Users\\xiaoguo\\Downloads\\B-small-attempt0.in");
		File output=new File("D:\\Users\\xiaoguo\\Desktop\\output.txt");
		readCaseFromInput(input);
		writeToOutput(output);
		System.out.println("Programe exist!");
	}

	static void readCaseFromInput(File input )
	{
		try {
				FileReader reader=new FileReader(input);
				BufferedReader buf=new BufferedReader(reader);
				int numberCase=Integer.parseInt(buf.readLine());
				resu=new int[numberCase];
				String contentLine=null;
				int numerLine=0;
				while((contentLine=buf.readLine())!=null)
				{
					String[] tab=contentLine.split("\\s");					
					int s=Integer.parseInt(tab[1]);
					int p=Integer.parseInt(tab[2]);
					int n=0;
					int needS=0;
					for(int i=3;i<tab.length;i++)
					{
						int totalP=Integer.parseInt(tab[i]);
						if(totalP>=Math.max((3*p-4),p))
						{
							
							if(totalP>=(3*p-2))
							{
								n++;
							}
							else
							{
								needS++;
							}
						}
					}
					n+=Math.min(needS, s);
					resu[numerLine]=n;
					numerLine++;									
				}
				
			buf.close();
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void writeToOutput(File output)
	{
		try {
			FileWriter out=new FileWriter(output);
			BufferedWriter buf=new BufferedWriter(out);
			String headLine="Case #";
			for(int i=0;i<resu.length;i++)
			{
				int number=i+1;
				String line=headLine+number+": ";
				line+=resu[i];
				buf.write(line);				
				buf.newLine();
			}
			buf.close();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
