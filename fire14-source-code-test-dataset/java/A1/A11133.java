import java.io.*;
import java.util.*;
class Source3
{
	public static void main(String[] args) throws IOException 
	{
		String s,word,buffer;
		 FileReader input = new FileReader("B-small.in");
		 BufferedReader in = new BufferedReader(input);
		File file = new File("B-small.out");
		BufferedWriter out = new BufferedWriter(new FileWriter(file));

			s = in.readLine();
		int count= Integer.parseInt(s);

		int i=1;
		 while ((s = in.readLine()) != null && s.length() != 0)
		{
			 out.write("Case #"+(i++)+": ");
				Scanner scan =new Scanner(s);
				
			
				int N =Integer.parseInt(scan.next());
				int S=Integer.parseInt(scan.next());
				int p=Integer.parseInt(scan.next());
				int[] t =new int[200];
				
				for(int x=0;x<N;x++)
				{
					t[x]= Integer.parseInt(scan.next());
					
				}

			int ans = perform(N,S,p,t);
			out.write(ans+"\n");
		}
				
				

				

		 out.close();
	}


	public static int perform(int N,int S ,int p ,int[] t)
	{
		int count=0;
		int surprise=0;
		boolean pass=false;
		int staticP=p;
				for(int x=0;x<N;x++)
				{
					pass=false; 
					p=staticP;
					while(p<=10&&!pass)
					{

							//System.out.println("SCORE : "+t[x]);
							int remain = t[x]-p;	
							int[][] possibleNS = {{p,p},{p+1,p+1},{p,p+1},{p,p-1},{p-1,p-1}     };
							int[][] possibleS = {{p+2,p+2},{p,p+2},{p+1,p+2},{p-2,p-2},{p-2,p-1},{p-2,p}  };
							
							//System.out.print("TRI: "+p);

							if(equalpair(remain,possibleNS))
							{
								count++;
								pass=true;
							}
							else if(equalpair(remain,possibleS))
							{
								if(surprise<S)
								{
									count++;
									surprise++;
									pass=true;
								}
							}
							p++;
					}

				}


				return count;
	}

	public static boolean equalpair(int num,int[][] pair)
	{
			
			boolean check=false;

			
			for(int i=0;i<pair.length;i++)
		{
			if(num==(pair[i][0]+pair[i][1]))
			{
				
				if(pair[i][0]>=0&&pair[i][0]<=10&&pair[i][1]>=0&&pair[i][1]<=10)
				{
					check=true;
					//System.out.println(" "+pair[i][0]+" "+pair[i][1]);
				}
			}
		}

			
			
			
			return check;
	}	
}
