import java.io.*;
public class CodeJamQual2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try{
			// Open the file that is the first 
			// command line parameter
			File file = new File("input.in");
			FileInputStream fstream = new FileInputStream("input.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			FileWriter fout = new FileWriter("out2.txt");
			BufferedWriter outprint = new BufferedWriter(fout);
			//Read File Line By Line
			int i = 0;
			while ((strLine = br.readLine()) != null) 	{
				if (i != 0) {
					String[] stringArray = strLine.split(" ");
					int NumberofGooglers = Integer.parseInt(stringArray[0]);
					int NumberofSurprises = Integer.parseInt(stringArray[1]);
					int p = Integer.parseInt(stringArray[2]);
					int overshoot = 0;
					int safe = 0;
					int diff = 0;
					
		        	switch (p) {
		        		case 0: overshoot = 0;safe = 0; break;
			        	case 1: overshoot = 1;safe = 1; break;
			        	case 2: overshoot = 2;safe = 4; break;
			        	default: overshoot = p*3-4;safe = p*3-2; break;
		        	}
				    
					int num = 0;
					int osnum = 0;
					int ssnum = 0;
					//System.out.println("overshoot " + overshoot + "   " + "safe " + safe);
					for (int j = 3; j < stringArray.length; j++) {
						num = Integer.parseInt(stringArray[j]);
						if (num >= safe){
							ssnum += 1;
						}
						if (num >= overshoot){
							osnum += 1;
						}
					}
					diff = osnum - ssnum;
					if (NumberofSurprises > diff) NumberofSurprises = diff;
					
					int out = ssnum + NumberofSurprises;
					
					outprint.write("Case #" + i + ": " + out);
					outprint.newLine();
					
					System.out.println("Case #" + i + ": " + out);
				}
				
				i++;
				
			}
			
			//Close the input stream
			in.close();
			//Close the output stream
			outprint.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
