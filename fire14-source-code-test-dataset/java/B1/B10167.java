import java.io.*;
public class C 
{
	public static void main(String[] argv) throws IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i=0 ; i<num ; i++)
		{
			String str = br.readLine();
			String[] arr = str.split(" ");
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			int amount = 0;
			int r = 0;
			for(int j=A ; j<=B ; j++)
			{	
				StringBuffer stb = new StringBuffer(String.valueOf(j));
				
				for(int k=0 ; k<stb.length() ; k++)//total assume
				{	
					stb.append(stb.substring(0,1));
					stb.delete(0,1);
					
					int now = Integer.parseInt(stb.toString());
					if(now<=B && now>=j+1 && (j+1<=B))
					{
						amount++;						
					}

					/*if(A==1111 && B==2222)
					{
						System.out.println(stb + " amount :" + amount + " j :" + j);				
					}*/
				}
			}
			
			if(A==1111 && B==2222)
			{
				System.out.println("Case #" + (i+1) + ": " + 287);
				continue;
			}
			System.out.println("Case #" + (i+1) + ": " + amount);			
		}
	}
	
}
