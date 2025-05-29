import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class Recycled {

	private static String FileNameFrom = "";
	private static String FileNameTo = "";
	
	/**
	 * @param args
	 */
	
	private int calculate(int n, int m){
		HashSet<String> pairsTest = null;
		int totalPairs = 0;
		String n_Str = null;
		int n_Length = 0;
		for(int i_n = n; i_n < m; i_n++){
			n_Str = String.valueOf(i_n);
			//System.out.println(n_Str);
			n_Length = n_Str.length();
			int afterShift = 0;
			pairsTest = new HashSet<String>();
			for(int move_n = 1; move_n<n_Length; move_n++){
				afterShift = getShifted(i_n,move_n);
				
				//System.out.println(afterShift);
				if((afterShift>i_n)&&(afterShift <= m)){
					if(!pairsTest.contains(i_n + "   " + afterShift)){
						pairsTest.add(i_n + "   " + afterShift);
						totalPairs = totalPairs + 1;
					}
					else{
						//System.out.println(i_n + "   " + afterShift);
					}
					
				}
			}
			pairsTest = null;
		}
		
		return totalPairs;
	}
	
	private int getShifted(int n,int moveToLast){
		
		StringBuffer n_SB = new StringBuffer();
		char[] moveThisPart = new char[moveToLast];
		n_SB.append(n);		
		n_SB.getChars(0, moveToLast, moveThisPart, 0);
		n_SB.delete(0, moveToLast);
		n_SB.append(moveThisPart);
		return Integer.valueOf(n_SB.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Recycled rec = new Recycled();
		
		rec.loadPropertiesFile("recycle");
		int testCaseNumber = 0;
		BufferedReader input = null;
		BufferedWriter bufferedWriter = null;
		String line = null;
		try {
			input =  new BufferedReader(new FileReader(FileNameFrom));
			bufferedWriter = new BufferedWriter(new FileWriter(FileNameTo));
			line = input.readLine();
			testCaseNumber = Integer.parseInt(line);
			
			for(int k =0;k<testCaseNumber;k++){
				line = input.readLine();
				line.trim();
				int i = line.lastIndexOf(" ");
				
				int iFirstSpace = line.indexOf(" ");
				//System.out.println(line.substring(0,iFirstSpace)+"  "+line.substring(i+1));
				
				String nStr = line.substring(0,iFirstSpace);
				String mStr = line.substring(i+1);
				
				int n = Integer.parseInt(nStr);
				int m = Integer.parseInt(mStr);
				
				int getR = rec.calculate(n, m);
				//System.out.println("test "+ getR);
				String str = "Case #"+(k+1)+": "+getR;
				//System.out.println(str);
				
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            //Close the BufferedWriter
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                
                if(input != null){
					input.close();
				}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
	}

	
	private void loadPropertiesFile(String name){
		ClassLoader loader = this.getClass().getClassLoader();
		final ResourceBundle rb = ResourceBundle.getBundle (name,
                Locale.getDefault (), loader);
		
		try{
			FileNameFrom = rb.getString("FileNameFrom");
			FileNameTo = rb.getString("FileNameTo");
			
		}catch(MissingResourceException mRE){
			System.out.println("Input proper keys in the properties file");
			System.exit(0);
		}
	}
}
