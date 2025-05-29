import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Dancing_With_the_Googlers {


    /**
     * The first line of the input gives the number of test cases, T.
     *  T test cases follow. 
     *  Each test case consists of a single line containing integers separated by single spaces. 
     *  The first integer will be N, the number of Googlers, and the second integer will be S, the number of surprising triplets of scores. 
     *  The third integer will be p, as described above. Next will be N integers ti: the total points of the Googlers. 
     * @throws IOException
     */
	   public static void main(String[] args) throws IOException {
	        // TODO Auto-generated method stub
			// Reading the input file
			Scanner in = new Scanner(new File("B-small-attempt0.in"));
			// writting the input file
			FileOutputStream fos = new FileOutputStream("B-small-attempt0.out");
			PrintStream out = new PrintStream(fos);
	         //Close the output stream
	        int testCase=Integer.parseInt(in.nextLine());
	        for(int i=0;i<testCase;i++) {
	        	out.print("Case #" + (i + 1) + ":\t");
	        	int NoOfGooglers= in.nextInt();
	        	int NoOfSurprisingResults = in.nextInt();
	        	int atLeastP=in.nextInt();
	        	ArrayList<Integer> scores= new ArrayList<Integer>();
        		int BestResults=0;
        		int Surprising=0;
	        	for(int j=0;j<NoOfGooglers;j++)
	        	{
	        		scores.add(in.nextInt());
	        		//System.out.print(scores.get(j));
	        		int modulus=scores.get(j)%3;
	        		int temp = scores.get(j);
	    			switch (modulus) {
					case 0:
						if (((temp / 3) >= atLeastP)) {
							BestResults++;
						} else {
							if (((((temp / 3) + 1) >= atLeastP) && ((temp / 3) >= 1))
									&& (Surprising < NoOfSurprisingResults)) {
								BestResults++;
								Surprising++;
								
							}
							
						}
						
						break;
					case 1:
						if ((temp / 3) + 1 >= atLeastP) {
							BestResults++;
							continue;
						}
						
						break;
					case 2:
						if ((temp / 3) + 1 >= atLeastP) {
							BestResults++;
						} else {
							if (((temp / 3) + 2 >= atLeastP)
									&& (Surprising < NoOfSurprisingResults)) {
								BestResults++;
								Surprising++;
							}
						}
						break;
					default:
						System.out.println("Error");
					}
	    			
				}// Internal for
				out.println(BestResults);
				// System.out.println(BestResults);
				System.out.println(Surprising);
				BestResults = 0;
			}// for
			in.close();
			out.close();
			fos.close();

	   }
}
