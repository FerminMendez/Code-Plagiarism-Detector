
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class gjam {
	
	public static void main(String[] args)
	{
	
		int TestCases = 0;
		int currentCase = 0;
		
		try
		{
			
		
			FileInputStream fstream = new FileInputStream("B-small-attempt2.in");
			DataInputStream dstream = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dstream));
			
			String inputStr = br.readLine();
			
			TestCases = Integer.parseInt(inputStr);
			
			while(currentCase != TestCases)
			{
				int N = 0;
				int S = 0;
				int p = 0;
				int[] scores;
				int result = 0;
				
				inputStr = br.readLine();
				
				String[] variableStr = inputStr.split(" ");
				
				N = Integer.parseInt(variableStr[0]);
				
				S = Integer.parseInt(variableStr[1]);
				
				p = Integer.parseInt(variableStr[2]);
				
				String[] scoreStr = new String[N];
				
				for(int i = 3; i < variableStr.length;i++)
				{
					scoreStr[i - 3] = variableStr[i];
				}
				
				scores = new int[N];
				
				for(int i = 0; i < scores.length; i++)
				{
					scores[i] = Integer.parseInt(scoreStr[i]);
				}
				for(int i = 0; i< scores.length; i++)
				{
					int tmp = scores[i];
					
					float d = tmp/3.0f;
					
					if(d == p)
					{
						result++;
					}
					else
					{
						if(d > p)
						{
							int r = 0;
							r += d;
							
							if((r + r + r) == tmp)
							{
								result++;
							}
							else
							if((r + r + (r-1)) == tmp)
							{
								result++;
							}
							else
							if((r + (r-1) + (r-1)) == tmp)
							{
								result++;
							}
							else
							if((r + (r+1)+r)==tmp)
							{
								result++;
							}
							else
							if((r +(r+1) + (r+1))==tmp)
							{
								result++;
							}
							else
							{
								if(S > 0)
								{
									if((r + r + (r-2))==tmp)
									{
										result++;
										S--;
									}
									else
									if((r+(r-2)+(r-2)) == tmp)
									{
										result++;
										S--;
									}
									else
									if((r + (r-1) + (r-2)) == tmp)
									{
										result++;
										S--;
									}
									if((r + (r+2)+r)==tmp)
									{
										result++;
										S--;
									}
									else
									if((r +(r+2) + (r+2))==tmp)
									{
										result++;
										S--;
									}
									else
									if((r + (r+1)+(r+2))==tmp)
									{
										result++;
										S--;
									}
											
								}
							}

						}
						else
						if((p + p + (p-1)) == tmp)
						{
							result++;
						}
						else
						if((p + (p-1) + (p-1)) == tmp)
						{
							result++;
						}
						else
						{
							if((S > 0) && (tmp != 0))
							{
								if((p + p + (p-2))==tmp)
								{
									result++;
									S--;
								}
								else
								if((p+(p-2)+(p-2)) == tmp)
								{
									result++;
									S--;
								}
								else
								if((p + (p-1) + (p-2)) == tmp)
								{
									result++;
									S--;
								}
										
							}
								
						}
								
					}
					
					
				}
				
			
				
				
				System.out.println("Case #" + (currentCase +1) + ": " + result);
				currentCase++;
			}
			
			
		}
		catch(Exception e)
		{
			System.err.println("Err: " + e.getMessage());
		}
		
	}
	
}
