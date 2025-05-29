import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingGooglers {

	public static String readFile(String nombreArchivo) throws Exception {

		String aux = "";
		String contenido = "";

		BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo));
		while ((aux = bf.readLine()) != null) {
			contenido += aux + "\r\n";
		}
		return contenido;
	}

	public static void writeFile(String nombreArchivo, String contenido) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(
					nombreArchivo));
			out.write(contenido);
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		String result;

		result = "";
		String lines[] = readFile("./input.txt").trim().split("\r\n");

		for (int j = 1; j < lines.length; j++) {
			int total = 0;
			String values[] = lines[j].split(" ");
			int dancers = Integer.parseInt(values[0]);
			int maxSurprise = Integer.parseInt(values[1]);
			int minScore = Integer.parseInt(values[2]);
			int scores[] = new int[dancers];
			for (int i = 3; i < values.length; i++) {
				scores[i - 3] = Integer.parseInt(values[i]);
			}

			for (int i = 0; i < scores.length; i++) {
				boolean flag = false;
				int comodin = 0;
				if (maxSurprise > 0) {
					comodin = 4;
				}

				if(scores[i] == 0){
					if (minScore == 0) {
						flag = true;
					}
				}else{
					if (minScore == 0) {
						flag = true;
					} else {
						if ((scores[i] + 2) / minScore >= 3) {
							flag = true;
						}
						if (!flag) {
							if ((scores[i] + comodin) / minScore >= 3) {
								flag = true;
								maxSurprise--;
							}
						}
					}
				}
				

				if (flag) {
					total++;
				}

			}
			result += "Case #" + j + ": " + total + "\r\n";
		}
		writeFile("./output.txt", result.trim());

	}
}
