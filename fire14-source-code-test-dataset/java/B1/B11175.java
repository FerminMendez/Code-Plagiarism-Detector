import java.util.*;
import java.io.*;
class recycle
{
	static int tes=0;
	public static void main(String[] args) 
	{
		String fileName="../Problem/C-small-attempt0.in";
		String outputFile="output-small.in";
		String ans="";
		List data=recycle.readFile(fileName);
		int testCase=Integer.parseInt(data.get(0).toString());
		for(int tc=1;tc<=testCase;tc++)
		{
			String[] ab=cutString(data.get(tc).toString());
			int n=Integer.parseInt(ab[0]);
			int m=Integer.parseInt(ab[1]);
			ans+="Case #"+tc+": "+recycle.process(n,m)+"\n";
		}
		writeFile(ans,outputFile);
		//recycle.swap("12345",1);
	}
	public static int process(int n,int m)
	{
		int rec=0;
		for(n=n;n<m;n++)
		{
            String aa=String.valueOf(n);
			//String test=""+n;
			//System.out.println(test);
			
			rec+=recycle.swap(aa,m);
			//System.out.println("REC MAIN="+rec);
		}
		//System.out.println("rec = "+rec);
		return rec;
	}
	public static int swap(String n,int m)
	{
		int rec=0;
		//String old=n;
		int l=n.length()-1;
		for(int y=0;y<n.length();y++)
		{
			String ans=""; //swap number
			for(int x=0;x<n.length();x++)//swap
			{
				//System.out.print(""+l);
				if(l==n.length()) l=0;
				ans+=n.charAt(l);
				l++;
			}
			l--;
			 
			if(ans.charAt(0)!='0')
			{
				//System.out.println(ans);
				int k=Integer.parseInt(ans.toString()); //new swap to int
				int o=Integer.parseInt(n.toString()); 
				if(k>o && k<=m) 
				{
					rec++;
					recycle.tes++;
					//System.out.println("(K="+k+"> O="+o+" && K="+k+"<m="+m+")Recy #"+recycle.tes+": ("+o+","+k+")");
				}

			}
		}
		return rec;
	}
	public static String[] cutString(String st)
	{
		String s[]=st.split(" ");
		return s;
	}
	public static List readFile(String pathFile)
	{
		List data=new ArrayList();
		File file=new File(pathFile);
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(file));
			String text;
			while((text = br.readLine()) != null) data.add(text);
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void writeFile(String output,String fileName)
	{
		try	
		{
			FileWriter fw=new FileWriter(fileName);
			BufferedWriter bw=new BufferedWriter(fw);
			String new_output[]=output.split("\n");
			for(int i=0;i<new_output.length;i++)
			{
				bw.write(new_output[i]);
				bw.newLine();
			}
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
