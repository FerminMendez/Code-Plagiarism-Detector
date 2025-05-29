package com.code;

import java.io.BufferedReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DancingWithGooglers 
{
	public static void main(String[] args) 
	{
		ReadWriteInputFile readObj = new ReadWriteInputFile();
		BufferedReader br = null;
		Writer outWriter = null;
		int caseNo = 0,i=0;
		
		String strLine="";
		br = readObj.readInputFile("B-small-attempt0.in");
		outWriter = readObj.writeOutputFile("output.txt");
		if(br!=null || outWriter!=null)
		{
			try
			{
				caseNo = Integer.parseInt(br.readLine());
				while ((strLine = br.readLine()) != null)
				{
					String[] splitStr = strLine.split(" ");
					int N=Integer.parseInt(splitStr[0]),S=Integer.parseInt(splitStr[1]) , p=Integer.parseInt(splitStr[2]);
					int validCount=0;
					ArrayList totalScores = new ArrayList();
					for (int j = 3; j < splitStr.length; j++) 
					{
						totalScores.add(splitStr[j]);
					}
					for(int j=0;j<totalScores.size();j++)
					{
						int q = Integer.parseInt(totalScores.get(j).toString()) / 3;
						int r = Integer.parseInt(totalScores.get(j).toString()) % 3;
						
						if(r==0)
						{
							if(q>=p)
								validCount++;
							else if((q+1)>=p && S!=0 && q!=0)
							{
								validCount++;S--;
							}
						}
						if(r==1)
						{
							if((q+1)>=p)
								validCount++;
						}
						if(r==2)
						{
							if((q+1)>=p)
								validCount++;
							else if((q+2)>=p && S!=0)
							{
								validCount++;S--;
							}
						}
					}
					outWriter.write("Case #"+(++i)+": "+validCount+"\n");
				}
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			readObj.closeObjects(outWriter);
		}
	}
}


/*
 
					
					for(int j=0;j<totalScores.size();j++)
					{
						int checkVal = ( (Integer.valueOf(totalScores.get(j).toString())-p)/2 );
						if(checkVal==p || (checkVal+1)==p)
						{
							validCount++;
						}
						else if(checkVal<p && S!=0 )
						{
							validCount++;S--;
						}
					}
 * */
 