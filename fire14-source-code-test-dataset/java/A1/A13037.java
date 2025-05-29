package dance;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileInputStream fstream;
		try {

			  FileOutputStream fos = new FileOutputStream("dance.out");
			  System.setOut(new PrintStream(fos, true));                              
			fstream = new FileInputStream("B-small-attempt1.in");

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int num = Integer.parseInt(br.readLine());
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				i++;
				System.err.println(strLine);
				String[] splits= strLine.split(" ");
				int googlers =Integer.parseInt(splits[0]);
				int surprising =Integer.parseInt(splits[1]);
				int min_score =Integer.parseInt(splits[2]);
				int[] score_for_googler = new int[googlers];
				for (int j = 0; j < googlers; j++) {
					score_for_googler[j]=Integer.parseInt(splits[j+3]);
				}
//				System.err.println("Googlers:"+googlers);
//				System.err.println("surprising: "+surprising);
//				System.err.println("min score "+min_score);
//				System.err.println("scores"+Arrays.toString(score_for_googler));
				int result=0;
				
					
				int num_surprised=0;
				int min_unsurprised=3*min_score-2;
				int min_surprised=3*min_score-4;
				if(min_surprised<0)
					min_surprised=0;
				for (int current_score : score_for_googler) {
					
					if(current_score==0)
						continue;
					if(current_score>=min_unsurprised)
						result++;
					else if (current_score>=min_surprised) {
						if(num_surprised<surprising)
							result++;
							num_surprised++;
						
					}
//					System.err.println("Scores:"+ current_score+" "+min_unsurprised+" "+min_surprised+" "+num_surprised+" r:"+result);
				}
				if(min_score==0)
					result=googlers;
				System.out.println("Case #"+i+": "+result);
				System.err.println("Case #"+i+": "+result);
//				System.in.read();
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
