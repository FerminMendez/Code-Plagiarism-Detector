import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QualificationB {

	public static void main(String[] args) {
		File file = new File("D:/CodeJam/B-small-attempt0.in");
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            int row = 0;
            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                //contents.append(text).append(System.getProperty("line.separator"));
                if(row == 0)
                	System.out.println(text);
                else{
                	String[] textArr = text.split(" ");
                	int s = Integer.parseInt(textArr[1]);
                	int p = Integer.parseInt(textArr[2]);
                	int savePoint = (p*3)-2;
                	int surprisePoint = savePoint-2;
                	if(savePoint < p)
                		savePoint = p;
                	if(surprisePoint < p)
                		surprisePoint = p;
                	int sure = 0;
                	int notsure = 0;
                	for(int i=3; i<textArr.length; i++){
                		if(Integer.parseInt(textArr[i]) >= savePoint)
                			sure++;
                		else if(Integer.parseInt(textArr[i]) >= surprisePoint)
                			notsure++;
                	}
                	if(notsure > s)
                		sure += s;
                	else
                		sure += notsure;
                	
                	contents.append("Case #"+row+": "+sure).
                		append(System.getProperty("line.separator"));
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // show file contents here
        System.out.println(contents.toString());
        
        try{
        	// Create file 
        	FileWriter fstream = new FileWriter("D:/CodeJam/B-small-attempt0.out");
        	BufferedWriter out = new BufferedWriter(fstream);
        	out.write(contents.toString());
        	//Close the output stream
        	out.close();
        }catch (Exception e){//Catch exception if any
        	System.err.println("Error: " + e.getMessage());
        }
	}

}
