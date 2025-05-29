import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class C {
	
	static int[] resu;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File input=new File("D:\\Users\\xiaoguo\\Downloads\\C-small.in");
		File output=new File("D:\\Users\\xiaoguo\\Desktop\\output.txt");
		readCaseFromInput(input);
		writeToOutput(output);
		System.out.println("Programe exist!");
	}
	
	static class Couple{
		
		private int a;
		private int b;
		
		public Couple(int a, int b)
		{
			this.a=a;
			this.b=b;
		}
		public boolean equals(Object o){
			   return (this.a==((Couple)o).a && this.b==((Couple)o).b);
			}
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
					String[] line=contentLine.split("\\s");
					int a=Integer.parseInt(line[0]);
					int b=Integer.parseInt(line[1]);
					int n=0;
					ArrayList<Couple> liste=new ArrayList<Couple>();
					if(a>=10 && b>=10)
					{						
						for(int i=a;i<=b;i++)
						{
							String number=String.valueOf(i);
							for(int j=number.length()-1;j>=1;j--)
							{
								int x=Integer.parseInt(number.substring(j)+number.substring(0, j));
								C.Couple couple=new C.Couple(i, x);
								if(x<=b && x>i && !liste.contains(couple))
								{
									n++;									
									liste.add(couple);
								}
							}
						}
					}
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
