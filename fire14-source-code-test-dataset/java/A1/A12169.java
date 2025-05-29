import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Dancing {

	public static void main(String args[]) throws IOException{
		// Setup the input
				File f1 = new File("B-small-attempt0.in");
				Scanner s1 = new Scanner(f1);
				// setup the output:
				PrintWriter out = new PrintWriter(new FileWriter("output.out"));
				
				// getting the number of test cases and getting rid of the line
				int testCases = Integer.parseInt(s1.nextLine());
				//System.out.println(testCases);
				
				// setting up some vars
				int googlers;
				int surprising;
				int testMax;
				ArrayList<Integer> scores = new ArrayList<Integer>();
				int j = 0;
				int resultNum;
				int surprisingLeft;
				// Loop over the lines
				while(s1.hasNextLine()){
					scores.clear();
					resultNum = 0;
					j++;
					googlers = s1.nextInt();
					surprising = s1.nextInt();
					surprisingLeft = surprising;
					testMax = s1.nextInt();
					for (int i = 0; i <googlers;i++){
						scores.add(s1.nextInt());
					}
					//System.out.println("Line "+j+" Googlers: " + googlers + " surprising: "+surprising+" testMax: " + testMax);
					// loop over all the googlers
					for (int k = 0; k<googlers;k++){
						//System.out.println(k);
						//int minScore = (testMax-1)+(testMax-1)+(testMax-1);
						//System.out.println(minScore);
						if (scores.get(k)>((testMax-1)+(testMax-1)+(testMax-1))){
							resultNum++;
						}
						else if (surprisingLeft != 0 && scores.get(k)!=0){
							if (scores.get(k)>=testMax+testMax-2+testMax-2){
								resultNum++;
								surprisingLeft--;
							}
							
						}
					}
					out.println("Case #"+j+": "+resultNum);
				}				
				// close the scanner
				s1.close();
				out.close();
	}
}
