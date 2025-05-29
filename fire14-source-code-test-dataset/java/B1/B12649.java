import java.util.*;
import java.io.*;
public class C
{
	List<String> arrList ;
	public void readFile(String srcFileName, String destFileName)
	{
		try
		{
			File srcFile = new File(srcFileName);
			File destFile = new File(destFileName);
			BufferedReader br = new BufferedReader(new FileReader(srcFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));
			int cases = Integer.parseInt(br.readLine());
			//cases =1;
			for(int i=0;i<cases;i++)
			{
				int counter =0;
				String lineInfo[] = br.readLine().split(" ");
				int firstNum = Integer.parseInt(lineInfo[0]);
				int secondNum = Integer.parseInt(lineInfo[1]);
				arrList= new ArrayList<String>();
				for(int k=firstNum;k<=secondNum;k++)
				{
					char[] ch = (k+"").toCharArray();
					for(int j =0; j<ch.length;j++)
					{
						ch = rotate(ch);
						int check = arrToString(ch);
					//	System.out.println(check);
						if(check != k && firstNum!=check && check!=secondNum)
						{
							if(firstNum<check && check<secondNum)
							{
								String sa = k+"-"+check;
								String sb = check+"-"+k;
								if(!arrList.contains(sa)&& !arrList.contains(sb))
								{
									arrList.add(sa);
									arrList.add(sb);
									counter++;
								}
							}
						}
					}
				}
				String str = "Case #"+(i+1)+": "+counter;
				bw.write(str);
				bw.newLine();
			}
			br.close();
			bw.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
	}
	
	public char[] rotate(char[] ch)
	{
		char temp = ch[0];
		for(int j=1;j<ch.length;j++)
		{
			ch[j-1]=ch[j];
		}
		ch[ch.length-1] = temp;
		return ch;
	}
	
	public int arrToString(char[] ch)
	{
		String str = "";
		for(int i=0;i<ch.length;i++)
		{
			str= str+ch[i];
		}
		return Integer.parseInt(str);
	}
	
	public static void main(String args[])
	{
		C c = new C();
		c.readFile(args[0],args[1]);
	}
}