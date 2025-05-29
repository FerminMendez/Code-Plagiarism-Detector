import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("small-input.in");
		File outputFile = new File("output.txt");
		try {
			FileWriter writer = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(writer);
			Scanner scanner = new Scanner(file);
			int count = 0;
			
			while (scanner.hasNextLine()) {
				count = count + 1;
				String line = scanner.nextLine();

				if (count >= 2) {
					int finalCount = 0;
					System.out.println(line);
					String[] stringArr = line.split(" ");
					int num1 = Integer.parseInt(stringArr[0]);
					int num2 = Integer.parseInt(stringArr[1]);
					int tempnum1 = num1;
					//System.out.println("number1 is " + num1);
					//System.out.println("number2 is " + num2);
					for (; tempnum1 <= num2; tempnum1++) {
						String str = String.valueOf(tempnum1);
						ArrayList usedList = new ArrayList();
						for (int j = 1; j < str.length(); j++) {
							String str1 = str.substring(str.length() - j, str
									.length());
							String str2 = str.substring(0, str.length() - j);
							String newStr = str1 + str2;
							int newIntVal = Integer.parseInt(newStr);
							
							if ((num1 <= newIntVal) && ((num2 >= newIntVal))) {
								if(newIntVal>tempnum1){
									if(!usedList.contains(newIntVal)){
									System.out.println("tempNum1 is "+tempnum1);
									System.out.println("newIntVal== "+newIntVal);
									usedList.add(newIntVal);
								finalCount = finalCount+1;
								System.out.println("-------------------------------------------------------------");
								//System.out.println("finalCount is "+finalCount);
									}
								}
							}
						}

					}
                  
					out.write("Case #" + (count - 1) + ": "+finalCount);
					out.newLine();

				}

			}
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
