import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class RecycledNumbers {
	
	public static void main(String [] args){
		String fileIn = "C:\\CodeJam\\C-small-attempt0.in";
		ArrayList<String> lines = getLines(fileIn);
		StringBuffer result = new StringBuffer();
		if(lines!=null){			
			String firstLine[] = lines.get(0).split(" ");
			int caseTotal = Integer.parseInt(firstLine[0]);
			for(int i = 0; i<caseTotal; i++){
				String[] line = lines.get(i+1).split(" ");
				result.append("Case #"+(i+1)+": "+ getResult(line)+"\n");
			}
		}
			
		String fileOut = "C:\\CodeJam\\C-small-attempt0.out";
		writeFile(fileOut, result.toString());	
	}
	
	public static int getResult(String[] line){
		String str = line[0];
		int line0 = Integer.parseInt(line[0]);
		int line1 = Integer.parseInt(line[1]);
		int tot = 0;
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		for(int i=line0;i<=line1;i++){
			for(int j=1; j<str.length();j++){
				String strAll = i+"";
				String str1 = strAll.substring(j);
				String str2 = strAll.substring(0,j);
				int strResult = Integer.parseInt(str1+str2);
				if(line0<=strResult && strResult<=line1){
					if(map.get(strAll+","+strResult)==null && !strAll.equalsIgnoreCase(strResult+"")){
						map.put(strAll+","+strResult,"Exist");
						map.put(strResult+","+strAll,"Exist");
						tot++;
					}
				}
			}  
		}
		return tot;
	}
	
	public static void writeFile(String filePath, String content){
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
			out.write(content);
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getLines(String filePath){
		ArrayList<String> lines = null;	
		try{
			lines = new ArrayList<String>();
			String str;	    	   
		    BufferedReader in = new BufferedReader( new FileReader(filePath));
		    while ((str = in.readLine()) != null) {
		    	lines.add(str);	      
		    }	    
		    in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return lines;
	}
}