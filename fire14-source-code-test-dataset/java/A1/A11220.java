import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DancingWithTheGooglers {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		BufferedReader br = null;
		int googlerNumber = 0;
		int surpriseNuber = 0;
		int p = 0;
		int[] points = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int totalLineNumber = Integer.parseInt(br.readLine().trim());
			for(int i = 0;i < totalLineNumber;i++){
				input.add(br.readLine());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0;i < input.size();i++){
			String[] infoArray = input.get(i).split(" ");
			googlerNumber = Integer.parseInt(infoArray[0]);
			surpriseNuber = Integer.parseInt(infoArray[1]);
			p = Integer.parseInt(infoArray[2]);
			points = new int[googlerNumber];
			for(int j = 0;j < googlerNumber;j++){
				points[j] = Integer.parseInt(infoArray[3+j]);
			}
			int notSurprisePointsNumber = 0;
			int notSurprisePointsMin = 3 * p - 2;
			if(notSurprisePointsMin < 0){
				notSurprisePointsMin = p;
			}
			int surprisePointsNumber = 0;
			int surprisePointsMin = 3 * p - 4;
			if(surprisePointsMin < 0){
				surprisePointsMin = p;
			}
			int result = 0;
			if(googlerNumber != surpriseNuber){
				for(int j = 0;j < points.length;j++){
					if(points[j] >= notSurprisePointsMin){
						notSurprisePointsNumber++;
						points[j] = -100;
					}
				}
			}
			if(surpriseNuber != 0){
				for(int j = 0;j < points.length && surprisePointsNumber < surpriseNuber;j++){
					if(points[j] >= surprisePointsMin){
						surprisePointsNumber++;
						points[j] = -100;
					}
				}
			}
			result = surprisePointsNumber + notSurprisePointsNumber;
			if(p == 0){
				result = googlerNumber;
			}
			if(result > googlerNumber){
				result = googlerNumber - (result - googlerNumber);
			}
			int flag = i + 1;
			System.out.print("Case #" + flag + ": ");
			System.out.println(result);
		}
	}

}
