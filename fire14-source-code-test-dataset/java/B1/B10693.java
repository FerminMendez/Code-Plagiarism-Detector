import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class C {

	public static void main(String[] args) {
		int n = 10;
		int m = 30;
		String line;
		String filename1 = "C-small-attempt0.in";
		String filename2 = "outC.out";
		BufferedReader input;
		BufferedWriter output;
		int counter = 0;
		int poruSkaicius = 0;
		try {
			input = new BufferedReader(new FileReader(filename1));
			output = new BufferedWriter(new FileWriter(filename2));
			while ((line = input.readLine()) != null) {
				if (counter == 0) {
				} else {
					n = Integer.parseInt(line.split("\\s")[0]);
					m = Integer.parseInt(line.split("\\s")[1]);
					output.write("Case #" + counter + ": ");
					//
					for (int i = n; i < m; i++) {
						for (int j = i; j <= m; j++) {
							poruSkaicius += skaiciuok(i, j);
						}
					}
					//
					output.write(poruSkaicius+"\n");
//					System.out.println(poruSkaicius);
					poruSkaicius=0;
				}
				counter++;
			}
			input.close();
			output.close();
		} catch (IOException e1) {
			System.exit(1);
		}

	}

	public static int skaiciuok(int pirmas, int antras) {
		//		System.out.println(pirmas+":"+antras);
		//		System.out.println(("" + pirmas).length());
		char[] temp = (pirmas + "").toCharArray();
		int counter = 0;
		for (int i = 0; i < ("" + pirmas).length()-1; i++) {
			//			System.out.print(temp);
			//			System.out.print("|");
			char tempChar = temp[temp.length -1];
			for (int j = temp.length - 1; j > 0; j--) {
				temp[j] = temp[j - 1];
			}
			temp[0] = tempChar;
			String tempString = new String(temp);
			//			System.out.println(tempString);
			if (tempString.equals(antras + "") && !tempString.equals(pirmas + "")) {
//				System.out.println(tempString+"/" + pirmas);
				counter++;
				break;
			}
		}
		//		System.out.print(counter);
		return counter;
	}
}
