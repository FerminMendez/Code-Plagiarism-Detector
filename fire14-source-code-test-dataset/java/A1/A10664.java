import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class B {

	public static void main(String[] args) {
		String line;
		String filename1 = "B-small-attempt0.in";
		String filename2 = "outB.out";
		BufferedReader input;
		BufferedWriter output;
		int counter = 0;
		try {
			input = new BufferedReader(new FileReader(filename1));
			output = new BufferedWriter(new FileWriter(filename2));
			while ((line = input.readLine()) != null) {
				if (counter == 0) {
				} else {
					String[] arrayS = line.split("\\s");
					int N = Integer.parseInt(arrayS[0]);
					int surprises = Integer.parseInt(arrayS[1]);
					int passingPoint = Integer.parseInt(arrayS[2]);
					int reducedPass = passingPoint - 1;
					int success = 0;
					boolean permazas = false;
					for (int i = 3; i < arrayS.length; i++) {
						if (reducedPass - 1 < 0) {
							reducedPass = 0;
							permazas = true;
						}
						int temp = (Integer.parseInt(arrayS[i]) - passingPoint) - (reducedPass * 2);
						//						System.out.println(temp);
						if (temp < 0 && surprises > 0) {
							if (temp + 2 >= 0 && !permazas) {
								surprises--;
								success++;
							}
						}
						if (temp >= 0) {
							success++;
						}
					}
					output.write("Case #" + counter + ": " + success + "\n");
//					System.out.println("result:" + success);
				}
				counter++;
			}
			input.close();
			output.close();
		} catch (IOException e1) {
			System.exit(1);
		}
	}
}
