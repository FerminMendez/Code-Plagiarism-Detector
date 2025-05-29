package loader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutPutWriter {

	public void write(String path, List<String> outputs){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			int count = 1;
			for(int i=0; i<outputs.size(); i++){
				writer.write("Case #" + count+ ": " + outputs.get(i) + '\n');
				count++;
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
