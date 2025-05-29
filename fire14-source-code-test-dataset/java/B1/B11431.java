import java.io.*;
import java.util.*;

class p3
{
	public static void main(String s[])
	{
		int startingnum;
		int endingnum;
		int totalcases;
		int pairs;
		try{
			File f = new File("C-small-attempt0.in");
			File o = new File("Output.out");
			String strLine=null;
			int first=1;

			BufferedReader br = new BufferedReader(new FileReader(f));
			PrintWriter out = new PrintWriter(new FileWriter(o));
			 
			strLine = br.readLine();
			totalcases=Integer.parseInt(strLine);
			
			for(int i=0; i<totalcases; i++)	
			{
				strLine = br.readLine();
				String nums[]=strLine.split(" ");
				startingnum=Integer.parseInt(nums[0]);
				endingnum=Integer.parseInt(nums[1]);
//				System.out.println("Start:"+startingnum+" End:"+endingnum);
				pairs=findPairs(startingnum,endingnum,out);
//				if(first==1)
//				{
					out.println("Case #"+(i+1)+": "+pairs);
//					first=0;
//				}
//				else if(first==0)
//					out.println("\n"+"Case #:"+i+": "+pairs);
			}
			br.close();
			out.close();
		}catch (Exception e)
		{//Catch exception if any
		System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	static int findPairs(int startingnum, int endingnum, PrintWriter out)
	{
		int currentnum=startingnum;
		int pairs=0;
		ArrayList<String> arl = new ArrayList<String>();
		
		for(currentnum = startingnum; currentnum <= endingnum; currentnum++)
		{
//			System.out.println();
			String curr=currentnum+"";
			String rotatednum=null;
			
			try{		
				for(int i=0; i<curr.length()-1; i++)
				{
					if(curr.charAt(curr.length()-1)=='0')
						continue;
					rotatednum=curr.substring(0,curr.length()-1);
					rotatednum=curr.substring(curr.length()-1,curr.length())+rotatednum;
//					System.out.println("Currentnum:"+currentnum+" Trying for:"+rotatednum);
					if( (Integer.parseInt(rotatednum) )>startingnum && ( Integer.parseInt(rotatednum) )<endingnum)
					{
						if(arl.indexOf(currentnum+" "+rotatednum)== -1 && arl.indexOf(rotatednum+" "+currentnum)== -1 && currentnum != Integer.parseInt(rotatednum))
						{
//							out.println("Pair Found for:"+currentnum+" and "+rotatednum);
							arl.add(currentnum+" "+rotatednum);
							pairs++;
						}
					}
					curr=rotatednum;
				}
			}catch(Exception e)	{
			}

		}
		return pairs;
	}
}
