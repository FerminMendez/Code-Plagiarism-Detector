import java.util.Scanner;


public class dancingwiththegooglers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int numOfLines = Integer.parseInt(in.nextLine());
		for(int i = 0;i<numOfLines;i++)
		{
			String resultline = "Case #"+(i+1)+": "+readLine(in.nextLine());
			System.out.println(resultline);
		}
	}
	
	private static int getResult(int S, int p, int[]points)
	{
		int result = 0;
		for(int i = 0;i<points.length;i++)
		{
			if(points[i] >=(3*p-2))
				result++;
			else if(points[i] >= 3*p - 4 && S > 0)
			{
				if(points[i]>0)
				{
					result++;
					S--;
				}
			}
		}
		return result;
	}
	
	private static String readLine(String line)
	{
		String[] inputs = line.split(" ");
		int S = Integer.parseInt(inputs[1]);
		int p = Integer.parseInt(inputs[2]);
		int[] points = new int[inputs.length-3];
		for(int i = 0;i<points.length;i++)
			points[i] = Integer.parseInt(inputs[i+3]);
		return String.valueOf(getResult(S, p, points));
	}
}