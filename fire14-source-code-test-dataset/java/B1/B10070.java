import java.io.*;
public class CodeJamQual3b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try{
			// Open the file that is the first 
			// command line parameter
			File file = new File("input.in");
			FileInputStream fstream = new FileInputStream("input.in");  //Input file name changed to input.in
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			FileWriter fout = new FileWriter("out3.txt");
			BufferedWriter outprint = new BufferedWriter(fout);
			//Read File Line By Line
			int i = 0;
			while (((strLine = br.readLine()) != null)) 	{
				if (i != 0 && i !=1111) {
					String[] stringArray = strLine.split(" ");
					
					int bot = Integer.parseInt(stringArray[0]);
					int top = Integer.parseInt(stringArray[1]);
					int counter = 0;
					int len = stringArray[0].length(); 
					//top
					for (int j = bot; j < top+1; j++) {
						counter = counter + count(j,top,bot,len);
						//System.out.println("j = " + j + "  " + count(j,top,bot));
					}
					//System.out.println (counter);
					
					outprint.write("Case #" + i + ": " + counter);
					outprint.newLine();
					System.out.println("Case #" + i + ": " + counter);
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
	
	public static int count(int j, int top, int bot, int len){
		char[] cArray = Integer.toString(j).toCharArray();
		int out = 0;
		int[] log = new int[len];
		for (int k = 0; k < len-1; k++) {
			cArray = shift(cArray);
			boolean flag = true;
			//System.out.println(new String(cArray));
			int recycled = Integer.parseInt(new String(cArray));
			if ((j <recycled) && (recycled > bot) && (recycled <= top)){
				//System.out.println("(" + j + " , " + recycled + ")" + " [ " + bot + " |" + top + " ] ");
				for (int in = 0; in < len; in++){
					if (recycled == log[in]){
						flag = false;
						//System.out.println("REPEAT" + recycled);
						break;
					}
				}
				if (flag == true){
					log[k] = recycled;
					//System.out.println("(" + j + " , " + recycled + ")" + " [ " + bot + " |" + top + " ] ");
					out += 1;
				}
			}
				
		}
		return out;
	}
	
	public static char[] shift(char[] cArray) {
	    char[] nArray = new char[cArray.length];
	    nArray[0] = cArray[cArray.length-1];
	    for (int d = 1; d < cArray.length; d++){
	    	nArray[d] = cArray[d-1];
		}
		return nArray;
	}
}
