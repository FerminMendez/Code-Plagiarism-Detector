import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DancingWithGooglers {
	static String max(String line, int index){
		
		String[] array = line.split(" ");
		
		int googlers = new Integer(array[0]);
		int surprising = new Integer(array[1]);
		int minimum = new Integer(array[2]);
		
		List<Integer> scores = new ArrayList<Integer>();
		
		for (int i=0; i<googlers; i++){
			scores.add(new Integer(array[3+i]));
		}
		
		Collections.sort(scores);
		
		int count = 0;
		List<Integer> l = new ArrayList<Integer>();
		
		for (Integer score : scores){
			if ((score+2)/3 >= minimum){
				count++;
			} else {
				l.add(score);
			}
		}
		
		scores = l;
		
		Collections.sort(scores);
		Collections.reverse(scores);
		
		//moderate scores
		int left = scores.size() > surprising ? surprising : scores.size();
		for (int i=0; i<left; i++){
			if (scores.get(i) < 2) {
			
			} else {
				scores.set(i, scores.get(i)+ 4);
			}
			
			if (scores.get(i)/3 >= minimum){
				count++;
			}
		}
		
		String prefix = "Case #" + index + ": ";
		return prefix + count + "\n";		
	}
	
	public static void main(String[] args) throws Exception{
		if (args.length < 1) throw new Exception("Expected Filename as first argument.");
		
		String filename = args[0];
		FileReader input = new FileReader(filename);
		BufferedReader bufferedinput = new BufferedReader(input);
		
		//number of lines
		int n = new Integer(bufferedinput.readLine());
		
		String line = bufferedinput.readLine();
		int index = 1;
		
		String outfilename = "b.txt";
		FileWriter f = new FileWriter(outfilename);
		
		while (line != null){
			String result = max(line, index);
			
			System.out.println(result);
			f.write(result);
			
			index++;
			line = bufferedinput.readLine();
		}
		f.close();
		
	}
}
