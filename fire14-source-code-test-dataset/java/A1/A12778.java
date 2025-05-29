import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




public class Texter {




	public static void writeText(String text) {

		String fileName = "output.txt";

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(text);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static String readFile() {

		String fileName = "test.txt";
		String LS = System.getProperty("line.separator");
		StringBuffer fileContent = new StringBuffer();

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(fileName));


			String line;
			while ((line = reader.readLine()) != null) {
				fileContent.append(line).append(LS);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileContent.toString();
	}



	static FileReader		fr;
	static BufferedReader	reader;



	public static void setupReader() {


		String fileName = "input.txt";


		try {
			fr = new FileReader(fileName);
			reader = new BufferedReader(new FileReader(fileName));


		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public static String readLine() {

		String fileName = "test.txt";
		String LS = System.getProperty("line.separator");
		//StringBuffer fileContent = new StringBuffer();

		String line = null;

		try {
			//FileReader fr = new FileReader(fileName);
			//	BufferedReader reader = new BufferedReader(new FileReader(fileName));



			line = reader.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}


		//Will return null at end of file
		return line;
	}




	public static ArrayList<Integer> parseNumberList(String input) {


		int length = input.length();
		ArrayList<Integer> numbersArray = new ArrayList<Integer>();



		int numberCount = 0;


		//Index to start current number at
		int noStart = 0;



		//First one shouldn't be a space so start ahead

		for (int i = 1; i < length; i++) {


			//If character is a space that means a number just ended

			if (input.charAt(i) == ' ') {


				//Get that number
				//Substring from startIndex to endIndex -1
				int number = Integer.parseInt(input.substring(noStart, i));


				//Add it to array
				numbersArray.add(number);

				//Increment count
				numberCount++;

				//Set new number start index to one after the space we just had
				noStart = i + 1;




			}


			//Add last number
			if (i == length - 1) {


				//Get that number
				//Substring from startIndex to endIndex -1
				int number = Integer.parseInt(input.substring(noStart, length));


				//Add it to array
				numbersArray.add(number);


			}




		}


		return numbersArray;




	}



}
