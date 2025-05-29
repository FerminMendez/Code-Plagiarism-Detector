import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileRW {
	
	
	public static List<String> readFile(String fileName) throws IOException{
		
		List<String> lines = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		
		while(line != null){
			lines.add(line.trim());
			line = reader.readLine();
		}
		reader.close();
		lines.remove(0);
		
		return lines;
	}
	
	
	public static void writeOutput(String fileName, List<String> result) throws IOException{
		
		StringBuilder out = new StringBuilder();
		String prefix = "Case #";
		for (int i = 0; i < result.size(); i++) {
			out.append(prefix + (i + 1) + ": " + result.get(i) + "\n");
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(out.toString());
		writer.close();
		
	}


	public static void writeOutput2(String fileName, String result) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(result);
		writer.close();
		
	}
	
}
