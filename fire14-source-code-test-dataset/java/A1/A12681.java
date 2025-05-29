import java.util.Scanner;


public class Dancing 
{
	public static void main(String[] inteettskit)
	{
	    int line = 0;
	    int T = 0;
	    int N = 0; // Number of googlers
		int S = 0; // Surprises
		int p = 0; // p
		
	    Scanner line_scanner = new Scanner(System.in);
	    	
    	
	    while(line_scanner.hasNextLine())
    	{
	    	String apa = line_scanner.nextLine();
	    	Scanner int_scanner = new Scanner(apa);
	    	
//	    	System.out.println("line: " + line);
	    	
	    	if(line == 0)
	    	{
    			T = int_scanner.nextInt();
//    			System.out.println("T: " + T);
	    	}
	    	
	    	else
		    {
		    	
		    	int[] input = null;
		    	int counter = 0;
		    	
		    	while (int_scanner.hasNextInt())
		    	{
		    		if(counter == 0)
		    		{
		    			N = int_scanner.nextInt();
		    			input = new int[N+3];
		    			input[0] = N;
		    		}
		    		
		    		else
		    		{
		    			int number = int_scanner.nextInt();
		    			input[counter] = number;
//		    			System.out.println("Scanner: " + number + " counter: " + counter);
		    		}
	    			
		    		counter++;
		    	}
		    	
		    		N = input[0]; // Number of googlers
					S = input[1]; // Surprises
					p = input[2]; // p
					int t[] = new int[N]; // total scores of the googlers
					
					int possible = 0;
					
					for( int i = 0; i < N; i++)
					{
//						System.out.println(input[i+3]);
						t[i] = input[i+3];
					}
					
					
//					System.out.println("Googlers: " + N);
//					System.out.println("Surprises: " + S);
//					System.out.println("p: " + p);
//					System.out.print("Scores:");
					
					for(int score: t)
					{
//						System.out.print(" " + score); 
					}
					
//					System.out.println();
					
					for(int i = 0; i < N ; i++)
					{
						
						int retur = pp(p, t[i]);
						if(retur >= 1)
						{
							if(retur >=2)
							{
								if(S > 0)
								{
									possible++;
									S--;
								}
							}
							else
							{
								possible ++;
							}
						
						}
							
					}
					System.out.println("Case #" + (line) +": " + possible);
	    	}
	    	line++;
	    	
	    }
	}
	
	public static int pp(int p, int totalscore)
	{
		int min_normal_score = 0;
		int min_surprise_score = 0;
		
		if(p-1 >= 0)
		{
			min_normal_score = (p + (p-1) + (p-1));
		}
		
		else
		{
			min_normal_score = p;
		}
		
		if(p-2 >= 0)
		{
			min_surprise_score = (p + (p-2) + (p-2));
		}
		
		else
		{
			min_surprise_score = p;
		}
		
//		System.out.println("Minimum surprise score for p = " + p + " is " + min_surprise_score);
//		System.out.println("Minimum normal score for p = " + p + " is " + min_normal_score);
		
		if(totalscore >= min_normal_score)
		{
//			System.out.println("Always!");
			return 1;
		}
		
		else if(totalscore >= min_surprise_score)
		{
//			System.out.println("Requires surprise");
			return 2;
		}
		
		else
		{
//			System.out.println("Never!");
			return 0;
		}
	}
	
}
