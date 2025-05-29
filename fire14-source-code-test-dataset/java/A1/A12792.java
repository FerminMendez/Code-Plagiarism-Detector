import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> nonsurprising=new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> surprising=new HashMap<Integer, Integer>();

		for(int i=0;i<=10;i++)
			for(int j=0;j<=10;j++)
				for(int k=0;k<=10;k++)
				{
					if(Math.abs(i-j)>2||(Math.abs(i-k)>2)||(Math.abs(k-j)>2))
					{
						continue;
					}
					else if(Math.abs(i-j)<=2||(Math.abs(i-k)<=2)||(Math.abs(k-j)<=2))
					{
						//suprising
						Integer sum=i+j+k;
						Integer local_Max=Math.max(i, Math.max(j, k));
						if(surprising.containsKey(sum))
						{
							Integer Global_max=surprising.get(sum);
							if(local_Max>Global_max)
							{
								surprising.remove(sum);
								surprising.put(sum, local_Max);
							}
						}
						else
						{
							surprising.put(sum, local_Max);
						}
						if(Math.abs(i-j)<=1&&(Math.abs(i-k)<=1)&&(Math.abs(k-j)<=1))
						{
							//nonsurprising
						
							if(nonsurprising.containsKey(sum))
							{
								Integer Global_max=nonsurprising.get(sum);
								if(local_Max>Global_max)
								{
									nonsurprising.remove(sum);
									nonsurprising.put(sum, local_Max);
								}
							}
							else
							{
								nonsurprising.put(sum, local_Max);
							}
						}
					}
					else
					{
						
					}
				}

		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		for(int l=1;l<=t;l++)
		{
			int n=input.nextInt();
			int s=input.nextInt();
			int p=input.nextInt();
			
			int[] totalsum=new int[n+1];
			for(int j=1;j<=n;j++)
			{
				totalsum[j]=input.nextInt();
			}
			
			int [][] M=new int [n+1][s+1];
			for(int j=0;j<=s;j++)
				M[0][j]=0;
			for(int i=1;i<=n;i++)
			{
				if(nonsurprising.get(totalsum[i])>=p)
					M[i][0]=M[i-1][0]+1;
				else
					M[i][0]=M[i-1][0];
			}
			for(int i=1;i<=n;i++)
				for(int j=1;j<=s;j++)
				{
					
					int vertical=M[i-1][j]+(nonsurprising.get(totalsum[i])>=p?1:0);
					int diag=M[i-1][j-1]+(surprising.get(totalsum[i])>=p?1:0);
					if(vertical>diag)
						M[i][j]=vertical;
					else
						M[i][j]=diag;
				}
			System.out.println("Case #"+l+": "+M[n][s]);
		}
	}

}
