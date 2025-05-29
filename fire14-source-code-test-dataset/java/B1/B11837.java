import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



public class Numbers {
	
	public static FileReader fr;
	public static BufferedReader br;
	public static FileWriter fw;
	public static BufferedWriter bw;
	
	
	public void read(String path) throws Exception
	{
		 fr = new FileReader(path);
		
		 br=new BufferedReader(fr);
	
	}
	
	
	public void write(String path) throws Exception
	{
		
	}
	
	public void execute(BufferedReader br,String path)throws Exception
	{
		
		String s;
		
		fw =new FileWriter(path,false);
		bw=new BufferedWriter(fw);
		s=br.readLine();	
		int i1=1;
		
		while((s=br.readLine())!=null)
		{
			int count =0;
			String st[]=s.split("\\s");
			int a=Integer.parseInt(st[0]);
			int b=Integer.parseInt(st[1]);
			
			
			
			for(int i=a;i<=b;i++)
			{
				int temp=i;
				String abc=Integer.toString(temp);
				int length=abc.length();
				int index=length-1;
				String tempString=abc;
				while(index>0)
				{
				
					String first=tempString.substring(0, index);
					String second=tempString.substring(index,length);
					abc=second+first;
					int newnumber=Integer.parseInt(abc);
					if((newnumber<=b && newnumber>temp )&& !abc.startsWith("0") && (Integer.toString(temp).length())==abc.length())
						count++;
					
					index--;
						
				}
			}
			
			bw.write("Case #"+ i1++ +": " +count +"\n");
			
			
			
			
		
		}
		bw.close();
		fr.close();
		
		
	}
	public static void main(String[] args) throws Exception
	
	{
		Numbers t=new Numbers();
		t.read("E:\\codejam\\Files\\A.in");
		t.execute(br,"E:\\codejam\\Files\\A.out");
	
		
	}

}
