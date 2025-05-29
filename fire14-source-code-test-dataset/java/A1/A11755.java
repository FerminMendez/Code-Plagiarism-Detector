import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex2 {


	public static void main(String[] args) throws IOException{
		String dir = System.getProperty("user.dir");
		String lineOfText;
		int T = 0;
		BufferedReader input = new BufferedReader(new FileReader(dir + "\\B-small-attempt2.in"));
		BufferedWriter output = new BufferedWriter(new FileWriter(dir + "\\B-small-attempt2.out"));		
		try {

			lineOfText = input.readLine();
			T = Integer.parseInt(lineOfText);
			
			int N=0;
			lineOfText = input.readLine();
			while (lineOfText!=null) {
				N++;
				StringBuilder newString = new StringBuilder();	
				
				Pattern p = Pattern.compile("-?\\d+");
				Matcher m = p.matcher(lineOfText);
				m.find();
				int googlers = Integer.parseInt(m.group());
				m.find();
				int surprises =  Integer.parseInt(m.group());
				m.find();
				int limit =  Integer.parseInt(m.group());
				ArrayList<Integer> points = new ArrayList<Integer>();
				for(int i=0;i<googlers;i++){
					m.find();
					points.add(Integer.parseInt(m.group()));
				}
				
				int result = 0;
				if(limit>=2){
					for(int i=0;i<googlers;i++){
						if(points.get(i)>=(limit+limit-1+limit-1)){
							result++;
						} else if(surprises>0 && points.get(i)==(limit+limit-1+limit-2)){
							surprises--;
							result++;
						} else if(surprises>0 && points.get(i)==(limit+limit-2+limit-2)){
							surprises--;
							result++;
						}
					}
				} else if(limit==1){
					for(int i=0;i<googlers;i++){
						if(points.get(i)>=(limit)){
							result++;
						}
					}
				} else if(limit==0){
					result = googlers;
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
