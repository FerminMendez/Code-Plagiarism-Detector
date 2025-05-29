import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;



/**
 * @author alex
 *
 */
public class ProblemCRecycledNumbers {
	public static void main(String args[]) {
		try{
			String fileDir = "/Users/alex/Documents/workspace/codejam2012/src/";
			String inputFile = "C-small-attempt3";
		//	String inputFile = "CSmallInput0";
			FileInputStream fstream = new FileInputStream(fileDir+inputFile+".in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String firstLine = br.readLine();
			int numberOfTests = Integer.parseInt(firstLine);

			String strLine;
			Integer numberOfRecurrences;
			// open write file descriptor
			 FileWriter ofstream = new FileWriter(fileDir+inputFile+"-output.txt");
			  BufferedWriter out = new BufferedWriter(ofstream);
			
			//Read File Line By Line
			for(int loop=0;loop<numberOfTests;loop++) {//while ((strLine = br.readLine()) != null)   {
				strLine = br.readLine();
				
				// translate line
				numberOfRecurrences = calculateRecycled(strLine);
				
				// Print the content on the console
				System.out.println ("Case #" + (loop+1) + ": " + numberOfRecurrences);
				out.write("Case #" + (loop+1) + ": " + numberOfRecurrences + "\n");
			}
			//Close the input stream
			in.close();
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e + e.getMessage());
		}
	}

	/**
	 * @param strLine
	 * @return
	 */
	private static Integer calculateRecycled(String strLine) {
		Integer result = 0;
		String[] nm = strLine.split(" ");
		Integer alpha = Integer.parseInt(nm[0]);
		Integer beta = Integer.parseInt(nm[1]);
		//System.out.println("niou and miou:" + niou + ":" + miou);
		if(alpha<10) return 0;
		
		for(Integer niou=alpha;niou<beta;niou++) {
			char[] nioudigits = (niou.toString()).toCharArray();
			if(nioudigits.length==2) {
				char[] revnioudigits = {nioudigits[1], nioudigits[0]};
				String miou1 = new String(revnioudigits);
				if( (alpha < Integer.parseInt( miou1 )) && (Integer.parseInt( miou1 ) <= beta) && (niou< Integer.parseInt( miou1 ))) {
//					System.out.println(">matched for:" + Integer.parseInt( revnioudigitsString ));
					result++;
				}
			} else if(nioudigits.length==3) {
				char[] revnioudigits1 = {nioudigits[2], nioudigits[0], nioudigits[1]};
				String miou11 = new String(revnioudigits1);
				char[] revnioudigits2 = {nioudigits[1], nioudigits[2], nioudigits[0]};
				String miou12 = new String(revnioudigits2);
				if( ((alpha < Integer.parseInt( miou11 )) && (Integer.parseInt( miou11 ) <= beta) && (niou < Integer.parseInt( miou11 ) && ( Integer.parseInt( miou11 ) != Integer.parseInt( miou12 ) ) )
					)
				) {
//					System.out.println(">>matched for:" + Integer.parseInt( revnioudigitsString1 ));
					result++;
				}
				if( (  (alpha < Integer.parseInt( miou12 )) && (Integer.parseInt( miou12 ) <= beta) && (niou < Integer.parseInt( miou12 ) && ( Integer.parseInt( miou11 ) != Integer.parseInt( miou12 ) )) 
						)
					) {
//						System.out.println(">>matched for2:" + Integer.parseInt( revnioudigitsString1 ));
						result++;
					}
			
				
			}
		}
		
		
		return result;
	}
}
