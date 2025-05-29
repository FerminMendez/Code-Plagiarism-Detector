import java.util.*;
import java.io.*;

public class DancingWithGooglers
{
	public static void main(String args[]) throws IOException
	{
		int case_no;
		String result = "";
		File inputFile = new File(".in");
		FileInputStream fin = new FileInputStream(inputFile);
		Scanner in = new Scanner(fin);

		PrintWriter out = new PrintWriter(new FileWriter(".out", true));

		case_no = in.nextInt();

		for( int i = 0; i < case_no; i++ )
		{
			int num_googlers, t_surprise, point, max_number_overp = 0, number_overp_temp = 0;
			PriorityQueue<Integer> _pq = new PriorityQueue<Integer>();
			result += "Case #"+ (i+1) + ": ";
			num_googlers = in.nextInt();
			t_surprise = in.nextInt();
			point = in.nextInt();

			for( int j = 0; j < num_googlers; j++ )
			{
				_pq.add(new Integer(in.nextInt()));
			}



			while( _pq.size()!= 0 )
			{
				int temp = _pq.poll().intValue();

				if( (temp <= 3*(point-1))&&(temp>=(3*(point-1)-1)))
				{
					if( (number_overp_temp < t_surprise)&&(temp > 0) )
					{
						number_overp_temp++;
						max_number_overp++;
					}
				}
				else if (temp > 3*(point-1))
				{
					max_number_overp++;

				}
			}

			result += "" + max_number_overp;
			out.println(result);
			result = "";
		}
		in.close();
		out.close();

	}
}
