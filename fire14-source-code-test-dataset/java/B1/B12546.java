import java.io.File;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.FileWriter;

public class RN {
	
	public static void main(String[] args) throws Exception{
		File input = new File("C-small-attempt1.in");
		File output = new File("output.out");
		FileWriter fw = new FileWriter(output);
		Scanner s = new Scanner(input);
		
		int numloops = s.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int n=0; n<numloops; n++){
			sb.append("Case #" + (n+1) + ": ");
			
			int low = s.nextInt();
			int hi = s.nextInt();
			int numrepeats = 0;
			
			for(int i=low; i<hi; i++){
				String strnum = "" + i;
				//System.out.println(strnum);
				
				for(int j=1; j<strnum.length(); j++){
					String rotstr = strnum.substring(j) + strnum.substring(0,j);
					//System.out.println(rotstr);
					int rotval = Integer.parseInt(rotstr);
					rotstr = "" + rotval;
					
					if(rotval > i && rotval <= hi ){//&& rotstr.length() == strnum.length()){
						numrepeats++;
						//System.out.println(strnum + " " + rotstr);
					}
					
					if(rotval == i)
						;//break; //already had a repeating number
				}
			}
			sb.append(numrepeats + "\n");
			//fw.append(numrepeats + "\n");
		}
		fw.write(sb.toString());
		fw.close();
	}
}
