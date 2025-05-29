import java.util.*;


import java.util.*;
public class soalC{

	public static void main(String[] args){
			Scanner scan=new Scanner(System.in);



			int tc = scan.nextInt();

			for (int i = 0 ; i <  tc; i++)
			{
				int awal = scan.nextInt();
				int akhir = scan.nextInt();

				int index = awal;
				int count = 0;

				for (int j = awal; j <= akhir ; j++)
				{
					for (int k = j+1; k <= akhir ; k++)
					{
						if (checkRecycle(j,k))
						{
							count++;
						}

					}

				}

				System.out.println("Case #"+(i+1)+": "+count);


			}
	}

	public static boolean checkRecycle(int m, int n)
	{
		String x = n+"";
		for (int i = 0 ; i < x.length() ; i++)
		{
			if (Integer.parseInt(x.substring(i,x.length())+(x.substring(0,i)))==m)
			{
				return true;
			}
		}


		return false;
	}

}



