import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

//DancingGooglers.java
//Completes the Dancing with Googlers problem for Google Code Jam 2012
//By Jack Thakar
//Coded in Java using Eclipse 3.7
public class DancingGooglers {
	public static void main(String[] args){
		String input = readFile("B-small-attempt0.in");
		String[] lines = input.split(System.lineSeparator());
		String output = "";
		for(int i=1;i<lines.length;i++){
			String line = lines[i];
			Case c = (new DancingGooglers()).new Case(line);
			output+="Case #"+i+": ";
			output+=c.getSolution();
			if(i<lines.length-1) output+=System.lineSeparator();
		}
		writeFile("B-small-attempt0.out",output);
	}
	class Case{
		int dancers;
		int surprising;
		int required;
		int[] scores;
		public Case(String data){
			String[] splits = data.split(" ");
			int[] datas = new int[splits.length];
			for(int i=0;i<splits.length;i++){
				datas[i] = Integer.parseInt(splits[i]);
			}
			dancers = datas[0];
			surprising = datas[1];
			required = datas[2];
			scores = new int[dancers];
			for(int i=0;i<scores.length;i++){
				scores[i] = datas[i+3];
			}
		}
		public int getSolution(){
			int possible = 0;
			int surprised = surprising;
			for(int score:scores){
				int result = getBestResult(score);
				if(result==2){
					possible++;
				}else if(result==1&&surprised>0){
					possible++;
					surprised--;
				}
			}
			return possible;
		}
		//0 -  Not possible, 1 - Suprising, 2 - Not suprising
		public int getBestResult(int score){
			int dividend = score/3;
			int remainder = score%3;
			if(dividend>=required) return 2;
			if(dividend+1>=required&&(remainder>=1)) return 2;
			if(dividend+2>=required&&(remainder>=2)) return 1;
			if(dividend+1>=required&&dividend>0) return 1;
			return 0;
		}

	}
	
	private static String readFile(String name){
		File file = new File("input"+File.separator+name);
		Charset charset = Charset.forName("ASCII");
		String text = "";
		try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        text+=line+System.lineSeparator();
		    }
		} catch (IOException e) {
		}
		return text;
	}
	private static void writeFile(String name, String data){
		File file = new File("output"+File.separator+name);
		Charset charset = Charset.forName("ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {
		    writer.write(data, 0, data.length());
		} catch (IOException e) {
		}
	}
}
