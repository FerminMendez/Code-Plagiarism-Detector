import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ProblemC {
	public static void main(String argv[])
	{
//		IOSystem ioSystem = new IOSystem("problem/A-small-attempt2");
		IOSystem ioSystem = new IOSystem("problem/C-small-attempt0");
//		IOSystem ioSystem = new IOSystem("problem/test");

		ioSystem.nextLong();
		while(ioSystem.hasNext())
		{
			int A = ioSystem.nextInt();
			int B = ioSystem.nextInt();

			int ret = 0;
			Set<String> set = new HashSet<String>();

			//smallだけでもとくか
			for(int i = A;i<B;i++)
			{
				if(i<10)continue;

				String s = ""+i;
				StringBuffer sb  = new StringBuffer(s);

				for(int j=0;j<sb.length()-1;j++)
				{
					char c = sb.charAt(0);
					sb.deleteCharAt(0);
					sb.append(c);

					if(sb.charAt(0)=='0')continue;

					int pair = Integer.parseInt(sb.toString());
					if(pair <= B && i < pair)
					{
//						System.out.println(s+":"+sb.toString());
						if(set.contains(i+sb.toString()))
						{
//							System.out.println("!!!"+i+":"+sb.toString());
						}
						else
						{
							ret++;
							set.add(i+sb.toString());
						}
					}

				}

			}


			ioSystem.appendAnswer(ret);
		}

		ioSystem.output();
	}
}


