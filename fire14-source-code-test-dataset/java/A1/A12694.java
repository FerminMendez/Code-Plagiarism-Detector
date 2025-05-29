import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;


public class Algorithm2 {

	static final String input_path = "F://workspace//GoogleContest2012//src//input.txt";
	static final String output_path = "F://workspace//GoogleContest2012//src//output.txt";
	static int total_case;
	
	static int findMax(String line){
		StringTokenizer token  = new StringTokenizer(line);
		int num = Integer.parseInt((String)token.nextElement());
		int surprising  = Integer.parseInt((String)token.nextElement());
		int mscore =  Integer.parseInt((String)token.nextElement());
		int goodline = 3*mscore - 2;
		int middline = 3*mscore - 4;
		goodline = goodline>0?goodline:0;
		middline = middline>0?middline:1;
		int[] scores = new int[num];
		int good  = 0, middle = 0;
		for(int i = 0; i< num;i++){
			scores[i] = Integer.parseInt((String)token.nextElement());
			if(scores[i]>=goodline){
				good++;
			}else if(scores[i]>=middline){
				middle++;
			}
		}
		
		return good + (middle>=surprising?surprising:middle);
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
