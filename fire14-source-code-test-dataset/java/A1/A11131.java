import java.util.*;
import java.io.*;
class dance
{
	public static void main(String[] args) 
	{
		String fileName="../Problem/B-small-attempt0.in";
		String outputFile="output-small.in";
		List data=dance.readFile(fileName);
		String ans="";
		int testCase=Integer.parseInt(data.get(0).toString());
		int indexTC=1;
		for(int tc=0;tc<testCase;tc++)
		{
			String[] initData=cutString(data.get(indexTC).toString());
			int N=Integer.parseInt(initData[0]);
			int S=Integer.parseInt(initData[1]);
			int p=Integer.parseInt(initData[2]);
			int[][] num=new int[N][3];
			for(int x=3;x<initData.length;x++)
			{
				num[x-3]=dance.divideThree(Integer.parseInt(initData[x]));
			}
			dance.surNumber(num,S,N,p);
			//show number
			//dance.showList(N,num);
			ans+="Case #"+indexTC+": "+dance.countNum(N,num,p)+"\n";
			indexTC++;
		}
		System.out.println(ans);
		dance.writeFile(ans,outputFile);
	}
	public static int[] divideThree(int sum)
	{
		int newsum=sum/3;
		int frag=sum%3;
		//System.out.println("SUM="+newsum+" frag="+frag);
		return dance.setNumber(newsum,frag);
	}
	public static int countNum(int N,int[][] num,int most)
	{
		int count=0;
		for(int i=0;i<N;i++)
		{
			//System.out.println(dance.mostNumber(num[i]));
			if(dance.mostNumber(num[i])>=most) count++;
		}
		return count;
	}
	public static int[] setNumber(int n,int frag)
	{
		int[] num=new int[3];
		//System.out.print("num = ");
		for(int x=0;x<3;x++)
		{
			num[x]=n;
			if(frag>0) { num[x]++; frag--; } 
			//System.out.print(num[x]+",");
		}
		//System.out.println("");
		return num;
	}
	public static void surNumber(int[][] num,int surprise,int googler,int mostNumber)
	{
		//System.out.println("================surNumber================");
		for(int y=0;y<googler;y++)
		{
			int same=dance.sameNumber(num[y]);
			boolean first=true;
			int most=dance.mostNumber(num[y]);
			//System.out.println("most="+most+" mostNumber="+mostNumber);
			if(most<mostNumber && most!=0)
			{
				if((most+1)>=mostNumber)
				{
					if(surprise>0)
					{
						//System.out.println("surprise="+surprise+" fixnumber");
						if(same!=0)
						{
							if(num[y][0]==num[y][1] && num[y][1]==num[y][2])
							{
								num[y][0]++;
								num[y][1]--;
							}
							else if(num[y][0]==num[y][1]) { if(num[y][2]>num[y][0]) num[y][0]--; else  num[y][0]++; }
							else if(num[y][0]==num[y][2]) { if(num[y][1]>num[y][0]) num[y][0]--; else  num[y][0]++; }
							else if(num[y][1]==num[y][2]) { if(num[y][0]>num[y][1]) num[y][2]--; else  num[y][2]++; }
						}
						surprise--;
					}
				}
			}
			//System.out.println("");
		}
	}
	public static void showList(int N,int[][] num)
	{
		System.out.println("===========Show Number=====");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<num[i].length;j++)
			{
				System.out.print(num[i][j]+",");
			}
			System.out.println("");
		}
	}
	public static int sameNumber(int[] number)
	{
		int same=0;
		if(number[0]==number[1]) same=number[0];
		else if(number[0]==number[2]) same=number[0];
		else if(number[1]==number[2]) same=number[1];
		return same;
	}
	public static int diffNumber(int[] number)
	{
		int diff=0;
		if(number[0]==number[1]) diff=number[2];
		else if(number[0]==number[2]) diff=number[1];
		else if(number[1]==number[2]) diff=number[0];
		return diff;
	}
	public static int mostNumber(int[] number)
	{
		int most=0;
		if(number[0]>=number[1]) most=number[0];
		else if(number[0]>=number[2]) most=number[0];
		else if(number[1]>=number[2]) most=number[1];
		return most;
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
