import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

//RecycledNumbers.java
//Completes the Recycled Numbers problem for Google Code Jam 2012
//By Jack Thakar
//Coded in Java using Eclipse 3.7
public class RecycledNumbers {
	public static void main(String[] args){
		String input = readFile("C-small-attempt0.in");
		String[] lines = input.split(System.lineSeparator());
		String output = "";
		for(int i=1;i<lines.length;i++){
			String line = lines[i];
			Case c = (new RecycledNumbers()).new Case(line);
			output+="Case #"+i+": ";
			output+=c.getSolution();
			if(i<lines.length-1) output+=System.lineSeparator();
		}
		writeFile("C-small-attempt0.out",output);
	}
	class Case{
		int a;
		int b;
		public Case(String data){
			String[] parts = data.split(" ");
			a = Integer.parseInt(parts[0]);
			b = Integer.parseInt(parts[1]);
		}
		public int getSolution(){
			List<Integer> foundM = new ArrayList<Integer>(),foundN = new ArrayList<Integer>();
			int count = 0;
			for(int n=a;n<=b;n++){
				String ni = Integer.toString(n);
				for(int j=1;j<ni.length();j++){
					String mi = ni.substring(j)+ni.substring(0,j);
					int m = Integer.parseInt(mi);
					boolean used = false;
					for(int i=0;i<foundM.size();i++){
						if(foundM.get(i).intValue()==m&&foundN.get(i).intValue()==n) used = true;
					}
					if(n<m&&m>=a&&m<=b&&used==false) {
						foundM.add(m);
						foundN.add(n);
						count++;
					}
				}
			}
			return count;
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
