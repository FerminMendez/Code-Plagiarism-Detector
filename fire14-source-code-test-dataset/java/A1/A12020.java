package googler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("B-small-attempt0.in"))));	

		br.readLine();
		String temp;
		int nsurprise=0;
		int best;
		int googlers;
		int usedmin;
		int answer;
		int casenumber=1;
		
		FileWriter fstream = new FileWriter("output.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		while((temp=br.readLine())!=null)
		{
			String arr[] = temp.split(" ");
			usedmin=0;
			answer=0;
			googlers = Integer.parseInt(arr[0]);
			nsurprise = Integer.parseInt(arr[1]);
			best = Integer.parseInt(arr[2]);
		
//			System.out.println("best: " + best);			
//			System.out.println("arrlength: " + arr.length);
			
			for(int j=arr.length-1;j>=3;j--)
			{
				int totalscore = Integer.parseInt(arr[j]);
				
				if(totalscore/3>=best)
				{
					answer++;
				}
				else if(totalscore!=0)
				{
					int eachscore = totalscore/3;	
					int thirdscore = totalscore - eachscore*2;
					
					if(thirdscore>=best && (thirdscore-eachscore)==2 && usedmin<nsurprise)
					{
						answer++;
						usedmin++;
					}
				
					else if(thirdscore>=best && (thirdscore-eachscore)==1)
					{
						answer++;
					}
					
					else if(thirdscore==eachscore && usedmin<nsurprise)
					{
						int secondscore = eachscore+1;
						eachscore = eachscore-1;
						thirdscore+=1;
						
						if(thirdscore>=best)
						{
							answer++;
							usedmin++;
						}
					}
					else if(thirdscore-eachscore==2)
					{
						eachscore = eachscore+1;
						thirdscore = thirdscore-2;
						
						if(eachscore>=best)
						{
							answer++;
						}
					}
				}
				
			}
			out.write("Case #" + casenumber + ": " + answer);
			System.out.println("Case #" + casenumber + ": " + answer);
			out.newLine();
			casenumber++;
		}
		
		out.close();
	}

}
