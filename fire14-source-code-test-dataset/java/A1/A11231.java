import java.io.*;
public class Q2 {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new FileReader("a-small.in"));
		PrintWriter pr = new PrintWriter(new FileWriter("output.txt"));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int cas = 1; cas<=T; cas++)
		{
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int S = Integer.parseInt(input[1]);
			int p = Integer.parseInt(input[2]);
			int score = 0;
			
			int normalMin = p + 2*(p-1);
			int sMin = p + 2*(p-2);
			
			if(p == 0)
			{
				normalMin = 0;
				sMin = 0;
			}
			else if(p == 1)
			{
				normalMin = 1;
				sMin = 1;
			}
			
			for(int person = 0; person<N;person++)
			{
				int total = Integer.parseInt(input[person+3]);
 				
				if(total >= normalMin)
				{
					score++;
				}
				else if(total >= sMin && S > 0)
				{
					score++;
					S--;
				}
			}
			
			pr.println("Case #" + cas + ": " + score);
		}
		
		pr.close();
	}

}
