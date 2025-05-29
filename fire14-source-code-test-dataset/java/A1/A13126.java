import java.util.HashMap;
import java.util.Map;

public class ProblemB {
	public static void main(String argv[])
	{
		IOSystem ioSystem = new IOSystem("problem/B-small-attempt0");
////		IOSystem ioSystem = new IOSystem("problem/A-small-attempt2");
//		IOSystem ioSystem = new IOSystem("problem/test");

		ioSystem.nextLong();
		while(ioSystem.hasNext())
		{
			int N = ioSystem.nextInt();
			int S = ioSystem.nextInt();
			int P = ioSystem.nextInt();

			int koeru = 0;
			int supKoeru = 0;

			for(int i=0;i<N;i++)
			{
				int t = ioSystem.nextInt();
				if(t==0)
				{
					if(P == 0)koeru++;
					continue;
				}
				if(t==1)
				{
					if(P <= 1)koeru++;
					continue;
				}



				//3つに分ける
				if(t%3==0)
				{
					if(t/3>= P)
					{
						koeru++;
					}
					else if(t/3 + 1>= P)
					{
						supKoeru++;
					}
				}
				else if(t%3 == 2)
				{
					if(t/3 + 1>= P)
					{
						koeru++;
					}
					else if(t/3 + 2>= P)
					{
						supKoeru++;
					}
				}
				else
				{
					if(t/3 + 1 >= P)
					{
						koeru++;
					}
				}
			}

			System.out.println(N+","+S+","+P+","+koeru+","+supKoeru);

			if(supKoeru > S)
			{
				koeru += S;
			}
			else
			{
				koeru += supKoeru;
			}


			ioSystem.appendAnswer(koeru);
		}

		ioSystem.output();
	}
}


