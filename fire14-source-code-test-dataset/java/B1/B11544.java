import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Recycler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		BufferedReader br;
		try{
			br=new BufferedReader(new InputStreamReader(System.in));
			int T=Integer.parseInt(br.readLine());
			int A,B;
			String []inputs;
			for (int i=0;i<T;i++)
			{
				input=br.readLine();
				inputs=input.split(" ");
				A=Integer.parseInt(inputs[0]);
				B=Integer.parseInt(inputs[1]);
				
				int s=0;
				int m;
				for (int n=A;n<=B;n++)
				{
					int multiple=10;
					while (1.0*n/multiple > 0)
					{
						m=Integer.parseInt(n%multiple + "" + n/multiple);
						if (m<=B && n<m)
						{
							s++;
						}
						multiple*=10;
					}
					
				}
				System.out.println("Case #"+ (i+1) + ": " +s);
			}
		}catch(Exception e)
		{
			
		}
	}

}
