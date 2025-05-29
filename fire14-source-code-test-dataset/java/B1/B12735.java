import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.HashMap;

public class Algorithm3 {

	static final String input_path = "F://workspace//GoogleContest2012//src//input.txt";
	static final String output_path = "F://workspace//GoogleContest2012//src//output.txt";
	static int total_case;
	
	static int findMax(String line){
		StringTokenizer token  = new StringTokenizer(line);
		Integer small = Integer.parseInt((String)token.nextElement());
		Integer large  = Integer.parseInt((String)token.nextElement());
		int number = 0;
		HashMap map = new HashMap();
		for(Integer i=small;i<large;i++){
			String str = i.toString();
			int length = str.length();
			map.clear();
			for(int k = 1;k<length;k++){
				//System.out.print(str.subSequence(length - k, length).toString()+","+str.subSequence(0, length - k).toString()+",");
				String temp = str.subSequence(length - k, length).toString()+str.subSequence(0, length - k).toString();
				int m = Integer.parseInt(temp);
				if(m<=large&&m>i){
					if(map.get(m)==null){
						number++;
						map.put(m, m);
					}
				}
			}
		}
		
		return number;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		Vector<String> outputs = new Vector<String>();
		try{
			File file = new File(input_path);
			BufferedReader reader =new BufferedReader(new FileReader(file));
			String line  = reader.readLine(); //skip number
			total_case = Integer.parseInt(line);
			while(i<total_case)
			{
				line = reader.readLine();
				
				Integer max = findMax(line);
				String decoded = "Case #"+(i+1)+": "+max;
				System.out.println(decoded);
				outputs.add(decoded);
				i++;
			}
			File file_o = new File(output_path);
			BufferedWriter writer =new BufferedWriter(new FileWriter(file_o));
			for(i=0;i<outputs.size();i++)
			{
				writer.write(outputs.get(i)+"\r\n");
			}
			writer.flush();
			reader.close();
			writer.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
