import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Principal {

	public static void main(String[] args) {
		
		Reader reader = new Reader();
		Case[] cases = reader.read();
		
		try {
			File file = new File("out.txt");
			file.delete();
			BufferedWriter bf = new BufferedWriter(new FileWriter(file));
			
			for(Case c : cases)
				bf.write(c.resolver());
			
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}//endClass
