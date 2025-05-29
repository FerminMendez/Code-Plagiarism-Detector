import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Triplets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<Integer> out=new ArrayList<Integer>();
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\partha\\Desktop\\test.txt"));
			int tests=Integer.parseInt(br.readLine());
			String line=null;
			while((line=br.readLine())!=null)
			{
				String[] tokens=line.split(" ");
				int n=Integer.parseInt(tokens[0]);
				int s=Integer.parseInt(tokens[1]);
				int min=Integer.parseInt(tokens[2]);
				int num[]=new int[n];
				for(int i=0;i<n;i++)
				{
					num[i]=Integer.parseInt(tokens[3+i]);
				}
				out.add(solve(num, min, s));
			}
			br.close();
			BufferedWriter bw=new BufferedWriter(new FileWriter("./out.txt"));
			for(int i=0;i<out.size();i++)
			{
				bw.write("Case #"+(i+1)+": "+out.get(i)+"\n");
				bw.flush();
			}
			bw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}


	public static int solve(int[] sc,int min,int sur)
	{
		int cnt=0;
		int surCnt=0;
		int posCnt=0;
		for(int i=0;i<sc.length;i++)
		{
			int num=sc[i]/3;
			if(num==0 )
			{
				if(min==0)
					cnt++;
				continue;
			}
			int p=num +1;
			//	System.out.println(p + " "+sc[i]);
			if(3*p-1== sc[i])
			{
				if(surCnt<sur)
				{
					if(min<=p-1 || min<=p+1)
					{
						cnt++;
						surCnt++;
					}
					if(min<=p-1 || min<=p)
						posCnt++;

				}
				else if(min<=p-1 || min<=p)
				{
					cnt++;
				}
				else if(posCnt>0)
				{
					if(min<=p-1 || min<=p+1)
					{
						cnt++;
						posCnt--;
					}
				}
			}
			else if(((3*p-2)== sc[i]))
			{

				if(surCnt<sur)
				{
					if(min<=p-2 ||  min<=p)
					{
						cnt++;
						surCnt++;
					}
					if(min<=p-1 || min<=p)
					{
						posCnt++;	
					}
				}
				else if(min<=p-1 || min<=p)
				{
					cnt++;
				}
				else if(posCnt>0)
				{
					if(min<=p-2 ||  min<=p)
					{
						cnt++;
						posCnt--;
					}

				}

			}
			else if((3*p-3)== sc[i])
			{

				if(surCnt<sur)
				{
					if(min<=p-2 || min<=p-1 || min<=p)
					{
						cnt++;
						surCnt++;
					}
					if(min<=p-1 )
					{
						posCnt++;
					}

				}
				else if(min<=p-1 )
				{
					cnt++;
				}
				else if(posCnt>0)
				{
					if(min<=p-2 || min<=p-1 || min<=p)
					{
						cnt++;
						posCnt--;
					}

				}

			}



		}




		return cnt;
	}


}
