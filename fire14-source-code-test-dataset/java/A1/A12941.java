import java.io.*;
import java.util.*;
public class dance
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("dance.in"))));
		PrintStream out = new PrintStream(new File("dance.out"));
		int cases = Integer.parseInt(in.readLine());
		StringTokenizer s1;
		int quant, surp, score, specnum1, specnum2, total, surpcount, with, without;
		int[] scores;
		for(int x = 0; x < cases; x++){
			s1 = new StringTokenizer(in.readLine(), " ");
			quant = Integer.parseInt(s1.nextToken());
			surp = Integer.parseInt(s1.nextToken());
			score = Integer.parseInt(s1.nextToken());
			scores = new int[quant];
			total = 0;
			surpcount = 0;
			for(int y = 0; y < quant; y++){
				scores[y] = Integer.parseInt(s1.nextToken());
				with = maxWith(scores[y]);
				without = maxWithout(scores[y]);
				if(without >= score)
					total++;
				else if(surpcount < surp){
					if(with >= score){
						total++;
						surpcount++;
					}
				}
			}
			out.println("Case #" + (x+1) + ": " + total);
		}
	}
	public static int maxWith(int num)
	{
		int base = num/3;
		int rem = num%3;
		if(num == 0)
			return 0;
		else if(rem == 0)
			return (base+1);
		else if(rem == 1)
			return (base+1);
		else
			return (base+2);
	}
	public static int maxWithout(int num)
	{
		int base = num/3;
		int rem = num%3;
		if(rem == 0)
			return base;
		else
			return (base+1);	
	}
}