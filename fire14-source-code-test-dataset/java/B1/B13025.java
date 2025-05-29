import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class QualificationC {
	public static void main(String[] args) {
		File file = new File("D:/CodeJam/C-small-attempt0.in");
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            int row = 0;
            while ((text = reader.readLine()) != null) {
                if(row == 0)
                	System.out.println(text);
                else{
                	String[] textArr = text.split(" ");
                	int a = Integer.parseInt(textArr[0]);
                	int b = Integer.parseInt(textArr[1]);
                	int half = (a+b)/2;
                	Set<Set<String>> resSet2 = new HashSet<Set<String>>();
                	int res = 0;
                	for(int i=a; i<=b; i++){
                		if(i<10)
                			continue;
                		String numStr = i+"";
                		for(int j=1; j<numStr.length(); j++){
                        	Set<String> resSet1 = new HashSet<String>();
                    		String moved = numStr.substring(j)+numStr.substring(0, j);
                    		if(moved.charAt(0) == '0')
                    			continue;
                    		if(moved.equals(numStr))
                    			continue;
                    		if(Integer.parseInt(moved) < a || Integer.parseInt(moved) > b)
                    			continue;
                    		
                    		resSet1.add(numStr);
                    		resSet1.add(moved);
                    		if(resSet2.contains(resSet1))
                    			continue;
                    		else
                    			resSet2.add(resSet1);
                    		
                    		//res += moved+" ";
                    		res++;
                		}
                	}
                	
                	contents.append("Case #"+row+": "+res).
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
        
        System.out.println(contents.toString());
        
        try{
        	FileWriter fstream = new FileWriter("D:/CodeJam/C-small-attempt0.out");
        	BufferedWriter out = new BufferedWriter(fstream);
        	out.write(contents.toString());
        	out.close();
        }catch (Exception e){
        	System.err.println("Error: " + e.getMessage());
        }
	}

}
