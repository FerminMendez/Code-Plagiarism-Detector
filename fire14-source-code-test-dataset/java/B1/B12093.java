import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class CodeJam
{
	public static void main(String[] args) throws Exception
	{
		File input=new File("input.txt");
		BufferedReader bufferedReader=new BufferedReader(new FileReader(input));
		String output="";
		String line=null;
		int lineCount=0;
		
		int caseNumbers=0;
		String solutionString="";
		while((line=bufferedReader.readLine())!=null)
		{
			if(lineCount==0)
			{
				caseNumbers=Integer.parseInt(line);
			}
			else
			{
				int solution=0;
				String[] split=line.split(" ");
				int a=Integer.parseInt(split[0]);
				int b=Integer.parseInt(split[1]);
				int n=a;
				int m=b;
				while(n<m)
				{
					while(n<m)
					{
						if(workout(n, m))
						{
							solution++;
						}
						n++;
					}
					n=a;
					m--;
				}
				solutionString=solutionString+"Case #"+Integer.toString(lineCount)+": "+Integer.toString(solution)+"\n";
			}
			lineCount++;
		}
		System.out.print(solutionString);
	}
	
	public static boolean workout(int n,int m)
	{
		boolean solution=false;
		String t=Integer.toString(n);
		char[] test=t.toCharArray();
		int count=1;
		while(count<=test.length)
		{
			String testString=new String(test);
			
			if(testString.equals(Integer.toString(m)))
			{
				solution=true;
			}
			char x=test[test.length-1];
			int count2=test.length-2;
			while(count2>=0)
			{
				test[count2+1]=test[count2];
				count2--;
			}
			test[0]=x;
			count++;
		}
		return solution;
	}

}
