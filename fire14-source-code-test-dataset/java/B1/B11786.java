import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex3 {


	public static void main(String[] args) throws IOException{
		String dir = System.getProperty("user.dir");
		String lineOfText;
		int T = 0;
		BufferedReader input = new BufferedReader(new FileReader(dir + "\\C-small-attempt0.in"));
		BufferedWriter output = new BufferedWriter(new FileWriter(dir + "\\C-small-attempt0.out"));		
		try {

			lineOfText = input.readLine();
			T = Integer.parseInt(lineOfText);
			
			int N=0;
			lineOfText = input.readLine();
			while (lineOfText!=null) {
				N++;
				StringBuilder newString = new StringBuilder();	
				int result = 0;
				Pattern p = Pattern.compile("-?\\d+");
				Matcher m = p.matcher(lineOfText);
				m.find();
				int A = Integer.parseInt(m.group());
				m.find();
				int B =  Integer.parseInt(m.group());
				ArrayList<String> set = new ArrayList<String>();
				for(int i=A;i<=B;i++){
					String num = new String(Integer.toString(i));
					int length = num.length();
					for(int y=1;y< length;y++){
						String part1 = num.substring(0,y);
						String part2 = num.substring(y);
						
						String newNum = part2+part1;
						int newNumber = Integer.parseInt(newNum);
						
						String pair = Integer.toString(i)+Integer.toString(newNumber);
						
						if(newNumber>=A && newNumber <=B && newNumber>i){
							if(!set.contains(pair)){
								result +=1;
								set.add(pair);
							}
						}
					}
					
				}
				lineOfText = input.readLine();
				newString.append("Case #"+N+": "+result);
				output.write(newString.toString());
				output.newLine();
			}
			
			
						
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
			output.close();
		}
		
	}

}
