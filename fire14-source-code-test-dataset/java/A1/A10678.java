import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Savepoint;
import java.util.Arrays;
import java.util.Vector;


public class Scoring {

	static Vector<String> questions = null; //new Vector<String>();
	static int count = -1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		questions = readFile("input.txt");
		String result = process();
		
		savetoFile("out.txt", result);
	}
	

	private static String process() {
		// TODO Auto-generated method stub
		String ret = "";
		for (int i=0; i<count; i++)
		{
			
			/*The first line of the input gives the number of test cases, T. T
			 *  test cases follow. 
			 *   N, the number of Googlers, 
			 *    second integer will be S, the number of surprising triplets of scores. 
			 *    The third integer will be p, as described above. 
			 *    
			 *    Next will be N integers ti: the total points of the Googlers. */
			
			String[] numbers = questions.elementAt(i).split(" ");
			int n = Integer.parseInt(numbers[0]); //jumlah peserta
			int s = Integer.parseInt(numbers[1]); //jumlah surprising triplets of scores.
			int p = Integer.parseInt(numbers[2]); //nilai terbaik
			numbers = Arrays.copyOfRange(numbers, 3, 3+n);
			int answ = 0;
			for (int j=0; j<numbers.length; j++)
			{
				
				int score = Integer.parseInt(numbers[j]);
				int mod = score % 3;
				int floor = new BigDecimal(score /3).abs().intValue();
			//	System.out.println(score+"");
				if (floor>=p){
					answ ++;
					System.out.print(mod+"Y"+score+"fp ");
				}
				else if (mod==0){
					if (s>0 && floor+1>=p && floor-1>0)
					//	if (  )
						{
						answ++;
						
							s--;
						System.out.print(mod+"Y"+( floor+1 )+"o ");
						}
				}
				else if (mod==1 && floor+1>=p){
					answ++;
					System.out.print(mod+"Y"+score+"m1 ");
				}else if (mod==2){
					if (1+floor>=p)
					{	
						answ++;
						
						System.out.print(mod+"Y"+score+" ");
					}
					else if (s!=0 && floor+mod>=p)
					{
						answ++;
						s--;
						System.out.print(mod+"Y"+score+"s ");
					}
					//System.out.print(mod+"Y"+score+"s ");
				 } 
				else System.out.print(mod+"x"+score+" ");


				
				
				/*
				Input
			  	
				Output
				 
				4
				3 1 5 15 13 11
				3 0 8 23 22 21
				2 1 1 8 0
				6 2 8 29 20 8 18 18 21
					Case #1: 3
				Case #2: 2
				Case #3: 1
				Case #4: 3
*/
			}
			System.out.println(answ);
			ret += "Case #"+(i+1)+": "+answ+"\n";
		}
		
		return ret;
	}


	static public Vector<String> readFile(String filename)
	{
		Vector<String> retval = new Vector<String>();
		try{
			  // Open the file that is the first 
		  // command line parameter
		  FileInputStream fstream = new FileInputStream(filename);
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
			  System.out.print(strLine+"\n");
			  if (count==-1) 
				  count = Integer.parseInt(strLine.trim());
			  else
				  retval.add(strLine);
		  }
		  //Close the input stream
		  		in.close();
			}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
			
		return retval;
	}
	
	public static void savetoFile(String filename, String s){
		try{
			  // Create file 
		  FileWriter fstream = new FileWriter(filename);
		  BufferedWriter out = new BufferedWriter(fstream);
		  
		  out.write(s);
		  
		  //Close the output stream
		  out.close();
		  } catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}

}
