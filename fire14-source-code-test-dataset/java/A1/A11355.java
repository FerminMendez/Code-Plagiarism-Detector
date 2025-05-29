import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Driver {


	public static void main(String[] args) {
		DeTerminator testBed = new DeTerminator();
		try{
			FileInputStream filestream = new FileInputStream("test.txt");
			DataInputStream input = new DataInputStream(filestream);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
			String currentLine;
			int counter = 1;
			int j = Integer.parseInt(buffer.readLine());
			for(int i = 0; i < j; i++){
				currentLine = buffer.readLine();
				String delimiter = " ";
				String[] temp;
				temp = currentLine.split(delimiter);
				System.out.println("Case #" + counter + ": " + testBed.determine(temp));
				counter++;
			}
			input.close();

		}
		catch (Exception e){ System.err.println("Error: " + e.getMessage()); }
	}

}
