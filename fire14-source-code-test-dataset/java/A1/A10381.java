import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution2 {

	private static int maxScoreWithSurprise(int media) {
		if (media == 0)
			return 0;

		Double realAverrage = new Double((double) media / 3);
		Double m = Math.ceil(realAverrage);
		int mediaDeNota = m.intValue();
		
		int notaMaxima = 0;
		if (realAverrage == realAverrage.longValue()) {
			notaMaxima = media - (mediaDeNota  * 2);
			notaMaxima++;
		} else {
			 notaMaxima = media - ((mediaDeNota - 1) * 2);
		}
		
		return Math.max(mediaDeNota, notaMaxima);
	}

	private static int maxScore(int media) {
		if (media == 0)
			return 0;

		Double m = Math.ceil(new Double((double) media / 3));
		int mediaDeNota = m.intValue();
		int notaMaxima = media - (mediaDeNota * 2);

		return Math.max(mediaDeNota, notaMaxima);
	}

	public static String parser(String input) {
		String[] lines = input.split("\n");
		StringBuilder sb = new StringBuilder();

		for (int index = 1; index < lines.length; index++) {
			String[] current = lines[index].split(" ");

			int numberSurprise = Integer.parseInt(current[1]);
			int minimalAverrage = Integer.parseInt(current[2]);
			int normalSum = 0;
			int withSurpriseSum = 0;

			for (int j = 3; j < current.length; j++) {
				int num = Integer.parseInt(current[j]);
				boolean normal = maxScore(num) >= minimalAverrage;

				if (normal)
					normalSum++;
				else if (maxScoreWithSurprise(num) >= minimalAverrage)
					withSurpriseSum++;
			}

			int result = withSurpriseSum + normalSum;
			result = (result <= normalSum + numberSurprise) ? result
					: normalSum + numberSurprise;

			sb.append("Case #");
			sb.append(index);
			sb.append(": ");
			sb.append(result);
			if (index != lines.length - 1)
				sb.append("\n");
		}

		return sb.toString();
	}

	public static String parseOfFile(File file) throws Exception {
		FileInputStream fstream = new FileInputStream(file);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuffer sb = new StringBuffer();

		String strLine;
		while ((strLine = br.readLine()) != null) {
			sb.append(strLine.trim());
			sb.append("\n");
		}

		return parser(sb.toString());
	}

	public static void main(String[] args) throws Exception {
//		System.out.println(maxScoreWithSurprise(21));
		System.out.println(parseOfFile(new File("C:\\cide\\teste.txt")));
	}

}
